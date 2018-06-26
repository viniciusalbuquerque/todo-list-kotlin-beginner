package com.example.viniciusalbuquerque.todotest.usecases

import com.example.viniciusalbuquerque.todotest.daos.TodoDAO
import com.example.viniciusalbuquerque.todotest.models.interfaces.OnRequestReponse
import com.example.viniciusalbuquerque.todotest.models.interfaces.OnTodoCallbacks
import com.example.viniciusalbuquerque.todotest.parsers.Parser

class AddTodoUseCase(val parser: Parser.TodoParser) : OnRequestReponse {


    fun addTodo(todoWrapperId: Long, todoTitle : String, todoDAO: TodoDAO, onTodoCallbacks: OnTodoCallbacks.Add) {

    }

    override fun onRequestSuccess(response: Any) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onRequestError(error: Any) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}