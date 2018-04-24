package photoview;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;

public class HackyViewPager extends ViewPager {

	public HackyViewPager(Context context) {
		super(context);
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		try {
			return super.onInterceptTouchEvent(ev);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}
	}

}