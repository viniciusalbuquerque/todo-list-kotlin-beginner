package com.example.viniciusalbuquerque.todotest.domain.interactors

import com.example.viniciusalbuquerque.todotest.domain.daos.TodoWrapperDAO
import com.example.viniciusalbuquerque.todotest.models.classes.TODOWrapper
import com.example.viniciusalbuquerque.todotest.models.interfaces.OnTodoWrappersCallbacks
import com.example.viniciusalbuquerque.todotest.domain.usecases.AddTodoWrapperUseCase
import com.example.viniciusalbuquerque.todotest.domain.usecases.ListTodoWrapperUseCase
import com.example.viniciusalbuquerque.todotest.domain.usecases.RemoveTodoWrapperUseCase

class TodoWrapperInteractor(val listTodoWrapperUseCase: ListTodoWrapperUseCase, val addTodoWrapperUseCase: AddTodoWrapperUseCase, val removeTodoWrapperUseCase: RemoveTodoWrapperUseCase) {

    fun addNewTodoWrapper(todoWrapperTitle : String, todoWrapperDAO: TodoWrapperDAO, onAddTodoWrappersCallbacks: OnTodoWrappersCallbacks.Add) {
        addTodoWrapperUseCase.addTodoWrapper(todoWrapperTitle, todoWrapperDAO, onAddTodoWrappersCallbacks)
    }

    fun listTodoWrappers(todoWrapperDAO: TodoWrapperDAO, onTodoWrappersCallbacksList: OnTodoWrappersCallbacks.List) {
        listTodoWrapperUseCase.loadTodoWrappers(todoWrapperDAO, onTodoWrappersCallbacksList)
    }

    fun deleteTodoWrapper(todoWrapper: TODOWrapper, todoWrapperDAO: TodoWrapperDAO, onRemoveTodoWrappersCallbacks: OnTodoWrappersCallbacks.Remove) {
        removeTodoWrapperUseCase.removeTodoWrapper(todoWrapper, todoWrapperDAO, onRemoveTodoWrappersCallbacks)
    }

}