package com.neuedu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.mapper.BuyMapper;
import com.neuedu.mapper.RepairMapper;
import com.neuedu.mapper.ScrapMapper;
import com.neuedu.mapper.TranslateMapper;
import com.neuedu.mapper.BalanceMapper;
import com.neuedu.model.Balance;
import com.neuedu.model.Buy;
import com.neuedu.model.Repair;
import com.neuedu.model.Scrap;
import com.neuedu.model.Translate;
import com.neuedu.service.UsageStatisticService;

@Service //ע��service��ʵ����
@Transactional //�˴����ٽ��д���SqlSession���ύ���� ���Ѿ���Springȥ������
public class UsageStatisticServiceImpl implements UsageStatisticService{
	@Resource //ע��ע��
	private BalanceMapper balanceMapper;
	//�ʲ�ͳ�ƣ�order by �ʲ�������BID
	public List<Balance> getZCByBid(){
		return balanceMapper.orderByBid();
	}
	public List<Balance> getOneBid(Integer bid){
		return balanceMapper.selectByBid(bid);
	}
	
	//�ʲ�ͳ�ƣ�order by ���ű��DEPARTID
	public List<Balance> getZCByDepart(){
		return balanceMapper.orderByDepart();
	}
	public List<Balance> getOneDepart(Integer depart){
		return balanceMapper.selectByDepart(depart);
	}
	
	@Resource //ע��ע��
	private BuyMapper BuyMapper;	
	public List<Buy> getAllBuyDetail(){
		return BuyMapper.selectAll();
	}
	public List<Buy> getOneBuyDetail(Integer buyid){
		return BuyMapper.selectByBuyid(buyid);
	}
	
	//�����¼
	@Resource //ע��ע��
	private TranslateMapper translateMapper;
	public List<Translate> getAllTranslate(){
		return translateMapper.selectAll();
	}
	public List<Translate> getOneTranslate(Integer pepartid){
		return translateMapper.selectOne(pepartid);
	}
	
	@Resource //ע��ע��
	private RepairMapper repairMapper;
	//���޼�¼
	public List<Repair> getRepairDetail(){
		return repairMapper.selectAll();
	}
	public List<Repair> getOneRepair(Integer repairid){
		return repairMapper.selectOne(repairid);
	}
	
	
	//���ϼ�¼
	@Resource //ע��ע��
	private ScrapMapper scrapMapper;
	public List<Scrap> getScrapDetail(){
		return scrapMapper.selectAll();
	}
	public List<Scrap> getOneScrap(Integer sid){
		return scrapMapper.selectOne(sid);
	}
}
