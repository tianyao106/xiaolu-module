package com.tianyao.xiaolu.widget.pulltorefresh;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tianyao.xiaolu.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by 陆维淋
 * on 2018/9/14
 */
public class PullToRefreshLayout extends RelativeLayout {

    private Context mContext;
    //回滚速度
    private float MOVE_SPEED = 8;
    // 在加载上一页过程中滑动操作
    private boolean isTouch = false;
    //下拉的距离
    private float pullDownY = 0;
    //上拉的距离
    private float pullUpY = 0;

    private MyTimer timer;
    //下拉箭头转180°动画
    private RotateAnimation rotateAnimation;
    //均匀旋转动画
    private RotateAnimation refreshingAnimation;

    //初始状态
    private static final int INIT = 0;
    //释放加载上一页
    private static final int RELEASE_TO_REFRESH = 1;
    //正在加载上一页
    private static final int REFRESHING = 2;
    //释放加载下一页
    private static final int RELEASE_TO_LOAD = 3;
    //正在加载下一页
    private static final int LOADING = 4;
    //操作完毕
    private static final int DONE = 5;

    private int state = INIT;

    //释放加载上一页的距离
    private float refreshDist = 100;
    //释放加载下一页的距离
    private float loadMoreDist = 100;
    //刷新的箭头
    private View refreshView;

    //下拉的箭头
    private View pullView;
    //上拉的箭头
    private View pullUpView;

    //第一次执行布局
    private boolean isLayout = false;

    //实现了Pullable接口的View
    private View pullableView;
    //上拉头
    private View loadmoreView;

    //加载结果：成功或失败
    private TextView tvRefreshState;
    //正在加载的图标
    private View refreshingView;
    //加载结果图标
    private View ivRefreshState;

    //加载结果：成功或失败
    private TextView tvLoadState;
    //正在加载的图标
    private View loadingView;
    //加载结果图标
    private View ivLoadState;

    public PullToRefreshLayout(Context context) {
        this(context, null);
    }

    public PullToRefreshLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PullToRefreshLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        mContext = context;
        timer = new MyTimer(updateHandler);
        rotateAnimation = (RotateAnimation) AnimationUtils.loadAnimation(mContext, R.anim.pull_to_refresh_reverse);
        refreshingAnimation = (RotateAnimation) AnimationUtils.loadAnimation(mContext, R.anim.pull_to_refresh_rotating);
        //添加匀速转动动画
        LinearInterpolator lir = new LinearInterpolator();
        rotateAnimation.setInterpolator(lir);
        refreshingAnimation.setInterpolator(lir);
    }

    /**
     * 执行自动回滚的handler
     */
    @SuppressLint("HandlerLeak")
    private Handler updateHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //回弹速度随下拉距离moveDeltaY增大而增大
            MOVE_SPEED = (float) (8 + 5 * Math.tan(Math.PI / 2 / getMeasuredHeight() * (pullDownY + Math.abs(pullUpY))));
            if (!isTouch) {
                //正在加载，且没有往上推的话则悬停，显示“正在加载...”
                if (state == REFRESHING && pullDownY <= refreshDist) {
                    pullDownY = refreshDist;
                    timer.cancel();
                } else if (state == LOADING && -pullUpY <= loadMoreDist) {
                    pullUpY = -loadMoreDist;
                    timer.cancel();
                }
            }
            if (pullDownY > 0) {
                pullDownY -= MOVE_SPEED;
            } else if (pullUpY < 0) {
                pullUpY += MOVE_SPEED;
            }
            if (pullDownY < 0) {
                //已完成回弹
                pullDownY = 0;
                pullView.clearAnimation();
                //隐藏下拉头时有可能还在刷新，只有当前状态不是正在刷新时才改变状态
                if (state != REFRESHING && state != LOADING) {
                    changeState(INIT);
                }
                timer.cancel();
                requestLayout();
            }
            if (pullUpY > 0) {
                //已完成回弹
                pullUpY = 0;
                pullUpView.clearAnimation();
                //隐藏上拉头时有可能还在加载，只有当前状态不是正在加载时才改变状态
                if (state != REFRESHING && state != LOADING) {
                    changeState(INIT);
                }
                timer.cancel();
                requestLayout();
            }
            //刷新布局，会自动调用onLayout
            requestLayout();
            //没有拖拉或者回弹完成
            if (pullDownY + Math.abs(pullUpY) == 0) {
                timer.cancel();
            }
        }
    };

    private void changeState(int state) {
        this.state = state;
        switch (state) {
            //下拉布局初始状态
            case INIT:
                break;
            case RELEASE_TO_REFRESH:
                break;
            case REFRESHING:
                break;
            case RELEASE_TO_LOAD:
                break;
            case LOADING:
                break;
            case DONE:
                break;
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (!isLayout) {
            //这里是第一次进来的时候做一些初始化
            refreshView = getChildAt(0);
            pullableView = getChildAt(1);
            loadmoreView = getChildAt(2);
            isLayout = true;
            initView();
        }
        //改变子控件的布局，这里直接用（pullDownY+pullUpY）作为偏移量，这样就可以不对当前状态作区分
        refreshView.layout(0, (int) (pullDownY + pullUpY) - refreshView.getMeasuredHeight(), refreshView.getMeasuredWidth(), (int) (pullDownY + pullUpY));
        pullableView.layout(0, (int) (pullDownY + pullUpY), pullableView.getMeasuredWidth(), (int) (pullDownY + pullUpY) + pullableView.getMeasuredHeight());
        loadmoreView.layout(0, (int) (pullDownY + pullUpY) + pullableView.getMeasuredHeight(), loadmoreView.getMeasuredWidth(), (int) (pullDownY + pullUpY) + pullableView.getMeasuredHeight() + loadmoreView.getMeasuredHeight());
    }

    private void initView() {
        //初始化下拉布局
        pullView = refreshView.findViewById(R.id.iv_pull_down);
        tvRefreshState = refreshView.findViewById(R.id.tv_state);
        refreshingView = refreshView.findViewById(R.id.iv_icon_refreshing);
        ivRefreshState = refreshView.findViewById(R.id.iv_state);
        //初始化上拉布局
        pullUpView = loadmoreView.findViewById(R.id.iv_pull_up);
        tvLoadState = loadmoreView.findViewById(R.id.tv_state);
        loadingView = loadmoreView.findViewById(R.id.iv_loading);
        ivLoadState = loadmoreView.findViewById(R.id.iv_state);
    }

    public class MyTimer {

        private Handler handler;
        private Timer timer;
        private MyTask myTask;

        public MyTimer(Handler handler) {
            this.handler = handler;
            this.timer = new Timer();
        }

        public void schedule(long period) {

            if (myTask != null) {
                myTask.cancel();
            }
            myTask = new MyTask(handler);
            timer.schedule(myTask, 0, period);
        }

        public void cancel() {
            if (myTask != null) {
                myTask.cancel();
                myTask = null;
            }
        }

        public class MyTask extends TimerTask {

            private Handler handler;

            public MyTask(Handler handler) {
                this.handler = handler;
            }

            @Override
            public void run() {
                this.handler.obtainMessage().sendToTarget();
            }
        }
    }
}
