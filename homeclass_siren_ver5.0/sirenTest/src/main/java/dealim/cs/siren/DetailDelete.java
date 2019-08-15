package dealim.cs.siren;

import javax.inject.Inject;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dealim.cs.siren.bean.Detail;
import dealim.cs.siren.sevice.TestService;

@Controller
public class DetailDelete {
	@Inject
	TestService service;
	@RequestMapping(value="/detailDelete",method= {RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody JSONObject tester(@RequestBody Detail test) throws Exception{ 
    	JSONObject json = new JSONObject();
    	System.out.println(test.getUserNum());
    	
		try {
			service.detailDelete(test);
			System.out.println("user number: "+test.getUserNum()+"  detail code: "+test.getDetailCode()+" 삭제 완료");
			json.put("result","T");
			System.out.println("성공");
			
		} catch (Exception e) {
			e.printStackTrace();
			json.put("result","F");
			System.out.println("실패");
		}
		
        return json;
    }
}
