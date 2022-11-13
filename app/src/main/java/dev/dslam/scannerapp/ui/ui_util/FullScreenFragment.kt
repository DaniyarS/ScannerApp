package dev.dslam.scannerapp.ui.ui_util

import android.os.Bundle
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import dev.dslam.scannerapp.R

abstract class FullScreenFragment : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(
            STYLE_NORMAL,
            R.style.ThemeOverlay_ScannerApp_FullscreenContainer
        )
    }

    override fun onStart() {
        super.onStart()
        dialog?.let {
            with(it.window!!) {
                setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            }
        }
    }
}