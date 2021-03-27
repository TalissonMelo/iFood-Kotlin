package com.talissonmelo.iFood.exceptions

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler


@ControllerAdvice
class ExceptionHandlers: ResponseEntityExceptionHandler() {

    override
    fun handleMethodArgumentNotValid(ex: MethodArgumentNotValidException, headers: HttpHeaders, status: HttpStatus, request: WebRequest): ResponseEntity<Any> {
        val error = Problema("Error Validation!",   status.value());
        // Percorrer lista de erros da excecao
        for (x in ex.getBindingResult().getFieldErrors()) {
            error.campos.add(Campo(x.field,x.defaultMessage.toString()));
        }
        return super.handleExceptionInternal(ex, error , headers, status, request);
    }
}