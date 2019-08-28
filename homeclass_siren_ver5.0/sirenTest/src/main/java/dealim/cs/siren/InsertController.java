package dealim.cs.siren;

import javax.inject.Inject;

import java.security.MessageDigest;
import dealim.cs.siren.bean.TestBean;
import dealim.cs.siren.sevice.TestService;
import dealim.cs.siren.sha256.SHA256Util;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InsertController {
    
	@Inject
    TestService service;
    
    @RequestMapping(value="/insert",method= {RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody JSONObject tester(@RequestBody TestBean test) throws Exception{
    	
        System.out.println("insert");
        JSONObject json = new JSONObject();
        
        try {
        	//sha256 에서 난수를 생성해서 받아온다 salt는 DB에저장
        	String salt = SHA256Util.generateSalt();
        	//db 변경 및 스프링 변경 test.setSalt(salt)
        	test.setSalt(salt);
        	String password = test.getPassword();//회원 가입 할때 비번 가져오기
        	password = SHA256Util.getEncrypt(password,salt);//비밀 번호와 난수를 사용하여 비밀번호를 암호화
        	test.setPassword(password);//암호화된 비밀번호를 다시 입력
        	
        	service.user_insert(test);
            json.put("result","T");
            System.out.println("T");
		} catch (Exception e) {
			json.put("result","F");
			System.out.println("F");
		}
        
        return json;
    }
    
    
}