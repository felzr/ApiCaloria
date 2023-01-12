package com.felzr.api.caloria.api.food.response

import com.felzr.api.caloria.api.food.model.Food

class FoodResponse(val id: String, val name: String) {
    companion object {
        fun fromEntity(food: Food): FoodResponse = FoodResponse(id = food.id!!.toString(), name = food.name)
    }
}