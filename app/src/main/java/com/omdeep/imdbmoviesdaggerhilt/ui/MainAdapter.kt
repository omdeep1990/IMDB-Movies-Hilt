package com.omdeep.imdbmoviesdaggerhilt.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.omdeep.imdbmoviesdaggerhilt.R
import com.omdeep.imdbmoviesdaggerhilt.data.model.MoviesResponse
import com.omdeep.imdbmoviesdaggerhilt.databinding.PopularMoviesLayoutBinding

class MainAdapter(private val list : List<MoviesResponse>) : RecyclerView.Adapter<MainAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding : PopularMoviesLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.popular_movies_layout, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.model = list[position]
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MyViewHolder(var binding : PopularMoviesLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}