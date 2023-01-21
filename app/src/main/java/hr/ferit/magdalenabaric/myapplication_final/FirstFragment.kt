package hr.ferit.magdalenabaric.myapplication_final

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction

class FirstFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        /*val radiogroup = view.findViewById<RadioGroup>(R.id.rgMenu)
        val button = view.findViewById<Button>(R.id.bttnGo)*/
        val titleView = view.findViewById<TextView>(R.id.titleView)
        val questionView= view.findViewById<TextView>(R.id.questionView)
        val mainImage=view.findViewById<ImageView>(R.id.mainImage)
        val paw1=view.findViewById<ImageView>(R.id.paw1)
        val paw2=view.findViewById<ImageView>(R.id.paw2)
        val paw3=view.findViewById<ImageView>(R.id.paw3)
        val paw4=view.findViewById<ImageView>(R.id.paw4)
        val paw5=view.findViewById<ImageView>(R.id.paw5)
        val paw6=view.findViewById<ImageView>(R.id.paw6)
        val giftButton=view.findViewById<Button>(R.id.giftButton)
        val adoptButton=view.findViewById<Button>(R.id.adoptButton)


        adoptButton.setOnClickListener {
            val sureFragment = AdoptFragment()
            //val radioButton = view.findViewById<RadioButton>(radiogroup.checkedRadioButtonId)
            val bundle= Bundle()
            //bundle.putString("button", radioButton.text.toString())
            sureFragment.arguments=bundle
            val fragmentTransaction: FragmentTransaction?=activity?.supportFragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.firstPage, sureFragment)
            fragmentTransaction?.commit()
        }

        giftButton.setOnClickListener {
            val sureFragment = GiftFragment()
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