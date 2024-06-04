package com.example.sortowaniee

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class InputActivity : AppCompatActivity(), InputFragment.OnSortButtonClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_input, InputFragment())
                .commit()
        }
    }

    override fun onSortButtonClick(method: String, inputText: String) {
        val intent = Intent(this, ResultActivity::class.java).apply {
            putExtra("SORT_METHOD", method)
            putExtra("INPUT_TEXT", inputText)
        }
        startActivity(intent)
    }
}
