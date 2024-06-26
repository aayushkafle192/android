package com.example.crud_34b.repository

import android.net.Uri
import com.example.crud_34b.model.ProductModel

interface ProductRepository {
<<<<<<< HEAD
    fun uploadImage(imageName:String,imageUrl : Uri,callback: (Boolean,String?) -> Unit)
    fun addProduct(productModel: ProductModel,callback :(Boolean,String?) -> Unit)
    fun getAllProduct(callback: (List<ProductModel>?,Boolean,String?) -> Unit)
    fun updateProduct(id:String,data: MutableMap<String,Any>?,callback: (Boolean, String?) -> Unit)

    fun deleteData(id:String,callback: (Boolean, String?) -> Unit)
    //Boolean for success either true of false
    //String for Message "Your data has been deleted"
    fun deleteImage(imageName:String,callback: (Boolean, String?) -> Unit)
=======
    fun uploadImage(imageName : String,imageurl:Uri,callback: (Boolean, String?) -> Unit)
    fun addProduct(productModel: ProductModel,callback :(Boolean,String?) -> Unit)


    fun getAllProduct(callback: (List<ProductModel>?,Boolean, String?) -> Unit)

    fun updateProduct(id:String,callback: (Boolean, String?) -> Unit)
    fun deleteData(id: String,callback: (Boolean, String?) -> Unit)
    fun deleteImage(imageName: String,callback: (Boolean, String?) -> Unit)

>>>>>>> c7b2af1f64667f384a96256baff3e32185861b66
}