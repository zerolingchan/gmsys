package com.neuedu.service;

import java.util.List;

import com.neuedu.model.Balance;
import com.neuedu.model.Buy;
import com.neuedu.model.Repair;
import com.neuedu.model.Scrap;
import com.neuedu.model.Translate;

public interface UsageStatisticService {
	//�ʲ�ͳ�ƣ�order by �ʲ�������BID
	public List<Balance> getZCByBid();
	public List<Balance> getOneBid(Integer bid);
	
	//�ʲ�ͳ�ƣ�order by ���ű��DEPARTID
	public List<Balance> getZCByDepart();
	public List<Balance> getOneDepart(Integer depart);
	
	//�ɹ���¼
	public List<Buy> getAllBuyDetail();
	public List<Buy> getOneBuyDetail(Integer buyid);
	
	//�����¼
	public List<Translate> getAllTranslate();
	public List<Translate> getOneTranslate(Integer tid);
	
	//���޼�¼
	public List<Repair> getRepairDetail();
	public List<Repair> getOneRepair(Integer repairid);
	
	//���ϼ�¼
	public List<Scrap> getScrapDetail();
	public List<Scrap> getOneScrap(Integer sid);
}
