package com.example.viniciusalbuquerque.todotest.models.interfaces

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
}