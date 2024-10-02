package edu.temple.scopefunctionactivity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Example test call
        Log.d("function output", getTestDataArray().toString())
    }

    // Return a list of random, sorted integers
    private fun getTestDataArray() = MutableList(10) { Random.nextInt() }.apply { sort() }

    // Return true if average value in list is greater than median value, false otherwise
    private fun averageLessThanMedian(listOfNumbers: List<Double>): Boolean = listOfNumbers.run {
        val avg = average()
        val median = sorted().let { sortedList ->
            if (size % 2 == 0)
                (sortedList[size / 2] + sortedList[(size - 1) / 2]) / 2
            else
                sortedList[size / 2]
        }
        avg < median
    }

    // Create a view from an item in a collection, but recycle if possible (similar to an AdapterView's adapter)
    private fun getView(position: Int, recycledView: View?, collection: List<Int>, context: Context): View =
        (recycledView as? TextView ?: TextView(context).apply {
            setPadding(5, 10, 10, 0)
            textSize = 22f
        }).apply {
            text = collection[position].toString()
        }
}
