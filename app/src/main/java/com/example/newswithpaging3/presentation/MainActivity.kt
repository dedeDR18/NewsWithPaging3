package com.example.newswithpaging3.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newswithpaging3.R
import com.example.newswithpaging3.databinding.ActivityMainBinding
import com.example.newswithpaging3.presentation.adapter.ArticleAdapter
import com.example.newswithpaging3.presentation.adapter.ArticleLoadStateAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var articleAdapter: ArticleAdapter

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initRv()

        viewModel.data.observe(this, Observer { it ->
            it?.let { data ->
                articleAdapter.submitData(lifecycle, data)
            }

        })
    }

    private fun initRv(){
        articleAdapter = ArticleAdapter()
        val adapterWithLoading = articleAdapter.withLoadStateFooter(ArticleLoadStateAdapter(articleAdapter::retry))
//        binding.rvArticle.adapter = articleAdapter.withLoadStateHeaderAndFooter(
//            header = ArticleLoadStateAdapter{ articleAdapter.retry()},
//            footer = ArticleLoadStateAdapter{ articleAdapter.retry()}
//        )
        binding.apply {
            val divider = DividerItemDecoration(this@MainActivity, (rvArticle.layoutManager as LinearLayoutManager).orientation)
            rvArticle.addItemDecoration(divider)
            rvArticle.adapter = adapterWithLoading


        }


    }
}