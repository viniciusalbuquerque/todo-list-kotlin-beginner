package com.example.viniciusalbuquerque.todotest.domain.interfaces

import com.example.viniciusalbuquerque.todotest.models.classes.TODO

interface OnTodoCallbacks {

    interface Add {
        fun finishedAddingTodo(todo : TODO)
        fun finishedAddingTodoError(error: Any)
    }

    interface Remove {
        fun finishedRemovingTodo(todo : TODO)
        fun finishedRemovingTodoWithError(error: Any)
    }


    interface Update {
        fun finishedUpdatingTodo(todo : TODO)
        fun finishedUpdatingTodoWithError(error: Any)
    }

}