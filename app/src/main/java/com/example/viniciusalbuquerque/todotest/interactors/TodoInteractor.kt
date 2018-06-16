package com.example.viniciusalbuquerque.todotest.interactors

import com.example.viniciusalbuquerque.todotest.usecases.AddTodoUseCase
import com.example.viniciusalbuquerque.todotest.usecases.RemoveTodoUseCase
import com.example.viniciusalbuquerque.todotest.usecases.UpdateTodoUseCase

class TodoInteractor (val addTodoUseCase: AddTodoUseCase, val removeTodoUseCase: RemoveTodoUseCase, updateTodoUseCase: UpdateTodoUseCase) {



}