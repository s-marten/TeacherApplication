package ru.marten.teacherapplication

import android.content.Context
import android.util.AttributeSet
import android.view.View

class TestCustomView : View {

    constructor(context: Context?) : super(context)

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes)

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        setBackgroundColor(resources.getColor(R.color.black, null))
    }

}