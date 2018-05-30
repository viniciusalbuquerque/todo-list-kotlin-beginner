package com.example.viniciusalbuquerque.todotest.models.adapters

import android.content.Context
import android.content.SharedPreferences
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import com.example.viniciusalbuquerque.todotest.R
import com.example.viniciusalbuquerque.todotest.models.classes.KEY_SAVED_TODOS
import com.example.viniciusalbuquerque.todotest.models.classes.KEY_SHARED_PREFERENCES
import com.example.viniciusalbuquerque.todotest.models.classes.TODO
import com.example.viniciusalbuquerque.todotest.models.interfaces.OnRequestReponse
import com.example.viniciusalbuquerque.todotest.models.interfaces.OnTODORequestMethods
import kotlinx.android.synthetic.main.adapter_todo.view.*

class TODOAdapter(val context : Context, val todoWrapperId: Long, val todoList : List<TODO>,
                  val onTODORequestMethods: OnTODORequestMethods)
        : RecyclerView.Adapter<TODOAdapter.ViewHolder>() {

    private var sharedPreferences: SharedPreferences

    init {
        this.sharedPreferences = context.getSharedPreferences(KEY_SHARED_PREFERENCES, Context.MODE_PRIVATE)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.adapter_todo, parent, false))
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val todo = todoList.get(position)
        val todoID = todo.id
        val value = todoWrapperId.toString() + ":" + todoID

        val stringSet:Set<String> = this.sharedPreferences.getStringSet(KEY_SAVED_TODOS, setOf())!!
        if(stringSet.contains(value))
            todo.isDone = true

        holder.hCheckBox.text = todo.title
        holder.hCheckBox.isChecked = todo.isDone

        holder.hCheckBox.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked: Boolean ->
            updateComponents(holder,todo)
            if(isChecked) {
                onTODORequestMethods.addTODO(todoWrapperId, todoID)
            } else {
                onTODORequestMethods.removeTODO(todoWrapperId, todoID)
            }

        }
    }

    private fun updateComponents(holder: ViewHolder, todo: TODO) {
        updateTODO(todo, holder.hCheckBox.isChecked)
    }

    private fun updateTODO(todo: TODO, isDone : Boolean) {
        todo.isDone = isDone
        val todoID = todo.id
        val value = todoWrapperId.toString() + ":" + todoID
        val setString : Set<String>
        if(!isDone) {
            setString = removeFromLocalSavings(value)
        } else {
            setString = addToLocalSavings(value)
        }

        updateSavedSet(setString)
    }

    private fun addToLocalSavings(value: String): Set<String> {
        var stringSet:Set<String> = this.sharedPreferences.getStringSet(KEY_SAVED_TODOS, setOf())!!
        stringSet.apply {
            stringSet = this.plusElement(value)
        }
        return stringSet
    }

    private fun removeFromLocalSavings(value: String): Set<String> {
        var stringSet:Set<String> = this.sharedPreferences.getStringSet(KEY_SAVED_TODOS, setOf())!!
        stringSet.apply {
            stringSet = this.minusElement(value)
        }
        return stringSet
    }

    private fun updateSavedSet(value: Set<String>) {
        sharedPreferences.edit().apply {
            this!!.putStringSet(KEY_SAVED_TODOS, value)
        }?.apply()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var shouldUpdate : Boolean = false
        val hCheckBox = itemView.adapter_todo_checkbox
    }
}