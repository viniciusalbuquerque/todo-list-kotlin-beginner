package com.example.viniciusalbuquerque.todotest.domain.usecases

import com.example.viniciusalbuquerque.todotest.daos.TodoDAO
import com.example.viniciusalbuquerque.todotest.models.interfaces.OnRequestReponse
import com.example.viniciusalbuquerque.todotest.models.interfaces.OnTodoCallbacks
import com.example.viniciusalbuquerque.todotest.parsers.Parser

class UpdateTodoUseCase(val todoWrapperParser: Parser.TodoParser) : OnRequestReponse {

    private var onUpdateTodoCallbacks : OnTodoCallbacks.Update? = null

    fun updateTodo(todoWrapperId : Long, todoId: Long, done : Boolean, todoDAO: TodoDAO, onUpdateTodoCallbacks: OnTodoCallbacks.Update) {
        this.onUpdateTodoCallbacks = onUpdateTodoCallbacks
        todoDAO.update(todoWrapperId, todoId, done, this)
    }

    override fun onRequestSuccess(response: Any) {
        onUpdateTodoCallbacks?.finishedUpdatingTodo(todoWrapperParser.parseTodo(response))
    }

    override fun onRequestError(error: Any) {
        onUpdateTodoCallbacks?.finishedUpdatingTodoWithError(todoWrapperParser.parseTodo(error))
    }

}