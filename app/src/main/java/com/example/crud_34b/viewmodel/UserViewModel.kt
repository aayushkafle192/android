package com.example.crud_34b.viewmodel

import com.example.crud_34b.model.ProductModel
import com.example.crud_34b.model.UserModel
import com.example.crud_34b.repository.UserRepository

class UserViewModel(val repository: UserRepository) {

    fun addUser(userModel: UserModel, callback:(Boolean, String?) -> Unit){
        repository.addUser(userModel,callback)
    }
}