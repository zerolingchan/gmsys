package com.neuedu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.neuedu.mapper.UserAccountMapper;
import com.neuedu.model.UserAccount;
import com.neuedu.service.UserAccountService;

@Service     //ע��service��ʵ����
@Transactional  //�˴����ٽ��д���SqlSession���ύ���񣬶��ѽ���springȥ�����ˡ�
public class UserAccountServiceImpl implements UserAccountService {
 
	@Resource  //ע��ע��
	private UserAccountMapper mapper;
	
	
	@Override//���½ӿ��ж���ķ���
	public UserAccount findUserByAccount(String accounts) {
		
		return mapper.findUserByAccount(accounts);
	}

}
