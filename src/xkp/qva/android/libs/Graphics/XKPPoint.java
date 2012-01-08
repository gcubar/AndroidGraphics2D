package xkp.qva.android.libs.Graphics;

import android.content.Context;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.PathShape;
import android.util.AttributeSet;

public class XKPPoint extends XKPGraphics {

	public XKPPoint(Context context) {
		this(context, null);
	}

	public XKPPoint(Context context, AttributeSet attrs) {
		super(context, attrs);

		updateShapePosition();
		
		RectF bounds = new RectF();
		mPathShape.computeBounds(bounds, true);
		
		mDrawable = new ShapeDrawable(new PathShape(mPathShape, bounds.width(), bounds.height()));
		mDrawable.setBounds(0, 0, (int) bounds.width(), (int) bounds.height());
	}
	
	@Override
	protected void updateShapePosition() {
		Integer mRadius = new Integer(1);
		mPathShape.reset();
		mPathShape.addCircle(mX1, mY1, mRadius, Direction.CCW);
	}
}
