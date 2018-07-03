package com.example.viniciusalbuquerque.todotest.domain.usecases

import com.example.viniciusalbuquerque.todotest.domain.daos.TodoWrapperDAO
import com.example.viniciusalbuquerque.todotest.models.classes.TODOWrapper
import com.example.viniciusalbuquerque.todotest.models.interfaces.OnRequestReponse
import com.example.viniciusalbuquerque.todotest.models.interfaces.OnTodoWrappersCallbacks
import com.example.viniciusalbuquerque.todotest.domain.parsers.Parser

class RemoveTodoWrapperUseCase(val todoWrapperParser: Parser.TodoWrapperParser) : OnRequestReponse {

    private var onRemoveTodoWrappersCallbacks : OnTodoWrappersCallbacks.Remove? = null

    fun removeTodoWrapper(todoWrapper: TODOWrapper, todoWrapperDAO: TodoWrapperDAO, onRemoveTodoWrappersCallbacks: OnTodoWrappersCallbacks.Remove) {
        todoWrapperDAO.delete(todoWrapper, this)
        this.onRemoveTodoWrappersCallbacks = onRemoveTodoWrappersCallbacks
    }

    override fun onRequestSuccess(response: Any) {
        this.onRemoveTodoWrappersCallbacks?.finishedRemovingTodoWrapper(todoWrapperParser.parseRemove(response))
    }

    override fun onRequestError(error: Any) {
        this.onRemoveTodoWrappersCallbacks?.finishedRemovingTodoWrapper(todoWrapperParser.parseRemove(error))
    }

}