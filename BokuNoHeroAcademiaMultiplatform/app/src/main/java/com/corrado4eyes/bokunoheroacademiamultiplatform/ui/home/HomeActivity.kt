package com.corrado4eyes.bokunoheroacademiamultiplatform.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.corrado4eyes.bokunoheroacademiamultiplatform.R
import com.corrado4eyes.bokunoheroacademiamultiplatform.databinding.ActivityHomeBinding
import com.corrado4eyes.bokunoheroacademiamultiplatform.ui.adapters.CharactersListAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.KoinComponent

class HomeActivity : AppCompatActivity(), KoinComponent, CoroutineScope by MainScope() {

    companion object {
        private const val TAG = "HomeActivity"
    }

    private val homeViewModel: HomeViewModel by viewModel()
    private val charactersListAdapter = CharactersListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setupBinding()
        observeViewModelProperties()

    }

    override fun onResume() {
        super.onResume()

        // Refreshing characters lists
       onSyncDown()
    }

    private fun onSyncDown() {
        MainScope().launch {
            homeViewModel.syncDown()
            homeViewModel.getCharactersList()
        }
    }

    private fun setupBinding() {
        val binding = DataBindingUtil
            .setContentView<ActivityHomeBinding>(this, R.layout.activity_home)
        binding.lifecycleOwner = this
        binding.homeViewModel = homeViewModel
        binding.charactersList.layoutManager = LinearLayoutManager(this)
        binding.charactersList.adapter = charactersListAdapter
    }

    private fun observeViewModelProperties() {
        homeViewModel.charactersList.observe(this, Observer {
            charactersListAdapter.updateCharacters(it)
        })
    }
}
