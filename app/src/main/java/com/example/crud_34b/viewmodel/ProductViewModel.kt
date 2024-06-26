package com.example.crud_34b.viewmodel

import android.net.Uri
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.crud_34b.model.ProductModel
import com.example.crud_34b.repository.ProductRepository

class ProductViewModel(val repository: ProductRepository) : ViewModel() {
<<<<<<< HEAD

    fun deleteData(id:String,callback: (Boolean, String?) -> Unit){
        repository.deleteData(id,callback)
    }
    fun deleteImage(imageName:String,callback: (Boolean, String?) -> Unit){
        repository.deleteImage(imageName,callback)
    }
    fun updateProduct(id:String,data:MutableMap<String,Any>?,callback: (Boolean, String?) -> Unit){
        repository.updateProduct(id,data,callback)
    }

    fun uploadImage(imageName: String,imageUrl: Uri, callback: (Boolean, String?) -> Unit) {
        repository.uploadImage(imageName,imageUrl) { success, imageUrl ->
            callback(success, imageUrl)
        }
    }


=======
    fun uploadImage(imageName:String,imageUrl: Uri, callback: (Boolean, String?, String?) -> Unit) {
        repository.uploadImage(imageName ,imageUrl) { success, imageUrl ->
            callback(success, imageUrl)










        }
    }

>>>>>>> c7b2af1f64667f384a96256baff3e32185861b66
    fun addProduct(productModel: ProductModel, callback: (Boolean, String?) -> Unit) {
        repository.addProduct(productModel, callback)
    }

<<<<<<< HEAD
    private var _productList = MutableLiveData<List<ProductModel>?>()

    var productList = MutableLiveData<List<ProductModel>?>()
        get() = _productList

    var _loadingState = MutableLiveData<Boolean>()
    var loadingState = MutableLiveData<Boolean>()
=======
    private var _productList=MutableLiveData<List<ProductModel>?>()


    var productList=MutableLiveData<List<ProductModel>?>()
        get()=_productList

    var _loadingState=MutableLiveData<Boolean>()
    var loadingState=MutableLiveData<Boolean>()
>>>>>>> c7b2af1f64667f384a96256baff3e32185861b66
        get() = _loadingState




<<<<<<< HEAD
    fun fetchProduct(){
        _loadingState.value = true
        repository.getAllProduct { productList, success, message ->
            if(productList!=null){
                _loadingState.value = false
                _productList.value = productList
=======

    fun fetchProduct(){
        _loadingState.value=true
        repository.getAllProduct { productList, success, message ->
            if(productList!=null){
                _loadingState.value=false
                _productList.value=productList





>>>>>>> c7b2af1f64667f384a96256baff3e32185861b66
            }
        }
    }
}