package com.example.gameingpoh.home

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.core.data.Resource
import com.example.core.ui.GameAdapter
//import com.example.gameingpoh.core.ui.ViewModelFactory
import com.example.gameingpoh.databinding.FragmentHomeBinding
import com.example.gameingpoh.detail.DetailGameActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {


//    private lateinit var homeViewModel: HomeViewModel
private val homeViewModel: HomeViewModel by viewModel()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val tourismAdapter = GameAdapter()
            tourismAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailGameActivity::class.java)
                intent.putExtra(DetailGameActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

//            val factory = ViewModelFactory.getInstance(requireActivity())
//            homeViewModel = ViewModelProvider(this, factory)[HomeViewModel::class.java]

            homeViewModel.game.observe(viewLifecycleOwner, { game ->
                if (game != null) {
                    when (game) {
                        is com.example.core.data.Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                        is com.example.core.data.Resource.Success -> {
                            binding.progressBar.visibility = View.GONE
                            tourismAdapter.setData(game.data)
                        }
                        is com.example.core.data.Resource.Error -> {
                            binding.progressBar.visibility = View.GONE
                            binding.viewError.root.visibility = View.VISIBLE
                            binding.viewError.tvError.text = game.message ?: ("something wrong")
                        }
                    }
                }
            })

            with(binding.rvGames) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tourismAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}