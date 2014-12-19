package com.example.alertdialogwithexist;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button exist=(Button)findViewById(R.id.button1);
		exist.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				AlertDialog alert=new AlertDialog.Builder(MainActivity.this).create();
				alert.setIcon(R.drawable.ic_launcher);
				alert.setTitle("really?");
				alert.setMessage("exist?!");
				
				alert.setButton(DialogInterface.BUTTON_NEGATIVE,"No",new OnClickListener(){
					public void onClick(DialogInterface dialog,int which){
						
					}
				});
				
				alert.setButton(DialogInterface.BUTTON_POSITIVE,"yes", new OnClickListener(){
					public void onClick(DialogInterface dialog,int which){
						finish();
					}
				});
				
				alert.show();
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
