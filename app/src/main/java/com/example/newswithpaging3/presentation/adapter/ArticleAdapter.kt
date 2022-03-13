package com.example.newswithpaging3.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.newswithpaging3.R
import com.example.newswithpaging3.databinding.ItemArticleBinding
import com.example.newswithpaging3.domain.model.Article

class ArticleAdapter : PagingDataAdapter<Article, ArticleAdapter.ArticleViewHolder>(ARTICLE_COMPARATOR) {


    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null){
            holder.bind(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ArticleViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_article, parent, false))


    companion object{
        private val ARTICLE_COMPARATOR = object : DiffUtil.ItemCallback<Article>(){
            override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean =
                oldItem.title == newItem.title


            override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean =
                oldItem == newItem

        }
    }

    inner class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val binding = ItemArticleBinding.bind(itemView)
        fun bind(data: Article){
            binding.article = data
        }
    }




}