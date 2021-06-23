package com.example.homeworkarticles

import android.os.Bundle
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager.widget.ViewPager
import com.example.homeworkarticles.databinding.ArticleFragmentBinding

class ArticleFragment : Fragment() {

    private val viewModel: ArticleViewModel by viewModels()

    lateinit var binding: ArticleFragmentBinding

    lateinit var adapter: ArticleViewPagerAdapter

    lateinit var articles: Articles

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ArticleFragmentBinding.inflate(layoutInflater)

        observer()
        viewModel.getArticles()
        initAdapter()

        return binding.root
    }

    private fun observer() {
        viewModel.articles.observe(viewLifecycleOwner, {
            adapter.setData(it)

            articles = it

            binding.tvDescription.text = it[0].summary
        })
    }

    private fun initAdapter(){
        adapter = ArticleViewPagerAdapter()
        binding.viewPager.adapter = adapter

        binding.viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {}

            override fun onPageSelected(position: Int) {
                binding.tvDescription.text = articles[position].summary
            }

            override fun onPageScrollStateChanged(state: Int) {}

        })
    }

}