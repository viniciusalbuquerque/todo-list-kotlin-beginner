package com.example.viniciusalbuquerque.todotest.domain.interfaces

import com.example.viniciusalbuquerque.todotest.models.classes.TODOWrapper

interface OnTodoWrappersCallbacks {
    interface List {
        fun finishedLoadingList(todoWrappers : ArrayList<TODOWrapper>)
        fun finishedLoadingListWithError(error : Any)
    }

    interface Add {
        fun finishedAddingTodoWrapper(todoWrapper : TODOWrapper)
        fun finishedAddingTodoWrapperWithError(error: Any)
    }

    interface Remove {
        fun finishedRemovingTodoWrapper(todoWrapper: TODOWrapper)
        fun finishedRemovingTodoWrapperWithError(error: Any)
    }
}