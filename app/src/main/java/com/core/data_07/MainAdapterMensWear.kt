package com.core.data_07

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.core.data_07.models.ProductMensWearList
import com.core.data_07.models.ProductMensWear

/**
 *  In the Adapters Constructor a list of photos and a click listener is passed in
 */
class MainAdapterMensWear(var productMensWear:List<ProductMensWear>, var clickListener : View.OnClickListener) : RecyclerView.Adapter<MainAdapterMensWear.PhotoHolder>() {

    override fun getItemCount(): Int {
        return productMensWear.size      //  Returns number of photos we currently have
    }

    override fun onBindViewHolder(holder: PhotoHolder, position: Int) {
        val product = productMensWear[position]             //  Get the photo at the given position
        val randomNumber = (10..100).shuffled().last().toDouble()      //  Random Number Generator because there is no price field in pixabay images - toDouble() added to allow String.format() to work
        holder?.tags?.text = product.tags

        //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        //  Original code without two decimal points left for reference uses randomNumber as no cost field in web resource
        //
        //  holder?.cost?.text = "£" + randomNumber             //  ""  and using toString() method because these are integers
        //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        holder?.cost?.text = "£" + String.format("%.2f", randomNumber)   //  New code to ensure two decimal places are used

        //holder?.likes?.text = product.likes.toString()    //  ""  and using toString() method because these are integers
        //holder?.favorites?.text = product.tags            //  "" and using toString() method because these are integers
        if (product.previewURL.isNotEmpty()) {
            Glide.with(holder?.tags?.context)
                .load(product.previewURL)
                .into(holder?.photo_item)
        }
    }


    override fun onCreateViewHolder(p0: ViewGroup, viewType: Int): PhotoHolder {
        return PhotoHolder(LayoutInflater.from(p0?.context).inflate(R.layout.photo_item, p0, false))
    }


    //  This function gets a specific photo and is used by MainActivity
    //
    fun getProducts(adapterPosition : Int) : ProductMensWear {
        return productMensWear[adapterPosition]
    }


    inner class PhotoHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var tags : TextView
        var cost : TextView
        var photo_item : ImageView

        init {
            if (clickListener != null) {
                itemView.setOnClickListener(clickListener)
            }
            itemView.tag = this
            tags = itemView.findViewById(R.id.name) as TextView
            cost = itemView.findViewById(R.id.cost) as TextView
            photo_item = itemView.findViewById(R.id.photo_item) as ImageView
        }
    }
}
