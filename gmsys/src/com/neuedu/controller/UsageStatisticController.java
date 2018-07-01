package com.neuedu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.neuedu.model.Balance;
import com.neuedu.model.Buy;
import com.neuedu.model.Repair;
import com.neuedu.model.Scrap;
import com.neuedu.model.Translate;
import com.neuedu.service.UsageStatisticService;

//����mvc�Ŀ�������
@Controller
public class UsageStatisticController {
	// ��mvc�Ŀ��Ʋ�����service�����
	@Autowired
	private UsageStatisticService usageStatisticService;
	
	//�������ͨ��URL��������������в�ѯ���вɹ���¼:/cgjl/findAll.do
	@RequestMapping("/cgjl/findAll")
	public String showBuyDetail(HttpServletRequest request){
		List<Buy> buyList=usageStatisticService.getAllBuyDetail();			
		request.setAttribute("listCgjl", buyList);
		return "purchaseHistory";
	}
	@RequestMapping("/cgjl/findById")
	public String findOneBuy(@RequestParam("buyid") Integer bid,HttpServletRequest request){
		List<Buy> b=usageStatisticService.getOneBuyDetail(bid);
		request.setAttribute("listCgjl", b);
		return "purchaseHistory";
	}
	
	//�������ͨ��URL��������������в�ѯ�ʲ�����:/balance/findAll.do
	@RequestMapping("/balance/findAll")
	public String showAllBalance(HttpServletRequest request){
		List<Balance> bidList=usageStatisticService.getZCByBid();			
		request.setAttribute("bidList", bidList);
		List<Balance> departList=usageStatisticService.getZCByDepart();			
		request.setAttribute("departList", departList);		
		return "totalAssets";
	}
	//��ѯ�ʲ����� by Bid
	@RequestMapping("balance/findById")
	public String showBalanceByBid(@RequestParam("bid") Integer bid,HttpServletRequest request){
		List<Balance> b=usageStatisticService.getOneBid(bid);			
		request.setAttribute("bidList", b);
		return "totalAssets";
	}
	//��ѯ�ʲ����� by Departid
	@RequestMapping("balance/findById2")
	public String showBalanceByDepart(@RequestParam("departid") Integer departid,HttpServletRequest request){
		List<Balance> b=usageStatisticService.getOneDepart(departid);			
		request.setAttribute("departList", b);
		return "totalAssets";
	}
	
	//�������ͨ��URL��������������в�ѯ�粿�ŵ����¼:/tpjl/findAll.do
	@RequestMapping("/tpjl/findAll")
	public String showTranslate(HttpServletRequest request){
		List<Translate> translateList=usageStatisticService.getAllTranslate();			
		request.setAttribute("translateList", translateList);
		return "deployHistory";
	}
	@RequestMapping("/tpjl/fingById")
	public String getOneById(@RequestParam("pepartid") Integer pepartid,HttpServletRequest request){
		List<Translate> translateList=usageStatisticService.getOneTranslate(pepartid);			
		request.setAttribute("translateList", translateList);
		return "deployHistory";
	}
	
	
	//�������ͨ��URL��������������в�ѯ���޼�¼:/bxjl/findAll.do
	@RequestMapping("/bxjl/findAll")
	public String showRepair(HttpServletRequest request){
		List<Repair> repairList=usageStatisticService.getRepairDetail();			
		request.setAttribute("repairList", repairList);
		return "baoxiuHistory";
	}
	@RequestMapping("/bxjl/findById")
	public String showOneRepair(@RequestParam("repairid") Integer repairid,HttpServletRequest request){
		List<Repair> repairList=usageStatisticService.getOneRepair(repairid);			
		request.setAttribute("repairList", repairList);
		return "baoxiuHistory";
	}
	
	//�������ͨ��URL��������������в�ѯ���ϼ�¼:/bfjl/findAll.do
	@RequestMapping("/bfjl/findAll")
	public String showScrap(HttpServletRequest request){
		List<Scrap> scrapList=usageStatisticService.getScrapDetail();			
		request.setAttribute("scrapList", scrapList);
		return "baofeiHistory";
	}
	@RequestMapping("/bfjl/findById")
	public String showOneScrap(@RequestParam("sid") Integer sid,HttpServletRequest request){
		List<Scrap> scrapList=usageStatisticService.getOneScrap(sid);			
		request.setAttribute("scrapList", scrapList);
		return "baofeiHistory";
	}
}
