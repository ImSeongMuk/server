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
public class EmailOverlapController {
	@Inject
    TestService service;
    //@RequestMapping(value = "/insert",method = RequestMethod.POST )
    //public String insertControllerPost(TestBean test, Model model) throws Exception
    
    @RequestMapping(value="/emailoverlap",method= {RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody JSONObject tester(@RequestBody TestBean test) throws Exception{
    	System.out.println("emailoverlap");
    	
        JSONObject json = new JSONObject();
        List<TestBean> list;
        try {
        	list = service.emailoverlap(test);
        	if(!list.isEmpty()) {
        		json.put("result", "F");
				for (TestBean testBean : list) {
					json.put("email", testBean.getEmail());
				}
        	}
        	else {
        		json.put("result", "T");
        	} 
		} catch (Exception e) {	
		}
        
        return json;
    }
    
}
