package com.mc.parking.client.entity;

import java.io.Serializable;
import java.util.Date;





import com.google.gson.annotations.Expose;

public class TServiceOrder implements Serializable{
	private static final long serialVersionUID = 1L;

	@Expose
	public long orderId;

	//�����Ӧ�ľ���service�����serviceName
	@Expose
	public String orderName;
	
	//����ķ����ַ
	@Expose
	public String contactAddress;
	
	//�������ϵ�绰
	@Expose
	public String contactNumber;
	
	//����ĳ��ƺ���
	@Expose
	public String carLisence;

	
	//������Ƿ����׼����Ӧservice�����serviceDetailForApp
	@Expose
	public String serviceDetailForApp;
	
	//packservie id
	@Expose
	public long serviceId;
	
	//��Ӧ��id
	@Expose
	public long venderId;
	
	//��Ӧ������
	@Expose
	public String venderName;
	
	//����״̬��1:��ʼ��2:��ɣ�3:��ʱ��4��ȡ�� 6������
	@Expose
	public int orderStatus;
	
	//��������
	@Expose
	public String orderCity;
	
	//����������
	@Expose
	public long createUserPhone;
	
	//�����ύ��ʱ��
	@Expose
	public Date orderStartDate;
	
	//������ɵ�ʱ��
	@Expose
	public Date orderEndDate;
	
	//�����ܶ�
	@Expose
	public double payTotal;
	
	//ʵ�ʸ���
	@Expose
	public double payActu;
	
	//���ʽ // 1��֧���� 2��΢��֧��
	@Expose
	public int payMethod;
	
	//֧��״̬ 0:��ʼ״̬ 1��֧���ɹ� 2���ȴ����ȷ�� 3:֧��ʧ��
	@Expose
	public int ackStatus; 
	
	//��������
	@Expose
	public Date payDate;

	//֧����Ӧ����
	@Expose
	public Date ackDate;
	
	@Expose
	public String orderDetail;
	//����Ԥ�ƽ���ʱ��
		@Expose
		public int estimate;
		
		//��Ӧ�̹ٷ��绰
		@Expose
		public String supplyPhone;
		
		//���ŷ�����ϵ�绰
		@Expose
		public String venderServicePhone;
		
		//���ŷ�����ϵ��
		@Expose
		public String venderServicePerson;
		//��Ӧ��˵��
		public String orderSupplyComments;
}
