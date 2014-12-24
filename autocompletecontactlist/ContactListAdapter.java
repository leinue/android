package com.example.autocompletecontactlist;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract.Contacts;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;
import android.widget.TextView;

public class ContactListAdapter extends CursorAdapter implements Filterable{
	
	private ContentResolver resolver;
	private String[] columns=new String[]{Contacts._ID,Contacts.DISPLAY_NAME};
	
	public ContactListAdapter(Context context, Cursor c) {
		super(context, c);
		// TODO �Զ����ɵĹ��캯�����
		resolver=context.getContentResolver();
	}
	

	@Override
	public View newView(Context context, Cursor cursor, ViewGroup parent) {
		// TODO �Զ����ɵķ������
		LayoutInflater inflater=LayoutInflater.from(context);
		TextView view=(TextView)inflater.inflate(android.R.layout.simple_dropdown_item_1line,parent,false);
		view.setText(cursor.getString(1));
		return view;
	}

	@Override
	public void bindView(View view, Context context, Cursor cursor) {
		// TODO �Զ����ɵķ������
		((TextView)view).setText(context.getString(1));
	}
	
	@Override
	public CharSequence convertToString(Cursor cursor){
		return cursor.getString(1);
	}
	
	@Override
	public Cursor runQueryOnBackgroundThread(CharSequence constraint){
		FilterQueryProvider filter=getFilterQueryProvider();
		if(filter!=null){
			return filter.runQuery(constraint);
		}
		Uri uri=Uri.withAppendedPath(Contacts.CONTENT_FILTER_URI,Uri.encode(constraint.toString()));
		return resolver.query(uri,columns,null,null,null);
	}
}