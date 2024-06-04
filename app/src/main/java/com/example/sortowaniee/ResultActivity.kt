package com.example.sortowaniee

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val method = intent.getStringExtra("SORT_METHOD")
        val inputText = intent.getStringExtra("INPUT_TEXT")

        val numbers = inputText?.split(",")?.map { it.trim().toIntOrNull() }?.filterNotNull()?.toTypedArray()

        if (numbers == null || numbers.isEmpty()) {
            // Handle error, e.g., show a toast or log an error message
            return
        }

        val sortedText = when (method) {
            "insertionSort" -> insertionSort(numbers).joinToString(", ")
            "mergeSort" -> mergeSort(numbers).joinToString(", ")
            else -> ""
        }

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_result, ResultFragment.newInstance(sortedText))
                .commit()
        }
    }

    private fun insertionSort(array: Array<Int>): Array<Int> {
        for (i in 1 until array.size) {
            val key = array[i]
            var j = i - 1
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j]
                j--
            }
            array[j + 1] = key
        }
        return array
    }

    private fun mergeSort(array: Array<Int>): Array<Int> {
        if (array.size <= 1) return array
        val middle = array.size / 2
        val left = array.copyOfRange(0, middle)
        val right = array.copyOfRange(middle, array.size)
        return merge(mergeSort(left), mergeSort(right))
    }

    private fun merge(left: Array<Int>, right: Array<Int>): Array<Int> {
        var i = 0
        var j = 0
        val result = mutableListOf<Int>()
        while (i < left.size && j < right.size) {
            if (left[i] < right[j]) {
                result.add(left[i])
                i++
            } else {
                result.add(right[j])
                j++
            }
        }
        while (i < left.size) result.add(left[i++])
        while (j < right.size) result.add(right[j++])
        return result.toTypedArray()
    }
}
