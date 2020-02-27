//Kim Kraemer
//CS250-MainActivity


package edu.monmouth.cs250.kraemer.cs250

import Student
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

// MainActivity
// Also implements OnItemClickListener interface for handling selection of a student view
class MainActivity : AppCompatActivity(), OnItemClickListener {

    private lateinit var customAdapter: StudentListCustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // student list recyclerview instantiate with linear layout.
        // instantiate a CustomAdapter (see RecipeListCustomAdapter.kt Class)
        // Setup the adapter for recyclerView
        studentsRecyclerView.layoutManager = LinearLayoutManager (this)
        customAdapter = StudentListCustomAdapter(this, this)
        studentsRecyclerView.adapter = customAdapter

    }
    // method to handle student view selection
    // create an intent class object for DetailActivity
    // start the activity

    override fun onViewItemClicked(student: Student) {
        val context = this
        print(student.name)
        val detailIntent = StudentDetailActivity.newIntent(this, student)
        startActivity(detailIntent)
    }


}


