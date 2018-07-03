package com.example.viniciusalbuquerque.todotest.domain.usecases

import com.example.viniciusalbuquerque.todotest.daos.TodoDAO
import com.example.viniciusalbuquerque.todotest.models.interfaces.OnRequestReponse
import com.example.viniciusalbuquerque.todotest.models.interfaces.OnTodoCallbacks
import com.example.viniciusalbuquerque.todotest.parsers.Parser

class AddTodoUseCase(val parser: Parser.TodoParser) : OnRequestReponse {

    private var onTodoCallbacks : OnTodoCallbacks.Add? = null

    fun addTodo(todoWrapperId: Long, todoTitle : String, todoDAO: TodoDAO, onTodoCallbacks: OnTodoCallbacks.Add) {
        this.onTodoCallbacks = onTodoCallbacks
        todoDAO.create(todoWrapperId, todoTitle, this)
    }

    override fun onRequestSuccess(response: Any) {
        this.onTodoCallbacks?.finishedAddingTodo(parser.parseTodo(response))
    }

    override fun onRequestError(error: Any) {
        this.onTodoCallbacks?.finishedAddingTodoError(parser.parseTodo(error))
    }

}