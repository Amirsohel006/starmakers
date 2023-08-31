package com.starmakers.app.modules.screenten.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.starmakers.app.databinding.SlideritemScreenTen1Binding
import com.starmakers.app.modules.screenten.`data`.model.ImageSliderSliderintrestonloanModel
import com.asksira.loopingviewpager.LoopingPagerAdapter
import java.util.ArrayList
import kotlin.Boolean
import kotlin.Int

class SliderintrestonloanAdapter(
  val dataList: ArrayList<ImageSliderSliderintrestonloanModel>,
  val mIsInfinite: Boolean
) : LoopingPagerAdapter<ImageSliderSliderintrestonloanModel>(dataList, mIsInfinite) {
  override fun bindView(
    binding: ViewBinding,
    listPosition: Int,
    viewType: Int
  ) {
    if (binding is SlideritemScreenTen1Binding) {
      binding.imageSliderSliderintrestonloanModel = dataList[listPosition]
    }
  }

  override fun inflateView(
    viewType: Int,
    container: ViewGroup,
    listPosition: Int
  ): ViewBinding {
    val itemBinding =  SlideritemScreenTen1Binding.inflate(
    LayoutInflater.from(container.context),
                    container,
                    false
    )
    return itemBinding
  }
}
