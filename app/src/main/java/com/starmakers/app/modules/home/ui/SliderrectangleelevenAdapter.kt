package com.starmakers.app.modules.home.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.starmakers.app.databinding.SlideritemHome1Binding
import com.starmakers.app.modules.home.`data`.model.ImageSliderSliderrectangleelevenModel
import com.asksira.loopingviewpager.LoopingPagerAdapter
import java.util.ArrayList
import kotlin.Boolean
import kotlin.Int

class SliderrectangleelevenAdapter(
  val dataList: ArrayList<ImageSliderSliderrectangleelevenModel>,
  val mIsInfinite: Boolean
) : LoopingPagerAdapter<ImageSliderSliderrectangleelevenModel>(dataList, mIsInfinite) {
  override fun bindView(
    binding: ViewBinding,
    listPosition: Int,
    viewType: Int
  ) {
    if (binding is SlideritemHome1Binding) {
      binding.imageSliderSliderrectangleelevenModel = dataList[listPosition]
    }
  }

  override fun inflateView(
    viewType: Int,
    container: ViewGroup,
    listPosition: Int
  ): ViewBinding {
    val itemBinding =  SlideritemHome1Binding.inflate(
    LayoutInflater.from(container.context),
                    container,
                    false
    )
    return itemBinding
  }
}
