package com.example.core.usecase

import androidx.paging.PagingConfig
import com.example.core.data.repository.CharactersRepository
import com.example.testing.MainCoroutineRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
//@RunWith(JUnit4::class)
class GetCharactersUseCaseImplTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @Mock
    lateinit var repository: CharactersRepository

    private lateinit var getCharactersUseCase: GetCharactersUseCase

    @Before
    fun setUp() {
//        MockitoAnnotations.initMocks(this)
        getCharactersUseCase = GetCharactersUseCaseImpl(repository)
    }

    @Test
    fun `should validate flow paging data creation when invoke from use case is called`() =
    runBlockingTest{
        val result = getCharactersUseCase.invoke(GetCharactersUseCase.GetCharacterParams("", PagingConfig(20)))
    }