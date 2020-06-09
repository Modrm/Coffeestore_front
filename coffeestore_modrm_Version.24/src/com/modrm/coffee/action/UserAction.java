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
 * �û�������ҵ���߼� ��½��ע�ᡢ�޸ġ�ɾ�������ҡ�ע��
 * 
 * @author Modrm
 *
 */
public class UserAction extends ActionSupport {

	// ͷ��
	private File headImg;
	private String headImgFileName;
	private String headImgContentType;
	// ��service ���� dao �������ݿ�󷵻ص����� ����֮��Ȼ
	// strustӳ�䵽ʵ���࣬ͨ��get������ʵ������ȡ��password����username��Ȼ���ֵ����dao��ȥ��֤��Ȼ���ٴ�������
	private User user;
	protected IUserService userService;
	private String userid;
	private String password;
	private String sex;
	private String age;
	private String email; 
	
	//�޸�ͷ��
	public String updateMyHeadImg(){
		String filePath = ServletActionContext.getServletContext().getRealPath("upload/"); //�����ļ�
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");//��ȷ������
		System.out.println(sdf);
		String date = sdf.format(new Date()); 
		String fileName = date + headImgFileName.substring(headImgFileName.lastIndexOf(".")); //copy�ļ�
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
				//���¼���session
				User modrm_user = userService.validateUser(user.getUsername(), user.getPassword());
				Map session = ActionContext.getContext().getSession();// �о�һ����仰�ĺ���
				session.put("user", modrm_user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return "success";
	}
	//�޸�����
	public String updateMySession(){
		/*UserBean userBean = new UserBean();//ʵ����
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
	// ʵ�ֵǳ�,��session���Ƴ�
	public String logout() {
		Map session = ActionContext.getContext().getSession();// �о�һ����仰�ĺ���
		session.remove("user");
		return "success";
	}

	// ʵ��ע�Ṧ�ܣ�ͨ��ʵ������������϶���dao�˽��д洢
	public String register() {
		String filePath = ServletActionContext.getServletContext().getRealPath("upload/"); //�����ļ�
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");//��ȷ������
		System.out.println(sdf);
		String date = sdf.format(new Date()); 
		String fileName = date + headImgFileName.substring(headImgFileName.lastIndexOf(".")); //copy�ļ�
//		System.out.println(date);
		try { 
			FileUtils.copyFile(headImg, new File(filePath,fileName));
//			System.out.println(fileName);
			user.setHeadImg(fileName); 
			//ע�Ტ��½����ͼƬҲ�Ž�session��ȥ
			//��ע�ᴫ�����ݿ�
			userService.saveUser(user);
			User modrm_user = userService.validateUser(user.getUsername(), user.getPassword());
			if (modrm_user != null) {
				// ��һ��ע���Ĺ��� ���ʵ�֣����û��ŵ�session����ȥ �û��������뿨 key value map����
				Map session = ActionContext.getContext().getSession();// �о�һ����仰�ĺ���
				// ���û����붼�浽session�����session���Դ�ܶ༯�ϻ����ַ�������ʱ��ͷ��Ҳ������ô��
				session.put("user", modrm_user);
				/*session.put("photoname",fileName);*/
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
//		System.out.println(fileName);
		return "success";
	}

	// �����½�Ĺ���
	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		User modrm_user = userService.validateUser(user.getUsername(), user.getPassword());
		if (modrm_user != null) {
			userService.addCookie(response,user.getUsername(), user.getPassword());
			// ��һ��ע���Ĺ��� ���ʵ�֣����û��ŵ�session����ȥ �û��������뿨 key value map����
			Map session = ActionContext.getContext().getSession();// �о�һ����仰�ĺ���
			// ���û����붼�浽session�����session���Դ�ܶ༯�ϻ����ַ�������ʱ��ͷ��Ҳ������ô��
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
