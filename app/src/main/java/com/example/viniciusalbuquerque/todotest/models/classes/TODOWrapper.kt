package com.example.viniciusalbuquerque.todotest.models.classes

import java.io.Serializable

class TODOWrapper(val id : Long, val title : String) : Serializable {
//    var title: String? = null
    var todoActivies: ArrayList<TODO>? = null
}
