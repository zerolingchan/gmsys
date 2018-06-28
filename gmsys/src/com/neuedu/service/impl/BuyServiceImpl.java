package com.neuedu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.neuedu.mapper.BuyMapper;
import com.neuedu.model.Buy;
import com.neuedu.service.BuyService;;

@Service     //ע��service��ʵ����
@Transactional  //�˴����ٽ��д���SqlSession���ύ���񣬶��ѽ���springȥ�����ˡ�
public class BuyServiceImpl implements BuyService{
	@Resource  //ע��ע��
	private BuyMapper mapper;
		
	@Override//���½ӿ��ж���ķ���
	public int deleteByPrimaryKey(Integer buyid) {		
		return mapper.deleteByPrimaryKey(buyid);
	}
	
	public int insert(Buy record) {		
		return mapper.insert(record);
	}

	public Buy selectByPrimaryKey(Integer buyid) {		
		return mapper.selectByPrimaryKey(buyid);
	}

	public List<Buy> selectAll(){
		return mapper.selectAll();
	}

    public int updateByPrimaryKey(Buy record){
    	return mapper.updateByPrimaryKey(record);
    }
}