package com.felzr.api.caloria.api.food.controller

import com.felzr.api.caloria.api.food.request.FoodRequest
import com.felzr.api.caloria.api.food.response.FoodResponse
import com.felzr.api.caloria.api.food.service.FoodService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api")
class FoodController(val foodService: FoodService) {
    @GetMapping("/foods")
    fun findAllFoods(): Flux<FoodResponse> {
        return foodService.findAllFoods()
    }

    @PostMapping("/save-food")
    fun saveFood(@RequestBody request: FoodRequest): Mono<FoodResponse> = foodService.saveFood(request)
}