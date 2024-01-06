package com.android.fragment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.android.fragment2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),FragmentDataListener {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //데이터 전달할 때
        binding.run {
            fragment1Btn.setOnClickListener {
                //액티비티 -> firstfragment 로 데이터 전달
                val dataToSend = "Hello First Fragment! \n From Activity"
                val fragment = FristFragment.newInstance(dataToSend)
                setFragment(fragment)
            }
            fragment2Btn.setOnClickListener {
                //액티비티 -> secondfragment 로 데이터 전달
                val dataToSend = "Hello Second Fragment! \n From Activity"
                val dataTosend2 = "액티비티에서"
                val fragment = SecondFragment.newInstance(dataToSend,dataTosend2)
                setFragment(fragment)
            }
        }

    }
    private fun setFragment(frag : Fragment) {
        supportFragmentManager.commit {
            //replace(a,b)는 a위치에 있는걸 b로 바꾼다는 뜻
            //add와 replace의 차이는 add는 그냥 추가이고 replace는 그자리를 없애고 추가이다
            replace(R.id.frameLayout,frag)
            //setReorderingAllowed(true)는 애니메이션과 전환이 올바르게 작동하도록 트랜잭션과 관련된 프래그먼트의 상태 변경을 최적화
            setReorderingAllowed(true)
            //addToBackStack을 처리하지 않으면 back버튼을 눌렀을 때 아무일 없이 액티비티가 꺼진다
            //back버튼은 액티비티 기준으로 finish 하는데 fragment는 따로 처리해줘야 해서 이걸 넣는다
            //이걸 해주면 커밋을 하기 전까지 모든 변경 내용이 하나의 트랜잭션으로 backStack에 들어감
            //트랜잭션으로는 add/replace/hide/show 모두 가능
            //backStack이란 액티비티를 오픈한 순서대로 저장되는게 스택형태로 저장되는것
            addToBackStack("")
        }
    }

    override fun onDataReceived(data: String) {
        //Fragment에서 받은 데이터를 처리
        Toast.makeText(this,data,Toast.LENGTH_SHORT).show()
    }
}