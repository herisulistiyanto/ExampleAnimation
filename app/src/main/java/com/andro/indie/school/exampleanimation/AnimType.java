package com.andro.indie.school.exampleanimation;

import android.support.annotation.IntDef;

/**
 * Created by herisulistiyanto on 1/30/18.
 */
@IntDef({
        AnimType.ANIM_FADE_IN,
        AnimType.ANIM_FADE_OUT,
        AnimType.ANIM_MOVE,
        AnimType.ANIM_ROTATE,
        AnimType.ANIM_SLIDE_DOWN,
        AnimType.ANIM_SLIDE_UP,
        AnimType.ANIM_SLIDE_RIGHT,
        AnimType.ANIM_SLIDE_LEFT,
        AnimType.ANIM_ZOOM_IN,
        AnimType.ANIM_ZOOM_OUT
})
public @interface AnimType {
    int ANIM_FADE_IN = R.anim.anim_fade_in;
    int ANIM_FADE_OUT = R.anim.anim_fade_out;
    int ANIM_MOVE = R.anim.anim_move;
    int ANIM_ROTATE = R.anim.anim_rotate;
    int ANIM_SLIDE_DOWN = R.anim.anim_slide_down;
    int ANIM_SLIDE_UP = R.anim.anim_slide_up;
    int ANIM_SLIDE_RIGHT = R.anim.anim_slide_right;
    int ANIM_SLIDE_LEFT = R.anim.anim_slide_left;
    int ANIM_ZOOM_IN = R.anim.anim_zoom_in;
    int ANIM_ZOOM_OUT = R.anim.anim_zoom_out;
}
