package dealim.cs.siren;

import javax.inject.Inject;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dealim.cs.siren.bean.TestBean;
import dealim.cs.siren.sevice.TestService;


@Controller
public class UserInfoUpdate {
	@Inject
    TestService service;
    
    @RequestMapping(value="/userInfoUpdate",method= {RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody JSONObject tester(@RequestBody TestBean test) throws Exception{
    	
       
        JSONObject json = new JSONObject();
        try {
        	//update ����
        	service.userInfoUpdate(test);
        	json.put("result","T");
        	System.out.println("userInfoUpdate o");
		} catch (Exception e) {
			//update ����
			json.put("result","F");
			System.out.println("userInfoUpdate x");
		}
        
        return json;
    }
}
