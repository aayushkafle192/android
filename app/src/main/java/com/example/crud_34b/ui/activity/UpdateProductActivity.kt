package com.example.crud_34b.ui.activity

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
<<<<<<< HEAD
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.appcompat.app.AppCompatActivity
=======
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
>>>>>>> c7b2af1f64667f384a96256baff3e32185861b66
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.crud_34b.R
import com.example.crud_34b.databinding.ActivityUpdateProductBinding
import com.example.crud_34b.model.ProductModel
<<<<<<< HEAD
import com.example.crud_34b.repository.ProductRepositoryImpl
import com.example.crud_34b.utils.ImageUtils
import com.example.crud_34b.viewmodel.ProductViewModel
import com.squareup.picasso.Picasso

class UpdateProductActivity : AppCompatActivity() {
    lateinit var updateProductBinding: ActivityUpdateProductBinding

=======
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.squareup.picasso.Picasso

class dateProductActivity : AppCompatActivity() {
    lateinit var updateProductBinding: ActivityUpdateProductBinding
    var firebaseDatabase : FirebaseDatabase = FirebaseDatabase.getInstance()
    var ref = firebaseDatabase.reference.child("products")
>>>>>>> c7b2af1f64667f384a96256baff3e32185861b66
    var id = ""
    var imageName = ""
    lateinit var activityResultLauncher : ActivityResultLauncher<Intent>
    var imageUri : Uri? = null
<<<<<<< HEAD

    lateinit var productViewModel: ProductViewModel
=======
    var firebaseStorage: FirebaseStorage = FirebaseStorage.getInstance()
    var storageRef : StorageReference = firebaseStorage.reference
>>>>>>> c7b2af1f64667f384a96256baff3e32185861b66

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if(requestCode == 1 && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            activityResultLauncher.launch(intent)
        }
    }

<<<<<<< HEAD
    lateinit var imageUtils: ImageUtils
=======
>>>>>>> c7b2af1f64667f384a96256baff3e32185861b66
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        updateProductBinding = ActivityUpdateProductBinding.inflate(layoutInflater)
        setContentView(updateProductBinding.root)
<<<<<<< HEAD

        var repo = ProductRepositoryImpl()
        productViewModel = ProductViewModel(repo)


        imageUtils = ImageUtils(this)
        imageUtils.registerActivity {
            imageUri = it
            Picasso.get().load(it).into(updateProductBinding.imageUpdate)
        }
=======
        registerActivityForResult()
>>>>>>> c7b2af1f64667f384a96256baff3e32185861b66

        var product: ProductModel? = intent.getParcelableExtra("product")
        id = product?.id.toString()
        imageName = product?.imageName.toString()
        updateProductBinding.editTextProductNameUpdate.setText(product?.name)
        updateProductBinding.editTextProductPriceUpdate.setText(product?.price.toString())
        updateProductBinding.editTextProductDescUpdate.setText(product?.description)

        Picasso.get().load(product?.url).into(updateProductBinding.imageUpdate)


        updateProductBinding.btnUpdate.setOnClickListener {
            uploadImage()
        }

        updateProductBinding.imageUpdate.setOnClickListener{
<<<<<<< HEAD
            imageUtils.launchGallery(this@UpdateProductActivity)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btnSensorList)) { v, insets ->
=======
            var permissions = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
                android.Manifest.permission.READ_MEDIA_IMAGES
            }else{
                android.Manifest.permission.READ_EXTERNAL_STORAGE
            }
            if (ContextCompat.checkSelfPermission(this,permissions) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this, arrayOf(permissions),1)
            }else{
                val intent = Intent()
                intent.type = "image/*"
                intent.action = Intent.ACTION_GET_CONTENT
                activityResultLauncher.launch(intent)
            }
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
>>>>>>> c7b2af1f64667f384a96256baff3e32185861b66
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
<<<<<<< HEAD
    }



    fun uploadImage(){
        imageUri?.let {
            productViewModel.uploadImage(imageName, it){
                success, imageUrl ->
                if(success){
                    updateProduct(imageUrl.toString())
                }
            }
        }
=======

    }

    fun registerActivityForResult(){
        activityResultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult(),
            ActivityResultCallback {result ->

                val resultcode = result.resultCode
                val imageData = result.data
                if(resultcode == RESULT_OK && imageData != null){
                    imageUri = imageData.data
                    imageUri?.let {
                        Picasso.get().load(it).into(updateProductBinding.imageUpdate)
                    }
                }

            })
    }

    fun uploadImage(){

        var imageReference = storageRef.child("products").child(imageName)

        imageUri?.let { url->
            imageReference.putFile(url).addOnSuccessListener {
                imageReference.downloadUrl.addOnSuccessListener {downloadUrl->
                    var imagesUrl = downloadUrl.toString()
                    updateProduct(imagesUrl)
                }
            }.addOnFailureListener {
                Toast.makeText(applicationContext,it.localizedMessage,
                    Toast.LENGTH_LONG).show()
            }
        }


>>>>>>> c7b2af1f64667f384a96256baff3e32185861b66
    }
    fun updateProduct(url: String){
        var updatedName : String = updateProductBinding.editTextProductNameUpdate.text.toString()
        var updatedPrice : Int = updateProductBinding.editTextProductPriceUpdate.text.toString().toInt()
        var updatedDesc : String = updateProductBinding.editTextProductDescUpdate.text.toString()

        var data = mutableMapOf<String,Any>()
        data["name"] = updatedName
        data["price"] = updatedPrice
        data["description"] = updatedDesc
        data["url"] = url

<<<<<<< HEAD
       productViewModel.updateProduct(id,data){
           success,message->
               if(success){
                   Toast.makeText(applicationContext,message,
                       Toast.LENGTH_LONG).show()
               }else{
                   Toast.makeText(applicationContext,message,
                       Toast.LENGTH_LONG).show()
               }

       }
=======
        ref.child(id).updateChildren(data).addOnCompleteListener {
            if(it.isSuccessful){
                Toast.makeText(applicationContext,"Data updated",
                    Toast.LENGTH_LONG).show()
                finish()
            }else{
                Toast.makeText(applicationContext,it.exception?.message,
                    Toast.LENGTH_LONG).show()
            }
        }
>>>>>>> c7b2af1f64667f384a96256baff3e32185861b66
    }
}