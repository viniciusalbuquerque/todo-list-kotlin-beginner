package com.example.viniciusalbuquerque.todotest.domain.usecases

import com.example.viniciusalbuquerque.todotest.domain.daos.TodoWrapperDAO
import com.example.viniciusalbuquerque.todotest.domain.interfaces.OnRequestReponse
import com.example.viniciusalbuquerque.todotest.domain.interfaces.OnTodoWrappersCallbacks
import com.example.viniciusalbuquerque.todotest.domain.parsers.Parser

class ListTodoWrapperUseCase(val todoWrapperParser: Parser.TodoWrapperParser) : OnRequestReponse {

    private var onListTodoWrappersCallback : OnTodoWrappersCallbacks.List? = null

    fun loadTodoWrappers(todoWrapperDAO: TodoWrapperDAO, onListTodoWrappersCallback: OnTodoWrappersCallbacks.List) {
        todoWrapperDAO.read(this)
        this.onListTodoWrappersCallback = onListTodoWrappersCallback
    }

    override fun onRequestSuccess(response: Any) {
        //Parse response to a list of TODOWrappers
        onListTodoWrappersCallback?.finishedLoadingList(todoWrapperParser.parseList(response))
    }

    override fun onRequestError(error: Any) {
        onListTodoWrappersCallback?.finishedLoadingListWithError(error)
    }
}