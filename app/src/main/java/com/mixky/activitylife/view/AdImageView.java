package com.mixky.activitylife.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * Created by Administrator on 2018/1/10.
 */

public class AdImageView extends AppCompatImageView {
    private int mDx;
    private int mMinDx;

    public void setDx(int dx) {
        if (getDrawable() == null) {
            return;
        }
        mDx = dx - mMinDx;
        if (mDx <= 0) {
            mDx = 0;
        }
        if (mDx > getDrawable().getBounds().height() - mMinDx) {
            mDx = getDrawable().getBounds().height() - mMinDx;
        }
        invalidate();


    }

    public int getDx() {
        return mDx;
    }


    public AdImageView(Context context) {
        super(context);
    }

    public AdImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AdImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        int w = getWidth();
        int h = (int) (getWidth() * 1.0f / drawable.getIntrinsicWidth() * drawable.getIntrinsicHeight());
        drawable.setBounds(0, 0, w, h);
        canvas.save();
        canvas.translate(0, -getDx());
        super.onDraw(canvas);
        canvas.restore();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mMinDx = h;
    }
}
