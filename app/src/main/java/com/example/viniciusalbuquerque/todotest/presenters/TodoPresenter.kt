package com.example.viniciusalbuquerque.todotest.presenters

import com.example.viniciusalbuquerque.todotest.contracts.TodoContract
import com.example.viniciusalbuquerque.todotest.daos.TodoDAO
import com.example.viniciusalbuquerque.todotest.domain.interactors.TodoInteractor
import com.example.viniciusalbuquerque.todotest.models.classes.TODO
import com.example.viniciusalbuquerque.todotest.models.interfaces.OnTodoCallbacks
import com.example.viniciusalbuquerque.todotest.parsers.Parser
import com.example.viniciusalbuquerque.todotest.domain.usecases.AddTodoUseCase
import com.example.viniciusalbuquerque.todotest.domain.usecases.RemoveTodoUseCase
import com.example.viniciusalbuquerque.todotest.domain.usecases.UpdateTodoUseCase

class TodoPresenter(val view : TodoContract.View, val todoDAO: TodoDAO, val parser: Parser.TodoParser) :
        TodoContract.Presenter, OnTodoCallbacks.Add, OnTodoCallbacks.Update, OnTodoCallbacks.Remove {

    private val interactor : TodoInteractor = TodoInteractor(AddTodoUseCase(parser), RemoveTodoUseCase(parser), UpdateTodoUseCase(parser))

    override fun fabAddTodoClicked() {
        view.showAddNewTodoDialog()
    }

    override fun addTodoDialogButtonClicked(todoWrapperId: Long, todoTitle: String) {
        interactor.addTodo(todoWrapperId, todoTitle, todoDAO, this)
    }

    override fun finishedAddingTodo(todo: TODO) {
        view.finishedAddingTodo(todo)
    }

    override fun finishedAddingTodoError(error: Any) {
        view.finishedAddingTodoWithError(error)
    }

    override fun deleteTodo(todoWrapperId: Long, todoId: Long) {
        interactor.removeTodo(todoWrapperId, todoId, todoDAO, this)
    }

    override fun finishedRemovingTodo(todo: TODO) {
        view.finishedRemovingTodo(todo)
    }

    override fun finishedRemovingTodoWithError(error: Any) {
        view.finishedAddingTodoWithError(error)
    }

    override fun updateTodo(todoWrapperId: Long, todoId: Long, done: Boolean) {
        interactor.updateTodo(todoId, todoWrapperId, done, todoDAO, this)
    }

    override fun finishedUpdatingTodo(todo: TODO) {
        view.finishedUpdating(todo)
    }

    override fun finishedUpdatingTodoWithError(error: Any) {
        view.finishedUpdatingWithError(error)
    }

    override fun cancelRequestsFromDAO() {
        todoDAO.cancelRequests()
    }

}