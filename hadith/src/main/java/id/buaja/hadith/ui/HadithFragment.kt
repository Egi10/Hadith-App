package id.buaja.hadith.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import id.buaja.hadith.R

@AndroidEntryPoint
class HadithFragment : Fragment() {
    private val viewModel: HadithViewModel by viewModels()

    private lateinit var message: TextView
    private lateinit var progressBar: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.hadith_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        message = view.findViewById(R.id.message)
        progressBar = view.findViewById(R.id.progress_circular)

        initViewModel()
    }

    private fun initViewModel() = with(viewModel) {
        loading.observe(viewLifecycleOwner, {
            when(it) {
                true -> {
                    progressBar.visibility = View.VISIBLE
                }

                false -> {
                    progressBar.visibility = View.GONE
                }
            }
        })

        success.observe(viewLifecycleOwner, {
            message.text = "Data Sukses Di Ambil"
        })

        error.observe(viewLifecycleOwner, {
            message.text = "Maaf Kami Mengalami Masalah ${it.message}"
        })
    }
}