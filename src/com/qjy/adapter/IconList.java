package com.qjy.adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.example.adaptertest.R;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class IconList extends ListActivity {
	private String[] mListTitle = {
			"姓名",
			"性别",
			"居住地",
			"邮箱"};
	private String[] mListStr = {
			"樊巧玲",
			"女",
			"23",
			"江苏涟水",
			"fan_qiao_ling@126.com"};
	ListView mListView = null;
	ArrayList<Map<String, Object>> mData = new ArrayList<Map<String,Object>>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		mListView = getListView();
		int length = mListTitle.length;
		for(int i=0; i<length; i++){
			Map<String, Object> item = new HashMap<String, Object>();
			item.put("image", R.drawable.ic_launcher);
			item.put("title", mListTitle[i]);
			item.put("text", mListStr[i]);
			mData.add(item);
		}
		SimpleAdapter adapter = new SimpleAdapter(this, 
				mData, 
				R.layout.main, 
				new String[]{"image","title","text"}, 
				new int[]{R.id.image,R.id.title,R.id.text});
		setListAdapter(adapter);
		mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				Toast.makeText(IconList.this, 
						"您选择了标题："+mListTitle[position]+"内容："+mListStr[position], 
						Toast.LENGTH_SHORT).show();
			}
		});
		super.onCreate(savedInstanceState);
	}
}
