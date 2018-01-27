package com.fueled.swipeablerecyclerview.adapter;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.fueled.swipeablerecyclerview.SwipeItemTouchHelperCallback;

/**
 * @author chetansachdeva on 27/07/17
 */

public class BindingAdapter {

	/**
	 * Bind ItemTouchHelper.SimpleCallback with RecyclerView
	 *
	 * @param recyclerView      	RecyclerView to bind to SwipeItemTouchHelperCallback
	 * @param swipeEnabled      	enable/disable swipe
	 * @param drawableSwipeLeft     drawable shown when swiped left
	 * @param drawableSwipeRight    drawable shown when swiped right
	 * @param bgColorSwipeLeft  	background color when swiped left
	 * @param bgColorSwipeRight 	background color when swiped right
	 * @param onItemSwipeLeft   	OnItemSwipeListener for swiped left
	 * @param onItemSwipeRight  	OnItemSwipeListener for swiped right
	 */
	@android.databinding.BindingAdapter(value = {"swipeEnabled", "drawableSwipeLeft", "drawableSwipeRight", "bgColorSwipeLeft", "bgColorSwipeRight", "onItemSwipeLeft", "onItemSwipeRight"}, requireAll = false)
	public static void setItemSwipeToRecyclerView(RecyclerView recyclerView, boolean swipeEnabled, Drawable drawableSwipeLeft, Drawable drawableSwipeRight, int bgColorSwipeLeft, int bgColorSwipeRight,
	                                              SwipeItemTouchHelperCallback.OnItemSwipeListener onItemSwipeLeft, SwipeItemTouchHelperCallback.OnItemSwipeListener onItemSwipeRight) {

		ItemTouchHelper.Callback swipeCallback = new SwipeItemTouchHelperCallback
				.Builder(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT)
				.bgColorSwipeLeft(bgColorSwipeLeft)
				.bgColorSwipeRight(bgColorSwipeRight)
				.drawableSwipeLeft(drawableSwipeLeft)
				.drawableSwipeRight(drawableSwipeRight)
				.setSwipeEnabled(swipeEnabled)
				.onItemSwipeLeftListener(onItemSwipeLeft)
				.onItemSwipeRightListener(onItemSwipeRight)
				.build();

		ItemTouchHelper itemTouchHelper = new ItemTouchHelper(swipeCallback);
		itemTouchHelper.attachToRecyclerView(recyclerView);
	}
}
