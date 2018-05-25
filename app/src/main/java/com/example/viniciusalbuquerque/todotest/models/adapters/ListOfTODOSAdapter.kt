package com.example.viniciusalbuquerque.todotest.models.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.viniciusalbuquerque.todotest.R
import com.example.viniciusalbuquerque.todotest.models.classes.TODOWrapper
import kotlinx.android.synthetic.main.adapter_list_of_todos.view.*

class ListOfTODOSAdapter(val context: Context, val todoWrappers: List<TODOWrapper>, val onClickListener: View.OnClickListener) : RecyclerView.Adapter<ListOfTODOSAdapter.ViewHolder>() {

    private val TAG = "ListOfTODOSAdapter";

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.i(TAG, "onCreateViewHolder!")
        val view = LayoutInflater.from(context).inflate(R.layout.adapter_list_of_todos, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return todoWrappers.size;
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.hTextView.text = todoWrappers.get(position).title
        holder.itemView.setOnClickListener(onClickListener)
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val hTextView = itemView.adapter_list_of_todos_textview
    }
}