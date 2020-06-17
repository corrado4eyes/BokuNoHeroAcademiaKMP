package com.corrado4eyes.bokunoheroacademiamultiplatform.data.characters

import kotlinx.serialization.Serializable

@Serializable
data class BNHACharacterResponse(
    val id: String,
    val image: String,
    val category: String,
    val characterClass: String,
    val name: String,
    val quirk: String
)
