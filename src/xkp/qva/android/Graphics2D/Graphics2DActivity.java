package xkp.qva.android.Graphics2D;

import xkp.qva.android.libs.Graphics.XKPClip;
import xkp.qva.android.libs.Graphics.XKPGraphics.OnClickInsideFigureListener;
import xkp.qva.android.libs.Graphics.XKPPolygon;
import xkp.qva.android.libs.Graphics.XKPRectangle;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class Graphics2DActivity 
	extends Activity 
	implements OnClickInsideFigureListener {
	
	XKPPolygon nose;
	XKPRectangle eyes;
	XKPRectangle mouth;
	XKPClip lefteye;
	XKPClip righteye;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        nose = (XKPPolygon) findViewById(R.id.nose);
        nose.addPoint(150, 130);
        nose.addPoint(120, 170);
        nose.addPoint(180, 170);
        nose.setOnClickInsideFigureListener(this);
        
        eyes = (XKPRectangle) findViewById(R.id.eyes);
        eyes.setOnClickInsideFigureListener(this);
        
        lefteye = (XKPClip) findViewById(R.id.lefteye);
        righteye = (XKPClip) findViewById(R.id.righteye);
        
        mouth = (XKPRectangle) findViewById(R.id.mouth);
        mouth.setOnClickInsideFigureListener(this);
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
		}
	}
}