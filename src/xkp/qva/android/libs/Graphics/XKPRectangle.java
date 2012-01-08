package xkp.qva.android.libs.Graphics;

import android.content.Context;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.PathShape;
import android.util.AttributeSet;

public class XKPRectangle extends XKPGraphics {
	
	public XKPRectangle(Context context) {
		this(context, null);
	}
	
	public XKPRectangle(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		updateShapePosition();
		
		RectF bounds = new RectF();
		mPathShape.computeBounds(bounds, true);
		
		mDrawable = new ShapeDrawable(new PathShape(mPathShape, bounds.width(), bounds.height()));
		mDrawable.setBounds(0, 0, (int) bounds.width(), (int) bounds.height());
	}
	
	@Override
	protected void updateShapePosition() {
		mPathShape.reset();
		mPathShape.addRect(mLeftTop.x, mLeftTop.y, mBottomRight.x, mBottomRight.y, Direction.CCW);
	}
}
