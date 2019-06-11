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
				json.put("email", testBean.getEmail());
				json.put("user_password", testBean.getUser_password());
				json.put("name", testBean.getName());
				json.put("tel", testBean.getTel());
				json.put("date_of_birth", testBean.getDate_of_birth());
				
				json.put("medicine1", testBean.getMedicine1());
				json.put("medicine2", testBean.getMedicine2());
				json.put("medicine3", testBean.getMedicine3());
				json.put("medicine4", testBean.getMedicine4());
				json.put("medicine5", testBean.getMedicine5());
				
				json.put("weight", testBean.getWeight());
				
				json.put("hospital", testBean.getHospital());
				
				json.put("disease2", testBean.getDisease2());
				json.put("disease3", testBean.getDisease3());
				json.put("disease4", testBean.getDisease4());
				json.put("disease5", testBean.getDisease5());
				
				json.put("around1", testBean.getAround1());
				json.put("around2", testBean.getAround2());
				json.put("around3", testBean.getAround3());
				json.put("around4", testBean.getAround4());
				json.put("around5", testBean.getAround5());
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}
}
