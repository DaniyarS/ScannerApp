package dev.dslam.scannerapp.ui.folder

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dev.dslam.scannerapp.databinding.FragmentFolderBinding
import dev.dslam.scannerapp.ui.folder.profile.LoginFragment
import dev.dslam.scannerapp.ui.folder.utils.DocumentsAdapter

class FolderFragment : Fragment() {

    private var _binding: FragmentFolderBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val adapter: DocumentsAdapter = DocumentsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val folderViewModel = ViewModelProvider(this).get(FolderViewModel::class.java)

        _binding = FragmentFolderBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.documentsList.adapter = adapter

        folderViewModel.documents.observe(viewLifecycleOwner) {
            adapter.documents = it
        }

        binding.profile.setOnClickListener {
            val fragment = LoginFragment.newInstance()
            fragment.show(childFragmentManager, fragment.javaClass.name)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}