package dev.dslam.scannerapp.ui.folder.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.dslam.scannerapp.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {

    companion object {
        fun newInstance() : LoginFragment {
            return LoginFragment()
        }
    }

    private var _binding: FragmentRegisterBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(layoutInflater)
        return binding.root
    }


}