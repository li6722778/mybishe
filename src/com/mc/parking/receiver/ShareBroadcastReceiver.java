package com.mc.parking.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Message;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version ����ʱ�䣺2015��8��19�� ����9:08:08
 */
public class ShareBroadcastReceiver extends BroadcastReceiver {

	  private static MessageListener mMessageListener;
	    public ShareBroadcastReceiver() {
	        super();
	    }

	    @Override
	    public void onReceive(Context context, Intent intent) {
	    	
	        String content = intent.getExtras().getString("success");
	        if(content=="ok"||content.equals("ok"))
	        {mMessageListener.OnReceived(content);}
	        abortBroadcast(); 
	    }

	    // �ص��ӿ�
	        public interface MessageListener {
	            public void OnReceived(String message);
	        }

	        public void setOnReceivedMessageListener(MessageListener messageListener) {
	            this.mMessageListener=messageListener;
	        }
}
