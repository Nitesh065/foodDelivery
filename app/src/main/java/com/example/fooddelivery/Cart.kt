package com.example.fooddelivery

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddelivery.adapter.CartRecycleAdapter
import com.example.fooddelivery.model.Cartdata

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Cart.newInstance] factory method to
 * create an instance of this fragment.
 */
class Cart : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
   private var btnDelete: ImageButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var name: String? = null
        var price: String? = null
        var image: Int? = null
        var btnBack: ImageButton = view.findViewById(R.id.backHome)
        val recyclerView: RecyclerView = view.findViewById(R.id.rvCart)
        val btnProceed: Button = view.findViewById(R.id.btnCart1)
        val tvCartEmpty: TextView = view.findViewById(R.id.tvCartEmpty)
        val layoutManager = LinearLayoutManager(view.context)
        arguments?.let {
           name = it.getString("name")
            price = it.getString("price")
            image = it.getInt("image")

        }
        val menu = Cartdata(image!!,name!!,price!!,1)
        val cartDataList: MutableList<Cartdata> = mutableListOf()
        cartDataList.add(menu)
        val adapter = CartRecycleAdapter(view.context,cartDataList)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
        if (cartDataList.size == 0){
            recyclerView.visibility = View.GONE
            tvCartEmpty.visibility = View.VISIBLE

        }
        else{
            tvCartEmpty.visibility = View.GONE
        }


        btnProceed.setOnClickListener {
            startActivity(Intent(activity,OrderDetail::class.java))
            activity?.finish()

        }

        btnBack.setOnClickListener {
            activity?.supportFragmentManager?.popBackStack()
        }



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Cart.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Cart().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }





}