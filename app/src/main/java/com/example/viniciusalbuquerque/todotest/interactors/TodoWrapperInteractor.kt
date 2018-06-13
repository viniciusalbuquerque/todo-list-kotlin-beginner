package com.example.viniciusalbuquerque.todotest.interactors

import com.example.viniciusalbuquerque.todotest.daos.TodoWrapperDAO
import com.example.viniciusalbuquerque.todotest.models.classes.TODOWrapper
import com.example.viniciusalbuquerque.todotest.usecases.AddTodoWrapperUserCase
import com.example.viniciusalbuquerque.todotest.usecases.ListTodoWrapperUseCase
import com.example.viniciusalbuquerque.todotest.usecases.RemoveTodoWrapperUserCase

class TodoWrapperInteractor(val listTodoWrapperUseCase: ListTodoWrapperUseCase, val addTodoWrapperUserCase: AddTodoWrapperUserCase, val removeTodoWrapperUserCase: RemoveTodoWrapperUserCase) {

    fun addNewTodoWrapper(todoWrapperTitle : String, todoWrapperDAO: TodoWrapperDAO) {
        addTodoWrapperUserCase.addTodoWrapper(todoWrapperTitle, todoWrapperDAO)
    }

    fun listTodoWrappers(todoWrapperDAO: TodoWrapperDAO) {
        listTodoWrapperUseCase.loadTodoWrappers(todoWrapperDAO)
    }

    fun deleteTodoWrapper(todoWrapper: TODOWrapper, todoWrapperDAO: TodoWrapperDAO) {
        removeTodoWrapperUserCase.removeTodoWrapper(todoWrapper, todoWrapperDAO)
    }

}