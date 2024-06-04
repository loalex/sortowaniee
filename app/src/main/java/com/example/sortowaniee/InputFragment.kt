package com.example.sortowaniee

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class InputFragment : Fragment() {

    private lateinit var listener: OnSortButtonClickListener

    interface OnSortButtonClickListener {
        fun onSortButtonClick(method: String, inputText: String)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnSortButtonClickListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnSortButtonClickListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_input, container, false)

        val editText = view.findViewById<EditText>(R.id.editTextText)
        val buttonSort1 = view.findViewById<Button>(R.id.button)
        val buttonSort2 = view.findViewById<Button>(R.id.button2)

        buttonSort1.setOnClickListener {
            listener.onSortButtonClick("insertionSort", editText.text.toString())
        }

        buttonSort2.setOnClickListener {
            listener.onSortButtonClick("mergeSort", editText.text.toString())
        }

        return view
    }
}
