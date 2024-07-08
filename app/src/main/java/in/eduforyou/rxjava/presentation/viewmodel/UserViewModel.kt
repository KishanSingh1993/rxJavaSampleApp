package `in`.eduforyou.rxjava.presentation.viewmodel

// presentation/viewmodel/UserViewModel.kt
import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import `in`.eduforyou.rxjava.data.model.User
import `in`.eduforyou.rxjava.domain.usecase.GetUsersUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class UserViewModel(private val getUsersUseCase: GetUsersUseCase) : ViewModel() {
    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> get() = _users
    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    fun fetchUsers() {
        getUsersUseCase.execute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { userList -> _users.value = userList },
                { throwable -> _error.value = throwable.message }
            )
    }
}
