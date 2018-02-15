package br.com.x10d.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		LinearLayout ll = new LinearLayout(this);
		
		TextView tv = new TextView(this);
		tv.setText("testennnnn");
		
		ll.addView(tv);
		
		setContentView(ll);
	}
}
