package com.example.listviewwithicon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ListView listview=(ListView)findViewById(R.id.listView1);
		int[] imageId=new int[]{R.drawable.img01,R.drawable.img02,R.drawable.img03,R.drawable.img04
				,R.drawable.img05,R.drawable.img06,R.drawable.img07,R.drawable.img08};
		
		String[] title=new String[]{"security","privacy","setting","internet","document","GPS","music","E-mail"};
		
		List<Map<String,Object>>listItems=new ArrayList<Map<String,Object>>();
		for(int i=0;i<imageId.length;i++){
			Map<String,Object>map=new HashMap<String,Object>();
			map.put("image",imageId[i]);
			map.put("title",title[i]);
			listItems.add(map);
		}
		
		SimpleAdapter adapter=new SimpleAdapter(this,listItems,R.layout.items,new String[]{"title","image"},new int[]{
				R.id.image});
		listview.setAdapter(adapter);
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
