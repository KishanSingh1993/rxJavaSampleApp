package `in`.eduforyou.rxjava.data.network

import `in`.eduforyou.rxjava.data.model.User
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    fun getUsers(): Single<List<User>>
}