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
import com.example.viewmodellivedata.databinding.EmailFragmentBinding
import com.example.viewmodellivedata.ui.viewmodel.SignUpViewModel
import com.example.viewmodellivedata.utils.returnChangedText

class EmailFragment : Fragment() {

    private var binding: EmailFragmentBinding? = null
    private lateinit var viewModel: SignUpViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = EmailFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(SignUpViewModel::class.java)

        binding?.let { binding ->
            binding.etEmail.addTextChangedListener(object : TextWatcher {
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
                    viewModel.email = s.toString()
                }
            })

            binding.fabNext.setOnClickListener {
                findNavController().navigate(R.id.action_email_fragment_to_name_fragment)
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