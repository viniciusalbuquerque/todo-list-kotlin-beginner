package com.example.viniciusalbuquerque.todotest.usecases

import com.example.viniciusalbuquerque.todotest.daos.TodoWrapperDAO
import com.example.viniciusalbuquerque.todotest.models.classes.TODOWrapper
import com.example.viniciusalbuquerque.todotest.models.interfaces.OnRequestReponse
import com.example.viniciusalbuquerque.todotest.models.interfaces.OnTodoWrappersCallbacks
import com.example.viniciusalbuquerque.todotest.parsers.Parser

class AddTodoWrapperUserCase(val todoWrapperParser: Parser.TodoWrapperParser) : OnRequestReponse {

    private var onAddTodoWrappersCallback : OnTodoWrappersCallbacks.Add? = null
    private var tempTodoWrapper : TODOWrapper? = null

    fun addTodoWrapper(title : String, todoWrapperDAO : TodoWrapperDAO, onAddTodoWrappersCallbacks: OnTodoWrappersCallbacks.Add) {
        tempTodoWrapper = TODOWrapper(-1, title)
        todoWrapperDAO.create(tempTodoWrapper!!, this)
        this.onAddTodoWrappersCallback = onAddTodoWrappersCallbacks
    }

    override fun onRequestSuccess(response: Any) {
        // Parse to TodoWrapper
        this.onAddTodoWrappersCallback?.finishedAddingTodoWrapper(todoWrapperParser.parseTodoWrapper(response))

    }

    override fun onRequestError(error: Any) {
        this.onAddTodoWrappersCallback?.finishedAddingTodoWrapperWithError(error)
    }

}