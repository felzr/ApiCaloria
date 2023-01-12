package com.felzr.api.caloria.api.food.service

import com.felzr.api.caloria.api.food.exception.CaloriaNotFoundException
import com.felzr.api.caloria.api.food.model.Food
import com.felzr.api.caloria.api.food.repository.FoodRespository
import com.felzr.api.caloria.api.food.request.FoodRequest
import com.felzr.api.caloria.api.food.response.FoodResponse
import org.bson.types.ObjectId
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class FoodServiceImpl(val foodRepository: FoodRespository) : FoodService {
    override fun findAllFoods(): Flux<FoodResponse> =
        foodRepository.findAll().map { FoodResponse.fromEntity(it) }.switchIfEmpty(
            Flux.error(
                CaloriaNotFoundException("Não existe alimentos na base")
            )
        )

    override fun saveFood(request: FoodRequest): Mono<FoodResponse> =
        foodRepository.save(Food.toEntity(request)).map { FoodResponse.fromEntity(it) }.or(
            Mono.error(CaloriaNotFoundException("Erro ao salvar Alimento"))
        )

    override fun findById(id: String): Mono<FoodResponse> =
        foodRepository.findById(id).map { FoodResponse.fromEntity(it) }
            .switchIfEmpty(
                Mono.error(
                    CaloriaNotFoundException("Alimento não encontrado com esse id id $id")
                )
            )

    override fun updateFood(reques: FoodRequest): Mono<FoodResponse> =
        foodRepository.save(Food.toEntity(reques)).map { FoodResponse.fromEntity(it) }.or(
            Mono.error(CaloriaNotFoundException("Erro ao atualizar o Alimento"))
        )

    override fun deleteFood(id: String): Mono<Void> = foodRepository.deleteById(id).or(
        Mono.error(CaloriaNotFoundException("Erro ao deletar o Alimento"))
    )

    override fun saveFoods(foods: List<FoodRequest>): Flux<FoodResponse> {
        var listFoods = foods.map { Food.toEntity(it) }
        return foodRepository.saveAll(listFoods).map { FoodResponse.fromEntity(it) }
            .or(Mono.error(CaloriaNotFoundException("Erro ao salvar os alimentos")))
    }

}