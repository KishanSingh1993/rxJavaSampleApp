package `in`.eduforyou.rxjava.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import `in`.eduforyou.rxjava.MainApplication
import `in`.eduforyou.rxjava.R
import `in`.eduforyou.rxjava.presentation.adapter.UserAdapter
import `in`.eduforyou.rxjava.presentation.viewmodel.UserViewModel
import `in`.eduforyou.rxjava.presentation.viewmodel.UserViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var userViewModel: UserViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val app = application as MainApplication
        val factory = UserViewModelFactory(app.getUsersUseCase)
        userViewModel = ViewModelProvider(this, factory).get(UserViewModel::class.java)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        userViewModel.users.observe(this, { userList ->
            adapter = UserAdapter(userList)
            recyclerView.adapter = adapter
        })

        userViewModel.error.observe(this, { errorMsg ->
            Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show()
        })

        userViewModel.fetchUsers()
    }
}