package com.example.accountsoft.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.accountsoft.model.Tb_inaccount;

public class InaccountDAO {
	
	private DBOpenHelper helper;
	private SQLiteDatabase db;
	
	public InaccountDAO(Context context){
		helper=new DBOpenHelper(context);
	}
	
	/**
	 * ����������Ϣ
	 * 
	 * @param tb_inaccount
	 */
	public void add(Tb_inaccount tb_inaccount){
		db=helper.getWritableDatabase();
		db.execSQL(
				"insert into tb_inaccount (_id,money,time,type,handler,mark) values (?,?,?,?,?,?)",
				new Object[] { tb_inaccount.getid(), tb_inaccount.getMoney(),
						tb_inaccount.getTime(), tb_inaccount.getType(),
						tb_inaccount.getHandler(), tb_inaccount.getMark() });
	}
	
	/**
	 * ����������Ϣ
	 * 
	 * @param tb_inaccount
	 */
	public void update(Tb_inaccount tb_inaccount) {
		db = helper.getWritableDatabase();// ��ʼ��SQLiteDatabase����
		// ִ���޸�������Ϣ����
		db.execSQL(
				"update tb_inaccount set money = ?,time = ?,type = ?,handler = ?,mark = ? where _id = ?",
				new Object[] { tb_inaccount.getMoney(), tb_inaccount.getTime(),
						tb_inaccount.getType(), tb_inaccount.getHandler(),
						tb_inaccount.getMark(), tb_inaccount.getid() });
	}
	
	/**
	 * ����������Ϣ
	 * 
	 * @param id
	 * @return
	 */
	public Tb_inaccount find(int id){
		db=helper.getWritableDatabase();
		Cursor cursor = db
				.rawQuery(
						"select _id,money,time,type,handler,mark from tb_inaccount where _id = ?",
						new String[] { String.valueOf(id) });// ���ݱ�Ų���������Ϣ�����洢��Cursor����
		if(cursor.moveToNext()){
			return new Tb_inaccount(
					cursor.getInt(cursor.getColumnIndex("_id")),
					cursor.getDouble(cursor.getColumnIndex("money")),
					cursor.getString(cursor.getColumnIndex("time")),
					cursor.getString(cursor.getColumnIndex("type")),
					cursor.getString(cursor.getColumnIndex("handler")),
					cursor.getString(cursor.getColumnIndex("mark")));
		}
		return null;// ���û����Ϣ���򷵻�null
	}
	
	/*
	 *ɾ��������Ϣ 
	 * 
	 * @param ids
	 */
	public void delete(Integer... ids){
		if(ids.length>0){
			StringBuffer sb=new StringBuffer();
			for(int i=0;i<ids.length;i++){
				sb.append('?').append(',');
			}
			sb.deleteCharAt(sb.length()-1);
			db=helper.getWritableDatabase();
			db.execSQL("delete from tb_inaccount where _id in("+sb+")", (Object[]) ids);
		}
	}
	
	/*
	 * ��ȡ������Ϣ
	 * @param start ��ʼλ�� 
	 * @param count ÿҳ��ʾ����
	 * @return
	 */
	public List<Tb_inaccount> getScrollData(int start,int count){
		List<Tb_inaccount> tb_inaccount=new ArrayList<Tb_inaccount>();
		db=helper.getWritableDatabase();
		Cursor cursor = db.rawQuery("select * from tb_inaccount limit ?,?",
				new String[] { String.valueOf(start), String.valueOf(count) });
		while(cursor.moveToNext()){
			tb_inaccount.add(new Tb_inaccount(cursor.getInt(cursor
					.getColumnIndex("_id")), cursor.getDouble(cursor
					.getColumnIndex("money")), cursor.getString(cursor
					.getColumnIndex("time")), cursor.getString(cursor
					.getColumnIndex("type")), cursor.getString(cursor
					.getColumnIndex("handler")), cursor.getString(cursor
					.getColumnIndex("mark"))));
		}
		return tb_inaccount;
	}
	
	/*
	 * ��ȡ�ܼ�¼�� 
	 * @return
	 */
	public long getCount(){
		db=helper.getWritableDatabase();
		Cursor cursor=db.rawQuery("select count(_id) from tb_inaccount", null);
		if(cursor.moveToNext()){
			return cursor.getLong(0);
		}
		return 0;
	}
}