package com.example.crud_34b.ui.activity

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.pm.PackageManager
import android.os.Build
import android.os.Build.VERSION_CODES
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationChannelCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.crud_34b.R
import com.example.crud_34b.databinding.ActivityNotificationBinding

class NotificationActivity : AppCompatActivity() {
    lateinit var notificationBinding: ActivityNotificationBinding
    var CHANNEL_Id="1"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        notificationBinding=ActivityNotificationBinding.inflate(layoutInflater)
        setContentView(notificationBinding.root)

        notificationBinding.btnNotification.setOnClickListener {
            showNotification()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun showNotification(){
        var builder=NotificationCompat.Builder(this@NotificationActivity,CHANNEL_Id)
        if(Build.VERSION.SDK_INT>= VERSION_CODES.O){
            var channel:NotificationChannel=
                NotificationChannel(CHANNEL_Id,"My channel",NotificationManager.IMPORTANCE_DEFAULT)

            var manager:NotificationManager=getSystemService(NOTIFICATION_SERVICE)as NotificationManager
            manager.createNotificationChannel(channel)
            builder.setSmallIcon(R.drawable.baseline_add_24).setContentTitle("Offer").setContentText("Grab your discount")


        }
        else{

            builder.setSmallIcon(R.drawable.baseline_add_24).setContentTitle("Offer").setContentText("Grab your discount")


        }
        var  notificationManagerCompat=NotificationManagerCompat.from(this@NotificationActivity)
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }
        notificationManagerCompat.notify(1,builder.build())
    }

}