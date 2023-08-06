package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CommingSoonReciqule.newInstance] factory method to
 * create an instance of this fragment.
 */
class CommingSoonReciqule : Fragment() {
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_comming_soon_reciqule, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var toolbar:Toolbar=view.findViewById(R.id.toolbar)
        toolbar.title="Popular Cities"

        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        var Recycle:RecyclerView=view.findViewById(R.id.RecyclerView)
        Recycle.layoutManager=LinearLayoutManager(context)
        val data= arrayOf(
                RectcleData("Courdes Alpes",200,R.drawable.comming_1,"description 1 for all"),
                RectcleData("Courdes Alpes",200,R.drawable.comming_2,"description 2 for all"),
                RectcleData("Courdes Alpes",200,R.drawable.comming_3,"description 3 for all")
        )
        val adapter=Adapter(data,context=this.requireContext())
        adapter.setOnClickLisener { position->
            var item:RectcleData=adapter.getItem(position)
            var intent=Intent(activity,RecycleItem::class.java)
            intent.putExtra("img",item.image)
            intent.putExtra("title",item.title)
            intent.putExtra("view",item.views)
            intent.putExtra("description",item.description)
            startActivity(intent)
        }
        Recycle.adapter=adapter
    }
}