package dealim.cs.siren;

import javax.inject.Inject;


import dealim.cs.siren.bean.TestBean;
import dealim.cs.siren.sevice.TestService;

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