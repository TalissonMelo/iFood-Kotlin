package com.talissonmelo.iFood.model.exceptions

import org.springframework.context.MessageSourceResolvable

abstract class CidadeExceptions : RuntimeException, MessageSourceResolvable {
    constructor(message: String) : super(message) { }
}

class CidadeException(message: String) : CidadeExceptions(message) {
    override fun getCodes(): Array<String>? {
        TODO("Not yet implemented")
    }
}