package com.example.app_test

import android.R.attr.data
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app_test.databinding.FragmentBookmarkBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BookmarkFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BookmarkFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var binding: FragmentBookmarkBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBookmarkBinding.inflate(inflater, container, false)

//        activity?.let{
//            val intent = Intent(context, FineDustMapFragment::class.java)
//            startActivity(intent)
//            if(intent.hasExtra("address")) {
//                val add = intent.getStringExtra("address")
//                val pm10 = intent.getStringExtra("pm10")
//                val pm2_5 = intent.getStringExtra("pm2_5")
//
//
//            } else {
//            }
//        }
        val bookmark = arrayListOf(
            Bookmark("서울시 용산구 원효로1가", "미세먼지 14㎍/㎥", "초미세먼지 14㎍/㎥")
        )
        val layoutManager_bookmark = LinearLayoutManager(this.context)
        layoutManager_bookmark.orientation = LinearLayoutManager.VERTICAL
        binding.bookmarkRv.layoutManager = layoutManager_bookmark
        binding.bookmarkRv.adapter = BookmarkAdapter(bookmark)




        





        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BookmarkFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BookmarkFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}