package com.example.demo.activity;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.RelativeLayout;

import com.example.demo.R;
import com.example.demo.adapter.HomeAdapter;
import com.example.demo.bean.CarModelsBean;
import com.example.demo.widget.PinnedHeaderListView;

/**
 * 
 * @author lsx
 */
public class HomeActivity extends FragmentActivity {
	
	/** 主ListView */
	private PinnedHeaderListView home_list = null;
	/** 头部 */
	private RelativeLayout head_layout = null;
	/** 列表数据源 */
	private List<String[]> mCarModels = null;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_home);
		initView();
		// 添加测试数据
		addTestData();
		
		head_layout.setFocusable(true);
		head_layout.setClickable(true);
		head_layout.setBackgroundColor(Color.parseColor("#ECECEC"));
		head_layout.setOnTouchListener(new ListViewAndHeadViewTouchLinstener());
		
		home_list.setOnTouchListener(new ListViewAndHeadViewTouchLinstener());
		home_list.setAdapter(new HomeAdapter(head_layout,mCarModels));
	}

	
	private void initView() {
		home_list = (PinnedHeaderListView) findViewById(R.id.pinnedListView_home);
		head_layout = (RelativeLayout) findViewById(R.id.layout_head);
	}

	
	class ListViewAndHeadViewTouchLinstener implements View.OnTouchListener {

		@Override
		public boolean onTouch(View arg0, MotionEvent arg1) {
			HorizontalScrollView headSrcrollView = (HorizontalScrollView) head_layout
					.findViewById(R.id.scrollView_home);
			headSrcrollView.onTouchEvent(arg1);
			return false;
		}
	}

	

	private void addTestData(){
		List<CarModelsBean> mCarModel = new ArrayList<CarModelsBean>();
		
		CarModelsBean bean0 = new CarModelsBean();
		bean0.setID(0);
		bean0.setLowPrice("全国最低价(万)");
		bean0.setGuideprice("厂商指导价(万)");
		bean0.setEngine("发动机");
		bean0.setSiftSpeed("变速箱");
		bean0.setVolume("长*宽*高(mm)");
		bean0.setUpSpeed("最高车速(km/h)");
		bean0.setAcceSpeed("官方0-100km/h加速(s)");
		bean0.setQuality("整车质保");
		bean0.setLength("长度");
		bean0.setHeight("宽度");
		bean0.setWidth("高度");
		
		CarModelsBean bean1 = new CarModelsBean();
		bean1.setID(1);
		bean1.setLowPrice("100万");
		bean1.setGuideprice("98万");
		bean1.setEngine("588马力");
		bean1.setSiftSpeed("4档手动一体");
		bean1.setVolume("100*100*200");
		bean1.setUpSpeed("120");
		bean1.setAcceSpeed("5.5");
		bean1.setQuality("一年不限公里");
		bean1.setLength("100");
		bean1.setHeight("100");
		bean1.setWidth("200");
		
		CarModelsBean bean2 = new CarModelsBean();
		bean2.setID(1);
		bean2.setLowPrice("100万");
		bean2.setGuideprice("98万");
		bean2.setEngine("588马力");
		bean2.setSiftSpeed("4档手动一体");
		bean2.setVolume("100*100*200");
		bean2.setUpSpeed("120");
		bean2.setAcceSpeed("5.5");
		bean2.setQuality("一年不限公里");
		bean2.setLength("100");
		bean2.setHeight("100");
		bean2.setWidth("200");
		
		mCarModel.add(bean0);
		mCarModel.add(bean1);
		mCarModel.add(bean2);
		
		mCarModels = new ArrayList<String[]>(11);
//		Map<String, String[]> map = new HashMap<String, String[]>();
		String[] str1 = new String[mCarModel.size()];
		String[] str2 = new String[mCarModel.size()];
		String[] str3 = new String[mCarModel.size()];
		String[] str4 = new String[mCarModel.size()];
		String[] str5 = new String[mCarModel.size()];
		String[] str6 = new String[mCarModel.size()];
		String[] str7 = new String[mCarModel.size()];
		String[] str8 = new String[mCarModel.size()];
		String[] str9 = new String[mCarModel.size()];
		String[] str10 = new String[mCarModel.size()];
		String[] str11 = new String[mCarModel.size()];
		
		for(int i = 0; i < mCarModel.size(); i++){
			str1[i] = mCarModel.get(i).getLowPrice();
			str2[i] = mCarModel.get(i).getGuideprice();
			str3[i] = mCarModel.get(i).getEngine();
			str4[i] = mCarModel.get(i).getSiftSpeed();
			str5[i] = mCarModel.get(i).getVolume();
			str6[i] = mCarModel.get(i).getUpSpeed();
			str7[i] = mCarModel.get(i).getAcceSpeed();
			str8[i] = mCarModel.get(i).getQuality();
			str9[i] = mCarModel.get(i).getLength();
			str10[i] = mCarModel.get(i).getHeight();
			str11[i] = mCarModel.get(i).getWidth();
		}
		
		mCarModels.add(str1);
		mCarModels.add(str2);
		mCarModels.add(str3);
		mCarModels.add(str4);
		mCarModels.add(str5);
		mCarModels.add(str6);
		mCarModels.add(str7);
		mCarModels.add(str8);
		mCarModels.add(str9);
		mCarModels.add(str10);
		mCarModels.add(str11);
	}
}
