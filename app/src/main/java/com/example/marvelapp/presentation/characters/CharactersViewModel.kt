package com.example.marvelapp.presentation.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.core.usecase.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import com.example.core.domain.model.Character

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val getCharacterUseCase: GetCharactersUseCase
) : ViewModel() {
    fun charactersPagingData(query: String): Flow<PagingData<Character>> {
        return getCharacterUseCase.invoke(
            GetCharactersUseCase.GetCharacterParams(query, getPageConfig())
        ).cachedIn(viewModelScope)
    }

    private fun getPageConfig() = PagingConfig(
        pageSize = 20
    )
}