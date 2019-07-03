package dealim.cs.siren;

import dealim.cs.siren.bean.TestBean;
import dealim.cs.siren.sevice.TestService;

import java.util.List;

import javax.inject.Inject;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class JsonController {
	@Inject
	TestService service;
	
	@RequestMapping(value = "/json", method = {RequestMethod.POST, RequestMethod.GET})
	public String test(Model model) throws Exception {	
		System.out.println("Ω««‡¡ﬂ");
		List<TestBean> list;	
		JSONObject json = new JSONObject();
		System.out.println(json);
	try{
		list = service.user_db();
		for (TestBean testBean : list) {
			json.put("userid", testBean.getEmail());
			json.put("user_password", testBean.getUser_password());
		}
		
			
	}catch(Exception e){
		e.printStackTrace();
	}
	model.addAttribute("json",json);
	System.out.println(json);
	return "/json";
}
}
