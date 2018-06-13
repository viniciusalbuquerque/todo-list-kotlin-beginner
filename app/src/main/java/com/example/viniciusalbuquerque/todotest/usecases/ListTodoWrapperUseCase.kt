package com.example.viniciusalbuquerque.todotest.usecases

import com.example.viniciusalbuquerque.todotest.daos.TodoWrapperDAO
import com.example.viniciusalbuquerque.todotest.models.interfaces.OnRequestReponse

class ListTodoWrapperUseCase : OnRequestReponse {

    fun loadTodoWrappers(todoWrapperDAO: TodoWrapperDAO) {
        todoWrapperDAO.read(this)
    }

    override fun onRequestSuccess(response: Any) {

    }

    override fun onRequestError(error: Any) {

    }
}