package com.neuedu.service;

import java.util.List;

import com.neuedu.model.Product;
import com.neuedu.model.Provider;

public interface SupplierService {

	/**
	 * ��ȡ��Ӧ���б�
	 * 
	 * @return
	 */
	public List<Provider> selectAll();

	/**
	 * ����id��ȡ��Ӧ�̼�¼
	 * 
	 * @return
	 */
	public Provider findById(Integer provid);

	/**
	 * ɾ����Ӧ�̼�¼
	 * 
	 * @param provid
	 */
	public void deleteById(Integer provid);

	/**
	 * ��ӹ�Ӧ�̼�¼
	 * 
	 * @param provider
	 */
	public void AddProvider(Provider provider);

	/**
	 * ���¹�Ӧ����Ϣ
	 * 
	 * @param provider
	 */
	public void updateProvider(Provider provider);

	/**
	 * ��ȡ��Ʒ�б�
	 * 
	 * @return
	 */
	public List<Product> selectAll2();

	/**
	 * ����id��ȡ��Ʒ��¼
	 * 
	 * @param provid
	 * @return
	 */
	public Product findById2(Integer prodid);

	/**
	 * ɾ����Ʒ��¼
	 * 
	 * @param product
	 */
	public void deleteById2(Integer prodid);

	public void updateProduct(Product product);
}
