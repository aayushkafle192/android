package com.example.crud_34b.repository

import com.example.crud_34b.model.UserModel

interface UserRepository {
    fun addUser(userModel: UserModel,callback:(Boolean,String?) -> Unit)

    fun getAllUser(callback: (List<UserModel>,Boolean?,String?) -> Unit)
    fun getUserById(id:String,callback: (List<UserModel>,Boolean?,String?) -> Unit)

    fun updateUser(id:String,data : MutableMap<String,Any>,callback: (Boolean?, String?) -> Unit)
    fun deleteUser(id:String,callback: (Boolean?, String?) -> Unit)


}

