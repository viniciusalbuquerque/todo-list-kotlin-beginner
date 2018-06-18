package com.example.viniciusalbuquerque.todotest.interactors

import com.example.viniciusalbuquerque.todotest.usecases.AddTodoUseCase
import com.example.viniciusalbuquerque.todotest.usecases.RemoveTodoUseCase
import com.example.viniciusalbuquerque.todotest.usecases.UpdateTodoUseCase

class TodoInteractor (val addTodoUseCase: AddTodoUseCase, val removeTodoUseCase: RemoveTodoUseCase, val updateTodoUseCase: UpdateTodoUseCase) {

    fun updateTodo(todoId: Long, todoWrapperId: Long, done: Boolean) {
        updateTodoUseCase.updateTodo(todoId, todoWrapperId, done)
    }

}