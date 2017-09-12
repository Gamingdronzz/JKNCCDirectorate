package com.jknccdirectorate.Listeners;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;

public class RecyclerViewTouchListeners implements OnItemTouchListener {
    private ClickListener clickListener;
    private GestureDetector gestureDetector;

    public RecyclerViewTouchListeners(Context context, final RecyclerView recycleView, final ClickListener clicklistener) {
        this.clickListener = clicklistener;
        this.gestureDetector = new GestureDetector(context, new SimpleOnGestureListener() {
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

            public void onLongPress(MotionEvent e) {
                View child = recycleView.findChildViewUnder(e.getX(), e.getY());
                if (child != null && clicklistener != null) {
                    clicklistener.onLongClick(child, recycleView.getChildAdapterPosition(child));
                }
            }
        });
    }

    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        View child = rv.findChildViewUnder(e.getX(), e.getY());
        if (!(child == null || this.clickListener == null || !this.gestureDetector.onTouchEvent(e))) {
            this.clickListener.onClick(child, rv.getChildAdapterPosition(child));
        }
        return false;
    }

    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
    }

    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
    }
}
