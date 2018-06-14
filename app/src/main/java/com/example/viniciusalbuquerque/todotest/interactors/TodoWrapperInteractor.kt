package com.example.viniciusalbuquerque.todotest.interactors

import com.example.viniciusalbuquerque.todotest.daos.TodoWrapperDAO
import com.example.viniciusalbuquerque.todotest.models.classes.TODOWrapper
import com.example.viniciusalbuquerque.todotest.models.interfaces.OnTodoWrappersCallbacks
import com.example.viniciusalbuquerque.todotest.usecases.AddTodoWrapperUserCase
import com.example.viniciusalbuquerque.todotest.usecases.ListTodoWrapperUseCase
import com.example.viniciusalbuquerque.todotest.usecases.RemoveTodoWrapperUserCase

class TodoWrapperInteractor(val listTodoWrapperUseCase: ListTodoWrapperUseCase, val addTodoWrapperUserCase: AddTodoWrapperUserCase, val removeTodoWrapperUserCase: RemoveTodoWrapperUserCase) {

    fun addNewTodoWrapper(todoWrapperTitle : String, todoWrapperDAO: TodoWrapperDAO, onAddTodoWrappersCallbacks: OnTodoWrappersCallbacks.Add) {
        addTodoWrapperUserCase.addTodoWrapper(todoWrapperTitle, todoWrapperDAO, onAddTodoWrappersCallbacks)
    }

    fun listTodoWrappers(todoWrapperDAO: TodoWrapperDAO, onTodoWrappersCallbacksList: OnTodoWrappersCallbacks.List) {
        listTodoWrapperUseCase.loadTodoWrappers(todoWrapperDAO, onTodoWrappersCallbacksList)
    }

    fun deleteTodoWrapper(todoWrapper: TODOWrapper, todoWrapperDAO: TodoWrapperDAO) {
        removeTodoWrapperUserCase.removeTodoWrapper(todoWrapper, todoWrapperDAO)
    }

}