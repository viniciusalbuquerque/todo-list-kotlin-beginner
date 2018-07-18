package com.example.viniciusalbuquerque.todotest.domain.usecases

import com.example.viniciusalbuquerque.todotest.domain.daos.TodoDAO
import com.example.viniciusalbuquerque.todotest.domain.interfaces.OnRequestReponse
import com.example.viniciusalbuquerque.todotest.domain.interfaces.OnTodoCallbacks
import com.example.viniciusalbuquerque.todotest.domain.parsers.Parser

class ListToDosUseCase(val parser: Parser.TodoParser) : OnRequestReponse {

    var onListTodoCallback : OnTodoCallbacks.List ?= null

    fun loadTodos(todoWrapperId : Long, todoDAO: TodoDAO, onListTodoCallback: OnTodoCallbacks.List) {
        todoDAO.read(todoWrapperId,this)
        this.onListTodoCallback = onListTodoCallback
    }

    override fun onRequestSuccess(response: Any) {
        this.onListTodoCallback?.finishedListingTodos(parser.parseList(response))
    }

    override fun onRequestError(error: Any) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}