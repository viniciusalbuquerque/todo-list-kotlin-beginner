package com.example.viniciusalbuquerque.todotest.presenters.contracts

import com.example.viniciusalbuquerque.todotest.models.classes.TODO

interface TodoContract {

    interface View {
        fun showAddNewTodoDialog()
        fun finishedLoadingTodos(todos : ArrayList<TODO>)
        fun finishedLoadingTodosWithError(error: Any)
        fun finishedAddingTodo(todo: TODO)
        fun finishedAddingTodoWithError(error : Any)
        fun finishedRemovingTodo(todo: TODO)
        fun finishedRemovingTodoWithError(error: Any)
        fun finishedUpdating(todo: TODO)
        fun finishedUpdatingWithError(error: Any)

    }

    interface Presenter {
        fun fabAddTodoClicked()
        fun addTodoDialogButtonClicked(todoWrapperId : Long, todoTitle : String)
        fun deleteTodo(todoWrapperId: Long, todoId: Long)
        fun cancelRequestsFromDAO()
        fun updateTodo(todoWrapperId: Long, todoId: Long, done : Boolean)
        fun loadTodos(todoWrapperId: Long)
    }

}