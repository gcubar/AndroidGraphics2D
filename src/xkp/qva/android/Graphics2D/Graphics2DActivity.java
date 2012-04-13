package xkp.qva.android.Graphics2D;

import xkp.qva.android.libs.Graphics.XKPClip;
import xkp.qva.android.libs.Graphics.XKPGraphics.OnClickInsideFigureListener;
import xkp.qva.android.libs.Graphics.XKPImage;
import xkp.qva.android.libs.Graphics.XKPPolygon;
import xkp.qva.android.libs.Graphics.XKPRectangle;
import xkp.qva.android.libs.Layouts.XKPLayout;
import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

public class Graphics2DActivity 
	extends Activity 
	implements OnClickInsideFigureListener {
	
	private XKPLayout mainLayout;
	
	private XKPPolygon nose;
	private XKPRectangle eyes;
	private XKPRectangle mouth;
	private XKPClip lefteye;
	private XKPClip righteye;
	private XKPRectangle body1;
	private XKPRectangle body2;
	
	private float logicalDensity;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        DisplayMetrics outMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
        logicalDensity = outMetrics.density;
        
        mainLayout = (XKPLayout) findViewById(R.id.mainLayout);
        
        nose = (XKPPolygon) findViewById(R.id.nose);
        nose.addPoint(dpi2px(150), dpi2px(130));
        nose.addPoint(dpi2px(120), dpi2px(170));
        nose.addPoint(dpi2px(180), dpi2px(170));
        nose.setOnClickInsideFigureListener(this);
        
        eyes = (XKPRectangle) findViewById(R.id.eyes);
        eyes.setOnClickInsideFigureListener(this);
        
        lefteye = (XKPClip) findViewById(R.id.lefteye);
        righteye = (XKPClip) findViewById(R.id.righteye);
        
        mouth = (XKPRectangle) findViewById(R.id.mouth);
        mouth.setOnClickInsideFigureListener(this);
        
        body1 = (XKPRectangle) findViewById(R.id.body1);
        body1.setOnClickInsideFigureListener(this);
        
        body2 = (XKPRectangle) findViewById(R.id.body2);
        body2.setOnClickInsideFigureListener(this);
        
        XKPImage img1 = new XKPImage(this);
        img1.setPosition(dpi2px(260), dpi2px(20));
        img1.setImageResource(R.drawable.launcher);
        mainLayout.addView(img1);
    }
    
    private int dpi2px(int dp) {
    	return (int) (dp * logicalDensity + 0.5);
    }
    
    private int mInc = 2;

	@Override
	public void onClickInsideFigure(View v) {
		switch (v.getId()) {
		case R.id.eyes:
			lefteye.setPosition(lefteye.getX1() - mInc, lefteye.getY1(), 
					lefteye.getX2() + mInc, lefteye.getY2());
			righteye.setPosition(righteye.getX1() - mInc, righteye.getY1(), 
					righteye.getX2() + mInc, righteye.getY2());
			break;
			
		case R.id.nose:
			mouth.setPosition(mouth.getX1() - mInc, mouth.getY1() - mInc, 
					mouth.getX2() + mInc, mouth.getY2() + mInc);
			break;
		
		case R.id.mouth:
			mouth.setPosition(mouth.getX1() + mInc, mouth.getY1() + mInc, 
					mouth.getX2() - mInc, mouth.getY2() - mInc);
			break;
			
		case R.id.body1:
			body1.setLeft(body1.getX1() - 5);
			body2.setLeft(body2.getX1() - 5);
			break;
			
		case R.id.body2:
			body1.setLeft(body1.getX1() + 5);
			body2.setLeft(body2.getX1() + 5);
			break;
		}
	}
}