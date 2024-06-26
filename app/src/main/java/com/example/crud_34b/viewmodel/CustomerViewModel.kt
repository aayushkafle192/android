package com.example.crud_34b.viewmodel

import com.example.crud_34b.model.CustomerModel
import com.example.crud_34b.model.UserModel
import com.example.crud_34b.repository.CustomerRepository
//import com.example.crud_34b.repository.UserRepository

class CustomerViewModel(val repository: CustomerRepository) {
    fun addUser(customerModel: CustomerModel, callback:(Boolean, String?) -> Unit){
        repository.addUser(customerModel,callback)
    }
}