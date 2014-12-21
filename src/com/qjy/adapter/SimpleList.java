package com.qjy.adapter;


import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class SimpleList extends ListActivity {
	private String[] mListString = {
			"������������", 
			"�Ա�Ů", 
			"���䣺23", 
			"��ס�أ�������ˮ", 
			"���䣺fan_qiao_ling@126.com"};
	private ListView mListView = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mListView = this.getListView();
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mListString));
		mListView.setOnItemClickListener(new ListView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				Toast.makeText(SimpleList.this, "��ѡ����"+mListString[position], Toast.LENGTH_SHORT).show();
			}
		});
	}
}

