package com.mc.parking.client.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.Date;
import java.util.HashMap;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Base64;

import com.mc.parking.client.PackingApplication;
import com.mc.parking.client.entity.TParkInfoEntity;
import com.mc.parking.client.entity.TuserInfo;

public class SessionUtils {

	public static String city;

	public static int cityCode;

	public static String address;

	public static TuserInfo loginUser;

	public static double lastTimeLantitude;
	public static double lastTimeLongitude;
	private Context context = PackingApplication.getInstance();

	public static boolean isLogined() {
		return SessionUtils.loginUser != null
				&& SessionUtils.loginUser.userPhone > 0;
	}

	public static HashMap<String, String> buildAuthHeaders() {
		if (isLogined()) {
			HashMap<String, String> params = new HashMap<String, String>();
			String creds = String.format("%s:%s", loginUser.userPhone,
					loginUser.passwd);
			String auth = "Basic "
					+ Base64.encodeToString(creds.getBytes(), Base64.DEFAULT);
			params.put("Authorization", auth);
			return params;
		}
		return new HashMap<String, String>();
	}

	// �����¼�û���Ϣ

	public static void saveoUserinfo(Context context) {
		Date date = new Date();
		Long time = date.getTime();
		try {
			// �������
			TuserInfo userInfo = SessionUtils.loginUser;

			SharedPreferences.Editor sharedata = context.getSharedPreferences(
					"user", 0).edit();
			// �Ƚ����л����д��byte�����У���ʵ�ͷ���һ���ڴ�ռ�
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream os = new ObjectOutputStream(bos);
			// ���������л�д��byte����
			os.writeObject(userInfo);
			// �����л�������תΪ16���Ʊ���
			String bytesToHexString = bytesToHexString(bos.toByteArray());
			// �����16��������
			sharedata.putString("userinfo", bytesToHexString);
			sharedata.putLong("time", time);
			sharedata.commit();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * desc:������תΪ16����
	 * 
	 * @param bArray
	 * @return modified:
	 */
	public static String bytesToHexString(byte[] bArray) {
		if (bArray == null) {
			return null;
		}
		if (bArray.length == 0) {
			return "";
		}
		StringBuffer sb = new StringBuffer(bArray.length);
		String sTemp;
		for (int i = 0; i < bArray.length; i++) {
			sTemp = Integer.toHexString(0xFF & bArray[i]);
			if (sTemp.length() < 2)
				sb.append(0);
			sb.append(sTemp.toUpperCase());
		}
		return sb.toString();
	}

	/**
	 * desc:��ȡ�����Object����
	 * 
	 * @param context
	 * @param key
	 * @return modified:
	 */
	public static Object readUserinfo(Context context, String key) {
		ByteArrayInputStream bis = null;
		ObjectInputStream is = null;
		try {
			SharedPreferences sharedata = context.getSharedPreferences("user",
					0);
			if (sharedata.contains(key)) {
				String string = sharedata.getString(key, "");
				if (TextUtils.isEmpty(string)) {
					return null;
				} else {
					// ��16���Ƶ�����תΪ���飬׼�������л�
					byte[] stringToBytes = StringToBytes(string);
					bis = new ByteArrayInputStream(stringToBytes);
					is = new ObjectInputStream(bis);
					// ���ط����л��õ��Ķ���
					Object readObject = is.readObject();
					return readObject;
				}
			}
		} catch (Exception e) {
			Log.e("readUserinfo",e.getMessage(), e);
		}  finally {

			try {
				if (bis != null) {
					bis.close();
				}
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				Log.e("readUserinfo",e.getMessage(), e);
			}

		}
		// �����쳣����null
		return null;

	}

	/**
	 * desc:��16���Ƶ�����תΪ����
	 * 
	 * @param data
	 * @return modified:
	 */
	public static byte[] StringToBytes(String data) {
		String hexString = data.toUpperCase().trim();
		if (hexString.length() % 2 != 0) {
			return null;
		}
		byte[] retData = new byte[hexString.length() / 2];
		for (int i = 0; i < hexString.length(); i++) {
			int int_ch; // ��λ16������ת�����10������
			char hex_char1 = hexString.charAt(i); // //��λ16�������еĵ�һλ(��λ*16)
			int int_ch1;
			if (hex_char1 >= '0' && hex_char1 <= '9')
				int_ch1 = (hex_char1 - 48) * 16; // // 0 ��Ascll - 48
			else if (hex_char1 >= 'A' && hex_char1 <= 'F')
				int_ch1 = (hex_char1 - 55) * 16; // // A ��Ascll - 65
			else
				return null;
			i++;
			char hex_char2 = hexString.charAt(i); // /��λ16�������еĵڶ�λ(��λ)
			int int_ch2;
			if (hex_char2 >= '0' && hex_char2 <= '9')
				int_ch2 = (hex_char2 - 48); // // 0 ��Ascll - 48
			else if (hex_char2 >= 'A' && hex_char2 <= 'F')
				int_ch2 = hex_char2 - 55; // // A ��Ascll - 65
			else
				return null;
			int_ch = int_ch1 + int_ch2;
			retData[i / 2] = (byte) int_ch;// ��ת�����������Byte��
		}
		return retData;
	}

	public static void cleanuserinfo(Context context) {

		SharedPreferences sharedata = context.getSharedPreferences("user", 0);
		Editor editor = sharedata.edit();
		editor.clear();
		editor.commit();
	}

	public static void savechoiceparkInfoAdm(Context context) {

		try {
			if (SessionUtils.loginUser != null
					&& SessionUtils.loginUser.parkInfoAdm != null) {
				// �������
				TParkInfoEntity parkInfoEntity = SessionUtils.loginUser.parkInfoAdm;

				SharedPreferences.Editor parkinfo = context
						.getSharedPreferences("park", 0).edit();
				// �Ƚ����л����д��byte�����У���ʵ�ͷ���һ���ڴ�ռ�
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				ObjectOutputStream os = new ObjectOutputStream(bos);
				// ���������л�д��byte����
				os.writeObject(parkInfoEntity);
				// �����л�������תΪ16���Ʊ���
				String bytesToHexString = bytesToHexString(bos.toByteArray());
				// �����16��������
				parkinfo.putString("parkinfo", bytesToHexString);
				parkinfo.commit();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static Object readchoiceparkInfoAdm(Context context, String key) {
		try {
			SharedPreferences parkinfo = context
					.getSharedPreferences("park", 0);
			if (parkinfo.contains(key)) {
				String string = parkinfo.getString(key, "");
				if (TextUtils.isEmpty(string)) {
					return null;
				} else {
					// ��16���Ƶ�����תΪ���飬׼�������л�
					byte[] stringToBytes = StringToBytes(string);
					ByteArrayInputStream bis = new ByteArrayInputStream(
							stringToBytes);
					ObjectInputStream is = new ObjectInputStream(bis);
					// ���ط����л��õ��Ķ���
					Object readObject = is.readObject();
					return readObject;
				}
			}
		} catch (StreamCorruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// �����쳣����null
		return null;

	}

	public static void cleanParkinfo(Context context) {

		SharedPreferences sharedata = context.getSharedPreferences("park", 0);
		Editor editor = sharedata.edit();
		editor.clear();
		editor.commit();
	}

}
