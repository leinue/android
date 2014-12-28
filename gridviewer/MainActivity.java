package com.example.gridviewer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.SimpleAdapter;

public class MainActivity extends ActionBarActivity {
	private int[] imageId = new int[] { R.drawable.img01, R.drawable.img02,
			R.drawable.img03, R.drawable.img04, R.drawable.img05,
			R.drawable.img06, R.drawable.img07, R.drawable.img08,
			R.drawable.img09, R.drawable.img10, R.drawable.img11,
			R.drawable.img12, }; // 定义并初始化保存图片id的数组
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		String[] title = new String[] { "花开富贵", "海天一色", "日出", "天路", "一枝独秀",
				"云", "独占鳌头", "蒲公英花", "花团锦簇", "争奇斗艳", "和谐", "林间小路" }; // 定义并初始化保存说明文字的数组
		GridView gridview=(GridView)findViewById(R.id.gv);
		
		List<Map<String,Object>>listItems=new ArrayList<Map<String,Object>>();
		
		for(int i=0;i<imageId.length;i++){
			Map<String,Object>map=new HashMap<String,Object>();
			map.put("image", imageId[i]);
			map.put("title", title[i]);
			listItems.add(map);
		}
		
		SimpleAdapter adapter=new SimpleAdapter(this,listItems,R.layout.gridlist,
				new String[]{"title","image"},
				new int[]{R.id.title,R.id.image});
		gridview.setAdapter(adapter);
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
