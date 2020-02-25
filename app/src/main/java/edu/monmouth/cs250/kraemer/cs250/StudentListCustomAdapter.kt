package edu.monmouth.cs250.kraemer.cs250


import Student
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.studentitem_view.view.*

class RecipeListCustomAdapter ( private val context: Context, val itemviewListener: OnItemClickListner) : RecyclerView.Adapter <CustomViewHolder> () {

    private var studentList = ArrayList<Student> ()

    // intializer method - get the data from Student model class
    // Note - we are invoking the companion object using class reference Recipe.getRecipesFromFrom(...)

    init {
        studentList = Student.getStudentsFromFile("cs250.json", context)
    }

    // number of items in RecyclerView

    override fun getItemCount(): Int {
        // return students.count()
        return studentList.count()
    }

    // create a viewHolder for the view

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {

        val studentItemLayout = LayoutInflater.from(parent.context)
        val studentItemView = studentItemLayout.inflate(R.layout.studentitem_view, parent, false)
        return CustomViewHolder(studentItemView)
    }

    // get the data for viewHolder for CustomViewHolder

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {


        val student = studentList.get(position)
        holder.bind(student, context, itemviewListener)
    }

}
// setup the data viewHolder view.
// Image loaded using Glide image library
// Also the clickListner.

class CustomViewHolder (itemView: View): RecyclerView.ViewHolder (itemView) {

    // variables to access the views in Activity Adapter
    var nameTextView: TextView = itemView.studentNameView
    var advisorTextView: TextView = itemView.studentAdvisorView
    var studentImage: ImageView = itemView.studentImageView
    var studentYearView: TextView = itemView.studentYearView

    // bind data to view
    // Also onClickListner as a lambda
    fun bind (student: Student, context: Context, itemviewListner: OnItemClickListner) {

        nameTextView.text = student.name
        advisorTextView.text = student.advisor
        studentYearView.text = student.year.toString()
        val imgURL = student.photoURL.replace("http:", "https:", true)
        Glide.with(context).load(imgURL).into(studentImage)

        itemView.setOnClickListener {
            itemviewListner.onViewItemClicked(student)
        }
    }
}

// interface spec to send callback a method in MainActivity which implements this interface

interface OnItemClickListner {
    fun onViewItemClicked(student: Student)
}
