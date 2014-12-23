package com.example.ad_board;

import java.util.Random;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity implements Runnable{
	
	private ImageView iv;
	private Handler handler;
	private int[] path=new int[]{R.drawable.ic_launcher,R.drawable.abc_btn_check_material};
	private String[] title=new String[]{"fuck","bitch"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		iv=(ImageView)findViewById(R.id.imageView1);
		Thread t=new Thread(this);
		t.start();
		
		handler=new Handler(){

			@Override
			public void handleMessage(Message msg) {
				// TODO 自动生成的方法存根
				super.handleMessage(msg);
				TextView tv=(TextView)findViewById(R.id.textView1);
				if(msg.what==0x101){
					tv.setText(msg.getData().getString("title"));
					iv.setImageResource(path[msg.arg1]);
				}
				super.handleMessage(msg);
			}
		};
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
	public void run() {
		// TODO 自动生成的方法存根
		int index=0;
		while(!Thread.currentThread().isInterrupted()){
			index=new Random().nextInt(path.length);
			Message m=handler.obtainMessage();
			m.arg1=index;
			Bundle bundle=new Bundle();
			m.what=0x101;
			bundle.putString("title",title[index]);
			m.setData(bundle);
			handler.sendMessage(m);
			try{
				Thread.sleep(2000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}
