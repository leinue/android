package com.example.notificationtest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends ActionBarActivity {
	final int NOTIFYID_1 = 123;	//第一个通知的ID
	final int NOTIFYID_2 = 124;	//第二个通知的ID
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final NotificationManager notificationManager=
				(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
		
		Button sendNoti=(Button)findViewById(R.id.button1);
		sendNoti.setOnClickListener(new OnClickListener(){
			
			public void onClick(View v){
				Notification notify=new Notification();
				notify.icon=R.drawable.ic_launcher;
				notify.tickerText="fuck off,son of bitch.";
				notify.when=System.currentTimeMillis();//设置发送时间
				notify.defaults=Notification.DEFAULT_ALL;//设置默认声音,默认振动和默认闪光灯
				notify.setLatestEventInfo(MainActivity.this,"233","develop",null);
				notificationManager.notify(NOTIFYID_1, notify);
				
				/*Notification notify1=new Notification(R.drawable.ic_launcher,"second",System.currentTimeMillis());
				notify1.flags|=Notification.FLAG_AUTO_CANCEL;
				Intent intent=new Intent(MainActivity.this,ContentActivity.class);
				PendingIntent pendingIntent=PendingIntent.getActivity(MainActivity.this,0,intent,0);
				notify1.setLatestEventInfo(MainActivity.this,"hhh","fuck u",pendingIntent);
				notificationManager.notify(NOTIFYID_2,notify1);*/
			}
		});
		
		Button remove=(Button)findViewById(R.id.button2);
		remove.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				notificationManager.cancel(NOTIFYID_1);
				notificationManager.cancelAll();
			}
		});
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
