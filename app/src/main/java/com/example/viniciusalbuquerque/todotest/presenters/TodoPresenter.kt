package com.example.viniciusalbuquerque.todotest.presenters

import com.example.viniciusalbuquerque.todotest.contracts.TodoContract
import com.example.viniciusalbuquerque.todotest.interactors.TodoInteractor
import com.example.viniciusalbuquerque.todotest.models.classes.TODOWrapper
import com.example.viniciusalbuquerque.todotest.usecases.AddTodoUseCase
import com.example.viniciusalbuquerque.todotest.usecases.RemoveTodoUseCase
import com.example.viniciusalbuquerque.todotest.usecases.UpdateTodoUseCase

class TodoPresenter(val view : TodoContract.View) : TodoContract.Presenter {

    private val interactor : TodoInteractor = TodoInteractor(AddTodoUseCase(), RemoveTodoUseCase(), UpdateTodoUseCase())

    override fun fabAddTodoClicked() {
        view.showAddNewTodoDialog()
    }

    override fun addTodoDialogButtonClicked(todoWrapperId: Long, todoTitle: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteTodo(todoWrapper: TODOWrapper) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun cancelRequestsFromDAO() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateTodo(todoWrapperId: Long, todoId: Long, done: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}