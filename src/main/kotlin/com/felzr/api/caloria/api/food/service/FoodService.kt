package com.felzr.api.caloria.api.food.service

import com.felzr.api.caloria.api.food.request.FoodRequest
import com.felzr.api.caloria.api.food.response.FoodResponse
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface FoodService {
    fun findAllFoods(): Flux<FoodResponse>
    fun saveFood(request: FoodRequest): Mono<FoodResponse>
    fun findById(id: String): Mono<FoodResponse>
    fun updateFood(reques: FoodRequest): Mono<FoodResponse>
    fun deleteFood(id: String): Mono<Void>
    fun saveFoods(foods: List<FoodRequest>): Flux<FoodResponse>
}