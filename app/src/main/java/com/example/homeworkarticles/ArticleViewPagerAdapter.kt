package com.example.homeworkarticles

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.example.homeworkarticles.databinding.ItemArticleLayoutBinding


class ArticleViewPagerAdapter() : PagerAdapter() {

    private var articlesList = Articles()

    override fun getCount() = articlesList.size

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as View
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val binding = ItemArticleLayoutBinding.inflate(
            LayoutInflater.from(container.context),
            container,
            false
        )

        val model = articlesList[position]

        Glide.with(binding.imageView.context).load(model.imageUrl).into(binding.imageView)
        binding.tvTitle.text = model.title
        binding.tvUpdatedAt.text = model.updatedAt


        container.addView(binding.root)


        return binding.root
    }

    override fun destroyItem(parent: ViewGroup, position: Int, `object`: Any) {
        parent.removeView(`object` as View)
    }

    fun setData(list: Articles) {
        articlesList = list
        notifyDataSetChanged()
    }
}