package com.mc.parking.client.entity;

import java.io.Serializable;
import java.util.Date;

public class TOrder_Py implements Serializable{



	
	public Long parkPyId;
	



	public OrderEntity order;
		

	public double payTotal;
	

	public double payActu;
	

	public double couponUsed;
	

	public int payMethod; // 1��֧���� 9���ֽ�
	

	public int ackStatus;  //0:��ʼ״̬ 1��֧���ɹ� 2���ȴ����ȷ�� 3:֧��ʧ��
	
	

	public Date payDate;

	
	public Date ackDate;

	public String createPerson;
	
	//��������磺ͣ���ѣ�ϴ���ѣ���ѩ��
	public String paymentName;

	//��������:��Ӧ ͣ������:1�� ��ֵ����2
	public int paymentType;

	//���״̬,1:������2��pending��Ҳ���ǻ���Ҫ����������ͣ������ֵ����
	public int paymentStatus;

	
}
