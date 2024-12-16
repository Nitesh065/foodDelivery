package com.example.fooddelivery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddelivery.adapter.MenuRecycleAdapter
import com.example.fooddelivery.model.menuData

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Menu.newInstance] factory method to
 * create an instance of this fragment.
 */
class Menu : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    val filterName = mutableListOf<String>()
    val filterPrice = mutableListOf<String>()
    val filterImage = mutableListOf<Int>()
    var recyclerView: RecyclerView? = null
    private var layoutManager :LinearLayoutManager? = null
    private var adapter :MenuRecycleAdapter?= null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        val recyclerView: RecyclerView = view.findViewById(R.id.menuRecycleView)
//        val layoutManager = LinearLayoutManager(view.context)
//        val menuDataList = dummyList()
//        val adapter = MenuRecycleAdapter(view.context,menuDataList)
//
//        recyclerView.layoutManager = layoutManager
//        recyclerView.adapter = adapter
        searchView()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Menu.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Menu().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    private fun dummyList():List<menuData>{
        var menuList = mutableListOf<menuData>()
        menuList.add(menuData(R.drawable.menu1,"Herbal Pancake","$7","Add"))
        menuList.add(menuData(R.drawable.menu2,"Herbal Pancake","$8","Add"))
        menuList.add(menuData(R.drawable.menu3,"Herbal Pancake","$10","Add"))
        menuList.add(menuData(R.drawable.menu4,"Herbal Pancake","$10","Add"))
        menuList.add(menuData(R.drawable.menu5,"Herbal Pancake","$10","Add"))
        menuList.add(menuData(R.drawable.menu6,"Herbal Pancake","$10","Add"))
        return menuList

    }
    private fun searchView(){
        recyclerView  = view?.findViewById(R.id.menuRecycleView)
        layoutManager = LinearLayoutManager(view?.context)

        val searchView: SearchView = view?.findViewById(R.id.searchView) ?: return
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // Handle query submission if needed
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterMenuItem(newText)
                return true

            }

            private fun filterMenuItem(query: String?) {
                val filterList = mutableListOf<menuData>()

                if (!query.isNullOrEmpty()){
                    for (item in dummyList()){
                        if (item.name.contains(query,ignoreCase = true) || item.price.contains(query,ignoreCase = true)){
                            filterList.add(item)
                            adapter = view?.let { MenuRecycleAdapter(it.context,filterList) }
                            recyclerView?.layoutManager = layoutManager
                            recyclerView?.adapter = adapter

                        }

                    }
                }
                else{
                    filterList.addAll(dummyList())
                    adapter = view?.let { MenuRecycleAdapter(it.context,dummyList()) }
                    recyclerView?.layoutManager = layoutManager
                    recyclerView?.adapter = adapter
                }


            }
        })
    }

    }

