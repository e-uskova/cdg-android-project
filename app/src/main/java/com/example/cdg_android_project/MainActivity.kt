package com.example.cdg_android_project

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.cdg_android_project.Match.Companion.toMatchEntity
import com.example.cdg_android_project.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject


class MainActivity : AppCompatActivity() {
    private val _webApi: IWebApi by inject()

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        //runTask1()

        val firstFragment = FirstFragment()
        setNewFragment(firstFragment)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        getDataFromWeb()
    }

    private fun getDataFromWeb() {
        lifecycleScope.launch(Dispatchers.IO) {
            _webApi.getMatches().collect {
                MatchesDatabase.getDatabase()?.matchesDao()?.addMatch(it.toMatchEntity())
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return false
    }

    private fun setNewFragment(fragment: Fragment) {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.frame_layout, fragment)
        ft.commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                val firstFragment = FirstFragment()
                setNewFragment(firstFragment)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
