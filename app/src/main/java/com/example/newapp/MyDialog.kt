package com.example.newapp

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.github.andreilisun.swipedismissdialog.SwipeDismissDialog

class MyDialog: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder= AlertDialog.Builder(context)
                .setTitle("hellow")
                .setNeutralButton("Submit", DialogInterface.OnClickListener { dialogInterface, i ->
                    Toast.makeText(context,"clicked ",Toast.LENGTH_LONG).show()
                })
//        val dialog= builder.create()
//        SwipeDismissDialog.Builder(context)
//                .setView(dialog.listView)
//                .build()
//                .sh
        return builder.create()
    }
}