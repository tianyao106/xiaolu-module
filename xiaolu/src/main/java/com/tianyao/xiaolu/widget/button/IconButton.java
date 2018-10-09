package com.tianyao.xiaolu.widget.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

import com.tianyao.xiaolu.R;


/**
 * Created by 陆维淋
 * on 2018/9/12
 */
public class IconButton extends AppCompatButton {

    private int drawableWidth;
    private DrawablePositions drawablePositions;
    private int iconPadding;
    private Rect bounds;

    private enum DrawablePositions {
        NONE,
        LEFT_AND_RIGHT,
        LEFT,
        RIGHT
    }

    public IconButton(Context context) {
        this(context, null);
    }

    public IconButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyAttributes(attrs);
    }

    private void applyAttributes(AttributeSet attrs) {
        if (bounds == null) {
            bounds = new Rect();
        }
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.IconButton);
        iconPadding = typedArray.getDimensionPixelSize(R.styleable.IconButton_iconPadding, 0);
        requestLayout();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Paint textPaint = getPaint();
        String text = getText().toString();
        textPaint.getTextBounds(text, 0, text.length(), bounds);

        int textWidth = bounds.width();
        int factor = (drawablePositions == DrawablePositions.LEFT_AND_RIGHT) ? 2 : 1;
        int contentWidth = drawableWidth + iconPadding * factor + textWidth;
        int horizontalPadding = (int) (getWidth() / 2.0 - contentWidth / 2.0);

        setCompoundDrawablePadding(-horizontalPadding + iconPadding);

        switch (drawablePositions) {
            case LEFT:
                setPadding(horizontalPadding, getPaddingTop(), 0, getPaddingBottom());
                break;
            case RIGHT:
                setPadding(0, getPaddingTop(), horizontalPadding, getPaddingBottom());
                break;
            case LEFT_AND_RIGHT:
                setPadding(horizontalPadding, getPaddingTop(), horizontalPadding, getPaddingBottom());
                break;
            default:
                setPadding(0, getPaddingTop(), 0, getPaddingBottom());
                break;
        }
    }

    @Override
    public void setCompoundDrawablesWithIntrinsicBounds(@Nullable Drawable left, @Nullable Drawable top, @Nullable Drawable right, @Nullable Drawable bottom) {
        super.setCompoundDrawablesWithIntrinsicBounds(left, top, right, bottom);
        if (left != null && right != null) {
            drawableWidth = left.getIntrinsicWidth() + right.getIntrinsicWidth();
            drawablePositions = DrawablePositions.LEFT_AND_RIGHT;
        } else if (left != null) {
            drawableWidth = left.getIntrinsicWidth();
            drawablePositions = DrawablePositions.LEFT;
        } else if (right != null) {
            drawableWidth = right.getIntrinsicWidth();
            drawablePositions = DrawablePositions.RIGHT;
        } else {
            drawablePositions = DrawablePositions.NONE;
        }
        requestLayout();
    }
}
