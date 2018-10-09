package com.tianyao.xiaolu.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tianyao.xiaolu.R;

/**
 * Created by 陆维淋
 * on 2018/9/13
 */
public class LoadingDialog extends Dialog {

    private Context context;
    private TextView tvText;

    public LoadingDialog(@NonNull Context context) {
        super(context, R.style.loading_dialog);
        this.context = context;
        init();
    }

    public LoadingDialog(@NonNull Context context, String title) {
        super(context, R.style.loading_dialog);
        this.context = context;
        init();
        initTitle(title);
    }

    private void init() {
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_loading, null);
        final ImageView ivLoading = view.findViewById(R.id.iv_loading);
        tvText = view.findViewById(R.id.tv_text);

        this.setCancelable(true);
        this.setCanceledOnTouchOutside(false);
        this.setContentView(view);

        this.setOnShowListener(new MyShowListener(ivLoading));
        this.setOnDismissListener(new MyDismissListener(ivLoading));
    }

    private void initTitle(String title) {
        tvText.setText(title);
    }

    /**
     * 使用静态内部类
     */
    public static class MyShowListener implements OnShowListener {

        private AnimationDrawable animationDrawable;
        private ImageView imgViewLoading;

        public MyShowListener(ImageView imgViewLoading) {
            this.imgViewLoading = imgViewLoading;
        }

        @Override
        public void onShow(DialogInterface dialog) {
            animationDrawable = (AnimationDrawable) imgViewLoading.getDrawable();
            animationDrawable.start();
        }
    }

    /**
     * 使用静态内部类
     */
    public static class MyDismissListener implements OnDismissListener {

        private AnimationDrawable animationDrawable;
        private ImageView imgViewLoading;

        public MyDismissListener(ImageView imgViewLoading) {
            this.imgViewLoading = imgViewLoading;
        }

        @Override
        public void onDismiss(DialogInterface dialog) {
            animationDrawable = (AnimationDrawable) imgViewLoading.getDrawable();
            animationDrawable.stop();
        }
    }

    public void setText(String text) {
        tvText.setText(text);
    }

}
