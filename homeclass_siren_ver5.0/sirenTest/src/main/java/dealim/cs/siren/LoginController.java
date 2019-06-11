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


@Controller
public class LoginController {
	@Inject
	TestService service;
 
    @RequestMapping(value="/email_login",method= {RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody JSONObject tester(@RequestBody TestBean test) throws Exception{ 
    	System.out.println("login");
    	JSONObject json = new JSONObject();
    	System.out.println(test.getEmail());
    	List<TestBean> list;
    	
		try {
			list = service.user_login(test);
			if(!list.isEmpty()) {
				for (TestBean testBean : list) {
					json.put("email", testBean.getEmail());
					json.put("user_password", testBean.getUser_password());
					
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
