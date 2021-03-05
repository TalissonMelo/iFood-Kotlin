package com.talissonmelo.iFood.exceptions

import com.talissonmelo.iFood.model.exceptions.CidadeException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.util.*

@ControllerAdvice
class ExceptionHandlers  {

    @ExceptionHandler(CidadeException::class)
    fun CidadeException(exception: CidadeException, locale: Locale) = ResponseEntity.badRequest();

}