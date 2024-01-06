package com.android.fragment2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import com.android.fragment2.databinding.FragmentFristBinding

private const val ARG_PARAM1 = "param1"

/**
 * A simple [Fragment] subclass.
 * Use the [FristFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FristFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private val binding by lazy { FragmentFristBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //액티비티에서 firstfragment로 데이터 전달 받기
        binding.tvFrag1.text = param1

        //다른 프래그먼트로 데이터 넘기기
        binding.btnFrag1.setOnClickListener {
            val dataToSend = "Hellow Fragment2! \n From Fragment1"
            val dataToSend2 = "프래그먼트 1에서"
            val fragment2 = SecondFragment.newInstance(dataToSend,dataToSend2)
            //requireActivity() 이건 !! 처럼 보장해주는 느낌. 없으면 Exception.app crash발생
            //supportFragmentManager 는 사용자 상호작용에 응답해 Fragment를 추가하거나 삭제하는등 작업을 할 수 있게 해주는 매니저
            //beginTransaction() 이건 fragmentmanger와 연결된 프래그먼트에 대해 일련의 편집작업 시작한다는 것(일단 여기거 해석한거)
            //찾아보니 beginTransaction()는 간단하게 트랜잭션 인스턴스를 가져올 수 있게 하는 것
            requireActivity().supportFragmentManager.beginTransaction()
                //replace(a,b)는 a위치에 있는걸 b로 바꾼다는 뜻
                //add와 replace의 차이는 add는 그냥 추가이고 replace는 그자리를 없애고 추가이다
                .replace(R.id.frameLayout,fragment2)
                //addToBackStack을 처리하지 않으면 back버튼을 눌렀을 때 아무일 없이 액티비티가 꺼진다
                //back버튼은 액티비티 기준으로 finish 하는데 fragment는 따로 처리해줘야 해서 이걸 넣는다
                //이걸 해주면 커밋을 하기 전까지 모든 변경 내용이 하나의 트랜잭션으로 backStack에 들어감
                //트랜잭션으로는 add/replace/hide/show 모두 가능
                //backStack이란 액티비티를 오픈한 순서대로 저장되는게 스택형태로 저장되는것
                .addToBackStack(null)
                //commit을 호출할 땐 프래그먼트가 이미 상태를 저장하지 않았는지 검사한다.
                //이미 상태를 저장한 경우 IllegalStateException 이라는 예외를 던짐
                //commitAllowingStateLoss()는 commit과 달리 onSaveInstanceState()
                //이후의 fragment 상태이다. commit에 대한 건 좀 많으니 더 찾아봐야 할 듯.
                .commit()
            //밑에 함수 설정하고 간단하게
            //setToFragment(fragment2)
        }


    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @return A new instance of fragment FristFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String) =
            FristFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
//    private fun setToFragment(frag : Fragment) {
//        requireActivity().supportFragmentManager.beginTransaction()
//            .replace(R.id.frameLayout,frag)
//            .addToBackStack(null)
//            .commit()
//    }

}