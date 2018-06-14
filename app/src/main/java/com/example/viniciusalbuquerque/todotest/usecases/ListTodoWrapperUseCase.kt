package com.example.viniciusalbuquerque.todotest.usecases

import com.example.viniciusalbuquerque.todotest.daos.TodoWrapperDAO
import com.example.viniciusalbuquerque.todotest.models.interfaces.OnRequestReponse
import com.example.viniciusalbuquerque.todotest.models.interfaces.OnTodoWrappersCallbacks

class ListTodoWrapperUseCase() : OnRequestReponse {

    private var onListTodoWrappersCallback : OnTodoWrappersCallbacks.List? = null

    fun loadTodoWrappers(todoWrapperDAO: TodoWrapperDAO, onListTodoWrappersCallback: OnTodoWrappersCallbacks.List) {
        todoWrapperDAO.read(this)
        this.onListTodoWrappersCallback = onListTodoWrappersCallback
    }

    override fun onRequestSuccess(response: Any) {
        //Parse response to a list of TODOWrappers
        onListTodoWrappersCallback?.finishedLoadingList(ArrayList())
    }

    override fun onRequestError(error: Any) {
        onListTodoWrappersCallback?.finishedLoadingListWithError(error)
    }
}