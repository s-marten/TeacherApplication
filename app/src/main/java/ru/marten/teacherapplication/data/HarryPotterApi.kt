package ru.marten.teacherapplication.data

import retrofit2.http.GET
import retrofit2.http.Query
import ru.marten.teacherapplication.data.dto.SpellDto

interface HarryPotterApi {

    @GET("/Spells")
    suspend fun getSpells(@Query("Type") type: String): List<SpellDto>

}