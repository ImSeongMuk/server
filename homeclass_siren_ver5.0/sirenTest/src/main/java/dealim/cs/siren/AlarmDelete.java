package dealim.cs.siren;

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
public class AlarmDelete {
	@Inject
	TestService service;
	@RequestMapping(value="/alarmDelete",method= {RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody JSONObject tester(@RequestBody AlarmList test) throws Exception{ 
    	JSONObject json = new JSONObject();
    	System.out.println(test.getUserNum());
    	
		try {
			service.alarmDelete(test);
			System.out.println("user number: "+test.getUserNum()+"  alarm code: "+test.getAlarmCode()+" ���� �Ϸ�");
			json.put("result","T");
			System.out.println("����");
			
		} catch (Exception e) {
			e.printStackTrace();
			json.put("result","F");
			System.out.println("����");
		}
		
        return json;
    }
}