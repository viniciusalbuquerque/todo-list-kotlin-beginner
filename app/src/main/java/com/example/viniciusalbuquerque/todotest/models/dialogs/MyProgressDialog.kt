package com.example.viniciusalbuquerque.todotest.models.dialogs

import android.content.Context
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.widget.TextView
import com.example.viniciusalbuquerque.todotest.R

class MyProgressDialog() {

    fun create(context: Context, layoutInflater: LayoutInflater, message : String = "Aguarde..."): AlertDialog {
        val builder = AlertDialog.Builder(context)
        val dialogView = layoutInflater.inflate(R.layout.dialog_progress, null)
        val textView = dialogView.findViewById<TextView>(R.id.dialog_progress_textview)
        textView.text = message

        builder.setView(dialogView)
        builder.setCancelable(false)
        return builder.create()
    }



}