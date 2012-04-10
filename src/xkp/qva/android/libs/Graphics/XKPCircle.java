package xkp.qva.android.libs.Graphics;

import xkp.qva.android.Graphics2D.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path.Direction;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.PathShape;
import android.util.AttributeSet;

public class XKPCircle extends XKPGraphics {
	
	private Integer mRadius = 1;
	
	public XKPCircle(Context context) {
		this(context, null);
	}

	public XKPCircle(Context context, AttributeSet attrs) {
		super(context, attrs);

		TypedArray ta = context.obtainStyledAttributes(
				attrs, R.styleable.XKPCircle);
		
		mRadius = ta.getDimensionPixelOffset(R.styleable.XKPCircle_radius, 1);
		
		ta.recycle();
		
		updateShapePosition();
		
		mPathShape.computeBounds(mBounds, true);
		
		mDrawable = new ShapeDrawable(new PathShape(mPathShape, mBounds.width(), mBounds.height()));
		mDrawable.setBounds(0, 0, (int) mBounds.width(), (int) mBounds.height());
	}
	
	@Override
	protected void updateShapePosition() {
		if(mRadius != null) {
			mPathShape.reset();
			mPathShape.addCircle(mX1, mY1, mRadius, Direction.CCW);
			mPathShape.transform(mMtxRotation);
		}
	}

	public void setRadius(Integer radius) {
		this.mRadius = radius;
		
		invalidate();
	}
	
	public Integer getRadius() {
		return mRadius;
	}
}
