package hr.ferit.magdalenabaric.myapplication_final

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction

class AdoptedFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_adopted, container, false)

        //val button = view.findViewById<Button>(R.id.bttnGo)
        val btnBack3=view.findViewById<Button>(R.id.btnBack3)
        val btnStart2=view.findViewById<Button>(R.id.btnNext4)
        val textView14=view.findViewById<TextView>(R.id.textView14)

        textView14.text= matchName



        btnBack3.setOnClickListener {
            val sureFragment = AdoptButtonsFragment()
            //val radioButton = view.findViewById<RadioButton>(radiogroup.checkedRadioButtonId)
            val bundle= Bundle()
            //bundle.putString("button", radioButton.text.toString())
            sureFragment.arguments=bundle
            val fragmentTransaction: FragmentTransaction?=activity?.supportFragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.firstPage, sureFragment)
            fragmentTransaction?.commit()
        }

        btnStart2.setOnClickListener {
            val sureFragment = FirstFragment()
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


}