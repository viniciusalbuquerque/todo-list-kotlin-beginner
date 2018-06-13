package com.example.viniciusalbuquerque.todotest.presenters

import com.example.viniciusalbuquerque.todotest.WebRequests
import com.example.viniciusalbuquerque.todotest.contracts.TodoWrapperContract
import com.example.viniciusalbuquerque.todotest.daos.TodoWrapperDAO
import com.example.viniciusalbuquerque.todotest.interactors.TodoWrapperInteractor
import com.example.viniciusalbuquerque.todotest.models.classes.TODOWrapper
import com.example.viniciusalbuquerque.todotest.usecases.AddTodoWrapperUserCase
import com.example.viniciusalbuquerque.todotest.usecases.ListTodoWrapperUseCase
import com.example.viniciusalbuquerque.todotest.usecases.RemoveTodoWrapperUserCase

class TodoWrapperPresenter(val view : TodoWrapperContract.View, val interactor: TodoWrapperInteractor) : TodoWrapperContract.Presenter {

    // This is a temporary variable that is being used while the server isn't working as expected.
    var tempLongIDs : Long = 0L

    private val todoWrapperInteractor : TodoWrapperInteractor

    init {
        todoWrapperInteractor = TodoWrapperInteractor(ListTodoWrapperUseCase(), AddTodoWrapperUserCase(), RemoveTodoWrapperUserCase())
    }

    override fun addTodoWrapperDialogButtonClicked(todoWrapperTitle : String, todoWrapperDAO: TodoWrapperDAO) {
        interactor.addNewTodoWrapper(todoWrapperTitle, todoWrapperDAO)
        view.finishAddingNewTodoWrapper(TODOWrapper(tempLongIDs, todoWrapperTitle))
        todoWrapperTitle.plus(1)
    }


    override fun fabAddTodoWrapperClicked() {
        view.showAddNewTodoWrapperDialog()
    }

    override fun listTodoWrappers(todoWrapperDAO: TodoWrapperDAO) {
        interactor.listTodoWrappers(todoWrapperDAO)
    }

    override fun deleteTodoWrapper(todoWrapper : TODOWrapper, todoWrapperDAO: TodoWrapperDAO) {
        interactor.deleteTodoWrapper(todoWrapper, todoWrapperDAO)
    }


}