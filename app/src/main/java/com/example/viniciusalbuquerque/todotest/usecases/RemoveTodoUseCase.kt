package com.example.viniciusalbuquerque.todotest.usecases

import com.example.viniciusalbuquerque.todotest.daos.TodoDAO
import com.example.viniciusalbuquerque.todotest.models.interfaces.OnRequestReponse
import com.example.viniciusalbuquerque.todotest.models.interfaces.OnTodoCallbacks
import com.example.viniciusalbuquerque.todotest.parsers.Parser

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