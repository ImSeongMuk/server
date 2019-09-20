package dealim.cs.siren;

import java.util.List;

import javax.inject.Inject;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dealim.cs.siren.bean.TestBean;
import dealim.cs.siren.sevice.TestService;
import dealim.cs.siren.sha256.SHA256Util;


@Controller
public class PasswordUpdate {
	@Inject
	TestService service;
	@RequestMapping(value="/passwordUpdate",method= {RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody JSONObject tester(@RequestBody TestBean test) throws Exception{ 
		JSONObject json = new JSONObject();
		//�Է��� ��й�ȣ�� �´��� Ȯ��
    	System.out.println(test.getEmail()+"��й�ȣ ������Ʈ");
    	
    	List<TestBean> listInfo;
    	List<TestBean> listLogin;
    	
		try {
			String salt = null;
			listInfo = service.userinfo(test);
			for(TestBean listinfo : listInfo) {// ���� �������� salt�� �����ͼ� �ִ´�
				salt = listinfo.getSalt();
			}
			
        	String password = test.getPassword();//�α��� �Է� ���� ��й�ȣ�� �Է��Ѵ�
        	password = SHA256Util.getEncrypt(password,salt);//��� ��ȣ�� ������ ����Ͽ� ��й�ȣ�� ��ȣȭ
        	test.setPassword(password);//��ȣȭ�� ��й�ȣ�� �ٽ� �Է�
        	//��ȣȭ�� ��й�ȣ�� �ְ� ��ȣȭ�� ��й�ȣ���� ������ Ȯ��
        	listLogin = service.user_login(test);
        	
			if(!listLogin.isEmpty()) {//������ �ƴϸ� ��й�ȣ ����
				
				password = test.getPasswordNew();//������ ��й�ȣ�� �����´�
	        	password = SHA256Util.getEncrypt(password,salt);//���ο� ��� ��ȣ�� db���� ������ salt�� ����Ͽ� ��й�ȣ�� ��ȣȭ
	        	test.setPassword(password);//��ȣȭ�� ��й�ȣ�� �ٽ� �Է�
	        	//��ȣȭ�� ��й�ȣ�� �ְ� ��ȣȭ�� ��й�ȣ���� ������ Ȯ��
	        	
	        	service.passwordUpdate(test);
	        	System.out.println("��к�ȣ ���� �Ϸ�");
	        	json.put("result","T");
			}
			else {//�����̸� ��й�ȣ �ٸ�
				json.put("result","F");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        return json;
    }
}