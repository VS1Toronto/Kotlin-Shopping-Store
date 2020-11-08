# Kotlin-Shopping-Store

Live app hosted on Google Play :

https://play.google.com/store/apps/details?id=com.core.data_07&hl=en_US



User journey showcasing functionality :

https://www.behance.net/gallery/82615175/Shopping-Store-App-Kotlin




In order to use the code when downloaded you have to code in your own Pixabay API keys
inside each product lines API script in the API section of the app in directory app/java/api by removing
the section of the code that instructs INSERT YOUR PIXABAY KEY HERE and replacing it with you own Pixabay key


Example :


    package com.core.data_07.api

    import com.core.data_07.models.ProductList
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
    interface ProductAPI {
        @GET("?key= INSERT YOUR PIXABAY KEY HERE &q=fashion&image_type=photo")
        fun getProducts() : Call<ProductList>
    }

