package dev.dslam.scannerapp.ui.folder.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.dslam.scannerapp.databinding.FragmentLoginBinding
import dev.dslam.scannerapp.ui.ui_util.FullScreenFragment

class LoginFragment : FullScreenFragment() {

    companion object {

        fun newInstance() : LoginFragment {
            return LoginFragment()
        }

    }

    private var _binding: FragmentLoginBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.dontHaveAccount.setOnClickListener {
            val fragment = RegisterFragment.newInstance()
            fragment.show(childFragmentManager, fragment.javaClass.name)
        }
    }
}