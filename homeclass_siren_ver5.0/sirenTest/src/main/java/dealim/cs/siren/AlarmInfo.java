package dealim.cs.siren;

import java.util.List;

import javax.inject.Inject;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dealim.cs.siren.bean.AlarmList;
import dealim.cs.siren.sevice.TestService;

@Controller
public class AlarmInfo {
	@Inject
	TestService service;
	@RequestMapping(value="/alarmInfo",method= {RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody JSONObject tester(@RequestBody AlarmList test) throws Exception{ 
    	JSONObject json = new JSONObject();
    	System.out.println(test.getUserNum());
    	List<AlarmList> list;
		try {
			list = service.alarmInfo(test);
			System.out.println("�˶� ����Ʈ �ҷ����� ����");
			
			if(!list.isEmpty()) {
				json.put("alarm",list);
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