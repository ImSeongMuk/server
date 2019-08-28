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
public class LoginController {
	@Inject
	TestService service;
 
    @RequestMapping(value="/email_login",method= {RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody JSONObject tester(@RequestBody TestBean test) throws Exception{ 
    	System.out.println("login");
    	JSONObject json = new JSONObject();
    	System.out.println(test.getEmail());
    	List<TestBean> listInfo;
    	List<TestBean> listLogin;
    	
		try {
			String salt = null;
			listInfo = service.userinfo(test);
			for(TestBean listinfo : listInfo) {// 유저 정보에서 salt를 가져와서 넣는다
				salt = listinfo.getSalt();
			}
			
        	String password = test.getPassword();//로그인 입력 비밀번호를 입력한다
        	password = SHA256Util.getEncrypt(password,salt);//비밀 번호와 난수를 사용하여 비밀번호를 암호화
        	test.setPassword(password);//암호화된 비밀번호를 다시 입력
        	//암호화한 비밀번호를 넣고 암호화안 비밀번호끼리 맟으면 확인
        	listLogin = service.user_login(test);
			if(!listLogin.isEmpty()) {
				for (TestBean testBean : listLogin) {
					json.put("email", testBean.getEmail());
					json.put("password", testBean.getPassword());
					json.put("userNum", testBean.getUserNum());
					json.put("name", testBean.getName());
				}
				json.put("result","T");
			}
			else {
				json.put("result","F");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
        return json;
    }
    
}
