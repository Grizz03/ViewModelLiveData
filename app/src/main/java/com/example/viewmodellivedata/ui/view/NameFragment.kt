package com.example.viewmodellivedata.ui.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.viewmodellivedata.R
import com.example.viewmodellivedata.databinding.NameFragmentBinding
import com.example.viewmodellivedata.ui.viewmodel.SignUpViewModel

class NameFragment : Fragment() {

    private var binding: NameFragmentBinding? = null
    private lateinit var viewModel: SignUpViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = NameFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(SignUpViewModel::class.java)

        binding?.let { binding ->
            binding.etFirstName.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                }

                override fun afterTextChanged(s: Editable?) {
                    viewModel.name = s.toString()
                }
            })

            binding.etLastName.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                }

                override fun afterTextChanged(s: Editable?) {
                    viewModel.lastName = s.toString()
                }
            })

            binding.fabNext.setOnClickListener {
                findNavController().navigate(R.id.action_name_fragment_to_setup_complete_fragment)
                viewModel.setButtonVisibility(false)
            }

            viewModel.nextButtonVisible.observe(viewLifecycleOwner, Observer {
                binding.fabNext.isVisible = it
            })
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}