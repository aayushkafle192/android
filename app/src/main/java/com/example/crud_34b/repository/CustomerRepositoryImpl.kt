package com.example.crud_34b.repository

import com.example.crud_34b.model.CustomerModel
import com.google.firebase.database.FirebaseDatabase

class CustomerRepositoryImpl :CustomerRepository {

    var firebaseDatabase : FirebaseDatabase = FirebaseDatabase.getInstance()
    var ref = firebaseDatabase.reference.child("Customer")
    override fun addUser(customerModel: CustomerModel, callback: (Boolean, String?) -> Unit) {
        var id = ref.push().key.toString()
        customerModel.id = id
        ref.child(id).setValue(customerModel).addOnCompleteListener {result->
            if(result.isSuccessful){
                callback(true,"Your data has been uploaded")
            }else{
                callback(false,"Unable to update data")
            }
        }
    }

    override fun getAllUser(callback: (List<CustomerModel>, Boolean?, String?) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun getUserById(
        id: String,
        callback: (List<CustomerModel>, Boolean?, String?) -> Unit
    ) {
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