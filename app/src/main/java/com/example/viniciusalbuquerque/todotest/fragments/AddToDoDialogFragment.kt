package com.example.viniciusalbuquerque.todotest.fragments

import android.app.Dialog
import android.app.DialogFragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.EditText
import com.example.viniciusalbuquerque.todotest.R
import kotlinx.android.synthetic.main.dialog_new_todo.*

class AddToDoDialogFragment() : DialogFragment() {

    val TAG : String = "AddToDoDialogFragment"
    var onClickListener: View.OnClickListener? = null
    var editTextToDoText : EditText? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        if(dialog.window != null) {
            dialog.window.requestFeature(Window.FEATURE_NO_TITLE)
        }
        return dialog
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater!!.inflate(R.layout.dialog_new_todo, container, false)
        val buttonAdd = view.findViewById<Button>(R.id.dialog_new_todo_button_add)
        val buttonCancel = view.findViewById<Button>(R.id.dialog_new_todo_button_cancel)
        editTextToDoText = view.findViewById<EditText>(R.id.dialog_new_todo_edittext_todo)
        buttonAdd.setOnClickListener(onClickListener)
        buttonCancel.setOnClickListener(View.OnClickListener {
            this.dismiss()
        })
        return view
    }
}