package com.example.gametest;

import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

public class Play extends Thread{
	private ImageView image;
	private int[] imagearray = {R.drawable.hole,R.drawable.mole1,R.drawable.mole2,R.drawable.mole3,R.drawable.mole4};
	private static int hitcount = 0;
	
	public Play(ImageView image) {
		super();
		this.image = image;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i=0;
		Boolean c =true;
		super.run();
		while(true){

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Message msg =handler.obtainMessage();
			msg.arg1 = i;
			handler.sendMessage(msg);
			if(i==3) c = false;
			if(i==0) c = true;
			if(c){
				i++;
			}else{
				i--;
			}
		}
	}
	Handler handler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			image.setImageResource(imagearray[msg.arg1]);
		}
		
	};
	

}
