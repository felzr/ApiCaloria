package com.felzr.api.caloria.api.repository

import com.felzr.api.caloria.api.model.Food
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface FoodRespository : ReactiveMongoRepository<Food, ObjectId> {
}