package dev.dslam.scannerapp.ui.folder

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.dslam.scannerapp.R
import dev.dslam.scannerapp.ui.folder.data.Document

class FolderViewModel : ViewModel() {

    private val _documents = MutableLiveData<ArrayList<Document>>().apply {
        value = arrayListOf(
            Document(0, R.drawable.ic_docx, "Health Insurance", "3.4 MB, .docx"),
            Document(1, R.drawable.ic_pdf, "Passport", "5.5 MB, .pdf"),
            Document(2, R.drawable.ic_docx, "Medicine", "3.4 MB, .docx"),
            Document(3, R.drawable.ic_pdf, "Car", "1.5 MB, .pdf"),
            Document(4, R.drawable.ic_docx, "License", "2.4 MB, .docx"),
            Document(5, R.drawable.ic_docx, "Avatar", "3.5 MB, .pdf")
        )
    }

    val documents: LiveData<ArrayList<Document>> = _documents

}