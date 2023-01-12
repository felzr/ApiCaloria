package com.felzr.api.caloria.api.food.model

import com.felzr.api.caloria.api.food.request.FoodRequest
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("foods")
data class Food(@Id val id: String?, var name: String) {
    companion object {
        fun toEntity(request: FoodRequest): Food = Food(id = null, name = request.name)
    }
}