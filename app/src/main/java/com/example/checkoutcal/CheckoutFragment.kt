package com.example.checkoutcal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class CheckoutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_checkout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tips = listOf(
            "Uvijek završi na Double!",
            "T20 je najčešći prvi dart.",
            "Bull vrijedi 50 poena.",
            "D20 = 40, idealan checkout!",
            "170 je maksimalni checkout."
        )

        val tvTip = view.findViewById<TextView>(R.id.tvFragmentTip)
        tvTip.text = tips.random()
    }
}