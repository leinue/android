package com.example.alertdialogtest;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button button1=(Button)findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener(){
			
			public void onClick(View v){
				AlertDialog alert=new AlertDialog.Builder(MainActivity.this).create();
				alert.setIcon(R.drawable.ic_launcher);
				alert.setTitle("tips");
				alert.setMessage("Èý¸ö°´Å¥");
				
				//add button cancel
				alert.setButton(DialogInterface.BUTTON_NEGATIVE,"cancel",new OnClickListener(){
					public void onClick(DialogInterface dialog,int which){
						Toast.makeText(MainActivity.this,"u click cancel button",Toast.LENGTH_SHORT).show();
					}
				});
				//add positive cancel
				alert.setButton(DialogInterface.BUTTON_POSITIVE,"ok",new OnClickListener(){
					public void onClick(DialogInterface dialog,int which){
						Toast.makeText(MainActivity.this,"u click positive button",Toast.LENGTH_SHORT).show();
					}
				});
				//add button cancel
				alert.setButton(DialogInterface.BUTTON_NEUTRAL,"no",new OnClickListener(){
					public void onClick(DialogInterface dialog,int which){
						Toast.makeText(MainActivity.this,"u click neutral button",Toast.LENGTH_SHORT).show();
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
