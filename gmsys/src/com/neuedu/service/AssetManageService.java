package com.neuedu.service;

import java.util.List;

import com.neuedu.model.Buy;
import com.neuedu.model.Department;
import com.neuedu.model.Product;
import com.neuedu.model.Repair;
import com.neuedu.model.Scrap;
import com.neuedu.model.Translate;

public interface AssetManageService {
	/**
	 * ��ȡ�ɹ������б�
	 * 
	 * @return
	 */
	public List<Buy> selectAll();

	/**
	 * ���ݲɹ����Ų�ѯ����
	 * 
	 * @param id
	 * @return
	 */
	public Buy findById(Integer id);

	/**
	 * ���ݲɹ�����ɾ������
	 * 
	 * @param buyid
	 */
	public void deleteById(Integer buyid);

	/**
	 * ��ȡ��Ʒ�б�
	 * 
	 * @return
	 */
	public List<Product> selectAllProductList();

	/**
	 * ��ȡ��Ӧ���б�
	 * 
	 * @return
	 */
	public List<Department> selectAllDepartmentList();

	/**
	 * ���ݹ�Ӧ��id��ȡ��Ʒ
	 * 
	 * @param provid
	 * @return
	 */
	public Product selectByProvid(Integer provid);

	/**
	 * ��Ӳɹ���¼
	 * 
	 * @param buy
	 */
	public void addBuy(Buy buy);

	/**
	 * ���²ɹ���¼
	 * 
	 * @param buy
	 */
	public void updateBuy(Buy buy);

	/**
	 * ��ȡ�����б�
	 * 
	 * @return
	 */
	public List<Translate> selectAllTranslateList();

	/**
	 * ����id��ѯ���ȼ�¼
	 * 
	 * @param tid
	 * @return
	 */
	public Translate findById2(Integer tid);

	/**
	 * ����idɾ�����ȼ�¼
	 * 
	 * @param tid
	 */
	public void deleteById2(Integer tid);

	/**
	 * ��ȡ�����б�
	 * 
	 * @return
	 */
	public List<Repair> selectAllRepairList();

	/**
	 * ����id��ѯ���޼�¼
	 * 
	 * @param tid
	 * @return
	 */
	public Repair findById3(Integer rid);

	/**
	 * ����idɾ�����޼�¼
	 * 
	 * @param tid
	 */
	public void deleteById3(Integer rid);

	/**
	 * ��ȡ�����б�
	 * 
	 * @return
	 */
	public List<Scrap> selectAllScrapList();

	/**
	 * ����id��ѯ���ϼ�¼
	 * 
	 * @param tid
	 * @return
	 */
	public Scrap findById4(Integer sid);

	/**
	 * ����idɾ�����ϼ�¼
	 * 
	 * @param tid
	 */
	public void deleteById4(Integer sid);
}
