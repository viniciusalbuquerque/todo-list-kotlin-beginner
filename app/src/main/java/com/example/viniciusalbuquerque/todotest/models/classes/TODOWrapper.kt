package com.example.viniciusalbuquerque.todotest.models.classes

import java.io.Serializable

class TODOWrapper(val id : Long) : Serializable {
    var title: String? = null
    var todoActivies: MutableList<TODO>? = null
}
