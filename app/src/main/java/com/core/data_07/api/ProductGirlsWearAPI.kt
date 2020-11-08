package com.core.data_07.api

import com.core.data_07.models.ProductGirlsWearList
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
interface ProductGirlsWearAPI {
    @GET("?key= INSERT YOUR PIXABAY KEY HERE &q=children girls fashion&image_type=photo")
    fun getProducts(): Call<ProductGirlsWearList>
}