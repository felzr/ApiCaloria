package com.felzr.api.caloria.api.food.service

import com.felzr.api.caloria.api.food.enums.FoodMessages
import com.felzr.api.caloria.api.food.exception.FoodException
import com.felzr.api.caloria.api.food.model.Food
import com.felzr.api.caloria.api.food.repository.FoodRespository
import com.felzr.api.caloria.api.food.request.FoodRequest
import com.felzr.api.caloria.api.food.response.FoodResponse
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class FoodServiceImpl(val foodRepository: FoodRespository) : FoodService {
    override fun findAllFoods(): Flux<FoodResponse> =
        foodRepository.findAll().map { FoodResponse.fromEntity(it) }.switchIfEmpty(
            Flux.error(
                FoodException(FoodMessages.LIST_ERROR.msg)
            )
        )

    override fun saveFood(request: FoodRequest): Mono<FoodResponse> =
        foodRepository.save(Food.toEntity(request)).map { FoodResponse.fromEntity(it) }.or(
            Mono.error(FoodException(FoodMessages.SAVE_ERROR.msg))
        )

    override fun findById(id: String): Mono<FoodResponse> =
        foodRepository.findById(id).map { FoodResponse.fromEntity(it) }
            .switchIfEmpty(
                Mono.error(
                    FoodException(FoodMessages.FOOD_NOOT_FOUND.msg)
                )
            )

    override fun updateFood(reques: FoodRequest): Mono<FoodResponse> =
        foodRepository.save(Food.toEntity(reques)).map { FoodResponse.fromEntity(it) }.or(
            Mono.error(FoodException(FoodMessages.UPDATE_ERROR.msg))
        )

    override fun deleteFood(id: String): Mono<Void> = foodRepository.deleteById(id).or(
        Mono.error(FoodException(FoodMessages.DELETE_ERROR.msg))
    )

    override fun saveFoods(foods: List<FoodRequest>): Flux<FoodResponse> {
        var listFoods = foods.map { Food.toEntity(it) }
        return foodRepository.saveAll(listFoods).map { FoodResponse.fromEntity(it) }
            .or(Mono.error(FoodException(FoodMessages.SAVE_ALL_ERROR.msg)))
    }

}