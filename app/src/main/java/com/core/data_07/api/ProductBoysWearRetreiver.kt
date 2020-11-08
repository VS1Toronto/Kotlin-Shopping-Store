package com.core.data_07.api

import com.core.data_07.models.ProductBoysWearList
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 *  This Class creates a Service and makes a call to the Pixelbay API for us
 */
class ProductBoysWearRetreiver {

    private val service: ProductBoysWearAPI


    /**
     *  Since Primary Constructors cannot contain any code
     *
     *  Kotlin uses the init{} code block for contructor code
     */
    init {

        //  Create Retrofit Object
        //
        val retrofit = Retrofit.Builder().
            baseUrl("https://pixabay.com/api/")
            .addConverterFactory(GsonConverterFactory.create())     //  add Gson Converter Factory to convert JSON data to the data Class
            .build()


        //  Create Service
        //
        //  class.java is Kotlins way of referencing a java Class object
        //
        //  What all this code in init{} does is use Retrofits Builder Class
        //  to construct an API Service for us
        //
        service = retrofit.create(ProductBoysWearAPI::class.java)
    }

    //  This method takes the callback that will be called once the API call has finished
    //  and this method calls the Service and enqueues it which means it will run Asynchronously
    //
    fun getProducts(callback : Callback<ProductBoysWearList>) {
        val call = service.getProducts()
        call.enqueue(callback)
    }
}