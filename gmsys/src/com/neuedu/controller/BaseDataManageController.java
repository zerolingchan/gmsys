package com.neuedu.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.javassist.expr.NewArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.neuedu.model.Area;
import com.neuedu.model.Balance;
import com.neuedu.model.Category;
import com.neuedu.model.Department;
import com.neuedu.model.Page;
import com.neuedu.service.BaseDataManageService;
import com.neuedu.service.UserAccountService;

//����mvc�Ŀ�������
@Controller
public class BaseDataManageController {

	// ��mvc�Ŀ��Ʋ�����service�����
	@Autowired
	private BaseDataManageService baseDataManageService;
	
	//�������ͨ��URL��������������е�¼:findAll.do
	@RequestMapping("/category/findAll.do")
	public String findAll(Model model,HttpServletRequest request){
		 //��ȡ��ǰҳ��
        String pageNow=request.getParameter("pageNow");
        //��ȡ��ҳ��
        int totalCount=((Number)baseDataManageService.findNewContCategory()).intValue();
        Page page=null;
        List<Category> list=new ArrayList<Category>();
        if (pageNow!=null) {
            page=new Page(Integer.parseInt(pageNow), totalCount);
            list=this.baseDataManageService.findNewsPageCategory(page.getStartPos(),page.getPageSize());
        }else {
            page=new Page(1, totalCount);
            list=this.baseDataManageService.findNewsPageCategory(page.getStartPos(),page.getPageSize());
        }
        model.addAttribute("listCategory", list);
        model.addAttribute("page", page);
		
		//List<Category> listcategory=baseDataManageService.selectAll();
		//request.setAttribute("listCategory", listcategory);
		
		return "classificationofassetsInfo";
	}
	//�������ͨ��URL��������������е�¼:findBymh.do
	@RequestMapping("/category/findBymh.do")
	public String findByCname(@RequestParam("zha") String cname,HttpServletRequest request){
		List<Category> listcategory=baseDataManageService.selectByCnamemohu(cname);
		request.setAttribute("listCategory", listcategory);
		
		return "classificationofassetsInfo";
	}
	//�������ͨ��URL��������������е�¼:findById.do
	@RequestMapping("/category/findById.do")
	public String findByCid(@RequestParam("cid") Integer cid,HttpServletRequest request){
		Category category=baseDataManageService.selectByCid(cid);
		request.setAttribute("category", category);
		return "updateClassificationOfAssets";
	}
	//�������ͨ��URL��������������е�¼:findByIdchakan.do
	@RequestMapping("/category/findByIdchakan.do")
	public String findByCidchakan(@RequestParam("cid") Integer cid,HttpServletRequest request){
		Category category=baseDataManageService.findByCidchakan(cid);
		request.setAttribute("category", category);
		return "classificationofassetsDetail";
	}
	//�������ͨ��URL��������������е�¼:update.do
	@RequestMapping("/category/update.do")
	public String updatezcfl(Integer cid, String cname,HttpServletRequest request){
		Category record=new Category();
		record.setCid(cid);
		record.setCname(cname);
		request.setAttribute("category", record);
		baseDataManageService.updatezcfl(record);
		return "classificationofassetsDetail";
	}
	//�������ͨ��URL��������������е�¼:delete.do
	@RequestMapping("/category/delete.do")
	public String deletezcfl(@RequestParam("cid") String cid, Model model,HttpServletRequest request){
		//baseDataManageService.deletezcfl(cid);
		String[] sourcestrStrings=cid.split(":");
		int[] sourceint=new int[sourcestrStrings.length];
		for (int i = 0; i < sourcestrStrings.length; i++) {
			sourceint[i]=Integer.parseInt(sourcestrStrings[i]);
			baseDataManageService.deletezcfl(sourceint[i]);
		}
		
		//��ȡ��ǰҳ��
        String pageNow=request.getParameter("pageNow");
        //��ȡ��ҳ��
        int totalCount=((Number)baseDataManageService.findNewContCategory()).intValue();
        Page page=null;
        List<Category> list=new ArrayList<Category>();
        if (pageNow!=null) {
            page=new Page(Integer.parseInt(pageNow), totalCount);
            list=this.baseDataManageService.findNewsPageCategory(page.getStartPos(),page.getPageSize());
        }else {
            page=new Page(1, totalCount);
            list=this.baseDataManageService.findNewsPageCategory(page.getStartPos(),page.getPageSize());
        }
        model.addAttribute("listCategory", list);
        model.addAttribute("page", page);
		
		
		return "classificationofassetsInfo";
	}
	//�������ͨ��URL��������������е�¼:add.do
	@RequestMapping("/category/add.do")
	public String addzcfl(String cname,Model model, HttpServletRequest request){
		Category record=new Category();
		record.setCname(cname);
		baseDataManageService.addzcfl(record);
		
		//List<Category> listcategory=baseDataManageService.selectAll();
		//request.setAttribute("listCategory", listcategory);
		//return "zcflxinxi";
		//��ȡ��ǰҳ��
        String pageNow=request.getParameter("pageNow");
        //��ȡ��ҳ��
        int totalCount=((Number)baseDataManageService.findNewContCategory()).intValue();
        Page page=null;
        List<Category> list=new ArrayList<Category>();
        if (pageNow!=null) {
            page=new Page(Integer.parseInt(pageNow), totalCount);
            list=this.baseDataManageService.findNewsPageCategory(page.getStartPos(),page.getPageSize());
        }else {
            page=new Page(1, totalCount);
            list=this.baseDataManageService.findNewsPageCategory(page.getStartPos(),page.getPageSize());
        }
        model.addAttribute("listCategory", list);
        model.addAttribute("page", page);
		
		//List<Category> listcategory=baseDataManageService.selectAll();
		//request.setAttribute("listCategory", listcategory);
		
		return "classificationofassetsInfo";
	}

	
	//��������
	//�������ͨ��URL��������������е�¼:findAll.do
	@RequestMapping("/department/findAll.do")
	public String departmentfindAll(HttpServletRequest request){
		List<Department> listdepartment=baseDataManageService.selectAllDepartment();
		request.setAttribute("listDepartment", listdepartment);
		return "departInfo";
	}
	//�������ͨ��URL��������������е�¼:findById.do
	@RequestMapping("/department/findById.do")
	public String findByDid(@RequestParam("departid") Integer departid,HttpServletRequest request){
		Department department=baseDataManageService.selectByDid(departid);
		request.setAttribute("department", department);
		return "updateDepartment";
	}
	//�������ͨ��URL��������������е�¼:findByIdchakan.do
	@RequestMapping("/department/findByIdchakan.do")
	public String findByDidchakan(@RequestParam("departid") Integer departid,HttpServletRequest request){
		Department department=baseDataManageService.findByDidchakan(departid);
		request.setAttribute("department", department);
		return "departDetail";
	}
	//�������ͨ��URL��������������е�¼:findBymh.do
	@RequestMapping("/department/findBymh.do")
	public String findByDepartid(@RequestParam("zha") Integer departid,HttpServletRequest request){
		Department department=baseDataManageService.selectByDid(departid);
		List<Object> list = new ArrayList<Object>();
		list.add(department);
		request.setAttribute("listDepartment", list);
		return "departInfo";
	}
	//�������ͨ��URL��������������е�¼:update.do
	@RequestMapping("/department/update.do")
	public String updatebm(Integer departid, String departname,String areaname,HttpServletRequest request){
		Department record=new Department();
		record.setDepartid(departid);
		record.setAreaid(baseDataManageService.selectByDid(departid).getAreaid());
		record.setAreaname(areaname);
		record.setDepartname(departname);
		baseDataManageService.updatebm(record);
		request.setAttribute("department", record);
		return "departDetail";
	}
	//�������ͨ��URL��������������е�¼:delete.do
	@RequestMapping("/department/delete.do")
	public String deletebm(@RequestParam("cid") String departid, HttpServletRequest request){
		//baseDataManageService.deletezcfl(cid);
		String[] sourcestrStrings=departid.split(":");
		int[] sourceint=new int[sourcestrStrings.length];
		for (int i = 0; i < sourcestrStrings.length; i++) {
			sourceint[i]=Integer.parseInt(sourcestrStrings[i]);
			baseDataManageService.deletebm(sourceint[i]);
		}
		List<Department> listdepartment=baseDataManageService.selectAllDepartment();
		request.setAttribute("listDepartment", listdepartment);
		return "departInfo";
	}
	//�������ͨ��URL��������������е�¼:add.do
	@RequestMapping("/department/add.do")
	public String addbm(String departname,String areaname, HttpServletRequest request){
		Department record=new Department();
		record.setDepartname(departname);
		record.setAreaname(areaname);
		baseDataManageService.addbm(record);
		List<Department> listdepartment=baseDataManageService.selectAllDepartment();
		request.setAttribute("listDepartment", listdepartment);
		return "departInfo";
	}
	//�ʲ�¼�빦��
	@RequestMapping("/zc/add.do")
	public String addzc(String zcname,Double zcnumber,BigDecimal price,Integer cid,Integer departid, HttpServletRequest request){
		Balance balance=new Balance();
		//balance.setBcount(bcount);�������һ��bid
		Date day=new Date();    
		//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		
		balance.setBcount(zcnumber);
		balance.setBdate(day);
		balance.setBname(zcname);
		balance.setCid(cid);
		balance.setCname(baseDataManageService.selectByCid(cid).getCname());
		balance.setDepartid(departid);
		balance.setPrice(price);
		baseDataManageService.addzc(balance);
		return "addProperty";
	}
	//�������
	@RequestMapping("/area/list.do")
	public String areafindAll(Model model,HttpServletRequest request){
		 //��ȡ��ǰҳ��
        String pageNow=request.getParameter("pageNow");
        //��ȡ��ҳ��
        int totalCount=((Number)baseDataManageService.findNewCont()).intValue();
        Page page=null;
        List<Area> list=new ArrayList<Area>();
        if (pageNow!=null) {
            page=new Page(Integer.parseInt(pageNow), totalCount);
            list=this.baseDataManageService.findNewsPage(page.getStartPos(),page.getPageSize());
        }else {
            page=new Page(1, totalCount);
            list=this.baseDataManageService.findNewsPage(page.getStartPos(),page.getPageSize());
        }
        model.addAttribute("list", list);
        model.addAttribute("page", page);
        //return "news.jsp";
        //request.setAttribute("list", list);
        //request.setAttribute("page", page);
		
		
		List<Area> listdepartment=baseDataManageService.selectAllArea();
		request.setAttribute("areaList", listdepartment);
		return "areaInfo";
	}
	//�������ͨ��URL��������������е�¼:findById.do
	@RequestMapping("/area/findById.do")
	public String findByAreaid(@RequestParam("areaid") Integer areaid,HttpServletRequest request){
		Area area=baseDataManageService.selectByAreaid(areaid);
		request.setAttribute("area", area);
		return "updateArea";
	}
	//�������ͨ��URL��������������е�¼:findByIdchakan.do
	@RequestMapping("/area/findByIdchakan.do")
	public String findByAreaidchakan(@RequestParam("areaid") Integer areaid,HttpServletRequest request){
		Area area=baseDataManageService.findByAreaidchakan(areaid);
		request.setAttribute("area", area);
		return "areaDetail";
	}
	//�������ͨ��URL��������������е�¼:update.do
	@RequestMapping("/area/update.do")
	public String updatearea(Integer areaid,String areaname,HttpServletRequest request){
		Area record=baseDataManageService.selectByAreaid(areaid);
		record.setAreaname(areaname);
		baseDataManageService.updatearea(record);
		request.setAttribute("area", record);
		return "areaDetail";
	}
	//�������ͨ��URL��������������е�¼:delete.do
	@RequestMapping("/area/delete.do")
	public String deletearea(@RequestParam("areaid") String areaid, HttpServletRequest request){
		//baseDataManageService.deletezcfl(cid);
		String[] sourcestrStrings=areaid.split(":");
		int[] sourceint=new int[sourcestrStrings.length];
		for (int i = 0; i < sourcestrStrings.length; i++) {
			sourceint[i]=Integer.parseInt(sourcestrStrings[i]);
			baseDataManageService.deletearea(sourceint[i]);
		}
		List<Area> listdepartment=baseDataManageService.selectAllArea();
		request.setAttribute("areaList", listdepartment);
		return "areaInfo";
	}
	//�������ͨ��URL��������������е�¼:add.do
	@RequestMapping("/area/add.do")
	public String addarea(String areaname,Integer relative,Integer areaid, HttpServletRequest request){
		Area record=new Area();
		record.setAreaid(areaid);
		record.setAreaname(areaname);
		record.setRelative(relative);
		baseDataManageService.addarea(record);
		List<Area> listdepartment=baseDataManageService.selectAllArea();
		request.setAttribute("areaList", listdepartment);
		return "areaInfo";
	}
	//�������ͨ��URL��������������е�¼:findBymh.do
	@RequestMapping("/area/findBymh.do")
	public String findByAreaidmh(@RequestParam("zha") Integer areaid,HttpServletRequest request){
		Area department=baseDataManageService.selectByAreaid(areaid);
		List<Object> list = new ArrayList<Object>();
		list.add(department);
		request.setAttribute("areaList", list);
		return "areaInfo";
	}
	
}
