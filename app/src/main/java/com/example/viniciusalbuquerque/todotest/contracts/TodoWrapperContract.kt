package com.example.viniciusalbuquerque.todotest.contracts

import com.example.viniciusalbuquerque.todotest.daos.TodoWrapperDAO
import com.example.viniciusalbuquerque.todotest.models.classes.TODOWrapper

interface TodoWrapperContract {

    interface View {
        fun showAddNewTodoWrapperDialog()
        fun finishAddingNewTodoWrapper(todoWrapper : TODOWrapper)
    }

    interface Presenter {
        fun fabAddTodoWrapperClicked()
        fun addTodoWrapperDialogButtonClicked(todoWrapperTitle : String, todoWrapperDAO: TodoWrapperDAO)
        fun listTodoWrappers(todoWrapperDAO: TodoWrapperDAO)
        fun deleteTodoWrapper(todoWrapper: TODOWrapper, todoWrapperDAO: TodoWrapperDAO)
    }
}