package com.example.viniciusalbuquerque.todotest.environment.parsers

import com.example.viniciusalbuquerque.todotest.domain.parsers.Parser
import com.example.viniciusalbuquerque.todotest.models.classes.TODOWrapper

class TodoWrapperJSONParser : Parser.TodoWrapperParser {

    override fun parseList(response : Any) : ArrayList<TODOWrapper> {
        return ArrayList()
    }

    override fun parseTodoWrapper(response: Any): TODOWrapper {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun parseRemove(response: Any): TODOWrapper {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}