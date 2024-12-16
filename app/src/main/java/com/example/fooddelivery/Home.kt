package com.example.fooddelivery

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.fooddelivery.adapter.HomeRecycleAdapter
import com.example.fooddelivery.databinding.FragmentHomeBinding
import com.example.fooddelivery.model.Cartdata
import com.example.fooddelivery.model.homeData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import org.w3c.dom.Text

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Home.newInstance] factory method to
 * create an instance of this fragment.
 */
class Home : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentHomeBinding
    private var database: FirebaseDatabase? = null
    private var databaseRef: DatabaseReference? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        database = FirebaseDatabase.getInstance()
        databaseRef = database?.getReference("data")

        getData(view.findViewById(R.id.RecycleView))

        val imageList = ArrayList<SlideModel>() // Create image list
        val imageSlider =view.findViewById<ImageSlider>(R.id.imageSlider)

        val viewMenu: Button = view.findViewById(R.id.btnHome1)


// imageList.add(SlideModel("String Url" or R.drawable)
// imageList.add(SlideModel("String Url" or R.drawable, "title") You can add title

        imageList.add(SlideModel(R.drawable.banner1,scaleType =ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner2,ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner3,ScaleTypes.FIT))
        imageSlider.setImageList(imageList)



        var  fullmenu = Menu();
        viewMenu.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.fragmentContainerView2, fullmenu).commit()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Home.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Home().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    private fun dummyList():List<homeData>{
        var menuList = mutableListOf<homeData>()
        menuList.add(homeData(R.drawable.menu1,"Herbal Pancake","$7","Add"))
        menuList.add(homeData(R.drawable.menu2,"Herbal Pancake","$8","Add"))
        menuList.add(homeData(R.drawable.menu3,"Herbal Pancake","$10","Add"))
        return menuList

    }
    fun getData(view: View){


        var menuList = mutableListOf<homeData>()

        databaseRef?.addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                for(data in snapshot.children){

                    val name = data.child("name").value.toString()
                    val price = data.child("price").value.toString()
                    val menu = homeData(name = name, price = price, image = R.drawable.menu2, food_type = "Add")
                    menuList.add(menu)
                }
                val recyclerView: RecyclerView = view.findViewById(R.id.RecycleView)
                val layoutManager = LinearLayoutManager(view.context)
                val menuDataList = menuList

                val adapter = HomeRecycleAdapter(view.context,menuDataList)

                recyclerView.layoutManager = layoutManager
                recyclerView.adapter = adapter
            }

            override fun onCancelled(error: DatabaseError) {
                Log.d("tag","$error")
            }

        })


    }


}