package hr.ferit.magdalenabaric.myapplication_final

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction

class AdoptButtonsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_adopt_buttons, container, false)

        val btnBack4= view.findViewById<Button>(R.id.btnBack4)
        val btnNext3= view.findViewById<Button>(R.id.btnNext3)


        btnBack4.setOnClickListener {
            val sureFragment = AdoptFragment()
            //val radioButton = view.findViewById<RadioButton>(radiogroup.checkedRadioButtonId)
            val bundle= Bundle()
            //bundle.putString("button", radioButton.text.toString())
            sureFragment.arguments=bundle
            val fragmentTransaction: FragmentTransaction?=activity?.supportFragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.firstPage, sureFragment)
            fragmentTransaction?.commit()
        }

        btnNext3.setOnClickListener {
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

}