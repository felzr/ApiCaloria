package com.felzr.api.caloria.api.food.enums

enum class FoodMessages(val msg: String) {
    FOOD_NOOT_FOUND("Não existe esse alimento na base"),
    SAVE_ERROR("Erro ao salvar o alimento"),
    SAVE_ALL_ERROR("Erro ao salvar os alimentos"),
    DELETE_ERROR("Erro ao deletar o Alimento"),
    LIST_ERROR("Não existe alimentos na base"),
    UPDATE_ERROR("Erro ao atualizar o Alimento")
}