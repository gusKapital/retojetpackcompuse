package com.kapital.retojetpackcompuse.data.remote

import com.kapital.retojetpackcompuse.data.model.CardResponse
import retrofit2.http.GET

interface CardApi {

    @GET("cardinfo.php")
    suspend fun getCards(): CardResponse
}