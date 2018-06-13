package com.example.viniciusalbuquerque.todotest.usecases

import com.example.viniciusalbuquerque.todotest.daos.TodoWrapperDAO
import com.example.viniciusalbuquerque.todotest.models.classes.TODOWrapper
import com.example.viniciusalbuquerque.todotest.models.interfaces.OnRequestReponse

class RemoveTodoWrapperUserCase : OnRequestReponse {

    fun removeTodoWrapper(todoWrapper: TODOWrapper, todoWrapperDAO: TodoWrapperDAO) {
        todoWrapperDAO.delete(todoWrapper, this)
    }

    override fun onRequestSuccess(response: Any) {

    }

    override fun onRequestError(error: Any) {

    }

}