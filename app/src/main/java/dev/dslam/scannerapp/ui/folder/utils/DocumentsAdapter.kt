package dev.dslam.scannerapp.ui.folder.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.dslam.scannerapp.databinding.FolderListItemBinding
import dev.dslam.scannerapp.ui.folder.data.Document

class DocumentsAdapter : RecyclerView.Adapter<DocumentsAdapter.DocumentsViewHolder>() {

    var documents: ArrayList<Document> = arrayListOf()
        set(value) {
            field.addAll(value)
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DocumentsViewHolder =
        DocumentsViewHolder(FolderListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: DocumentsViewHolder, position: Int) {
        holder.bind(documents[position])
    }

    override fun getItemCount(): Int = documents.size

    inner class DocumentsViewHolder(private val binding: FolderListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(document: Document) {
            with(binding) {
                documentIcon.setImageResource(document.icon)
                documentTitle.text = document.name
                documentInfo.text = document.property
            }
        }

    }
}