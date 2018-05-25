package com.example.viniciusalbuquerque.todotest.models.classes

import java.io.Serializable

class TODO(val id : Long, val title: String) : Serializable {
    var isDone : Boolean = false
}
