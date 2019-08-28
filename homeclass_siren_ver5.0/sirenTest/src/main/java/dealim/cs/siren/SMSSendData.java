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
import dealim.cs.siren.bean.ProtectorTel;
import dealim.cs.siren.bean.TestBean;
import dealim.cs.siren.sevice.TestService;

@Controller
public class SMSSendData {
	@Inject
	TestService service;
	@RequestMapping(value="/smsSendData",method= {RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody JSONObject tester(@RequestBody TestBean test) throws Exception{ 
		
    	JSONObject json = new JSONObject();
    	List<ProtectorTel> listProtect;
    	List<Detail> listDetail;
    	List<TestBean> listTestBean;
    	
    	
		try {
			//보호자 연락쳐 가져오기
			listProtect = service.protectTest(test);
			if(!listProtect.isEmpty()) {
				json.put("protect",listProtect);
				json.put("result","T");
			}
			else {
				json.put("result","null");
			}
			
			//세부사항 정보 가져오기
			listDetail = service.detailTest(test);
			
			if(!listDetail.isEmpty()) {
				json.put("detail",listDetail);
				json.put("result","T");
				System.out.println("성공");
				System.out.println(json);
			}
			else {
				System.out.println("공백");
				json.put("result","null");
			}
			
			////유저 정보 가져오기
			listTestBean = service.userinfo(test);
			
			for (TestBean testBean : listTestBean) {
				json.put("userNum", testBean.getUserNum());
				json.put("email", testBean.getEmail());
				json.put("password", testBean.getPassword());
				json.put("name", testBean.getName());
				json.put("phone", testBean.getPhone());
				json.put("birth", testBean.getBirth());
				json.put("hospital", testBean.getHospital());
			}
			
			System.out.println("sms data");
			json.put("result","T");
			
		} catch (Exception e) {
			System.err.println(e);
			//e.printStackTrace();
			System.out.println("실패");
			json.put("result","F");
			
		}
		
        return json;
    }
}
