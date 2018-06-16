package com.example.viniciusalbuquerque.todotest.parsers

import com.example.viniciusalbuquerque.todotest.models.classes.TODO
import com.example.viniciusalbuquerque.todotest.models.classes.TODOWrapper

interface Parser {

    interface TodoWrapperParser {
        fun parseList(response : Any) : ArrayList<TODOWrapper>
        fun parseTodoWrapper(response: Any) : TODOWrapper
        fun parseRemove(response: Any) : TODOWrapper
    }

    interface TodoParser {
        fun parseTodo(response: Any) : TODO
        fun parseRemove(response: Any) : TODO
        fun parseUpdate(response: Any) : String //message?
    }


}