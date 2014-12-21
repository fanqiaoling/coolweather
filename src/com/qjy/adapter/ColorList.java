package com.qjy.adapter;

import com.example.adaptertest.R;

import android.app.Activity;
import android.content.Context;

import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ColorList extends Activity {
	private String[] mListTitle = {
			"姓名",
			"性别",
			"年龄",
			"居住地",
			"邮箱"};
	private String[] mListText = {
			"樊巧玲",
			"女",
			"23",
			"江苏涟水",
			"fan_qiao_ling@126.com"};
	private ListView mListView = null;
	private MyListAdapter myAdapter = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main2);
		mListView = (ListView) findViewById(R.id.listView);
		myAdapter = new MyListAdapter(ColorList.this);
		mListView.setAdapter(myAdapter);
		
		mListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
//				View v = parent.getChildAt(position);
//				view.setBackgroundColor(Color.RED);
				Toast.makeText(ColorList.this, 
						"你选择了"+mListText[position], Toast.LENGTH_SHORT).show();
			}
		});
	}
	private class MyListAdapter extends BaseAdapter {
		private Context mContext;
		private int[] colors = new int[]{0xff626569,0xff4f5257};
		public MyListAdapter(Context context){
			this.mContext = context;
		}
		@Override
		public int getCount() {
			return mListText.length;
		}

		@Override
		public Object getItem(int position) {
			return position;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView image = null;
			TextView title = null;
			TextView content = null;
			if(convertView == null){
				convertView = LayoutInflater.from(mContext).inflate(R.layout.main1, null);
				image = (ImageView) convertView.findViewById(R.id.color_image);
				title = (TextView) convertView.findViewById(R.id.color_title);
				content = (TextView) convertView.findViewById(R.id.color_text);
			}
//			int colorPos = position%colors.length;
//			convertView.setBackgroundColor(colors[colorPos]);
			if(title != null && content != null && image != null){
				Log.i("", "执行！！");
				title.setText(mListTitle[position]);
				content.setText(mListText[position]);
				image.setImageResource(R.drawable.ic_launcher);
			}
			return convertView;
		}
	}
}
