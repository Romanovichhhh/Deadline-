package com.example.mvvmplayer.features.presentation.views

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import androidx.annotation.StringRes
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.mvvmplayer.R

class PinCodeView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr)  {

    private val titleView: TextView
    private val symbolsArrayView : List<View>

    init {
        View.inflate(context, R.layout.view_pin_code, this)
        titleView = findViewById(R.id.pin_code_view_title)
        symbolsArrayView = listOf(
            findViewById(R.id.pin_code_view_symbol_1),
            findViewById(R.id.pin_code_view_symbol_2),
            findViewById(R.id.pin_code_view_symbol_3),
            findViewById(R.id.pin_code_view_symbol_4)
        )
        val typedArray = context.obtainStyledAttributes(
            attrs,
            R.styleable.PinCodeView,
            defStyleAttr,
            0
        )
        val title = typedArray.getString(R.styleable.PinCodeView_title)
        setTitle(title)
        val filledSymbols = typedArray.getInt(R.styleable.PinCodeView_filledSymbols, 0)
        setFilledSymbols(filledSymbols)
        typedArray.recycle()
    }

    fun setTitle(@StringRes res: Int) {
        titleView.text = context.getString(res)
    }

    fun setTitle(value: String?) {
        titleView.text = value
    }

    fun setFilledSymbols(count: Int) {
        for (i in 0 until count) {
            symbolsArrayView[i].background = resources.getDrawable(R.drawable.view_pin_symbol_filled)
        }
    }
    fun clearFilledSymbols() {
        symbolsArrayView.forEach{
            it.background = resources.getDrawable(R.drawable.view_pin_symbol_empty)
        }
    }
}