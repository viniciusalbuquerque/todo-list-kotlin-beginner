package com.example.viniciusalbuquerque.todotest.presenters

import com.example.viniciusalbuquerque.todotest.presenters.contracts.TodoContract
import com.example.viniciusalbuquerque.todotest.domain.daos.TodoDAO
import com.example.viniciusalbuquerque.todotest.domain.interactors.TodoInteractor
import com.example.viniciusalbuquerque.todotest.models.classes.TODO
import com.example.viniciusalbuquerque.todotest.domain.interfaces.OnTodoCallbacks
import com.example.viniciusalbuquerque.todotest.domain.parsers.Parser
import com.example.viniciusalbuquerque.todotest.domain.usecases.AddTodoUseCase
import com.example.viniciusalbuquerque.todotest.domain.usecases.ListToDosUseCase
import com.example.viniciusalbuquerque.todotest.domain.usecases.RemoveTodoUseCase
import com.example.viniciusalbuquerque.todotest.domain.usecases.UpdateTodoUseCase

class TodoPresenter(val view : TodoContract.View, val todoDAO: TodoDAO, val parser: Parser.TodoParser) :
        TodoContract.Presenter, OnTodoCallbacks.Add, OnTodoCallbacks.Update, OnTodoCallbacks.Remove, OnTodoCallbacks.List {

    private val interactor : TodoInteractor = TodoInteractor(ListToDosUseCase(parser), AddTodoUseCase(parser), RemoveTodoUseCase(parser), UpdateTodoUseCase(parser))

    override fun loadTodos(todoWrapperId: Long) {
        interactor.listTodo(todoWrapperId, todoDAO, this)
    }

    override fun finishedListingTodos(todos: ArrayList<TODO>) {
        view.finishedLoadingTodos(todos)
    }

    override fun finishedListingTodosWithError(error: Any) {
        view.finishedLoadingTodosWithError(error)
    }

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