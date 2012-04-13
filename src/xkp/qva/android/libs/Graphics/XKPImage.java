package xkp.qva.android.libs.Graphics;

import xkp.qva.android.Graphics2D.R;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;

public class XKPImage extends XKPGraphics {

	private Context 	mContext;
	private int 		mBitmapResourceId;
	
	public XKPImage(Context context) {
		this(context, null);
	}

	public XKPImage(Context context, AttributeSet attrs) {
		super(context, attrs);

		mContext = context;
		TypedArray ta = context.obtainStyledAttributes(
				attrs, R.styleable.XKPImage);
		
		mBitmapResourceId = ta.getResourceId(R.styleable.XKPImage_src, 0);
		
		ta.recycle();
		
		resolveBitmapFromResource(mBitmapResourceId);
		calculateSize();
	}
	
	public void setImageBitmap(Bitmap bmp) {
		mBitmap = bmp;
		calculateSize();
		mBitmap.prepareToDraw();
		invalidate();
	}
	
	public void setAlpha() {
		//TODO: 
	}
	
	public void setImageResource(int resId) {
		if(resId == 0) return;
		
		Resources res = mContext.getResources();
		setImageBitmap(BitmapFactory.decodeResource(res, resId));
	}
	
	private void resolveBitmapFromResource(int resId) {
		Resources res = mContext.getResources();
		mBitmap = BitmapFactory.decodeResource(res, resId);
	}
	
	private void calculateSize() {
		if(mBitmap == null) return;
		
		if(mX2 == -1 || mX1 == mX2) mX2 = mX1 + mBitmap.getWidth();
		if(mY2 == -1 || mY1 == mY2) mY2 = mY1 + mBitmap.getHeight();
	}
}
