package com.debug.debugflix.presenter

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.debug.debugflix.R
import com.debug.debugflix.presenter.adapter.MovieAdapter
import com.debug.debugflix.presenter.model.ViewState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private val viewModel by viewModels<MainViewModel>()

    private lateinit var recyclerView: RecyclerView
    private lateinit var loading: ProgressBar
    private lateinit var btn : Button

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.getMovies()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.movies)
        loading = view.findViewById(R.id.loading)
        btn = view.findViewById(R.id.retry)
        btn.setOnClickListener {
            viewModel.getMovies()
        }

        setupObservers()
    }

    private fun setupObservers() {
        viewModel.movies.observe(viewLifecycleOwner) { movies ->
            recyclerView.adapter = MovieAdapter(movies)
        }

        viewModel.viewState.observe(viewLifecycleOwner) { state ->
            setViewState(state)
        }
    }

    private fun setViewState(state: ViewState) {
        when (state) {
            ViewState.LOADING -> setLoadingState()
            ViewState.CONTENT -> setContentState()
            ViewState.ERROR -> setErrorState()
        }
    }

    private fun setLoadingState() {
        loading.isVisible = true
        recyclerView.isVisible = false
    }

    private fun setContentState() {
        loading.isVisible = false
        recyclerView.isVisible = true
    }

    private fun setErrorState() {
        loading.isVisible = false
        recyclerView.isVisible = false

        AlertDialog.Builder(requireContext()).setMessage(R.string.error_message)
            .setPositiveButton(R.string.retry, object : DialogInterface.OnClickListener {
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    loading.isVisible = true
                    viewModel.getMovies()
                }
            }).setCancelable(false)
            .show()
    }

}