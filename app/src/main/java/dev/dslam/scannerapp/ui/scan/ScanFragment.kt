package dev.dslam.scannerapp.ui.scan

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import dev.dslam.scannerapp.databinding.FragmentScanBinding

class ScanFragment : Fragment() {

    companion object {
        private const val REQUEST_PERMISSION_CODE_CAMERA = 100
        private const val BITMAP_REQUEST_CODE = 7
    }

    private var _binding: FragmentScanBinding? = null
    private val binding: FragmentScanBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentScanBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.scan.setOnClickListener {
            if (hasCameraPermissions()) {
                startCamera()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == BITMAP_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            data?.extras?.get("data")?.let {
                try {
                    binding.imageView.setImageBitmap(it as Bitmap)
                } catch (e: Exception) {

                }
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            REQUEST_PERMISSION_CODE_CAMERA -> {
                if (grantResults.isNotEmpty() && grantResults.first() == PackageManager.PERMISSION_GRANTED) {
                    startCamera()
                } else {
                    // todo: toast camera access failure
                }
            }
        }
    }

    private fun hasCameraPermissions(): Boolean {
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.CAMERA
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissions(arrayOf(Manifest.permission.CAMERA), REQUEST_PERMISSION_CODE_CAMERA)
            return false
        }
        return true
    }

    private fun startCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, BITMAP_REQUEST_CODE)
    }

    private fun navigateToDocuments() {
        // todo: handle navigation to documents page
    }
}