package com.example.viniciusalbuquerque.todotest.environment.parsers

import com.example.viniciusalbuquerque.todotest.domain.parsers.Parser
import com.example.viniciusalbuquerque.todotest.models.classes.TODO

class TodoJSONParser : Parser.TodoParser {

    override fun parseTodo(response: Any): TODO {
        return TODO(1L, "First")
    }

    override fun parseRemove(response: Any): TODO {
        return TODO(1L, "First")
    }

    override fun parseUpdate(response: Any): String {
        return "Updated"
    }

}