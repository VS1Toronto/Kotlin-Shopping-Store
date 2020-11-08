package com.core.data_07.api

import com.core.data_07.models.ProductMensWearList
import retrofit2.Call
import retrofit2.http.GET

/**
 *  This Interface defines our REST API
 *
 *  This Class accesses the Pixabay website using the unique key below and API
 *
 *  The annotation below allows access with the Pixabay API and requests images with the
 *  keyword of nature
 */
interface ProductMensWearAPI {
    @GET("?key= INSERT YOUR PIXABAY KEY HERE &q=menswear&image_type=photo")
    fun getProducts(): Call<ProductMensWearList>
}