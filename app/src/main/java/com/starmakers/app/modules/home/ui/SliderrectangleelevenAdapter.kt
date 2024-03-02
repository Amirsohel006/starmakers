import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.asksira.loopingviewpager.LoopingPagerAdapter
import com.starmakers.app.databinding.SlideritemHome1Binding
import com.starmakers.app.modules.home.data.model.ImageSliderSliderrectangleelevenModel
import com.starmakers.app.responses.CrowdResponses
import com.starmakers.app.service.ApiManager

class SliderrectangleelevenAdapter(
  val dataList: ArrayList<CrowdResponses>,
  val mIsInfinite: Boolean,
  private val onItemClick: (String) -> Unit // Click listener
) : LoopingPagerAdapter<CrowdResponses>(dataList, mIsInfinite) {

  override fun bindView(
    binding: ViewBinding,
    listPosition: Int,
    viewType: Int
  ) {
    if (binding is SlideritemHome1Binding) {
      val realPosition = listPosition % dataList.size
      val item = dataList[realPosition]

      val itemmovie=item.movie_poster
      val file=ApiManager.getImageUrl(itemmovie!!)
      val imageModel = ImageSliderSliderrectangleelevenModel(file ?: "")

      // Assign the converted model to the binding
      binding.imageSliderSliderrectangleelevenModel = imageModel

      // Handle click event
      binding.root.setOnClickListener {
        onItemClick(item.id ?: "") // Pass the id to the click listener
      }
    }
  }



  override fun inflateView(
    viewType: Int,
    container: ViewGroup,
    listPosition: Int
  ): ViewBinding {
    val itemBinding = SlideritemHome1Binding.inflate(
      LayoutInflater.from(container.context),
      container,
      false
    )
    return itemBinding
  }
}
