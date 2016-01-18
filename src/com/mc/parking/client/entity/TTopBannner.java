package com.mc.parking.client.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class TTopBannner implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	public Long id;
	
	//ͼƬHTTP������,��http://127.0.0.1:9000/cblimg
	public String imgUrlHeader;

	//ͼƬ�ĺ���·��,��/banner/23.jpg; ��ȷ����ʾͼƬ�ķ�ʽ�� imgUrlHeader+imgUrlPath
	public String imgUrlPath;
	
	//������Ϣ�����������Ϣ����ʾ��banner�ϵĹ���������
	public String detail;
	
	// ����״̬��1:native UI��������ԭ��ui,��ȡ�û���Ϣ��2:web UI,�������ת��web view��3:����,�����û�з�Ӧ
	public int bannerType;
	
	//���bannerType����2���������Ч���������ת���Ǹ�url
	public String clickurl;
	
	// ����״̬��1:�Զ����֣�2:�ֶ��������
	public int autoappear;
	
	// ����״̬��0:δ���ţ�1:����
	public int bannnerStatus;
	
	//����Ӧ�ķ���id
	public long serviceId;
	
	//����Ӧ�ķ���entity
	public List<TParkService> parkServiceBean;
	

	public Date updateDate;
	
	//���˵��
	public String formComments;
	public String updateName;
	//���ظ��û�ǰһ�γ�λ������λ�ã������û���ַ��Ĭ��ֵ�������ַΪnull��մ������ÿͻ���sessionutils����ĵ�ַ
		public String cacheAddress;
}
