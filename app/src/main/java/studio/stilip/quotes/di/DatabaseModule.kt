package studio.stilip.quotes.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import studio.stilip.quotes.data.api.RetrofitProvider
import studio.stilip.quotes.data.api.RetrofitServiceQuote

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun provideRetrofitServiceQuote(retrofitProvider: RetrofitProvider): RetrofitServiceQuote =
        retrofitProvider.retrofitServiceQuote

}