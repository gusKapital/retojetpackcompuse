package com.kapital.retojetpackcompuse.di

import com.kapital.retojetpackcompuse.data.remote.ApiClient
import com.kapital.retojetpackcompuse.data.remote.CardApi
import com.kapital.retojetpackcompuse.data.repository.CardRepositoryImpl
import com.kapital.retojetpackcompuse.domain.repository.CardRepository
import com.kapital.retojetpackcompuse.domain.usecase.GetCardByIdUseCase
import com.kapital.retojetpackcompuse.domain.usecase.GetCardsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCardApi(): CardApi {
        return ApiClient.createService(CardApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCardRepository(cardApi: CardApi): CardRepository {
        return CardRepositoryImpl(cardApi)
    }

    @Provides
    @Singleton
    fun provideGetCardsUseCase(cardRepository: CardRepository): GetCardsUseCase {
        return GetCardsUseCase(cardRepository)
    }

    @Provides
    @Singleton
    fun provideGetCardByIdUseCase(cardRepository: CardRepository): GetCardByIdUseCase {
        return GetCardByIdUseCase(cardRepository)
    }
}