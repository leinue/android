package com.example.buttontest;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		RadioGroup sex=(RadioGroup)findViewById(R.id.radioGroup1);
		sex.setOnCheckedChangeListener(new OnCheckedChangeListener(){
			
			public void onCheckedChanged(RadioGroup group,int checkedId){
				RadioButton r=(RadioButton)findViewById(checkedId);
				r.getText();
				//Toast.makeText(this,r.getText().toString(),Toast.LENGTH_SHORT).show();
				Log.i("hhh",r.getText().toString());
				Toast.makeText(MainActivity.this,r.getText().toString(),Toast.LENGTH_SHORT).show();
			}
			
		});
		
		Button submitBtn=(Button)findViewById(R.id.submit);
		submitBtn.setOnClickListener(new OnClickListener(){
			
			public void onClick(View v){
				Toast.makeText(MainActivity.this,"sssa",Toast.LENGTH_SHORT).show();
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


