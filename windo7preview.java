package com.example.win7windowspreview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;

public class MainActivity extends ActionBarActivity {
	
	private int[] imageId=new int[]{R.drawable.img01,R.drawable.img02,R.drawable.img03,
			R.drawable.img04,R.drawable.img05,R.drawable.img06,R.drawable.img07,R.drawable.img08};
	private ImageSwitcher imageSwitcher;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		imageSwitcher=(ImageSwitcher)findViewById(R.id.imageSwitcher1);
		imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_in));
		imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));
		imageSwitcher.setFactory(new ViewFactory(){
			public View makeView(){
				ImageView imageView=new ImageView(MainActivity.this);
				imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
				imageView.setLayoutParams(new ImageSwitcher.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
				return imageView;
			}
		});
		imageSwitcher.setImageResource(imageId[6]);//设置默认显示的图像
	
		GridView gridview=(GridView)findViewById(R.id.gridView1);
		BaseAdapter adapter=new BaseAdapter(){
			public View getView(int position,View convertView,ViewGroup parent){
				ImageView imageview;
				if(convertView==null){
					imageview=new ImageView(MainActivity.this);
					
					imageview.setAdjustViewBounds(true);
					imageview.setMaxWidth(150);
					imageview.setMaxHeight(113);
					
					imageview.setPadding(5,5,5,5);
				}else{
					imageview=(ImageView)convertView;
				}
				imageview.setImageResource(imageId[position]);
				return imageview;
			}

			public int getCount() {
				// TODO 自动生成的方法存根
				return imageId.length;
			}

			public Object getItem(int arg0) {
				// TODO 自动生成的方法存根
				return arg0;
			}

			public long getItemId(int arg0) {
				// TODO 自动生成的方法存根
				return arg0;
			}
		};
		
		gridview.setAdapter(adapter);
		gridview.setOnItemClickListener(new OnItemClickListener(){
			public void onItemClick(AdapterView<?> parent,View view,int pos,long id){
				imageSwitcher.setImageResource(imageId[pos]);
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
