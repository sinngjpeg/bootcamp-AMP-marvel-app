package com.example.core.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.core.data.repository.CharactersRepository
import com.example.core.domain.model.Character
import com.example.core.usecase.base.PagingUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val charactersRepository: CharactersRepository
) : PagingUseCase<GetCharactersUseCase.GetCharacterParams, Character>() {

    override fun createFlowObservable(params: GetCharacterParams): Flow<PagingData<Character>> {
        return Pager(config = params.pagingConfig) {
            // PagingSource
            charactersRepository.getCharacters(params.query)
        }.flow
    }

    data class GetCharacterParams(val query: String, val pagingConfig: PagingConfig)

}