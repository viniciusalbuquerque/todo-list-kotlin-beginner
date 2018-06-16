package com.example.viniciusalbuquerque.todotest.contracts

import com.example.viniciusalbuquerque.todotest.models.classes.TODO
import com.example.viniciusalbuquerque.todotest.models.classes.TODOWrapper

interface TodoContract {

    interface View {
        fun showAddNewTodoDialog()
        fun finishedAddingTodo(todo: TODO)
        fun finishedAddingTodoWithError(error : Any)
        fun finishedRemovingTodo(todo: TODO)
        fun finishedRemovingTodoWithError(error: Any)

    }

    interface Presenter {
        fun fabAddTodoClicked()
        fun addTodoDialogButtonClicked(todoWrapperId : Long, todoTitle : String)
        fun deleteTodo(todoWrapper: TODOWrapper)
        fun cancelRequestsFromDAO()
        fun updateTodo(todoWrapperId: Long, todoId: Long, done : Boolean)
    }

}