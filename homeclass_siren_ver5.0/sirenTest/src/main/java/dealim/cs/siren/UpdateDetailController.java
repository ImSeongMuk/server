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
public class UpdateDetailController {
	@Inject
    TestService service;
    
    @RequestMapping(value="/updatedetail",method= {RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody JSONObject tester(@RequestBody TestBean test) throws Exception{
    	
        System.out.println("updatedetail");
        JSONObject json = new JSONObject();
        
        try {
        	//update ����
        	service.update_detail(test);
        	json.put("result","T");
        	System.out.println("F");
		} catch (Exception e) {
			//update ����
			json.put("result","F");
			System.out.println("F");
		}
        
        return json;
    }
}
