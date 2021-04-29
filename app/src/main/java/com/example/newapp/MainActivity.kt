package com.example.newapp

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.example.newapp.UI.ClassB
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progressBar= findViewById(R.id.progressBar)

        loaddialog()
    }

    private fun loaddialog() {
        progressBar.visibility= View.VISIBLE
        val url = "https://backend-test-zypher.herokuapp.com/testData"
        val jsonObjectRequest =JsonObjectRequest(
            Request.Method.POST, url, null,
            { response ->
                ClassB.getInstance(this).showDialogBox(response.getString("title"),
                    response.getString("imageURL"),
                    response.getString("success_url")
                )
                progressBar.visibility= View.INVISIBLE
            },
            { error ->
                Toast.makeText(applicationContext, error.message, Toast.LENGTH_LONG)
                    .show()
                progressBar.visibility= View.INVISIBLE
            }
        )
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest)
    }
}