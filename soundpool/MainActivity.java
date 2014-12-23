package com.example.soundpool;

import java.util.HashMap;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {
	
	private SoundPool soundpool;
	private HashMap<Integer,Integer> soundmap=new HashMap<Integer,Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button chiems=(Button)findViewById(R.id.button1);
        Button ding=(Button)findViewById(R.id.button2);
        
        soundpool=new SoundPool(5,AudioManager.STREAM_SYSTEM,0);
        soundmap.put(1,soundpool.load(this,R.raw.chimes,1));
        soundmap.put(2,soundpool.load(this,R.raw.ding,1));
        
        chiems.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				soundpool.play(soundmap.get(1),1, 1, 0, 0, 1);
			}
        	
        });
        
        ding.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				soundpool.play(soundmap.get(2),1, 1, 0, 0, 1);
			}
        	
        });
        
        
    }
    
    @Override
    public boolean onKeyDown(int keyCode,KeyEvent  event){
    	soundpool.play(soundmap.get(1),1,1,0,0,1);
    	return true;
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
