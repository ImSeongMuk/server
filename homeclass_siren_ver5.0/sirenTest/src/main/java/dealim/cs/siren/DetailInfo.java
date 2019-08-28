package dealim.cs.siren;

import java.util.List;

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
public class DetailInfo {
	@Inject
	TestService service;
	@RequestMapping(value="/detailInfo",method= {RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody JSONObject tester(@RequestBody Detail test) throws Exception{ 
    	JSONObject json = new JSONObject();
    	System.out.println(test.getUserNum());
    	List<Detail> list;
		try {
			list = service.detailInfo(test);
			System.out.println("디테일 리스트 불러오기 성공");
			
			if(!list.isEmpty()) {
				json.put("detail",list);
				json.put("result","T");
				System.out.println("성공");
				System.out.println(json);
			}
			else {
				System.out.println("공백");
				json.put("result","null");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("실패");
			json.put("result","F");
			
		}
		
        return json;
    }
}
