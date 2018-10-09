package com.tianyao.xiaolu.widget.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

import com.tianyao.xiaolu.R;

/**
 * Created by 陆维淋
 * on 2018/9/10
 */
public class StateButton extends AppCompatButton {

    //圆角半径
    int cornerRadius = 0;
    //边框宽度
    int borderStroke = 0;
    //边框颜色
    int borderColor = 0;
    //enable为false时的颜色
    int unableColor = 0;

    GradientDrawable shape;

    int colorId;
    int alpha;
    boolean unable;

    public StateButton(Context context) {
        this(context, null);
    }

    public StateButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (shape == null) {
            shape = new GradientDrawable();
        }
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.StateButton, 0, 0);
        cornerRadius = (int) typedArray.getDimension(R.styleable.StateButton_corner_radius, 0);
        borderStroke = (int) typedArray.getDimension(R.styleable.StateButton_border_stroke, 0);
        borderColor = typedArray.getColor(R.styleable.StateButton_border_color, 0);
        unableColor = typedArray.getColor(R.styleable.StateButton_unable_color, Color.GRAY);

        ColorDrawable buttonColor = (ColorDrawable) getBackground();
        colorId = buttonColor.getColor();
        alpha = 255;

        if (unable) {
            shape.setColor(unableColor);
        } else {
            shape.setColor(colorId);
        }
        typedArray.recycle();
        init();
    }

    private void init() {
        //设置圆角半径
        shape.setCornerRadius(cornerRadius);
        //设置边框宽度和颜色
        shape.setStroke(borderStroke, borderColor);
        //将GradientDrawable设置为背景
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            setBackground(shape);
        } else {
            setBackgroundDrawable(shape);
        }
    }

    @Override
    public void setPressed(boolean pressed) {
        super.setPressed(pressed);
        if (pressed) {
            shape.setAlpha((int) (alpha * 0.6));
        } else {
            shape.setAlpha(alpha);
        }
        init();
    }

    @Override
    public void setBackgroundColor(int color) {
        super.setBackgroundColor(color);
        if (unable) {
            shape.setColor(unableColor);
        } else {
            shape.setColor(color);
        }
        init();
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        unable = !enabled;
        if (shape != null) {
            shape = new GradientDrawable();
            if (unable) {
                shape.setColor(unableColor);
            } else {
                shape.setColor(colorId);
            }
            init();
        }
    }
}
