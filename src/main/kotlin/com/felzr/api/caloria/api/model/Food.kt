package com.felzr.api.caloria.api.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("foods")
data class Food(@Id val id: String?, var name: String) {}