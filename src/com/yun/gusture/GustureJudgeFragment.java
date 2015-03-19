package com.yun.gusture;

import android.support.v4.app.Fragment;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/**
 * 手势监听fragment
 * 
 * @author yun
 * 
 */
public abstract class GustureJudgeFragment extends Fragment implements
		OnTouchListener {
	// 滑动等级
	private static int LEFT_GLIDE_LEVEL = 1, RIGHT_GLIDE_LEVEL = 1,
			UP_GLIDE_LEVEL = 1, DOWN_GLIDE_LEVEL = 1;
	// 每一等级的距离
	public static int STEP = 100;
	private float downX, downY;

	public abstract void leftGlide(int glideLevel);

	public abstract void rightGlide(int glideLevel);

	public abstract void upGlide(int glideLevel);

	public abstract void downGlide(int glideLevel);
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			downX = event.getX();
			downY = event.getY();
		} else if (event.getAction() == MotionEvent.ACTION_MOVE) {
			if (event.getX() - downX > STEP * RIGHT_GLIDE_LEVEL) {
				rightGlide(RIGHT_GLIDE_LEVEL);
				RIGHT_GLIDE_LEVEL++;
			} else if (downX - event.getX() > STEP * LEFT_GLIDE_LEVEL) {
				leftGlide(LEFT_GLIDE_LEVEL);
				LEFT_GLIDE_LEVEL++;
			} else if (event.getY() - downY > STEP * UP_GLIDE_LEVEL) {
				downGlide(DOWN_GLIDE_LEVEL);
				DOWN_GLIDE_LEVEL++;
			} else if (downY - event.getY() > STEP * DOWN_GLIDE_LEVEL) {
				upGlide(UP_GLIDE_LEVEL);
				UP_GLIDE_LEVEL++;
			}
		} else if (event.getAction() == MotionEvent.ACTION_UP) {
			DOWN_GLIDE_LEVEL = 0;
			UP_GLIDE_LEVEL = 0;
			LEFT_GLIDE_LEVEL = 0;
			RIGHT_GLIDE_LEVEL = 0;
		}
		return true;
	}

}
