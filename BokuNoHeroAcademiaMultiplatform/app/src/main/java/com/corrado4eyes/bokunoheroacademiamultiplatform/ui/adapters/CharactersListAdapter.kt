package com.corrado4eyes.bokunoheroacademiamultiplatform.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.corrado4eyes.bokunoheroacademiamultiplatform.R
import com.corrado4eyes.bokunoheroacademiamultiplatform.databinding.PreviewCharacterBinding
import com.corrado4eyes.bokunoheroacademiamultiplatform.data.characters.BNHACharacterResponse
import java.util.Collections.emptyList

class CharactersListAdapter : RecyclerView.Adapter<CharactersListAdapter.CharacterViewHolder>() {

    var charactersList: List<BNHACharacterResponse> = emptyList()

    inner class CharacterViewHolder(private val binding: PreviewCharacterBinding)
        : RecyclerView.ViewHolder(binding.root) {

        private fun setupUi(BNHACharacterResponse: BNHACharacterResponse) {
            binding.name.text = BNHACharacterResponse.name
            binding.category.text = BNHACharacterResponse.category
            binding.characterClass.text = BNHACharacterResponse.characterClass
            binding.quirk.text = BNHACharacterResponse.quirk

            binding.characterImage.setImage(BNHACharacterResponse.image)
        }

        fun bind(BNHACharacterResponse: BNHACharacterResponse) {
            setupUi(BNHACharacterResponse)
        }

    }

    fun updateCharacters(list: List<BNHACharacterResponse>) {
        charactersList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding =
            DataBindingUtil.inflate<PreviewCharacterBinding>(
                LayoutInflater.from(parent.context),
                R.layout.preview_character, parent, false)
        return CharacterViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return charactersList.size
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val card = charactersList[position]
        holder.bind(card)
    }

}

@BindingAdapter("characters")
fun RecyclerView.bindEntries(newList: List<BNHACharacterResponse>) {
    (adapter as? CharactersListAdapter)?.updateCharacters(newList)
}

fun ImageView.setImage(url: String) {
    this.load(url) {
        crossfade(true)
    }
}