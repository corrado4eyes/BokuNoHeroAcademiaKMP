package com.corrado4eyes.bokunoheroacademiamultiplatform.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.corrado4eyes.bokunoheroacademiamultiplatform.data.characters.BNHACharacterResponse
import com.corrado4eyes.bokunoheroacademiamultiplatform.models.AnimeCharacterModel
import com.corrado4eyes.bokunoheroacademiamultiplatform.utils.CoroutineUtil
import kotlinx.coroutines.flow.collect
import org.koin.core.KoinComponent
import java.util.Collections.emptyList

class HomeViewModel(
    private val coroutineUtil: CoroutineUtil,
    private val animeCharacterModel: AnimeCharacterModel
) : ViewModel(), KoinComponent {

    val charactersList: MutableLiveData<List<BNHACharacterResponse>> = MutableLiveData()

    init {
        charactersList.value = emptyList()
    }

    suspend fun getCharactersList() = coroutineUtil.doInBackground {
       animeCharacterModel.getAll().collect {
           charactersList.postValue(it.map { el -> BNHACharacterResponse(
               el.id,
               el.image,
               el.category,
               el.characterClass,
               el.name,
               el.quirk)
           })
       }
    }

    suspend fun syncDown() {
        animeCharacterModel.syncDown()
    }

}