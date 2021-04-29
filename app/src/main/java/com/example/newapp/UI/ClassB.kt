package com.example.newapp.UI

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.newapp.R
import com.github.andreilisun.swipedismissdialog.SwipeDismissDialog

class ClassB(val context: Context) {
    companion object{
        private var instance:ClassB? = null
        fun getInstance(context: Context): ClassB {
            if (instance==null)
                instance= ClassB(context)
            return instance!!
        }
    }

    fun showDialogBox(title:String, image:String,url:String){
        val view= LayoutInflater.from(context).inflate(R.layout.dialogview,null)
        val titleview= view.findViewById<TextView>(R.id.textView2)
        val imaageview= view.findViewById<ImageView>(R.id.imageView2)
        val submit= view.findViewById<Button>(R.id.button2)
        submit.setOnClickListener{
            val intent= Intent(Intent.ACTION_VIEW)
            intent.data= Uri.parse(url)
            context.startActivity(intent)
        }
        Glide.with(context).load(image).into(imaageview)
        titleview.text=title
        SwipeDismissDialog.Builder(context)
            .setView(view)
            .build()
            .show()
    }
}