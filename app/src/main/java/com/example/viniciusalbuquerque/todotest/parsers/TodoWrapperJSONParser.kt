package com.example.viniciusalbuquerque.todotest.parsers

import com.example.viniciusalbuquerque.todotest.models.classes.TODOWrapper

class TodoWrapperJSONParser : Parser.TodoWrapperParser {

    override fun parseList(response : Any) : ArrayList<TODOWrapper> {
        return ArrayList()
    }

    override fun parseTodoWrapper(response: Any): TODOWrapper {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun parseRemove(response: Any): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}