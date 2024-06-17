package com.example.crud_34b.repository

import com.example.crud_34b.model.UserModel
import com.google.firebase.database.FirebaseDatabase

class UserRepoImpl : UserRepository {

    var firebaseDatabase : FirebaseDatabase = FirebaseDatabase.getInstance()
    var ref = firebaseDatabase.reference.child("users")

    override fun addUser(userModel: UserModel, callback: (Boolean, String?) -> Unit) {
      var id = ref.push().key.toString()
        userModel.id = id
        ref.child(id).setValue(userModel).addOnCompleteListener {result->
            if(result.isSuccessful){
                callback(true,"Your data has been uploaded")
            }else{
                callback(false,"Unable to update data")
            }
        }
    }

    override fun getAllUser(callback: (List<UserModel>, Boolean?, String?) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun getUserById(id: String, callback: (List<UserModel>, Boolean?, String?) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun updateUser(
        id: String,
        data: MutableMap<String, Any>,
        callback: (Boolean?, String?) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun deleteUser(id: String, callback: (Boolean?, String?) -> Unit) {
        TODO("Not yet implemented")
    }
}