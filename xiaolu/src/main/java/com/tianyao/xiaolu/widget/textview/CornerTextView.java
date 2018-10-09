package com.tianyao.xiaolu.widget.textview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;

import com.tianyao.xiaolu.R;

/**
 * Created by 陆维淋
 * on 2018/9/12
 */
public class CornerTextView extends android.support.v7.widget.AppCompatTextView {

    GradientDrawable shape;

    public CornerTextView(Context context) {
        this(context, null);
    }

    public CornerTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (shape == null) {
            shape = new GradientDrawable();
        }
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CornerTextView, 0, 0);
        int cornerRadius = (int) typedArray.getDimension(R.styleable.CornerTextView_tv_corner_radius, 360);
        int borderStroke = (int) typedArray.getDimension(R.styleable.CornerTextView_tv_border_stroke, 1);
        int borderColor = typedArray.getColor(R.styleable.CornerTextView_tv_border_color, Color.parseColor("#3b7fd4"));
        shape.setCornerRadius(cornerRadius);
        shape.setStroke(borderStroke, borderColor);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            setBackground(shape);
        } else {
            setBackgroundDrawable(shape);
        }
    }
}
