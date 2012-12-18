package edu.eci.maeocs;

import android.R.layout;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.LabeledIntent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.Display;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MapWindow extends Activity {
	
	private Bundle bundle;
	private int width = 0;
	private int height = 0;
	private int grid = 30;
	private TextView grilla[][];
	private TableLayout table;
	private TableLayout background;
	int pass = 0;
	int xpos = 0;
	int ypos = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.activity_map_window);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.maeocs_window_title);
//		bundle = this.getIntent().getExtras();
//		width = bundle.getInt("width");
//		height = bundle.getInt("height");
//		grid = bundle.getInt("grid");
		background = (TableLayout) findViewById(R.id.rl_MapWindowBackground);
		background.setWeightSum(grid);
		grilla = new TextView[grid][grid];
		for (int i = 0; i < grid; i++) {
			for (int j = 0; j < grid; j++) {
				grilla[i][j]= new TextView (this);
				grilla[i][j].setText(" ");
				if(i==5)
					grilla[i][j].setBackgroundColor(Color.GREEN);
			}
		}
		for (int i = 0; i < grid; i++) {
			TableRow row = new TableRow(this);
			for (int j = 0; j < grid; j++) {
				row.addView(grilla[i][j]);
				System.out.println(grilla[i][j].getText());
			}
			background.addView(row, new TableLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		}
		
//		demoview = new DemoView(this);
//		setContentView(demoview);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_map_window, menu);
		return true;
	}
	
//	private class DemoView extends View {
//		public DemoView(Context context) {
//		super(context);
//		this.setBackgroundColor(R.drawable.background);
//		}
//
//		@Override
//		protected void onDraw(Canvas canvas) {
//		super.onDraw(canvas);
//		this.setBackgroundColor(R.drawable.background);
//		// custom drawing code here
//		// remember: y increases from top to bottom
//		// x increases from left to right
//
//		Paint paint = new Paint();
//		paint.setStyle(Paint.Style.FILL);
//
//		// make the entire canvas white
//		paint.setColor(Color.TRANSPARENT);
//		canvas.drawPaint(paint);
//
//		Display display = getWindowManager().getDefaultDisplay();
//		width = display.getWidth();//start
//		height = display.getHeight();//end
//
//
//		xpos = width / 7;
//		ypos = height/7;
//		for (int i = 0; i < 7; i++) {
//
//		paint.setColor(Color.WHITE);
//		canvas.drawLine(xpos +(xpos*i), 0, xpos +(xpos*i), height, paint);
//		//canvas.drawLine(startX, startY, stopX, stopY, paint)
//
//		}
//		paint.setStyle(Style.STROKE);
//		for (int i = 0; i < 7; i++) {
//		paint.setColor(Color.WHITE);
//		canvas.drawLine(0, (ypos*pass)+ 5, width, (ypos*pass)+5, paint);
//		pass++;
//
//		}
//		}
//		}

}
