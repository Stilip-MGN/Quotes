package studio.stilip.quotes.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import studio.stilip.quotes.data.repositories.QuoteRepositoryImpl
import studio.stilip.quotes.domain.repository_interface.QuoteRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideAdRepository(repositoryImpl: QuoteRepositoryImpl): QuoteRepository
}