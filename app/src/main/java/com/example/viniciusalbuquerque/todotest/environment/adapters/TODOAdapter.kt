package com.example.viniciusalbuquerque.todotest.environment.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import com.example.viniciusalbuquerque.todotest.R
import com.example.viniciusalbuquerque.todotest.models.classes.TODO
import com.example.viniciusalbuquerque.todotest.domain.interfaces.OnTODORequestMethods
import com.example.viniciusalbuquerque.todotest.presenters.TodoPresenter
import kotlinx.android.synthetic.main.adapter_todo.view.*

class TODOAdapter(val context : Context, val todoWrapperId: Long, val todoList : List<TODO>,
                  val presenter : TodoPresenter)
        : RecyclerView.Adapter<TODOAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.adapter_todo, parent, false))
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val todo = todoList.get(position)
        val todoID = todo.id

        holder.hCheckBox.text = todo.title
        holder.hCheckBox.isChecked = todo.isDone

        holder.hCheckBox.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked: Boolean ->
            presenter.updateTodo(todoWrapperId, todoID, isChecked)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val hCheckBox = itemView.adapter_todo_checkbox
    }
}