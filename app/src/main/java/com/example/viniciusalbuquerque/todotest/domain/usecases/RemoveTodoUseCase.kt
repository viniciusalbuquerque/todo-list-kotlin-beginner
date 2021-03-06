package com.example.viniciusalbuquerque.todotest.domain.usecases

import com.example.viniciusalbuquerque.todotest.domain.daos.TodoDAO
import com.example.viniciusalbuquerque.todotest.domain.interfaces.OnRequestReponse
import com.example.viniciusalbuquerque.todotest.domain.interfaces.OnTodoCallbacks
import com.example.viniciusalbuquerque.todotest.domain.parsers.Parser

class RemoveTodoUseCase(val parser: Parser.TodoParser) : OnRequestReponse {

    private var onTodoCallbacks : OnTodoCallbacks.Remove? = null

    fun removeTodo(todoWrapperId : Long, todoId : Long, todoDAO: TodoDAO, onTodoCallbacks: OnTodoCallbacks.Remove) {
        this.onTodoCallbacks = onTodoCallbacks
        todoDAO.delete(todoWrapperId, todoId, this)
    }

    override fun onRequestSuccess(response: Any) {
        this.onTodoCallbacks?.finishedRemovingTodo(parser.parseRemove(response))
    }

    override fun onRequestError(error: Any) {
        this.onTodoCallbacks?.finishedRemovingTodoWithError(parser.parseRemove(error))
    }

}