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
import dealim.cs.siren.bean.DiseaseConnect;
import dealim.cs.siren.sevice.TestService;
@Controller
public class UserDisease {
	@Inject
	TestService service;
	@RequestMapping(value="/email_login",method= {RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody JSONObject tester(@RequestBody DiseaseConnect test) throws Exception{ 
    	System.out.println("login");
    	JSONObject json = new JSONObject();
    	System.out.println(test.getUserNum());
    	List<DiseaseConnect> list;
    	
		try {
			list = service.userDisease(test);
			if(!list.isEmpty()) {
				for (DiseaseConnect diseaseConnect : list) {
					json.put("userNum", diseaseConnect.getUserNum());
					json.put("diseaseCode", diseaseConnect.getDiseaseCode());
					json.put("diseaseName", diseaseConnect.getDiseaseName());
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



