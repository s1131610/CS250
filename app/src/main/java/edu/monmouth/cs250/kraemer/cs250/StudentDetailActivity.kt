//Kim Kraemer
//CS250-StudentDetailActivity class

package edu.monmouth.cs250.kraemer.cs250

import Student
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_studentdetail.*

// Activity to show the student details inside the view.
class StudentDetailActivity: AppCompatActivity() {
    // companion object to create one instance of the Intent
    // save the required data as key-value using putExtra method

    companion object {
        const val EXTRA_TITLE = "name"
        const val EXTRA_CLASS = "classLevel"
        const val EXTRA_ID = "ID"

        val thisStudent: Student?= null

        fun newIntent(context: Context, student: Student): Intent {
            val detailIntent = Intent(context, StudentDetailActivity::class.java)
            detailIntent.putExtra(EXTRA_TITLE, student.name)
            detailIntent.putExtra(EXTRA_CLASS, student.year)
            return detailIntent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_studentdetail)

        // fetch the saved data from Intent creation above
        val title = intent?.extras?.getString(EXTRA_TITLE)
        val year = intent?.extras?.getInt(EXTRA_CLASS)
        // set title for Activity
        setTitle(title)
        //turn on switch if student is junior or senior
        if(year ==3 || year ==4){
            yearSwitch.isChecked = true
        }
        /*//set the image to the student's image
        studentimageview = findViewById(R.id.studentImage)
        //studentimageview.
        //set studentNameText to student's name
        studentnameview = findViewById(R.id.studentNameText)
        //set studentIDText to student's ID number
        studentidview = findViewById(R.id.studentIDText)
        studentidview.setText(student.id)
        //if student's year is a junior or senior, turn on the switch.
        studentyearswitch = findViewById<Switch>(R.id.yearSwitch)
        when(student.year){
            3,4->studentyearswitch.isChecked = true
            else->studentyearswitch.isChecked = false
        }
        */
    }
}
