package com.example.viniciusalbuquerque.todotest.interactors

import com.example.viniciusalbuquerque.todotest.daos.TodoDAO
import com.example.viniciusalbuquerque.todotest.models.interfaces.OnTodoCallbacks
import com.example.viniciusalbuquerque.todotest.usecases.AddTodoUseCase
import com.example.viniciusalbuquerque.todotest.usecases.RemoveTodoUseCase
import com.example.viniciusalbuquerque.todotest.usecases.UpdateTodoUseCase

class TodoInteractor (val addTodoUseCase: AddTodoUseCase, val removeTodoUseCase: RemoveTodoUseCase, val updateTodoUseCase: UpdateTodoUseCase) {

    fun updateTodo(todoId: Long, todoWrapperId: Long, done: Boolean, todoDAO: TodoDAO, onTodoCallbacks: OnTodoCallbacks.Update) {
        updateTodoUseCase.updateTodo(todoId, todoWrapperId, done, todoDAO, onTodoCallbacks)
    }

    fun addTodo(todoWrapperId: Long, todoTitle: String, todoDAO: TodoDAO, onTodoCallbacks: OnTodoCallbacks.Add) {
        addTodoUseCase.addTodo(todoWrapperId, todoTitle, todoDAO, onTodoCallbacks)
    }

    fun removeTodo(todoWrapperId: Long, todoId: Long, todoDAO: TodoDAO, onTodoCallbacks: OnTodoCallbacks.Remove) {
        removeTodoUseCase.removeTodo(todoWrapperId, todoId, todoDAO, onTodoCallbacks)
    }

}