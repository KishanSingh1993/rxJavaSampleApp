package `in`.eduforyou.rxjava

import android.app.Application
import `in`.eduforyou.rxjava.data.network.ApiService
import `in`.eduforyou.rxjava.data.repository.UserRepositoryImpl
import `in`.eduforyou.rxjava.di.NetworkModule
import `in`.eduforyou.rxjava.domain.repository.UserRepository
import `in`.eduforyou.rxjava.domain.usecase.GetUsersUseCase

class MainApplication : Application() {
    lateinit var userRepository: UserRepository
    lateinit var getUsersUseCase: GetUsersUseCase

    override fun onCreate() {
        super.onCreate()
        val apiService: ApiService = NetworkModule.provideApiService()
        userRepository = UserRepositoryImpl(apiService)
        getUsersUseCase = GetUsersUseCase(userRepository)
    }
}