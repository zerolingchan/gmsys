package com.neuedu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.neuedu.model.Product;
import com.neuedu.model.Provider;
import com.neuedu.service.SupplierService;

//����mvc�Ŀ�������
@Controller
public class SupplierController {

	// ��mvc�Ŀ��Ʋ�����service�����
	@Autowired
	private SupplierService supplierService;

	/**
	 * ��ȡ��Ӧ�̼�¼
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/provider/findAll")
	public String findAllProvider(HttpServletRequest request) {

		List<Provider> listProvider = supplierService.selectAll();
		request.setAttribute("listProvider", listProvider);

		return "supplierInfo";
	}

	/**
	 * ����id��ѯ��Ӧ�̼�¼
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/provider/findById")
	public String findById(@RequestParam("id") Integer id, HttpServletRequest request) {
		if (id != null) {
			Provider query = supplierService.findById(id);
			request.setAttribute("query", query);
		} else {
			List<Provider> listProvider = supplierService.selectAll();
			request.setAttribute("listProvider", listProvider);
		}
		return "supplierInfo";
	}

	/**
	 * ɾ����Ӧ�̼�¼
	 * 
	 * @param buyidString
	 * @param request
	 * @return
	 */
	@RequestMapping("/provider/delete")
	public String delete(@RequestParam("number") String buyidString, HttpServletRequest request) {
		String[] sourcestrStrings = buyidString.split("-");
		int[] sourceint = new int[sourcestrStrings.length];
		for (int i = 0; i < sourcestrStrings.length; i++) {
			sourceint[i] = Integer.parseInt(sourcestrStrings[i]);
			supplierService.deleteById(sourceint[i]);
		}
		List<Provider> listProvider = supplierService.selectAll();
		request.setAttribute("listProvider", listProvider);
		return "supplierInfo";
	}

	/**
	 * ��ӹ�Ӧ�̼�¼
	 * 
	 * @param provname
	 * @param phone
	 * @param address
	 * @param request
	 * @return
	 */
	@RequestMapping("/provider/add")
	public String addProvider(@RequestParam("provname") String provname, @RequestParam("phone") String phone,
			@RequestParam("address") String address, HttpServletRequest request) {
		Provider provider = new Provider();
		provider.setProvname(provname);
		provider.setPhone(phone);
		provider.setAddress(address);
		supplierService.AddProvider(provider);

		List<Provider> listProvider = supplierService.selectAll();
		request.setAttribute("listProvider", listProvider);
		return "supplierInfo";
	}

	/**
	 * ����id��ȡ��Ӧ����Ϣ����ת����Ӧ�̱༭ҳ
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/provider/find2")
	public String findById2(@RequestParam("id") Integer id, HttpServletRequest request) {
		Provider query = supplierService.findById(id);
		request.setAttribute("listProvider", query);
		return "updateSupplier";
	}

	@RequestMapping("/provider/update")
	public String update(@RequestParam("provid") Integer provid, @RequestParam("provname") String provname,
			@RequestParam("phone") String phone, @RequestParam("address") String address, HttpServletRequest request) {
		Provider provider = new Provider();
		provider.setProvid(provid);
		provider.setProvname(provname);
		provider.setPhone(phone);
		provider.setAddress(address);
		supplierService.updateProvider(provider);

		List<Provider> listProvider = supplierService.selectAll();
		request.setAttribute("listProvider", listProvider);
		return "supplierInfo";
	}

	/**
	 * ����id��ȡ��Ӧ����Ϣ����ת����Ӧ������ҳ
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/provider/find")
	public String findById3(@RequestParam("id") Integer id, HttpServletRequest request) {
		Provider query = supplierService.findById(id);
		request.setAttribute("listProvider", query);
		return "supplierDetail";
	}

	/**
	 * ��ȡ��Ʒ�б�
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/product/findAll")
	public String findAllProduct(HttpServletRequest request) {

		List<Product> listProduct = supplierService.selectAll2();
		request.setAttribute("listProduct", listProduct);

		return "productInfo";
	}

	/**
	 * ����id��ѯ��Ʒ��¼
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/product/findById")
	public String findById4(@RequestParam("id") Integer id, HttpServletRequest request) {
		if (id != null) {
			Product query = supplierService.findById2(id);
			request.setAttribute("query", query);
		} else {
			List<Product> listProduct = supplierService.selectAll2();
			request.setAttribute("listProduct", listProduct);
		}
		return "productInfo";
	}

	@RequestMapping("/product/delete")
	public String delete2(@RequestParam("number") String buyidString, HttpServletRequest request) {
		String[] sourcestrStrings = buyidString.split("-");
		int[] sourceint = new int[sourcestrStrings.length];
		for (int i = 0; i < sourcestrStrings.length; i++) {
			sourceint[i] = Integer.parseInt(sourcestrStrings[i]);
			supplierService.deleteById2(sourceint[i]);
		}
		List<Product> listProduct = supplierService.selectAll2();
		request.setAttribute("listProduct", listProduct);
		return "productInfo";
	}
	
	/**
	 * ����id��ȡ��Ʒ��Ϣ����ת����Ʒ�༭ҳ
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/product/find")
	public String findProductById(@RequestParam("id") Integer id, HttpServletRequest request) {
		Product query = supplierService.findById2(id);
		request.setAttribute("listProduct", query);
		return "updateProduct";
	}

	@RequestMapping("/product/update")
	public String update(@RequestParam("prodid") Integer prodid, @RequestParam("prodname") String prodname,
			@RequestParam("prodcount") Double prodcount, @RequestParam("provid") Integer provid, HttpServletRequest request) {
		Product product = new Product();
		product.setProdid(prodid);
		product.setProdname(prodname);
		product.setProdcount(prodcount);
		product.setProvid(provid);
		supplierService.updateProduct(product);

		List<Product> listProduct = supplierService.selectAll2();
		request.setAttribute("listProduct", listProduct);
		return "productInfo";
	}

	/**
	 * ����id��ȡ��Ʒ��Ϣ����ת����Ʒ����ҳ
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/product/findProduct")
	public String findProductById1(@RequestParam("id") Integer id, HttpServletRequest request) {
		Product query = supplierService.findById2(id);
		request.setAttribute("listProduct", query);
		return "productDetail";
	}
}
