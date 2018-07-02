package com.neuedu.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.neuedu.model.Buy;
import com.neuedu.model.Department;
import com.neuedu.model.Product;
import com.neuedu.model.Repair;
import com.neuedu.model.Scrap;
import com.neuedu.model.Translate;
import com.neuedu.service.AssetManageService;

//����mvc�Ŀ�������
@Controller
public class AssetManageController {

	// ��mvc�Ŀ��Ʋ�����service�����
	@Autowired
	private AssetManageService assetManageService;

	/**
	 * ��ѯ�ɹ���¼
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/buy/findAll")
	public String findAllBuy(HttpServletRequest request) {

		List<Buy> listBuy = assetManageService.selectAll();
		request.setAttribute("listBuy", listBuy);

		return "purchaseInfo";
	}

	/**
	 * ����id��ѯ�ɹ���¼
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/buy/findById3")
	public String findById3(@RequestParam("id") Integer id, HttpServletRequest request) {
		if (id != null) {
			Buy Buy1 = assetManageService.findById(id);
			request.setAttribute("Buy1", Buy1);
		} else {
			List<Buy> listBuy = assetManageService.selectAll();
			request.setAttribute("listBuy", listBuy);
		}
		return "purchaseInfo";
	}

	/**
	 * ɾ���ɹ���¼
	 * 
	 * @param buyidString
	 * @param request
	 * @return
	 */
	@RequestMapping("/buy/delete")
	public String delete(@RequestParam("number") String buyidString, HttpServletRequest request) {
		String[] sourcestrStrings = buyidString.split("-");
		int[] sourceint = new int[sourcestrStrings.length];
		for (int i = 0; i < sourcestrStrings.length; i++) {
			sourceint[i] = Integer.parseInt(sourcestrStrings[i]);
			assetManageService.deleteById(sourceint[i]);
		}
		List<Buy> listBuy = assetManageService.selectAll();
		request.setAttribute("listBuy", listBuy);
		return "purchaseInfo";
	}

	/**
	 * ��ʼ����Ӳɹ���¼ҳ
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/buy/findAll2")
	public String findAll2(HttpServletRequest request) {
		List<Product> Buy2 = assetManageService.selectAllProductList();
		List<Department> Buy3 = assetManageService.selectAllDepartmentList();

		request.setAttribute("Buy2", Buy2);
		request.setAttribute("Buy3", Buy3);
		return "addPurchase";
	}

	/**
	 * ��Ӳɹ���¼
	 * 
	 * @param BUYCOUNT
	 * @param BUYTIME
	 * @param PROVID
	 * @param DEPARTID
	 * @param request
	 * @return
	 */
	@RequestMapping("/buy/add")
	public String addCaigouxinxi(Double BUYCOUNT, String BUYTIME, Integer PROVID, Integer DEPARTID,
			HttpServletRequest request) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Buy buy = new Buy();
			buy.setBuycount(BUYCOUNT);
			buy.setBuytime(format.parse(BUYTIME));
			buy.setProvid(PROVID);
			buy.setDepartid(DEPARTID);
			assetManageService.addBuy(buy);
			List<Buy> listBuy = assetManageService.selectAll();
			request.setAttribute("listBuy", listBuy);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "purchaseInfo";
	}

	/**
	 * ��ʼ�����²ɹ���¼ҳ
	 * 
	 * @param buyid
	 * @param request
	 * @return
	 */
	@RequestMapping("/buy/findById")
	public String findById(@RequestParam("id") Integer buyid, HttpServletRequest request) {
		Buy Buy1 = assetManageService.findById(buyid);

		List<Product> Buy2 = assetManageService.selectAllProductList();
		List<Department> Buy3 = assetManageService.selectAllDepartmentList();

		request.setAttribute("Buy1", Buy1);
		request.setAttribute("Buy2", Buy2);
		request.setAttribute("Buy3", Buy3);

		return "updatePurchase";
	}

	/**
	 * ���²ɹ���¼
	 * 
	 * @param BUYID
	 * @param BUYCOUNT
	 * @param BUYTIME
	 * @param PROVID
	 * @param DEPARTID
	 * @param request
	 * @return
	 */
	@RequestMapping("/buy/update")
	public String update(Integer BUYID, Double BUYCOUNT, String BUYTIME, Integer PROVID, Integer DEPARTID,
			HttpServletRequest request) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Buy buy = new Buy();
			buy.setBuyid(BUYID);
			buy.setBuycount(BUYCOUNT);
			buy.setBuytime(format.parse(BUYTIME));
			buy.setProvid(PROVID);
			buy.setDepartid(DEPARTID);
			assetManageService.updateBuy(buy);

			List<Buy> listBuy = assetManageService.selectAll();
			request.setAttribute("listBuy", listBuy);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "purchaseInfo";
	}

	/**
	 * ����id��ȡ�ɹ���¼����ת������ҳ
	 * 
	 * @param buyid
	 * @param request
	 * @return
	 */
	@RequestMapping("/buy/findById2")
	public String findById2(@RequestParam("id") Integer buyid, HttpServletRequest request) {
		Buy Buy1 = assetManageService.findById(buyid);
		request.setAttribute("Buy1", Buy1);
		return "purchaseDetail";
	}

	/**
	 * ��ʼ���̵����ҳ
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/buyProuduct/findAll")
	public String findAllBuyProduct(HttpServletRequest request) {
		List<Buy> listBuy1 = assetManageService.selectAll();
		List<Translate> listBuy2 = assetManageService.selectAllTranslateList();
		List<Repair> listBuy3 = assetManageService.selectAllRepairList();
		List<Scrap> listBuy4 = assetManageService.selectAllScrapList();

		request.setAttribute("listBuy1", listBuy1);
		request.setAttribute("listBuy2", listBuy2);
		request.setAttribute("listBuy3", listBuy3);
		request.setAttribute("listBuy4", listBuy4);

		return "checkInfo";
	}

	/**
	 * ��ȡ�����б�
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/buyProuduct/findAll2")
	public String findAll2BuyProduct(HttpServletRequest request) {
		List<Translate> listBuy2 = assetManageService.selectAllTranslateList();

		request.setAttribute("listBuy2", listBuy2);

		return "deployInfo";
	}

	/**
	 * ����id��ѯ�����¼
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/translate/findById")
	public String findById4(@RequestParam("id") Integer id, HttpServletRequest request) {
		if (id != null) {
			Translate query = assetManageService.findById2(id);
			request.setAttribute("query", query);
		} else {
			List<Translate> listBuy2 = assetManageService.selectAllTranslateList();
			request.setAttribute("listBuy2", listBuy2);
		}
		return "deployInfo";
	}

	/**
	 * ɾ�������¼
	 * 
	 * @param buyidString
	 * @param request
	 * @return
	 */
	@RequestMapping("/translate/delete")
	public String delete2(@RequestParam("number") String buyidString, HttpServletRequest request) {
		String[] sourcestrStrings = buyidString.split("-");
		int[] sourceint = new int[sourcestrStrings.length];
		for (int i = 0; i < sourcestrStrings.length; i++) {
			sourceint[i] = Integer.parseInt(sourcestrStrings[i]);
			assetManageService.deleteById2(sourceint[i]);
		}
		List<Translate> listBuy2 = assetManageService.selectAllTranslateList();
		request.setAttribute("listBuy2", listBuy2);
		return "deployInfo";
	}

	/**
	 * ��ȡ�����б�
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/buyProuduct/findAll3")
	public String findAll3BuyProduct(HttpServletRequest request) {
		List<Repair> listBuy3 = assetManageService.selectAllRepairList();

		request.setAttribute("listBuy3", listBuy3);

		return "baoxiuInfo";
	}

	/**
	 * ����id��ѯ���޼�¼
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/repair/findById")
	public String findById5(@RequestParam("id") Integer id, HttpServletRequest request) {
		if (id != null) {
			Repair query = assetManageService.findById3(id);
			request.setAttribute("query", query);
		} else {
			List<Repair> listBuy3 = assetManageService.selectAllRepairList();
			request.setAttribute("listBuy3", listBuy3);
		}
		return "baoxiuInfo";
	}

	/**
	 * ɾ�����޼�¼
	 * 
	 * @param buyidString
	 * @param request
	 * @return
	 */
	@RequestMapping("/repair/delete")
	public String delete3(@RequestParam("number") String buyidString, HttpServletRequest request) {
		String[] sourcestrStrings = buyidString.split("-");
		int[] sourceint = new int[sourcestrStrings.length];
		for (int i = 0; i < sourcestrStrings.length; i++) {
			sourceint[i] = Integer.parseInt(sourcestrStrings[i]);
			assetManageService.deleteById3(sourceint[i]);
		}
		List<Repair> listBuy3 = assetManageService.selectAllRepairList();
		request.setAttribute("listBuy3", listBuy3);
		return "baoxiuInfo";
	}

	/**
	 * ��ȡ�����б�
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/buyProuduct/findAll4")
	public String findAll4BuyProduct(HttpServletRequest request) {
		List<Scrap> listBuy4 = assetManageService.selectAllScrapList();

		request.setAttribute("listBuy4", listBuy4);

		return "baofeiInfo";
	}

	/**
	 * ����id��ѯ���ϼ�¼
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/scrap/findById")
	public String findById6(@RequestParam("id") Integer id, HttpServletRequest request) {
		if (id != null) {
			Scrap query = assetManageService.findById4(id);
			request.setAttribute("query", query);
		} else {
			List<Scrap> listBuy4 = assetManageService.selectAllScrapList();
			request.setAttribute("listBuy4", listBuy4);
		}
		return "baofeiInfo";
	}

	/**
	 * ɾ�����ϼ�¼
	 * 
	 * @param buyidString
	 * @param request
	 * @return
	 */
	@RequestMapping("/scrap/delete")
	public String delete4(@RequestParam("number") String buyidString, HttpServletRequest request) {
		String[] sourcestrStrings = buyidString.split("-");
		int[] sourceint = new int[sourcestrStrings.length];
		for (int i = 0; i < sourcestrStrings.length; i++) {
			sourceint[i] = Integer.parseInt(sourcestrStrings[i]);
			assetManageService.deleteById4(sourceint[i]);
		}
		List<Scrap> listBuy4 = assetManageService.selectAllScrapList();
		request.setAttribute("listBuy4", listBuy4);
		return "baofeiInfo";
	}
}
