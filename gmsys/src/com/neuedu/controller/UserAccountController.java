package com.neuedu.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neuedu.model.UserAccount;
import com.neuedu.service.UserAccountService;

//����mvc�Ŀ�������
@Controller
public class UserAccountController {

	// ��mvc�Ŀ��Ʋ�����service�����
	@Autowired
	private UserAccountService accountService;

	//�������ͨ��URL��������������е�¼:doLogin.do
	@RequestMapping("/doLogin")
	public String doLogin(String account, String password, HttpSession session) {
		
		UserAccount userAccount = accountService.findUserByAccount(account);
		
		if (userAccount != null && userAccount.getPassword().equals(password)) {
			// ��¼�ɹ������뵽�������
			//�����û���¼״̬
			session.setAttribute("login", true);
			session.setAttribute("loginUser", userAccount);
			
			return "redirect:index.jsp";
		} else {
			// ��¼ʧ�ܣ����ص�¼ҳ��
			//ɾ����¼״̬�������¼���ٴε�¼
			session.removeAttribute("login");
			return "redirect:login.html";
		}
	}//end 
	
	
	@RequestMapping("/doLogout")
	public String doLogout(HttpSession session){
		
		/**
		 * 
		 * 1.HttpSession session��jsp/servlet�����еĻỰ����������һ����������ڶ�η��ʷ�����ʱ�������ڶ��ҳ���servlet�乲������
		 * 2.ֻҪ��ǰ���������û�йرգ���Ựû�г�ʱ(Ĭ��30���ӳ�ʱ),�Ϳ���ʹ��session�ڷ���˹�������
		 * 3.�ر�ģ������һ���رգ��ٴδ�ʱ�Ὺ��һ���µĻỰ��֮ǰ�����ڻỰ�е����ݾ��޷���ʹ��
		 * 
		 * 
		 * 4.�Ự��ʱ���ǱȽϳ��ġ���Ӧ��һ�������й�������ݣ�Ӧ��ʹ��HttpServletRequest������б��湲��
		 * 
		 * 
		 */
		
		//�˳���Ҫ����û���¼״̬�Լ���¼�õ���Ϣ
		session.removeAttribute("login");
		session.removeAttribute("loginUser");
		
		return "redirect:login.html";
	}
}
