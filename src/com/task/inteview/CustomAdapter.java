package com.task.inteview;
import java.util.ArrayList;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;


public class CustomAdapter extends BaseAdapter  {
	
	private ArrayList<Data> mAlitems;
	private MainActivity main;
private LayoutInflater inflater;
	public CustomAdapter(ArrayList<Data> mALlist,
			LayoutInflater layoutInflater,MainActivity main) {
		this.mAlitems=mALlist;
		this.inflater=layoutInflater;
	this.main=main;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mAlitems.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mAlitems.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
	final	 ViewHolder holder;
		Data data = (Data) this.getItem(position);  
		if(convertView==null){
			convertView=inflater.inflate(R.layout.listitem, null);
			holder=new ViewHolder();
			holder.text=(TextView) convertView.findViewById(R.id.xTvtext);
			holder.checkbox=(CheckBox) convertView.findViewById(R.id.xCbbox);
		
            holder.checkbox.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					CheckBox checkbox = (CheckBox) v;
			        Data data = (Data) checkbox.getTag();
			        data.setCheck(checkbox.isChecked());
					main.update();
					
				}
			});
			convertView.setTag(holder);
			
			
			
		}else{
			holder=(ViewHolder)convertView.getTag();
		}
		//set tag 
		holder.checkbox.setTag(data);
		holder.text.setText(data.getTask());
		
		holder.checkbox.setChecked(data.isCheck());
		
		
		if(data.isCheck())
			convertView.setBackgroundColor(Color.BLUE);
		else
			convertView.setBackgroundColor(Color.GREEN);
     
		return convertView;
	}
	
	public class ViewHolder{
		TextView text;
		CheckBox checkbox;
	}

	
	
	
	
}
