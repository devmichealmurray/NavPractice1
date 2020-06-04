package com.devmmurray.navpractice1

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.devmmurray.navpractice1.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {

    private lateinit var binding: FragmentThirdBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_third, container, false)
        val userName = arguments?.getString("user-name")
        binding.userName.text = userName.toString()

        binding.emailButton.setOnClickListener {
            if (!TextUtils.isEmpty(binding.email.text.toString())) {
                val bundle = bundleOf(
                    "user-name" to userName,
                    "user-email" to binding.email.text.toString())
                it.findNavController().navigate(R.id.action_thirdFragment_to_fourthFragment, bundle)
            } else {
                Toast.makeText(activity, "Must Enter Your Name", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root

    }


}
