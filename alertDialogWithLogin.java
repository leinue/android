package com.example.alertdialoglogin;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Builder login=new AlertDialog.Builder(this);
		
		login.setIcon(R.drawable.ic_launcher);
		login.setTitle("login");
		login.setMessage("hhhh");
		LayoutInflater inflater=getLayoutInflater();
		View view=inflater.inflate(R.layout.login,null);
		login.setView(view);
		login.setPositiveButton("submit to login in",null);
		login.setNegativeButton("exist",new OnClickListener(){
			public void onClick(DialogInterface dialog,int which){
				finish();
			}
		});
		login.create().show();
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
