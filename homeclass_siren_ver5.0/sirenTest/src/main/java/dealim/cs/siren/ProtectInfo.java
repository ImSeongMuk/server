package dealim.cs.siren;

import java.util.List;

import javax.inject.Inject;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dealim.cs.siren.bean.ProtectorTel;
import dealim.cs.siren.sevice.TestService;

@Controller
public class ProtectInfo {
	@Inject
	TestService service;
	@RequestMapping(value="/protectInfo",method= {RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody JSONObject tester(@RequestBody ProtectorTel test) throws Exception{ 
    	JSONObject json = new JSONObject();
    	List<ProtectorTel> list;
		try {
			list = service.protectInfo(test);
			System.out.println("��ȣ�� ����Ʈ �ҷ����� ����");
			
			if(!list.isEmpty()) {
				json.put("protect",list);
				json.put("result","T");
				System.out.println("����");
				System.out.println(json);
			}
			else {
				System.out.println("����");
				json.put("result","null");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("����");
			json.put("result","F");
			
		}
		
        return json;
    }
}