package com.example.demo.adapter;


import java.util.List;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.demo.R;
import com.example.demo.widget.MyHScrollView;
import com.example.demo.widget.MyHScrollView.OnScrollChangedListener;

/**
 * 
 * @Description 首页列表适配器
 * @author Abily
 */
public class HomeAdapter extends SectionedBaseAdapter {

	private RelativeLayout head_layout = null;
	private List<String[]> mCarModels = null;
			
	public HomeAdapter(RelativeLayout head_layout,List<String[]> mCarModels) {
		this.head_layout = head_layout;
		this.mCarModels = mCarModels;
	}
	
	@Override
	public Object getItem(int section, int position) {
		return null;
	}

	@Override
	public long getItemId(int section, int position) {
		return 0;
	}

	@Override
	public int getSectionCount() {
		return 4;
	}

	@Override
	public int getCountForSection(int section) {
		if (section == 0) {
			return 8;
		}
		return 3;
	}

	@Override
	public View getItemView(int section, int position, View convertView,
			ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			LayoutInflater inflator = (LayoutInflater) parent.getContext()
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflator.inflate(R.layout.item_home, null);

			holder = new ViewHolder();
			MyHScrollView scrollView1 = (MyHScrollView) convertView
					.findViewById(R.id.scrollView_home);

			holder.item_scrollView = scrollView1;
			holder.item_txt_sign1 = (TextView) convertView.findViewById(R.id.txt_sign1);
			holder.item_txt_sign2 = (TextView) convertView.findViewById(R.id.txt_sign2);
			holder.item_txt_sign3 = (TextView) convertView.findViewById(R.id.txt_sign3);
			holder.item_txt_sign4 = (TextView) convertView.findViewById(R.id.txt_sign4);

			MyHScrollView headSrcrollView = (MyHScrollView) head_layout
					.findViewById(R.id.scrollView_home);
			headSrcrollView
					.AddOnScrollChangedListener(new OnScrollChangedListenerImp(
							scrollView1));

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		TextView[] temp_textview = { holder.item_txt_sign1, holder.item_txt_sign2, holder.item_txt_sign3 };

		for (int i = 0; i < temp_textview.length; i++) {
			temp_textview[i].setText("");
			if (section == 0) {
				temp_textview[i].setText(mCarModels.get(position)[i]);
			} else if (section == 1) {
				temp_textview[i].setText(mCarModels.get(8 + position)[i]);
			}
		}
		holder.item_txt_sign4.setText("");
		return convertView;
	}

	class OnScrollChangedListenerImp implements OnScrollChangedListener {
		MyHScrollView mScrollViewArg;

		public OnScrollChangedListenerImp(MyHScrollView scrollViewar) {
			mScrollViewArg = scrollViewar;
		}

		@Override
		public void onScrollChanged(int l, int t, int oldl, int oldt) {
			mScrollViewArg.smoothScrollTo(l, t);
		}
	};

	class ViewHolder {
		TextView item_txt_sign1;
		TextView item_txt_sign2;
		TextView item_txt_sign3;
		TextView item_txt_sign4;
		TextView item_txt_sign5;
		HorizontalScrollView item_scrollView;
	}

	@Override
	public View getSectionHeaderView(int section, View convertView,
			ViewGroup parent) {
		LinearLayout layout = null;
		if (convertView == null) {
			LayoutInflater inflator = (LayoutInflater) parent.getContext()
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			layout = (LinearLayout) inflator.inflate(R.layout.item_home_header,
					null);
		} else {
			layout = (LinearLayout) convertView;
		}
		String txt = "";
		if (section == 0) {
			txt = "基本信息";
		} else if (section == 1) {
			txt = "车身";
		} else {
			txt = "测试section效果";
		}
		((TextView) layout.findViewById(R.id.textHeaderItem)).setText(txt);
		return layout;
	}
}
