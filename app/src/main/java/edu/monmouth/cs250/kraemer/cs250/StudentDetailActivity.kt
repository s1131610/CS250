

package edu.monmouth.cs250.kraemer.cs250

import Student
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity


// Activity to show the Recipe inside a webView


class StudentDetailActivity: AppCompatActivity() {

    private lateinit var recipewebview: WebView

    // companion object to create one instance of the Intent
    // save the required data as key-value using putExtra method


    companion object {
        const val EXTRA_TITLE = "name"

        fun newIntent(context: Context, student: Student): Intent {
            val detailIntent = Intent(context, StudentDetailActivity::class.java)

            detailIntent.putExtra(EXTRA_TITLE, student.name)
            return detailIntent
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_studentdetail)

        // fetch the saved data from Intent creaton above

        val title = intent?.extras?.getString(EXTRA_TITLE)
       // set title for Activity
        setTitle(title)

        //TODO
        //set the image to the student's image

        //set studentNameText to student's name

        //set studentIDText to student's ID number

        //if student's year is a junior or senior, turn on the switch.
    }
}
