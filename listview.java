package com.example.listviewtest;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final ListView listview=(ListView)findViewById(R.id.listView1);
		//listview.addHeaderView(line());
		
		ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(MainActivity.this,
				R.array.ctype,android.R.layout.simple_list_item_checked);
		
		listview.setAdapter(adapter);
		//listview.addFooterView(line());
		
		listview.setOnItemClickListener(new OnItemClickListener(){
			public void onItemClick(AdapterView<?> parent,View arg1,int pos,long id){
				String result=parent.getItemAtPosition(pos).toString();
				Toast.makeText(MainActivity.this,result,Toast.LENGTH_SHORT).show();
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
