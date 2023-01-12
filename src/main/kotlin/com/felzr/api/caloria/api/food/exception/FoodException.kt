package com.felzr.api.caloria.api.food.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import java.lang.RuntimeException

@ResponseStatus(HttpStatus.NOT_FOUND)
class FoodException(msg: String) : RuntimeException(msg) {

}