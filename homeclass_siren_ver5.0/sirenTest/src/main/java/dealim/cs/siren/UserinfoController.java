package dealim.cs.siren;

import java.util.List;

import javax.inject.Inject;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dealim.cs.siren.bean.TestBean;
import dealim.cs.siren.sevice.TestService;



@Controller
public class UserinfoController {
	@Inject
	TestService service;
	//사용할 service를 inject(삽입)
	@RequestMapping(value="/userinfo",method = {RequestMethod.GET,RequestMethod.POST})//value는 사이트 주소 /test 입력시 이동
	public @ResponseBody JSONObject tester(@RequestBody TestBean test) throws Exception{
		System.out.println("user info send");
		
		JSONObject json = new JSONObject();
		
		List<TestBean> list;	
		//DB에서 불러온 값은 Model에 담는다.
		try {
			list = service.userinfo(test);
			for (TestBean testBean : list) {
				json.put("userNum", testBean.getUserNum());
				json.put("email", testBean.getEmail());
				json.put("password", testBean.getPassword());
				json.put("name", testBean.getName());
				json.put("phone", testBean.getPhone());
				json.put("birth", testBean.getBirth());
				json.put("hospital", testBean.getHospital());
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}
}
