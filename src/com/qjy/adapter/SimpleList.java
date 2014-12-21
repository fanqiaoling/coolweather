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
			"姓名：樊巧玲", 
			"性别：女", 
			"年龄：23", 
			"居住地：江苏涟水", 
			"邮箱：fan_qiao_ling@126.com"};
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
				Toast.makeText(SimpleList.this, "你选择了"+mListString[position], Toast.LENGTH_SHORT).show();
			}
		});
	}
}

