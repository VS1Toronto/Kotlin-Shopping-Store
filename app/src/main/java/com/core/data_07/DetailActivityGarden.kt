package com.core.data_07

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.core.data_07.models.ProductGarden
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.photo_item.*

class DetailActivityGarden : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_garden)
        setSupportActionBar(toolbar)

        //-------------------------------------------------------------------------------------------------------------
        //  Find Image that user clicked and use Glide to load that
        //  image into the imageView assosiated with this
        //  DetailActivity in the activity_detail.xml
        //
        val imageView = findViewById(R.id.imageView_6) as ImageView
        val product = intent.getSerializableExtra(PHOTO) as ProductGarden?


        product?.previewURL.let {
            Glide.with(this).load(product?.previewURL)
                .into(imageView)
        }

        //  With the correct photo being sent from the MainAdapter getPhoto() method
        //  using adapterPosition this is taken advantage of and the textViews in turn
        //  have their values assignedfrom the photo object here
        //
        product?.cost.let {
            val textView: TextView = findViewById(R.id.cost_detail_11) as TextView


            val randomNumber = (10..100).shuffled().last().toDouble()      //  Random Number Generator used as we Mens Wear web resource does not have cost field

            //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            //  Original code used for Womens Wear as that web resource has a cost field but pixabays does not so random numbers are used
            //
            //  textView.text = "£" + product?.cost.toString()
            //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

            textView.text = "£" + String.format("%.2f", randomNumber)
        }

        //  With the correct photo being sent from the MainAdapter getPhoto() method
        //  using adapterPosition this is taken advantage of and the textViews in turn
        //  have their values assignedfrom the photo object here
        //
        product?.tags.let {
            val textView: TextView = findViewById(R.id.cost_detail_12) as TextView
            textView.text = "Details: " + product?.tags
        }

        imageView.setOnClickListener {
            finish()
        }
        //-------------------------------------------------------------------------------------------------------------

    }

    companion object {
        val PHOTO ="PHOTO"  //  This is used as a key to pass in photos
    }
}