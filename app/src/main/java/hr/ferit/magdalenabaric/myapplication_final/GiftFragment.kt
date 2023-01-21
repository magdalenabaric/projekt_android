package hr.ferit.magdalenabaric.myapplication_final

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class GiftFragment : Fragment() {
    val db = Firebase.firestore
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_gift, container, false)

        val editTextName= view.findViewById<TextView>(R.id.EditTextName)
        val editTextColor= view.findViewById<TextView>(R.id.EditTextColor)
        val editTextHeight= view.findViewById<TextView>(R.id.EditTextHeight)
        val editTextBreed= view.findViewById<TextView>(R.id.EditTextBreed)
        val btnBack2=view.findViewById<Button>(R.id.btnBack2)
        val btnNext2=view.findViewById<Button>(R.id.btnNext2)



        btnBack2.setOnClickListener {
            val sureFragment = FirstFragment()
            //val radioButton = view.findViewById<RadioButton>(radiogroup.checkedRadioButtonId)
            val bundle= Bundle()
            //bundle.putString("button", radioButton.text.toString())
            sureFragment.arguments=bundle
            val fragmentTransaction: FragmentTransaction?=activity?.supportFragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.firstPage, sureFragment)
            fragmentTransaction?.commit()
        }

        btnNext2.setOnClickListener {
            val dog = Dog("", editTextName.text.toString(), editTextBreed.text.toString(), editTextHeight.text.toString(), editTextColor.text.toString())

            val sureFragment = GiftButtonsFragment()
            //val radioButton = view.findViewById<RadioButton>(radiogroup.checkedRadioButtonId)
            val bundle= Bundle()
            //bundle.putString("button", radioButton.text.toString())
            sureFragment.arguments=bundle
            val fragmentTransaction: FragmentTransaction?=activity?.supportFragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.firstPage, sureFragment)
            fragmentTransaction?.commit()


            db.collection("projekt")
                .add(dog)
                .addOnSuccessListener { documentReference ->
                    Log.d(ContentValues.TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    Log.w(ContentValues.TAG, "Error adding document", e)
        }
        }

        return view
    }


}