package com.andro.indie.school.exampleanimation;


import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.support.annotation.AnimRes;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class AnimUtil {

    private Context mContext;
    private Handler animHandler;

    private final String TAG = AnimUtil.class.getSimpleName();

    public AnimUtil(Context context) {
        this.mContext = context;
        this.animHandler = new Handler();
    }

    public interface AnimListener {
        void onAnimStart();
        void onAnimEnd();
        void onAnimRepeat();
    }

    private Animation getAnim(final int animType) {
        Animation anim = null;
        try {
            anim = AnimationUtils.loadAnimation(mContext, animType);
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
        }
        return anim;
    }

    public void setAnim(View view, @AnimRes final int animType, final AnimListener listener) {
        Animation animation = getAnim(animType);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                listener.onAnimStart();
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                listener.onAnimEnd();
                animHandler.removeCallbacksAndMessages(null);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                listener.onAnimRepeat();
            }
        });
        startCurrentAnim(view, animation);
    }

    public void setAnim(View view, final int animType) {
        Animation animation = getAnim(animType);
        startCurrentAnim(view, animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                animHandler.removeCallbacksAndMessages(null);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    private void startCurrentAnim(final View view, final Animation animation) {
        try {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    animHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            view.startAnimation(animation);
                        }
                    });
                }
            }).start();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
