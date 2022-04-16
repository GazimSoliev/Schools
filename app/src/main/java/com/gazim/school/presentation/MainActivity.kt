package com.gazim.school.presentation

import android.os.Bundle
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.gazim.school.R
import com.gazim.school.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val imm by lazy { this.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager }
    private val search by lazy { binding.mainFragment.findViewById<TextInputEditText>(R.id.etSearch) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        with(binding.mySpace) {
            if (ev.action == MotionEvent.ACTION_DOWN && ev.y.toInt() > top && ev.x.toInt() in (left)..(right))
                clrFocAndHideKBoardFromET()
        }
        return super.dispatchTouchEvent(ev)
    }

    private fun clrFocAndHideKBoardFromET() {
        search.clearFocus()
        imm.hideSoftInputFromWindow(
            search.windowToken,
            InputMethodManager.HIDE_NOT_ALWAYS
        )
    }

}