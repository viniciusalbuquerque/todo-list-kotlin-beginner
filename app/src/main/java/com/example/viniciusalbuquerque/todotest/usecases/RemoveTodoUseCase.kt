package com.example.viniciusalbuquerque.todotest.usecases

import com.example.viniciusalbuquerque.todotest.models.interfaces.OnRequestReponse

class RemoveTodoUseCase : OnRequestReponse {

    fun removeTodo(todoId : Long, todoWrapperId : Long) {
        
    }

    override fun onRequestSuccess(response: Any) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onRequestError(error: Any) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}