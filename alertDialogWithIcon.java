package com.example.alertdialogwithicon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		int[] imageId=new int[]{R.drawable.img01,R.drawable.img02,R.drawable.img03};
		final String[] title=new String[]{"management","fuck","shit"};
		List<Map<String,Object>> listItems=new ArrayList<Map<String,Object>>();
		for(int i=0;i<imageId.length;i++){
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("image",imageId[i]);
			map.put("title",title[i]);
			listItems.add(map);
		}
		final SimpleAdapter adapter=new SimpleAdapter(this,listItems,R.layout.items,
				new String[]{"title","image"},new int[]{R.id.title,R.id.image});
		
		Button get=(Button)findViewById(R.id.button1);
		get.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				Builder build=new AlertDialog.Builder(MainActivity.this);
				build.setIcon(R.drawable.ic_launcher);
				build.setTitle("bitch");
				build.setAdapter(adapter, new OnClickListener(){
					public void onClick(DialogInterface dialog,int which){
						Toast.makeText(MainActivity.this,title[which],Toast.LENGTH_SHORT).show();
					}
				});
				build.create().show();
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
