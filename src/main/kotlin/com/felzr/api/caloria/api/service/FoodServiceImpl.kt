package com.felzr.api.caloria.api.service

import com.felzr.api.caloria.api.repository.FoodRespository
import com.felzr.api.caloria.api.response.FoodResponse
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class FoodServiceImpl(val foodRepository: FoodRespository) : FoodService {
    override fun findAllFoods(): Flux<FoodResponse> {
        return foodRepository.findAll().map { FoodResponse.fromEntity(it) }
    }
}