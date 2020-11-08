package com.core.data_07

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.core.data_07.api.ProductBoysWearRetreiver
import com.core.data_07.models.ProductBoysWear
import com.core.data_07.models.ProductBoysWearList
import kotlinx.android.synthetic.main.activity_boyswear.*


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class BoysWearActivity : AppCompatActivity(), View.OnClickListener {

    //  These variables are assosiated with the Recycler View in activity_main.xml
    //
    var photos : List<ProductBoysWear>? = null
    var mainAdapterBoysWear : MainAdapterBoysWear? = null
    lateinit var recyclerView_3 : RecyclerView



    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //  ONCREATE
    //
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boyswear)
        setSupportActionBar(toolbar_3)


        //---------------------------------------------------------------------------------------------------------------------------------------
        //  SETTINGS PREFERENCES STEP 1
        //
        val settings = PreferenceManager.getDefaultSharedPreferences(this)

        //  This is checking if the checkbox in the SETTINGS option on the toolbar has been checked
        //
        val grid = settings.getBoolean(getString(R.string.pref_display_grid), false)
        //---------------------------------------------------------------------------------------------------------------------------------------


        //---------------------------------------------------------------------------------------------------------------------------------------
        //  Use Rest API to get photos List and send them to RecyclerView_1 im xml file assosiated with WomensWearActivity

        //  Setup Recycler View
        //
        recyclerView_3 = findViewById(R.id.recyclerView_3) as RecyclerView
        recyclerView_3.layoutManager =
            LinearLayoutManager(this)
        //---------------------------------------------------------------------------------------------------------------------------------------


        //---------------------------------------------------------------------------------------------------------------------------------------
        //  SETTINGS PREFERENCES STEP 2
        //
        if (grid) {
            recyclerView_3.setLayoutManager(
                GridLayoutManager(
                    this,
                    3
                )
            )
        }
        //---------------------------------------------------------------------------------------------------------------------------------------


        //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        //  Create Instance of our REST API Class
        //
        var retriever = ProductBoysWearRetreiver()    //  Variable that can make our API call
        val callback = object : Callback<ProductBoysWearList> {      //  This callback is needed by the Retreiver Class

            override fun onResponse(call: Call<ProductBoysWearList>, response: Response<ProductBoysWearList>) {
                response?.isSuccessful.let {
                    this@BoysWearActivity.photos = response?.body()?.hits  //  The @ symbol is how you reference your outer Activity in Kotlin - THIS "hits" is the name of the array on the JSON RESOURCE WEB FEED
                    mainAdapterBoysWear = MainAdapterBoysWear(this@BoysWearActivity.photos!!,
                        this@BoysWearActivity)
                    recyclerView_3.adapter = mainAdapterBoysWear
                }
            }

            override fun onFailure(call: Call<ProductBoysWearList>, t: Throwable) {
                Log.e("MainActivity", "Problems calling API", t)
            }

        }

        retriever.getProducts(callback)
        //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    }
    //  END ONCREATE
    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------



    //  Create new Intent to start the DetailActivityBoysWear
    //  passing the Photo object via the MainAdapters PhotoHolder method
    //
    override fun onClick(view: View?) {
        val intent = Intent(this, DetailActivityBoysWear::class.java)
        val holder = view?.tag as MainAdapterBoysWear.PhotoHolder
        intent.putExtra(
            DetailActivityBoysWear.PHOTO,
            mainAdapterBoysWear?.getProducts(holder.adapterPosition)

        )
        startActivity(intent)
    }





    //---------------------------------------------------------------------------------------------------------------------------------------
    //  SETTINGS PREFERENCES STEP 3
    //
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
    //---------------------------------------------------------------------------------------------------------------------------------------


    //---------------------------------------------------------------------------------------------------------------------------------------
    //  SETTINGS PREFERENCES STEP 4
    //
    //  USER CLICKING THE ACTION BAR SETTINGS CAUSES AN INTENT TO START PrefsActivity
    //
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {



            //  SETTINGS OPTION FOR PREFERENCES
            //
            //  1   USER CHOOSES MENU CHOICE on Toolbar named SETTINGS while on MAINACTIVITY
            //  2   THAT LOADS PREFSACTIVITY
            //  3   PREFSACTIVITY LOADS SETTINGS FRAGMENT
            //  4   SETTINGS FRAGMENT LOADS SETTINGS
            //
            R.id.action_settings -> {
                val settingsIntent = Intent(this, PrefsActivity::class.java)
                startActivity(settingsIntent)
                return true
            }


        }
        return super.onOptionsItemSelected(item)
    }
    //---------------------------------------------------------------------------------------------------------------------------------------


}
