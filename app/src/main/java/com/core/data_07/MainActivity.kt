package com.core.data_07

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button


import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {

    //-----------------------------------------------------------------------------------------------------------------
    //  ON CREATE
    //
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        //-------------------------------------------------------------------------------------------------------------
        //  Product Activity onClickListener with Intent
        //
        val productActivityBtn_1 = findViewById(R.id.menswear) as Button
        val productActivityBtn_2 = findViewById(R.id.womenswear) as Button
        val productActivityBtn_3 = findViewById(R.id.boyswear) as Button
        val productActivityBtn_4 = findViewById(R.id.girlswear) as Button
        val productActivityBtn_5 = findViewById(R.id.home) as Button
        val productActivityBtn_6 = findViewById(R.id.garden) as Button


        // set on-click listener
        //
        productActivityBtn_1.setOnClickListener {
            // your code to perform when the user clicks on the button
            startActivity(Intent(this,MensWearActivity::class.java));
        }

        // set on-click listener
        //
        productActivityBtn_2.setOnClickListener {
            // your code to perform when the user clicks on the button
            startActivity(Intent(this,WomensWearActivity::class.java));
        }

        // set on-click listener
        //
        productActivityBtn_3.setOnClickListener {
            // your code to perform when the user clicks on the button
            startActivity(Intent(this,BoysWearActivity::class.java));
        }

        // set on-click listener
        //
        productActivityBtn_4.setOnClickListener {
            // your code to perform when the user clicks on the button
            startActivity(Intent(this,GirlsWearActivity::class.java));
        }

        // set on-click listener
        //
        productActivityBtn_5.setOnClickListener {
            // your code to perform when the user clicks on the button
            startActivity(Intent(this,HomeActivity::class.java));
        }

        // set on-click listener
        //
        productActivityBtn_6.setOnClickListener {
            // your code to perform when the user clicks on the button
            startActivity(Intent(this,GardenActivity::class.java));
        }

        //-------------------------------------------------------------------------------------------------------------


    }
    //  END ON CREATE
    //-----------------------------------------------------------------------------------------------------------------



    override fun onClick(v: View?) {

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    //---------------------------------------------------------------------------------------------------------------------------------------
    //  2   USER CLICKING THE ACTION BAR MENU SIGN IN CAUSES AN INTENT TO START SigninActivity
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