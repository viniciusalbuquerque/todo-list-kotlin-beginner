package com.example.viniciusalbuquerque.todotest.environment.fragments

import android.app.Dialog

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.viniciusalbuquerque.todotest.R

class AddToDoDialogFragment : DialogFragment() {

    val TAG : String = "AddToDoDialogFragment"
    var onClickListener: View.OnClickListener? = null
    var editTextToDoText : EditText? = null
    var textTitle : String? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        if(dialog.window != null) {
            dialog.window.requestFeature(Window.FEATURE_NO_TITLE)
        }
        return dialog
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dialog_new_todo, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonAdd = view.findViewById<Button>(R.id.dialog_new_todo_button_add)
        val buttonCancel = view.findViewById<Button>(R.id.dialog_new_todo_button_cancel)
        editTextToDoText = view.findViewById(R.id.dialog_new_todo_edittext_todo)

        if(textTitle != null) {
            view.findViewById<TextView>(R.id.dialog_new_todo_textview_title).text = textTitle
        }

        buttonAdd.setOnClickListener(onClickListener)
        buttonCancel.setOnClickListener {
            this.dismiss()
        }
    }

}