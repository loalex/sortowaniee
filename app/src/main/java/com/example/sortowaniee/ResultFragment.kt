package com.example.sortowaniee

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class ResultFragment : Fragment() {

    companion object {
        private const val ARG_RESULT = "result"

        fun newInstance(result: String): ResultFragment {
            val fragment = ResultFragment()
            val args = Bundle()
            args.putString(ARG_RESULT, result)
            fragment.arguments = args
            return fragment
        }
    }

    private lateinit var resultTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_result, container, false)
        resultTextView = view.findViewById(R.id.textViewResult)

        val result = arguments?.getString(ARG_RESULT)
        resultTextView.text = result

        return view
    }
}
