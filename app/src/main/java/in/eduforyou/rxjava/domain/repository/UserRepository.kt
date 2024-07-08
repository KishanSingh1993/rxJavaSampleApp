package `in`.eduforyou.rxjava.domain.repository

import `in`.eduforyou.rxjava.data.model.User
import io.reactivex.rxjava3.core.Single

interface UserRepository {
    fun getUsers(): Single<List<User>>
}