package com.starmakers.app.modules.homecontainer.ui
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.starmakers.app.R
import com.starmakers.app.appcomponents.base.BaseActivity
import com.starmakers.app.databinding.ActivityHomeContainerBinding
import com.starmakers.app.modules.activities.ui.ActivitiesFragment
import com.starmakers.app.modules.financialoverview.ui.FinancialOverviewFragment
import com.starmakers.app.modules.home.ui.HomeFragment
import com.starmakers.app.modules.homecontainer.`data`.viewmodel.HomeContainerVM
import com.starmakers.app.modules.search.ui.SearchFragment
import kotlin.String
import kotlin.Unit

class HomeContainerActivity :
    BaseActivity<ActivityHomeContainerBinding>(R.layout.activity_home_container) {
  private val viewModel: HomeContainerVM by viewModels<HomeContainerVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.homeContainerVM = viewModel
   replaceFragment(HomeFragment())
    window.statusBarColor= ContextCompat.getColor(this,R.color.statusbar2)
  }

  override fun setUpClicks(): Unit {

    binding.frameBottombar.setOnItemSelectedListener {

      when(it.itemId ){
        R.id.linearColumnhome -> {
          replaceFragment(HomeFragment())
        }

        R.id.linearColumnWallet -> replaceFragment(SearchFragment())


        R.id.linearColumnLive-> replaceFragment(FinancialOverviewFragment())

        R.id.linearColumnProfile -> replaceFragment(ActivitiesFragment())

        else -> {
        }
      }
      true

    }
  }




  private fun replaceFragment(fragment: Fragment){
    val fragmentManager=supportFragmentManager
    val fragmentTransaction=fragmentManager.beginTransaction()
    fragmentTransaction.replace(R.id.fragmentContainer,fragment)
    fragmentTransaction.addToBackStack(null)
    fragmentTransaction.commit()
  }


  @Deprecated("Deprecated in Java")
  override fun onBackPressed() {
    val fragmentManager=supportFragmentManager


    if(fragmentManager.backStackEntryCount>1){
      fragmentManager.popBackStackImmediate(
        fragmentManager.getBackStackEntryAt(1).id,
        FragmentManager.POP_BACK_STACK_INCLUSIVE
      )
    }else{
      super.onBackPressed()
    }


  }

  companion object {
    const val TAG: String = "HOME_CONTAINER_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, HomeContainerActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
