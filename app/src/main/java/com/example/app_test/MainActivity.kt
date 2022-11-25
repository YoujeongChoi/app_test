package com.example.app_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.example.app_test.databinding.ActivityMainBinding
import com.google.android.gms.common.api.internal.LifecycleCallback.getFragment
import java.sql.RowId

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val fl: FrameLayout by lazy {
        findViewById(R.id.fine_dust_map)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initNavigationBar()

//        binding.btmNav.setOnItemSelectedListener {
//            changeFragment(it.itemId)
//            true
//        }

        changeFragment(R.id.tab_home)

    }

    fun initNavigationBar() {
        binding.btmNav.run {
            setOnNavigationItemReselectedListener {
                when(it.itemId) {
                    R.id.tab_home -> {
                        changeFragment(HomeFragment())
                    }
                    R.id.tab_map -> {
                        changeFragment(FineDustMapFragment())
                    }
                    R.id.tab_star -> {
                        changeFragment(BookmarkFragment())
                    }
                    R.id.tab_user -> {
                        changeFragment(MyPageFragment())
                    }
                }
                true
            }
            selectedItemId = R.id.tab_home
        }
    }

    fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.mainContent.id, fragment).commit()
    }

    private fun changeFragment(menuItemId: Int) {
        val targetFragment = getFragment(menuItemId)

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_content, targetFragment)
            .commitAllowingStateLoss()
    }

    private fun getFragment(menuItemId: Int) : Fragment {
        val title = when (menuItemId) {
            R.id.tab_home -> "page1"
            R.id.tab_map -> "page2"
            R.id.tab_star -> "page3"
            R.id.tab_user -> "page4"
            else -> throw IllegalArgumentException("not found menu item id")
        }

        return HomeFragment.newInstance(title)
    }


}