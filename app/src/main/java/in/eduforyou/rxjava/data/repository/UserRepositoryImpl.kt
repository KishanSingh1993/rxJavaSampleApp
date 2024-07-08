package `in`.eduforyou.rxjava.data.repository

import `in`.eduforyou.rxjava.data.model.User
import `in`.eduforyou.rxjava.data.network.ApiService
import `in`.eduforyou.rxjava.domain.repository.UserRepository
import io.reactivex.rxjava3.core.Single

class UserRepositoryImpl(private val apiService: ApiService) : UserRepository {
    override fun getUsers(): Single<List<User>> {
        return apiService.getUsers()
    }
}