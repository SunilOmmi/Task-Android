package com.task.inteview;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements OnClickListener,Checklistener{

	private EditText mEtedit;
//
	private Button mBtnAdd;
	private ArrayList<Data> mALlist;
	private ListView mLVview;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		//initialise array list
		mALlist=new ArrayList<Data>();
		mEtedit=(EditText) findViewById(R.id.xEtedit);
		mBtnAdd=(Button) findViewById(R.id.xBtnAdd);
		mBtnAdd.setOnClickListener(this);
		
		
		mLVview=(ListView) findViewById(R.id.xListview);
		mLVview.setCacheColorHint(0);

		mLVview.setItemsCanFocus(false);	
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    // Inflate the menu items for use in the action bar
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.itemss, menu);
	    return super.onCreateOptionsMenu(menu);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v==mBtnAdd){
			if(TextUtils.isEmpty(mEtedit.getText().toString())){
				Toast.makeText(getApplicationContext(), "Empty data cannot be added", Toast.LENGTH_SHORT).show();
			return;
			}else{
				/*
				 * Adds data to array list
				 */
			Data	data=new Data();
				data.setCheck(false);
				data.setTask(mEtedit.getText().toString());
			mALlist.add(data);
			//clears the edit text
			mEtedit.setText("");
			}
			
			/*
			 * If adapter is null set adapter else call notify data set changed on listview adapter
			 */
			if(mLVview.getAdapter()==null){
				mLVview.setAdapter(new CustomAdapter(mALlist,getLayoutInflater(),MainActivity.this));
			}else{
				update();
			}
			
			
			
		}
		
	}
/*
 * updates listview with new data
 * @see com.task.inteview.Checklistener#update()
 */
	public void update() {
		

		CustomAdapter adapter = (CustomAdapter) mLVview.getAdapter(); 
		adapter.notifyDataSetChanged();
	
	}



	



}
