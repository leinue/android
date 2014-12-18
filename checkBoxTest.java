package com.example.checkboxtest;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final CheckBox like1=(CheckBox)findViewById(R.id.like1);
		final CheckBox like2=(CheckBox)findViewById(R.id.like2);
		final CheckBox like3=(CheckBox)findViewById(R.id.like3);
		
		like1.setOnCheckedChangeListener(checkBox_listener);
		like2.setOnCheckedChangeListener(checkBox_listener);
		like3.setOnCheckedChangeListener(checkBox_listener);
		
		final Button submit=(Button)findViewById(R.id.button1);
		submit.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				String like="";
				if(like1.isChecked()){
					like+=like1.getText().toString()+" ";
				}
				if(like2.isChecked()){
					like+=like2.getText().toString()+" ";
				}
				if(like3.isChecked()){
					like+=like3.getText().toString()+" ";
				}
				Toast.makeText(MainActivity.this,like,Toast.LENGTH_SHORT).show();
			}
		});
	}
	
	private OnCheckedChangeListener checkBox_listener=new OnCheckedChangeListener(){
		public void onCheckedChanged(CompoundButton buttonView,boolean isChecked){
			if(isChecked){
				Toast.makeText(MainActivity.this,buttonView.getText().toString(),Toast.LENGTH_SHORT).show();
				Log.i("CheckBox",buttonView.getText().toString());
			}
		}
	};

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
