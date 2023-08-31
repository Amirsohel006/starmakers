package com.starmakers.app.modules.screennine.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.starmakers.app.databinding.SlideritemScreenNine1Binding
import com.starmakers.app.modules.screennine.`data`.model.ImageSliderSliderintrestonloanModel
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
    if (binding is SlideritemScreenNine1Binding) {
      binding.imageSliderSliderintrestonloanModel = dataList[listPosition]
    }
  }

  override fun inflateView(
    viewType: Int,
    container: ViewGroup,
    listPosition: Int
  ): ViewBinding {
    val itemBinding =  SlideritemScreenNine1Binding.inflate(
    LayoutInflater.from(container.context),
                    container,
                    false
    )
    return itemBinding
  }
}
