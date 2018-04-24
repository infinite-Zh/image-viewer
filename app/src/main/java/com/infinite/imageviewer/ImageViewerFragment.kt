package layout

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.infinite.imageviewer.R
import kotlinx.android.synthetic.main.layout_image_viewer.*

/**
 * @author kfzhangxu
 * Created on 2018/4/24.
 */
class ImageViewerFragment : Fragment() {

    private val mPath: MutableList<String> = mutableListOf()
    private var mPager:ViewPager?=null
    val adapter = ImageViewerAdapter()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.layout_image_viewer, container, false)
        mPager=view.findViewById(R.id.viewPager)
        mPager!!.adapter=adapter
        return view
    }

    public fun setPaths(paths: MutableList<String>) {
        paths.let {
            mPath.clear()
            mPath.addAll(paths)
            adapter.notifyDataSetChanged()
        }
    }

    inner class ImageViewerAdapter() : PagerAdapter() {
        override fun isViewFromObject(view: View?, `object`: Any?): Boolean {
            return view == `object`
        }

        override fun getCount(): Int {
           return mPath.size
        }

        override fun instantiateItem(container: ViewGroup?, position: Int): Any {
            val inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val view = inflater.inflate(R.layout.item_image, container, false)
            val image = view.findViewById<ImageView>(R.id.image)
            Glide.with(context)
                    .load(mPath[position])
                    .into(image)
            container!!.addView(view)
            return view
        }

        override fun destroyItem(container: ViewGroup?, position: Int, `object`: Any?) {
            container!!.removeView(`object` as View?)
        }

    }
}

