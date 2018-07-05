package com.example.viniciusalbuquerque.todotest.presenters.contracts

import com.example.viniciusalbuquerque.todotest.models.classes.TODOWrapper

interface TodoWrapperContract {

    interface View {
        fun showAddNewTodoWrapperDialog()
        fun showTodoInfo(todoId: Long)
        fun finishAddingNewTodoWrapper(todoWrapper : TODOWrapper)
        fun finishAddingNewTodoWrapperWithError(error: Any)
        fun finishLoadingList(todoWrappers : ArrayList<TODOWrapper>)
        fun finishLoadingListWithError(error : Any)
        fun finishedRemovingTodoWrapper(todoWrapper: TODOWrapper)
        fun finishedRemovingTodoWrapperWithError(error: Any)
    }

    interface Presenter {
        fun fabAddTodoWrapperClicked()
        fun addTodoWrapperDialogButtonClicked(todoWrapperTitle : String)
        fun listTodoWrappers()
        fun todoSelected(todoId: Long)
        fun deleteTodoWrapper(todoWrapper: TODOWrapper)
        fun cancelRequestsFromDAO()
    }
}