package hr.ferit.magdalenabaric.myapplication_final

import android.os.Bundle
import android.telecom.Call
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.google.android.gms.common.api.Response
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class AdoptListFragment : Fragment() {      //ovdje trebam spojit recycler view
    private lateinit var adapter: Adapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var dogArrayList: ArrayList<Dog>
    private val db = Firebase.firestore
    private lateinit var recyclerAdapter: Adapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_adopt_list, container, false)
        val view2 = inflater.inflate(R.layout.fragment_adopt, container, false)
        val view3 = inflater.inflate(R.layout.fragment_adopt_buttons, container, false)

        val btnBack7= view.findViewById<Button>(R.id.btnBack7)
        val btnNext6= view.findViewById<Button>(R.id.btnNext6)
        val recyclerViewAdopt = view.findViewById<RecyclerView>(R.id.dogList)

        db.collection("projekt")
            .get()
            .addOnSuccessListener {
                val list : ArrayList<Dog> = ArrayList()
                for(data in it.documents){
                    val dog = data.toObject(Dog::class.java)
                    if ( dog != null){
                        dog.id = data.id
                        list.add(dog)
                    }
                }
                recyclerAdapter = Adapter(list)
                recyclerView.apply{
                   // layoutManager = LinearLayoutManager(@this)
                    adapter =
                        recyclerAdapter
                }
            }
            .addOnFailureListener{
                Log.e("MainActivity", it.message.toString())
            }


        btnBack7.setOnClickListener {
            val sureFragment = AdoptButtonsFragment()
            //val radioButton = view.findViewById<RadioButton>(radiogroup.checkedRadioButtonId)
            val bundle= Bundle()
            //bundle.putString("button", radioButton.text.toString())
            sureFragment.arguments=bundle
            val fragmentTransaction: FragmentTransaction?=activity?.supportFragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.firstPage, sureFragment)
            fragmentTransaction?.commit()
        }

        btnNext6.setOnClickListener {
            val sureFragment = AdoptedFragment()
            //val radioButton = view.findViewById<RadioButton>(radiogroup.checkedRadioButtonId)
            val bundle= Bundle()
            //bundle.putString("button", radioButton.text.toString())
            sureFragment.arguments=bundle
            val fragmentTransaction: FragmentTransaction?=activity?.supportFragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.firstPage, sureFragment)
            fragmentTransaction?.commit()
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView=view.findViewById(R.id.dogList)
        recyclerView.layoutManager=LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)
        adapter=Adapter(dogArrayList)
        recyclerView.adapter=adapter
    }
}