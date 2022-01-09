package com.example.appdeprueba

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.appdeprueba.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var toogle: ActionBarDrawerToggle


    overrride fun onCreate(SavedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toogle=ActionBarDrawerToggle(this, drawerlayout, R.string.open_drawer, R.string.close_drawer)
        drawerLayout.addDrawerListener(toogle)
        toogle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)



        nav.view.setNavigationItemSelectedListener {
            it:MenuItem
            when (it.itemId) {
                R.id.nav_home -> {
                    supportFragmentManager.beginTransaction().apply {
                        this:FragmentTransaction
                        replace(R.id.fragmentContainerView, HomeFragment())
                        commit()
                    }
                }
                R.id.nav_camera -> {
                    supportFragmentManager.beginTransaction().apply {
                        this:FragmentTransaction
                        replace(R.id.fragmentContainerView, CameraFragment())
                        commit()
                    }
                }
                R.id.nav_gallery -> {
                    supportFragmentManager.beginTransaction().apply {
                        this:FragmentTransaction
                        replace(R.id.fragmentContainerView, GalleryFragment())
                        commit()
                    }
                }
                R.id.nav_messages -> {
                    supportFragmentManager.beginTransaction().apply {
                        this:FragmentTransaction
                        replace(R.id.fragmentContainerView, MessagesFragment())
                        commit()
                    }
                }

            }
            drawerlayout.closeDrawer(GravityCompat)

            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toogle.onOptionsItemSelected(item)) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }


}




