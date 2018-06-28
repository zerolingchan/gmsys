package com.neuedu.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neuedu.model.Buy;
import com.neuedu.model.UserAccount;
import com.neuedu.service.BuyService;
import com.neuedu.service.UserAccountService;

@Controller
public class BuyController {
	// 在mvc的控制层整合service服务层
	@Autowired
	private BuyService buyService;
}
