package com.mc.addpic.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.mc.parking.client.entity.GetParkinfoBean;
import com.mc.parking.client.entity.OrderEntity;
import com.mc.parking.client.entity.TParkInfoEntity;
import com.mc.parking.client.entity.TParkInfo_ImgEntity;
import com.mc.parking.client.entity.TParkInfo_LocEntity;
import com.mc.parking.client.entity.TParkService;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Bimp {
	public static int max = 0;
	
	public static int ShowMode=0;
	
	public static ArrayList<ImageItem> tempSelectBitmap = new ArrayList<ImageItem>();   //选择的图片的临时列表
	public static Long parkid;
	  public static  ArrayList<GetParkinfoBean> templistbean=new ArrayList<GetParkinfoBean>();
	  public static TParkInfoEntity tempTParkInfo=new TParkInfoEntity();
	  public static List<TParkInfo_ImgEntity> tempTParkImageList=new ArrayList<TParkInfo_ImgEntity>();
	  public static List<TParkInfo_LocEntity> tempTParkLocList=new ArrayList<TParkInfo_LocEntity>();
	  public static OrderEntity temporder=new OrderEntity();
	  
	  public static int ADDPARK_VIEW_MODE=0;
	  public static String currentfile=null;
	  
	  //΢��֧������״̬1.��ʾ�ɹ�2.��ʾʧ��0��ʾû����΢��֧��
	  public static int WXback=0;
	  
	public static Bitmap revitionImageSize(String path) throws IOException {
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(
				new File(path)));
		BitmapFactory.Options options = new BitmapFactory.Options();
		options.inJustDecodeBounds = true;
		BitmapFactory.decodeStream(in, null, options);
		in.close();
		int i = 0;
		Bitmap bitmap = null;
		while (true) {
			if ((options.outWidth >> i <= 1000)
					&& (options.outHeight >> i <= 1000)) {
				in = new BufferedInputStream(
						new FileInputStream(new File(path)));
				options.inSampleSize = (int) Math.pow(2.0D, i);
				options.inJustDecodeBounds = false;
				bitmap = BitmapFactory.decodeStream(in, null, options);
				break;
			}
			i += 1;
		}
		return bitmap;
	}
}
