package com.example.comftyaccess

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.RecyclerView.SmoothScroller.Action
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var action: Action
    private var email:String? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val toolbar: Toolbar = findViewById(R.id.mainToolbar)
        setSupportActionBar(toolbar)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

       val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.main_nav_host) as? NavHostFragment
        navController =
            navHostFragment?.navController ?: throw RuntimeException("NavController not found")
        setupActionBarWithNavController(navController)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_profile -> {
                    val bundle = Bundle()
                    bundle.putString("email", email)
                    navController.navigate(R.id.action_global_myProfileFragment, bundle)
                    true
                }
                R.id.nav_home -> {
                    navController.navigate(R.id.action_global_allReviewsFragment)
                    true
                }
                 R.id.nav_filter -> {
                    navController.navigate(R.id.action_global_filterFragment)
                    true
                }

                else -> false
            }


        }
            
    }
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}