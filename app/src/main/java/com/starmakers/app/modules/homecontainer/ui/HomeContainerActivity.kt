package com.starmakers.app.modules.homecontainer.ui
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
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


//  @Deprecated("Deprecated in Java")
//  override fun onBackPressed() {
//    val fragmentManager=supportFragmentManager
//
//
//    if(fragmentManager.backStackEntryCount>1){
//      fragmentManager.popBackStackImmediate(
//        fragmentManager.getBackStackEntryAt(1).id,
//        FragmentManager.POP_BACK_STACK_INCLUSIVE
//      )
//    }else{
//      super.onBackPressed()
//    }
//
//
//  }


  @Deprecated("Deprecated in Java")
  override fun onBackPressed() {
    val fragmentManager=supportFragmentManager
    val fragments = supportFragmentManager.backStackEntryCount
    if (fragments == 1) {
      AlertDialog.Builder(this)
        .setMessage("Are you sure you want to exit?")
        .setCancelable(false)
        .setPositiveButton("Yes",
          DialogInterface.OnClickListener { dialog, id -> finish() })
        .setNegativeButton("No", null)
        .show()
    }
    else {

      if (fragmentManager.backStackEntryCount > 1) {
        fragmentManager.popBackStackImmediate(
          fragmentManager.getBackStackEntryAt(1).id,
          FragmentManager.POP_BACK_STACK_INCLUSIVE
        )

        var selectedFragment: Fragment? = null
        val fragments = supportFragmentManager.fragments
        for (fragment in fragments) {
          if (fragment != null && fragment.isVisible) {
            selectedFragment = fragment
            break
          }
        }



        if(selectedFragment is HomeFragment){
          binding.frameBottombar.selectedItemId = R.id.linearColumnhome
        }
        if (selectedFragment is SearchFragment) {
          binding.frameBottombar.selectedItemId = R.id.linearColumnWallet
        }
        if (selectedFragment is FinancialOverviewFragment) {
          binding.frameBottombar.selectedItemId=R.id.linearColumnLive
        }
        if (selectedFragment is ActivitiesFragment)
        {
          binding.frameBottombar.selectedItemId= R.id.linearColumnProfile
        } else {
          super.onBackPressed()
        }
      }
      else {
        super.onBackPressed()
      }
    }
    // }
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
