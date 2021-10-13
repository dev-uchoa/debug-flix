package com.debug.debugflix.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.debug.debugflix.R

class MainFragment : Fragment() {

    private lateinit var movies: RecyclerView

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movies = view.findViewById(R.id.movies)

        getMovies()
    }

    private fun getMovies() {
        // TODO: Implement the Retrofit here
    }
}


















