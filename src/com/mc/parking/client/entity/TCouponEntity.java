package com.mc.parking.client.entity;

import java.io.Serializable;
import java.util.Date;





import com.google.gson.annotations.Expose;

public class TCouponEntity implements Serializable{

	
	
	public Long counponId;
	
	

	public String counponCode;
	

	
	public  Double  money;
	

	public int count;
	


	public int scancount;
	
	//1��ʾ���ã�0��ʾ�ر�


	public int isable;
	


	public Date startDate;


	public Date endDate;
	
	

	public Date createDate;
	

	public String createName;
	
	
	
}
