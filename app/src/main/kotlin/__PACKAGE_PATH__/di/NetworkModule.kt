package __PACKAGE_NAME__.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton
import __PACKAGE_NAME__.data.network.ApiService

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

  @Provides @Singleton
  fun provideOkHttp(): OkHttpClient =
    OkHttpClient.Builder()
      .addInterceptor(HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
      })
      .build()

  @Provides @Singleton
  fun provideMoshi(): Moshi =
    Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

  @Provides @Singleton
  fun provideRetrofit(client: OkHttpClient, moshi: Moshi): Retrofit =
    Retrofit.Builder()
      .baseUrl("https://api.example.com/") // change per environment
      .addConverterFactory(MoshiConverterFactory.create(moshi))
      .client(client)
      .build()

  @Provides @Singleton
  fun provideApiService(retrofit: Retrofit): ApiService =
    retrofit.create(ApiService::class.java)
}
