package com.mc.parking.client.entity;

import java.io.Serializable;
import java.util.Date;





import com.google.gson.annotations.Expose;

public class TSupply implements Serializable{

	@Expose
	public long id;
	
	@Expose
	public String supplyName;
	
	//��Ӧ������
	@Expose
	public String supplyDesc;
	
	//��Ӧ�̵绰
	@Expose
	public String supplyPhone;
	
	//��Ӧ������
	@Expose
	public String venderBankOwner;
	
	//��Ӧ��������
	@Expose
	public String venderBankName;

	//��Ӧ�����к���
	@Expose
	public String venderBankNumber;
	
	// �����͸���ʱ��
	@Expose
	public Date updateDate;

	// ������
	@Expose
	public String updatePerson;
	
	@Expose
	public String orderSupplyComments;
}
