package com.modrm.coffee.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import com.modrm.coffee.service.IUserService;
import com.modrm.coffee.vo.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;



/**
 * 用户操作的业务逻辑 登陆、注册、修改、删除、查找、注销
 * 
 * @author Modrm
 *
 */
public class UserAction extends ActionSupport {

	// 头像
	private File headImg;
	private String headImgFileName;
	private String headImgContentType;
	// 从service 里找 dao 查找数据库后返回的数据 ，反之亦然
	// strust映射到实体类，通过get方法从实体类里取出password，和username，然后把值传到dao里去验证，然后再传回来。
	private User user;
	protected IUserService userService;
	private String userid;
	private String password;
	private String sex;
	private String age;
	private String email; 
	
	//修改头像
	public String updateMyHeadImg(){
		String filePath = ServletActionContext.getServletContext().getRealPath("upload/"); //保存文件
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");//精确到毫秒
		System.out.println(sdf);
		String date = sdf.format(new Date()); 
		String fileName = date + headImgFileName.substring(headImgFileName.lastIndexOf(".")); //copy文件
		try { 
			FileUtils.copyFile(headImg, new File(filePath,fileName));
			//UserBean ub = new UserBean();
			User myuser = new User();
			myuser.setUserid(Integer.parseInt(userid));
			myuser.setHeadImg(fileName);
			System.out.println(fileName);
			System.out.println(Integer.parseInt(userid));
			boolean bl = userService.updateHeadImg(myuser);
			if(bl){
				//重新加载session
				User modrm_user = userService.validateUser(user.getUsername(), user.getPassword());
				Map session = ActionContext.getContext().getSession();// 研究一下这句话的含义
				session.put("user", modrm_user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return "success";
	}
	//修改数据
	public String updateMySession(){
		/*UserBean userBean = new UserBean();//实例化
			userBean.setPassword(getPassword());
			userBean.setSex(getSex());
			userBean.setAge(Integer.parseInt(getAge()));
			userBean.setEmail(getEmail());*/
//			userBean.setUsername(user.getUsername());
		/*int mysession = userService.updateUser(userBean);
		if(mysession>0){
			return "success";
		}
		return "error";*/
		/*UserBean userBean = new UserBean();
		userBean.setPassword(password);
		userBean.setSex(sex);
		userBean.setAge(Integer.parseInt(age));
		userBean.setEmail(email);
		userBean.setId(Integer.parseInt(userid));*/
		User user = new User();
		user.setPassword(password);
		user.setSex(sex);
		user.setAge(Integer.parseInt(age));
		user.setEmail(email);
		user.setUserid(Integer.parseInt(userid));
/*		System.out.println(password);
		System.out.println(sex);
		System.out.println(Integer.parseInt(age));
		System.out.println(email);
		
		System.out.println("---------------------------");
		System.out.println(userBean.getPassword());
		System.out.println(userBean.getSex());
		System.out.println(userBean.getAge());
		System.out.println(userBean.getEmail());
		System.out.println(userBean.getId());*/
		int mysession = userService.updateUser(user);
		if(mysession>0){
			User modrm_user = userService.validateUser(user.getUsername(), user.getPassword());
			Map session = ActionContext.getContext().getSession();
			
			session.put("user", modrm_user);
			return "success";
		}
		return "error";
//		return "success";
		
	}
	// 实现登出,从session里移除
	public String logout() {
		Map session = ActionContext.getContext().getSession();// 研究一下这句话的含义
		session.remove("user");
		return "success";
	}

	// 实现注册功能，通过实体类把整个集合丢到dao了进行存储
	public String register() {
		String filePath = ServletActionContext.getServletContext().getRealPath("upload/"); //保存文件
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");//精确到毫秒
		System.out.println(sdf);
		String date = sdf.format(new Date()); 
		String fileName = date + headImgFileName.substring(headImgFileName.lastIndexOf(".")); //copy文件
//		System.out.println(date);
		try { 
			FileUtils.copyFile(headImg, new File(filePath,fileName));
//			System.out.println(fileName);
			user.setHeadImg(fileName); 
			//注册并登陆并把图片也放进session里去
			//把注册传入数据库
			userService.saveUser(user);
			User modrm_user = userService.validateUser(user.getUsername(), user.getPassword());
			if (modrm_user != null) {
				// 加一个注销的功能 如何实现，把用户放到session里面去 用户名和密码卡 key value map集合
				Map session = ActionContext.getContext().getSession();// 研究一下这句话的含义
				// 把用户密码都存到session里，看来session可以存很多集合或者字符串，到时候头像也可以这么加
				session.put("user", modrm_user);
				/*session.put("photoname",fileName);*/
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
//		System.out.println(fileName);
		return "success";
	}

	// 负责登陆的功能
	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		User modrm_user = userService.validateUser(user.getUsername(), user.getPassword());
		if (modrm_user != null) {
			userService.addCookie(response,user.getUsername(), user.getPassword());
			// 加一个注销的功能 如何实现，把用户放到session里面去 用户名和密码卡 key value map集合
			Map session = ActionContext.getContext().getSession();// 研究一下这句话的含义
			// 把用户密码都存到session里，看来session可以存很多集合或者字符串，到时候头像也可以这么加
			session.put("user", modrm_user);
			return "success";
		}

		return "error";
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}

	public File getHeadImg() {
		return headImg;
	}

	public void setHeadImg(File headImg) {
		this.headImg = headImg;
	}

	public String getHeadImgFileName() {
		return headImgFileName;
	}

	public void setHeadImgFileName(String headImgFileName) {
		this.headImgFileName = headImgFileName;
	}

	public String getHeadImgContentType() {
		return headImgContentType;
	}

	public void setHeadImgContentType(String headImgContentType) {
		this.headImgContentType = headImgContentType;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
