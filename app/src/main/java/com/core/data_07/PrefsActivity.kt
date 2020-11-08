package com.core.data_07

import android.os.Bundle
import android.preference.PreferenceFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceFragmentCompat
import androidx.appcompat.widget.Toolbar
import android.view.View

class PrefsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prefs)

        //  This ensures that as the activity loads it loads the fragment into the container
        //
        //  The fragment itself is responsible for going and getting the preference definition and loading that
        //
        val fragmentManager = supportFragmentManager

        fragmentManager
            .beginTransaction()
            .add(R.id.prefs_content, SettingsFragment())
            .commit()

        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }


    //  This is a member class named     SettingsFragment     which extends the class     PreferenceFragment
    //
    //  This approach is being used to wrap the preferences screen in a fragment so that
    //  it maintains its state as the devices orientation or other configuration changes
    //
    //  When the fragment loads the onCreate() method will be called just like any other
    //  fragment and we override that method and after the superclasses call we use a method
    //  called     addPreferencesFromResource     and we pass in a reference to the      new settings.xml
    //
    class SettingsFragment : PreferenceFragmentCompat() {
        override fun onCreatePreferences(p0: Bundle?, p1: String?) {
            addPreferencesFromResource(R.xml.settings)     //  This is a reference to the new     settings.xml     file
        }
    }

}

