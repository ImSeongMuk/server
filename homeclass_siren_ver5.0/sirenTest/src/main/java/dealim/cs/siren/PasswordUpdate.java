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
		//입력한 비밀번호가 맞는지 확인
    	System.out.println(test.getEmail()+"비밀번호 업데이트");
    	
    	List<TestBean> listInfo;
    	List<TestBean> listLogin;
    	
		try {
			String salt = null;
			listInfo = service.userinfo(test);
			for(TestBean listinfo : listInfo) {// 유저 정보에서 salt를 가져와서 넣는다
				salt = listinfo.getSalt();
			}
			
        	String password = test.getPassword();//로그인 입력 현재 비밀번호를 입력한다
        	password = SHA256Util.getEncrypt(password,salt);//비밀 번호와 난수를 사용하여 비밀번호를 암호화
        	test.setPassword(password);//암호화된 비밀번호를 다시 입력
        	//암호화한 비밀번호를 넣고 암호화안 비밀번호끼리 맟으면 확인
        	listLogin = service.user_login(test);
        	
			if(!listLogin.isEmpty()) {//공백이 아니면 비밀번호 맞음
				
				password = test.getPasswordNew();//변경할 비밀번호를 가져온다
	        	password = SHA256Util.getEncrypt(password,salt);//새로운 비밀 번호와 db에서 가져온 salt를 사용하여 비밀번호를 암호화
	        	test.setPassword(password);//암호화된 비밀번호를 다시 입력
	        	//암호화한 비밀번호를 넣고 암호화안 비밀번호끼리 맟으면 확인
	        	
	        	service.passwordUpdate(test);
	        	System.out.println("비밀변호 변경 완료");
	        	json.put("result","T");
			}
			else {//공백이면 비밀번호 다름
				json.put("result","F");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        return json;
    }
}
