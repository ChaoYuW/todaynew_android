package com.wdit.today_new_android.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
/**
 * @desc 不可以滑动的 ViewPager
 */
public class DisableScrollViewPager extends ViewPager {

    private boolean noScroll = true;

    public DisableScrollViewPager(@NonNull Context context) {
        super(context);
    }

    public DisableScrollViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void setNoScroll(boolean noScroll){
        this.noScroll = noScroll;
    }

    @Override
    public void scrollTo(int x, int y) {
        super.scrollTo(x, y);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (noScroll)
            return false;
        else
            return super.onTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (noScroll)
            return false;
        else
            return super.onInterceptTouchEvent(ev);
    }
    @Override
    public void setCurrentItem(int item, boolean smoothScroll) {
        super.setCurrentItem(item, smoothScroll);
    }

    /**
     * @desc 通过方法切换时，不需要显示动画
     * @param item
     */
    @Override
    public void setCurrentItem(int item) {
        super.setCurrentItem(item, false);
    }
}
