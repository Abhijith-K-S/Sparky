package com.example.sparky
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ItemSpace: RecyclerView.ItemDecoration() {
    private var verticalSpace = 2

    override fun getItemOffsets(outRect: Rect,view: View,parent: RecyclerView,state: RecyclerView.State)
    {
        outRect.bottom = verticalSpace
    }
}