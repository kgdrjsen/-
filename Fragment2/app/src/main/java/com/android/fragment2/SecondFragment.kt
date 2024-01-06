package com.android.fragment2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.fragment2.databinding.FragmentSecondBinding
import java.lang.RuntimeException


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


/**
 * A simple [Fragment] subclass.
 * Use the [SecondFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondFragment : Fragment() {
    //액티비티로 전달할 기능 함수 listener 선언
    private var listener : FragmentDataListener? = null
    private var _binding : FragmentSecondBinding? = null
    private var param1: String? = null
    private var param2: String? = null
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        //SecondFragment 에서 Activity로
        //context가 메인택티비티에서 왔으니 메인액티비티에 FragmentDataListener가 있는지 체크(is)
        //초기화 하는 과정이라고 한다.
        if (context is FragmentDataListener) {
            listener = context
        }else {
            throw RuntimeException("$context must implement FragmentDataListener")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSecondBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //프래그먼트1에서 글자 받기
        binding.tvFrag2.text = param1
        binding.tvFrag2Sub.text = param2
        //프래그먼트 1로 데이터 전달
        binding.btnFrag2.setOnClickListener {
            val dataToSend = "Hellow Fragment1! \n From Fragment2"
            val fragment1 = FristFragment.newInstance(dataToSend)
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout,fragment1)
                .addToBackStack(null)
                .commit()
        }

        //현재 프래그먼트에서 액티비티로
        binding.btnActivity.setOnClickListener {
            val dataToSend = "Hello from SecondFragment!"
            listener?.onDataReceived(dataToSend)
            //액티비티로 화면 이동을 할 때에는 this를 사용 못 하므로 getActivity 또는 activity로 넣어야한다.
            val intent = Intent(activity,MainActivity::class.java)
            startActivity(intent)

        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2
         * @return A new instance of fragment SecondFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String,param2: String) =
            SecondFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        //Binding 객체 해제
        _binding = null
        listener = null
    }
}