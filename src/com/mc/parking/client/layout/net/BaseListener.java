package com.mc.parking.client.layout.net;

import android.util.Log;

import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;

/**
 * 
 * @author woderchen
 *
 * @param <T>
 */
public abstract class BaseListener<T> implements Response.ErrorListener,
		Response.Listener<T> {

	public abstract void onSuccess(T arg0);

	public abstract void onFailed(String message);

	@Override
	public void onResponse(T arg0) {
		onSuccess(arg0);
	}

	@Override
	public void onErrorResponse(VolleyError arg0) {
		Log.e("BaseListener",
				"-----network error time:" + arg0.getNetworkTimeMs() + "------");

		Log.e("BaseListener", arg0.getMessage(), arg0);
		String errorMessage = arg0.getMessage();
		if (errorMessage == null) {
			NetworkResponse response = arg0.networkResponse;
			if (response != null) {
				int error = response.statusCode;
				String message = "unknow error type for remote server.";
				switch (error) {
				case 400:
					message = "Bad Request";
					break;
				case 401:
					message = "��֤ʧ��,��������֤";
					break;
				case 402:
					message = "Payment Required";
					break;
				case 403:
					message = "Forbidden";
					break;
				case 404:
					message = "����ӿ��쳣";
					break;
				case 405:
					message = "Method Not Allowed";
					break;
				case 406:
					message = "Not Acceptable";
					break;
				case 407:
					message = "Proxy Authentication Required";
					break;
				case 408:
					message = "Request Timeout";
					break;
				case 409:
					message = "Conflict";
					break;
				case 410:
					message = "Gone";
					break;
				case 411:
					message = "Length Required";
					break;
				case 412:
					message = "Precondition Failed";
					break;
				case 413:
					message = "Request Entity Too Large";
					break;
				case 414:
					message = "Request-URI Too Long";
					break;
				case 415:
					message = "Unsupported Media Type";
					break;
				case 416:
					message = "Requested Range Not Satisfiable";
					break;
				case 417:
					message = "Expectation Failed";
					break;
				}

				onFailed("[" + error + "]" + message);

			} else {
				
				if(arg0 instanceof TimeoutError){
					onFailed("���ӷ�������ʱ");
				}else{
				   onFailed("Զ�̷�����δ֪����");
				}
			}

		} else {
			String errorstring;
			String[] errores = errorMessage.split("Exception:");
			if (errores.length > 1){
				String errorInfo = errores[1];
				
				if(errorInfo.trim().startsWith("No authentication")){
					onFailed("�û������������");
				}else{
					 errorstring=transfer(errorInfo);
				   onFailed(errorstring);
				}
			}
			else{
			
				if(errorMessage.trim().startsWith("No authentication")){
					onFailed("�û������������");
				}else{
					 errorstring=transfer(errorMessage);
				   onFailed(errorstring);
				}
				
			}
		}
	}
	//ȥ������IP��ַ����ʾ��Ϣ
	private String transfer(String original){
		int index = original.toLowerCase().indexOf("network is unreachable");
		int indexOther = original.toLowerCase().indexOf("connection refused");
		String errorstring="";
		if(index>=0 || indexOther>=0)
			errorstring="Զ�̷���������Ӧ,���Ժ�����";
		else{
			
			errorstring=original;
			}
		return errorstring;
	}

}
