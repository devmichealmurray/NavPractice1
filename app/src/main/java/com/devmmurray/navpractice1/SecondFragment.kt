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
import com.devmmurray.navpractice1.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_second, container, false)
        binding.button.setOnClickListener {
            if (!TextUtils.isEmpty(binding.name.text.toString())) {
                val bundle = bundleOf("user-name" to binding.name.text.toString())
                it.findNavController().navigate(R.id.action_secondFragment_to_thirdFragment, bundle)
            } else {
                Toast.makeText(activity, "Must Enter Your Name", Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }

}
