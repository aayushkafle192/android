package com.example.crud_34b.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.crud_34b.R
import com.example.crud_34b.model.UserModel
import com.example.crud_34b.repository.UserRepoImpl
import com.example.crud_34b.viewmodel.UserViewModel

class UserActivity : AppCompatActivity() {
    lateinit var userViewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user)

        val repo = UserRepoImpl()
        userViewModel  = UserViewModel(repo)

        var data = UserModel("","sa")
        userViewModel.addUser(data){
            success, message ->
            if(success){

                Toast.makeText(applicationContext,message,Toast.LENGTH_LONG).show()
            }
                Toast.makeText(applicationContext,message,Toast.LENGTH_LONG).show()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}