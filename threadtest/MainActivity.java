package com.example.threadtest;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends ActionBarActivity implements Runnable{
	
	private Thread thread;
	int i;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button start=(Button)findViewById(R.id.button1);
		start.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				i=0;
				thread=new Thread(MainActivity.this);
				thread.start();
			}
			
		});
		
		Button stop=(Button)findViewById(R.id.button2);
		stop.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				if(thread!=null){
					thread.interrupt();
					thread=null;
				}
			}
			
		});
	}

	@Override
	public void run() {
		// TODO 自动生成的方法存根
		while(!Thread.currentThread().isInterrupted()){
			i++;
			Log.i("counter",String.valueOf(i));
		}
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

	@Override
	protected void onDestroy() {
		// TODO 自动生成的方法存根
		if(thread!=null){
			thread.interrupt();
			thread=null;
		}
		super.onDestroy();
	}
}
