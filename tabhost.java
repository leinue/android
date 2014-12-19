package com.example.tabhost;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;

public class MainActivity extends ActionBarActivity {
	
	private TabHost tabHost;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tabHost=(TabHost)findViewById(R.id.tabhost);
		tabHost.setup();
		
		LayoutInflater inflater=LayoutInflater.from(this);
		inflater.inflate(R.layout.tab1,tabHost.getTabContentView());
		inflater.inflate(R.layout.tab2,tabHost.getTabContentView());
		tabHost.addTab(tabHost.newTabSpec("tab01").setIndicator("fuck").setContent(R.id.linearLayout1));
		tabHost.addTab(tabHost.newTabSpec("tab02").setIndicator("bitch").setContent(R.id.linearLayout2));
	}
	
	
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
