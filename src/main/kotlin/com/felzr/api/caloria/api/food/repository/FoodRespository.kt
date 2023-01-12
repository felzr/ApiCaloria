package com.felzr.api.caloria.api.food.repository

import com.felzr.api.caloria.api.food.model.Food
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Mono

interface FoodRespository : ReactiveMongoRepository<Food, String> {
}