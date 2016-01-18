package com.mc.parking.client.entity;

import java.io.Serializable;
import java.util.Date;

public class TParkService implements Serializable,Cloneable {

	
	public long id;


	public long serviceId;


	public long ownerId;

	//��������.1���������Ŷ�,2��ͣ�����Խ�
	public int serviceType;

	//������
	public String serviceName;

	//��������
	public String serviceDetail;

	//����״̬��0:ֹͣ�У�1:������
	public int serviceStatus;

	//�����ṩ���ٴη���-1������

	public int serviceLimit;

	//���η������
	public double serviceFee;

	//����Сʱ��һ�ηѣ�0:����Сʱ�շѣ�1��N:����Сʱ��Ŀ
	public int feePreHour;

	//ǿ����ѡ��0:Ĭ�ϲ�ѡ�У�1:ǿ��ѡ��
	public int forceSelection;

	//����ֶ��һ��serviceDetail��serviceFee��������app�˾�������ֶ���ʾ����
	public String serviceDetailForApp;

	//�����͸���ʱ��
	public Date updateDate;

	//������
	public String updatePerson;
	
	public TSupply supplyInfo;
	public TParkService clone() {  
		TParkService o = null;  
        try {  
            o = (TParkService) super.clone();  
        } catch (CloneNotSupportedException e) {  
            e.printStackTrace();  
        }  
        return o;  
    }

}
