package com.felzr.api.caloria.api.service

import com.felzr.api.caloria.api.request.FoodRequest
import com.felzr.api.caloria.api.response.FoodResponse
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface FoodService {
    fun findAllFoods(): Flux<FoodResponse>
    fun saveFood(request: FoodRequest): Mono<Void>

}