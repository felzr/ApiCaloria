package com.felzr.api.caloria.api.controller

import com.felzr.api.caloria.api.response.FoodResponse
import com.felzr.api.caloria.api.service.FoodService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("/api/foods")
class FoodController(val foodService: FoodService) {
    @GetMapping
    fun findAllFoods(): Flux<FoodResponse> {
        return foodService.findAllFoods()
    }
}