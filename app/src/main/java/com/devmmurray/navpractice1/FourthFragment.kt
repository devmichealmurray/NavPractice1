package com.devmmurray.navpractice1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.devmmurray.navpractice1.databinding.FragmentFourthBinding

class FourthFragment : Fragment() {

    private lateinit var binding: FragmentFourthBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_fourth, container, false)
        val userName = arguments?.getString("user-name")
        val userEmail = arguments?.getString("user-email")

        binding.userName.text = userName.toString()
        binding.userEmail.text = userEmail.toString()

        binding.termsButton2.setOnClickListener {
            it.findNavController().navigate(R.id.action_fourthFragment_to_termsFragment)
        }

        return binding.root
    }

}
