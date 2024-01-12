package com.android.applemarket

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.ImageView
import android.widget.Toast
import android.window.OnBackInvokedDispatcher
import androidx.appcompat.app.AlertDialog
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.applemarket.databinding.ActivityMainBinding
import java.io.ByteArrayOutputStream

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.imgNotify.setOnClickListener {
            notification()
        }

        //더미데이터들 리스트로 만들어 추가하기
        val dataList = mutableListOf<MyItem>()

        dataList.add(MyItem(R.drawable.sample1,getString(R.string.no1_title),getString(R.string.no1_location),
            getString(R.string.no1_subtitle),getString(R.string.no1_person),1000,13,25))
        dataList.add(MyItem(R.drawable.sample2,getString(R.string.no2_title),getString(R.string.no2_location),
            getString(R.string.no2_subtitle),getString(R.string.no2_person),20000,8,28))
        dataList.add(MyItem(R.drawable.sample3,getString(R.string.no3_title),getString(R.string.no3_location),
            getString(R.string.no3_subtitle),getString(R.string.no3_person),10000,23,5))
        dataList.add(MyItem(R.drawable.sample4,getString(R.string.no4_title),getString(R.string.no4_location),
            getString(R.string.no4_subtitle),getString(R.string.no4_person),10000,14,17))
        dataList.add(MyItem(R.drawable.sample5,getString(R.string.no5_title),getString(R.string.no5_location),
            getString(R.string.no5_subtitle),getString(R.string.no5_person),150000,22,9))
        dataList.add(MyItem(R.drawable.sample6,getString(R.string.no6_title),getString(R.string.no6_location),
            getString(R.string.no6_subtitle),getString(R.string.no6_person),50000,25,16))
        dataList.add(MyItem(R.drawable.sample7,getString(R.string.no7_title),getString(R.string.no7_location),
            getString(R.string.no7_subtitle),getString(R.string.no7_person),150000,142,54))
        dataList.add(MyItem(R.drawable.sample8,getString(R.string.no8_title),getString(R.string.no8_location),
            getString(R.string.no8_subtitle),getString(R.string.no8_person),180000,31,7))
        dataList.add(MyItem(R.drawable.sample9,getString(R.string.no9_title),getString(R.string.no9_location),
            getString(R.string.no9_subtitle),getString(R.string.no9_person),30000,7,28))
        dataList.add(MyItem(R.drawable.sample10,getString(R.string.no10_title),getString(R.string.no10_location),
            getString(R.string.no10_subtitle),getString(R.string.no10_person),190000,40,6))


        //어댑터에 데이터 집어넣기
        val adapter = MyAdapter(dataList)
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = LinearLayoutManager(this)

        //클릭하면 디테일로 넘기기
        adapter.itemClick = object : MyAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val intent = Intent(this@MainActivity, DetailPage::class.java)
                intent.putExtra(Contants.Item_OBJECT,dataList[position])
                startActivity(intent)
//                intent.putExtra(Contants.Item_NUMBER, position)
//                //Parcelize를 이용해서 나머지 데이터도 전달하기
//                intent.putExtra(Contants.Item_OBJECT,dataList[position])
//                startActivity(intent)
            }

        }
        adapter.itemLongClick = object : MyAdapter.ItemLongClick {
            override fun onLongClick(view: View, position: Int) {

            }
        }

    }

    //뒤로가기 눌렀을 때 다이얼로그 띄우고, 확인 누르면 종료
    override fun onBackPressed() {

        val builder = AlertDialog.Builder(this)
        builder.setIcon(R.drawable.speech_bubble)
        builder.setTitle("종료")
        builder.setMessage("정말 종료하시겠습니까?")

//        //fun onBackPressed에 슈퍼콜을 못 넣어서 다른 방법 찾아보기
//        val listener = object : DialogInterface.OnClickListener {
//            override fun onClick(p0: DialogInterface?, p1: Int) {
//                when (p1) {
//                    DialogInterface.BUTTON_POSITIVE ->
//                        finishAffinity()
//                    DialogInterface.BUTTON_NEGATIVE ->
//                        null
//                }
//            }
//        }
//        builder.setPositiveButton("확인",listener)
//        builder.setNegativeButton("취소",listener)

        //확인을 눌렀을 때 뒤로가게끔
        builder.setPositiveButton("확인",
            DialogInterface.OnClickListener{dialog, which ->
                super.onBackPressed()
                finishAffinity()
            })
        builder.setNegativeButton("취소",
            DialogInterface.OnClickListener{dialog, which ->
                //null 대신 dismiss()넣기
                dialog.dismiss()
            })
        builder.show()
    }


    //알림
    fun notification() {
        val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        val builder: NotificationCompat.Builder
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // 26 버전 이상
            val channelId = "one-channel"
            val channelName = "My Channel One"
            val channel = NotificationChannel(
                channelId,
                channelName,
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                // 채널에 다양한 정보 설정
                description = "My Channel One Description"
                setShowBadge(true)
                val uri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
                val audioAttributes = AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .setUsage(AudioAttributes.USAGE_ALARM)
                    .build()
                setSound(uri, audioAttributes)
                enableVibration(true)
            }
            // 채널을 NotificationManager에 등록
            manager.createNotificationChannel(channel)

            // 채널을 이용하여 builder 생성
            builder = NotificationCompat.Builder(this, channelId)

        } else {
            // 26 버전 이하
            builder = NotificationCompat.Builder(this)
        }

        //알림을 눌렀을 때 앱의 메인 화면 띄우게 연결하기
        val intent = Intent(this,MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)

        // 알림의 기본 정보
        builder.run {
            setSmallIcon(R.mipmap.ic_launcher)
            setWhen(System.currentTimeMillis())
            setContentTitle("사과마켓 알림!")
            setContentText("알림이 발생 하였습니다.")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
        }
        manager.notify(13, builder.build())
    }
}