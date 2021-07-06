package com.example.viewmodellivedata.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodellivedata.databinding.SignUpCompleteFragmentBinding
import com.example.viewmodellivedata.ui.viewmodel.SignUpViewModel

class SignUpCompleteFragment : Fragment() {

    private var binding: SignUpCompleteFragmentBinding? = null
    private lateinit var viewModel: SignUpViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SignUpCompleteFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(SignUpViewModel::class.java)

        binding?.let { binding ->
            binding.tvName.text = viewModel.name
            binding.tvLastName.text = viewModel.lastName
            binding.tvEmail.text = viewModel.email
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}