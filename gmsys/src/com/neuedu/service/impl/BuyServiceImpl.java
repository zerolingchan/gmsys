package com.neuedu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.neuedu.mapper.BuyMapper;
import com.neuedu.model.Buy;
import com.neuedu.service.BuyService;;

@Service     //注解service的实现类
@Transactional  //此处不再进行创建SqlSession和提交事务，都已交由spring去管理了。
public class BuyServiceImpl implements BuyService{
	@Resource  //注解注入
	private BuyMapper mapper;
		
	@Override//重新接口中定义的方法
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