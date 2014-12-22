package com.example.menutest;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        TextView tv=(TextView)findViewById(R.id.textview1);
        registerForContextMenu(tv);
    }
    
    @Override
    public void onCreateContextMenu(ContextMenu menu,View v,ContextMenuInfo menuInfo){
    	MenuInflater inflator=new MenuInflater(this);
    	inflator.inflate(R.menu.main, menu);
    	menu.setHeaderIcon(R.drawable.ic_launcher);
    	menu.setHeaderTitle("please choose");
    }
    
    @Override
    public boolean onContextItemSelected(MenuItem item){
    	Toast.makeText(this,item.getTitle(),Toast.LENGTH_SHORT).show();
    	return super.onContextItemSelected(item);
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
