package `in`.eduforyou.rxjava.domain.usecase

import `in`.eduforyou.rxjava.data.model.User
import `in`.eduforyou.rxjava.domain.repository.UserRepository
import io.reactivex.rxjava3.core.Single

class GetUsersUseCase(private val userRepository: UserRepository) {
    fun execute(): Single<List<User>> {
        return userRepository.getUsers()
    }
}