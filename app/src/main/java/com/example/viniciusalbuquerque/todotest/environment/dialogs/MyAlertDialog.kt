package com.example.viniciusalbuquerque.todotest.environment.dialogs

import android.content.Context
import android.support.v7.app.AlertDialog


class MyAlertDialog {

    fun create(context: Context, title : String = "Atenção", message : String = "") : AlertDialog {
        val builder = AlertDialog.Builder(context)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setNeutralButton("OK"){_,_ -> }
        return builder.create()
    }


}
