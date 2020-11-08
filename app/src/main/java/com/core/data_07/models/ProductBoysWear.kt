package com.core.data_07.models

import java.io.Serializable

/**
 *  THIS CLASS HOLDS THE PHOTO INFORMATION
 *
 *  To be able to pass this class to another Activity we need
 *  to add Serializable after the constructor with     : Serializable
 *
 *  With this the Class is implementing the Serializable Interface and the
 *  fields in the constructor are what will be coming from the network call as
 *  JSON data
 *
 *  The JSON converter in Retrofit will convert the data into this data Class
 *
 *  Retrofit is a library from Square that makes it easy to call REST APIs on the web
 */
data class ProductBoysWear(val id : String,
                           val tags : String,
                           val cost : Float,
                           val likes: Int,
                           val favourites : Int,
                           val previewURL : String,
                           val webFormatURL : String) : Serializable{
}