package hr.ferit.magdalenabaric.myapplication_final

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
public var matchName: String= "";
public var dogBreed: String="";
public var dogColor: String="";
public var dogHeight: String="";

class AdoptFragment : Fragment() {
    val db = Firebase.firestore
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_adopt, container, false)
        val view2 = inflater.inflate(R.layout.fragment_adopted, container, false)
        val view3 = inflater.inflate(R.layout.fragment_adopt_buttons, container, false)

        val textView1 = view.findViewById<TextView>(R.id.textView)
        val textView2 = view.findViewById<TextView>(R.id.textView2)
        val textView3 = view.findViewById<TextView>(R.id.textView3)
        val textView4 = view.findViewById<TextView>(R.id.textView4)
        val editText1 = view.findViewById<EditText>(R.id.EditText1)
        val editText2 = view.findViewById<EditText>(R.id.EditText2)
        val editText3 = view.findViewById<EditText>(R.id.EditText3)
        val button = view.findViewById<Button>(R.id.btnNext)
        val button2 = view.findViewById<Button>(R.id.btnBack)
        val textView14= view2.findViewById<TextView>(R.id.textView14)

        var br: Int=0;
        var match: Int=0;

        button.setOnClickListener {
            val dog = Dog(
                "",
                editText1.text.toString(),
                editText2.text.toString(),
                editText3.text.toString()
            )
            val sureFragment = AdoptButtonsFragment()
            val bundle = Bundle()
            sureFragment.arguments = bundle
            val fragmentTransaction: FragmentTransaction? =
                activity?.supportFragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.firstPage, sureFragment)
            fragmentTransaction?.commit()


            val dogs = arrayListOf<Dog>()
            db.collection("projekt")
                .get()
                .addOnSuccessListener { documents ->
                    for (document in documents) {

                        val dog = Dog(
                            document.id,
                            document.data.get("name").toString(),
                            document.data.get("breed").toString(),
                            document.data.get("color").toString(),
                            document.data.get("height").toString(),
                            document.data.get("personality").toString()
                        )
                        dogs.add(dog)

                        for(dog in dogs){
                            br=0
                            if(dog.color.toString()==editText1.toString()){
                                br++
                            }
                            if(dog.breed.toString()==editText2.toString()){br++}
                            if(dog.height.toString()==editText3.toString()){br++}
                            if(br>match){
                                match=br
                                matchName=br.toString()
                            }
                        }

                    }
                }
                .addOnFailureListener { exception ->
                    Log.w(TAG, "Error getting documents: ", exception)
                }


        }

            button2.setOnClickListener {
                val sureFragment = FirstFragment()
                val bundle = Bundle()
                sureFragment.arguments = bundle
                val fragmentTransaction: FragmentTransaction? =
                    activity?.supportFragmentManager?.beginTransaction()
                fragmentTransaction?.replace(R.id.firstPage, sureFragment)
                fragmentTransaction?.commit()
            }



            return view
        }}

