package com.example.viniciusalbuquerque.todotest.presenters

import com.example.viniciusalbuquerque.todotest.contracts.TodoWrapperContract
import com.example.viniciusalbuquerque.todotest.daos.TodoWrapperDAO
import com.example.viniciusalbuquerque.todotest.interactors.TodoWrapperInteractor
import com.example.viniciusalbuquerque.todotest.models.classes.TODOWrapper
import com.example.viniciusalbuquerque.todotest.models.interfaces.OnTodoWrappersCallbacks
import com.example.viniciusalbuquerque.todotest.parsers.Parser
import com.example.viniciusalbuquerque.todotest.usecases.AddTodoWrapperUseCase
import com.example.viniciusalbuquerque.todotest.usecases.ListTodoWrapperUseCase
import com.example.viniciusalbuquerque.todotest.usecases.RemoveTodoWrapperUseCase

class TodoWrapperPresenter(val view : TodoWrapperContract.View, val todoWrapperDAO: TodoWrapperDAO, todoWrapperParser: Parser.TodoWrapperParser) : TodoWrapperContract.Presenter,
        OnTodoWrappersCallbacks.List, OnTodoWrappersCallbacks.Add, OnTodoWrappersCallbacks.Remove {

    private val todoWrapperInteractor : TodoWrapperInteractor = TodoWrapperInteractor(ListTodoWrapperUseCase(todoWrapperParser), AddTodoWrapperUseCase(todoWrapperParser), RemoveTodoWrapperUseCase(todoWrapperParser))

    override fun finishedAddingTodoWrapper(todoWrapper: TODOWrapper) {
        view.finishAddingNewTodoWrapper(todoWrapper)
    }

    override fun finishedAddingTodoWrapperWithError(error: Any) {
        view.finishAddingNewTodoWrapperWithError(error)
    }

    override fun addTodoWrapperDialogButtonClicked(todoWrapperTitle : String) {
        todoWrapperInteractor.addNewTodoWrapper(todoWrapperTitle, todoWrapperDAO, this)
    }

    override fun fabAddTodoWrapperClicked() {
        view.showAddNewTodoWrapperDialog()
    }

    override fun listTodoWrappers() {
        todoWrapperInteractor.listTodoWrappers(todoWrapperDAO, this)
    }

    override fun finishedLoadingList(todoWrappers : ArrayList<TODOWrapper>) {
        view.finishLoadingList(todoWrappers)
    }

    override fun finishedLoadingListWithError(error: Any) {
        view.finishLoadingListWithError(error)
    }

    override fun deleteTodoWrapper(todoWrapper : TODOWrapper) {
        todoWrapperInteractor.deleteTodoWrapper(todoWrapper, todoWrapperDAO, this)
    }

    override fun finishedRemovingTodoWrapper(todoWrapper: TODOWrapper) {
        view.finishedRemovingTodoWrapper(todoWrapper)
    }

    override fun finishedRemovingTodoWrapperWithError(error: Any) {
        view.finishLoadingListWithError(error)
    }

    override fun cancelRequestsFromDAO() {
        todoWrapperDAO.cancelRequests()
    }

}