//Kim Kraemer
//CS250-Student class

import android.content.Context
import org.json.JSONException
import org.json.JSONObject

    /*define Class properties based on the roster
    JSON file, parse the JSON, and create Student objects based on JSON keys, and
    add them to ArrayList of Student.
     */
// Student class to read a JSON file and create a list of Student objects


class Student (

    // class properties

    val name: String,
    val id: String,
    val email: String,
    val major: String,
    val year: Int,
    val advisor: String,
    val credits: Int,
    val admitStatus: String,
    val photoURL: String)
{

    // companion object. There is only one instance this.
    // reads json object and create an arraylist of student objects.
    // uses Kotlin's built in java encoder/decoder to parse JSON data from a file.

    companion object {

        fun getStudentsFromFile(filename: String, context: Context): ArrayList<Student> {
            val studentList = ArrayList<Student>()

            try {
                // Load data
                val jsonString = loadJsonFromAsset(filename, context)
                if (jsonString != null) {
                    val json = JSONObject(jsonString)  // decode JSON Sting to an key-value pair map
                    val students = json.getJSONArray("cs250students")

                    // Get Student objects from data
                    (0 until students.length()).mapTo(studentList) {
                        Student(students.getJSONObject(it).getString("Student Name"),
                            students.getJSONObject(it).getString("ID"),
                            students.getJSONObject(it).getString("Email"),
                            students.getJSONObject(it).getString("Major"),
                            students.getJSONObject(it).getInt("Class"),
                            students.getJSONObject(it).getString("Advisor"),
                            students.getJSONObject(it).getInt("Credits"),
                            students.getJSONObject(it).getString("Admit Status"),
                            students.getJSONObject(it).getString("photoURL")) }
                } else {
                    println ("not a valid JSON string")
                }

            } catch (e: JSONException) {
                e.printStackTrace()
            }

            return studentList
        }

        // open file and read all characters into a buffer. Convert buffer to String

        private fun loadJsonFromAsset(filename: String, context: Context): String? {
            var json: String?

            try {
                val inputStream = context.assets.open(filename)
                val size = inputStream.available()
                val buffer = ByteArray(size)

                inputStream.read(buffer)
                inputStream.close()
                val charset = Charsets.UTF_8

                json = buffer.toString(charset)

            } catch (ex: java.io.IOException) {
                ex.printStackTrace()
                return null
            }

            return json
        }
    }

}