package com.felzr.api.caloria.api.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import java.lang.RuntimeException

@ResponseStatus(HttpStatus.NOT_FOUND)
class CaloriaNotFoundException(msg: String) : RuntimeException(msg) {

}