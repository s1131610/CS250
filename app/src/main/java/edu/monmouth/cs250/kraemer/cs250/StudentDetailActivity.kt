//Kim Kraemer
//CS250-StudentDetailActivity class

package edu.monmouth.cs250.kraemer.cs250

import Student
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_studentdetail.*

// Activity to show the student details inside the view.
class StudentDetailActivity: AppCompatActivity() {
    // companion object to create one instance of the Intent
    // save the required data as key-value using putExtra method

    companion object {
        const val EXTRA_TITLE = "name"
        const val EXTRA_CLASS = "classLevel"
        const val EXTRA_EMAIL = "EMAIL"
        const val EXTRA_IMAGE = "photoURL"

        fun newIntent(context: Context, student: Student): Intent {
            val detailIntent = Intent(context, StudentDetailActivity::class.java)
            detailIntent.putExtra(EXTRA_TITLE, student.name)
            detailIntent.putExtra(EXTRA_CLASS, student.year)
            detailIntent.putExtra(EXTRA_EMAIL,student.email)
            detailIntent.putExtra(EXTRA_IMAGE,student.photoURL)
            return detailIntent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_studentdetail)

        // fetch the saved data from Intent creation above
        val title = intent?.extras?.getString(EXTRA_TITLE)
        val year = intent?.extras?.getInt(EXTRA_CLASS)
        val email = intent?.extras?.getString(EXTRA_EMAIL)
        val xtraImg = intent?.extras?.getString(EXTRA_IMAGE)
        // set title for Activity
        setTitle(title)
        //set image
        val imgURL = xtraImg?.replace("http:", "https:", true)
        Glide.with(this).load(EXTRA_IMAGE).into(studentImage)

        //set student name
        studentNameText.text = title
        //display email under image
        studentEmailText.text = email
        //turn on switch if student is junior or senior
        if(year ==3 || year ==4){
            yearSwitch.isChecked = true
        }
        /*//set the image to the student's image
        studentimageview = findViewById(R.id.studentImage)
        //studentimageview.
        //set studentNameText to student's name
        studentnameview = findViewById(R.id.studentNameText)
        studentidview.setText(student.id)
       */
    }
}
