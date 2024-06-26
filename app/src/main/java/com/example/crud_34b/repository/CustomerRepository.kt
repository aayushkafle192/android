package com.example.crud_34b.repository

import com.example.crud_34b.model.CustomerModel
import com.example.crud_34b.model.UserModel

interface CustomerRepository {
    fun addUser(customerModel: CustomerModel, callback:(Boolean, String?) -> Unit)

    fun getAllUser(callback: (List<CustomerModel>, Boolean?, String?) -> Unit)
    fun getUserById(id:String,callback: (List<CustomerModel>, Boolean?, String?) -> Unit)

    fun updateUser(id:String,data : MutableMap<String,Any>,callback: (Boolean?, String?) -> Unit)
    fun deleteUser(id:String,callback: (Boolean?, String?) -> Unit)


}