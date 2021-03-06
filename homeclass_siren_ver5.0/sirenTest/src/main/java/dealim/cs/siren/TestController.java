package dealim.cs.siren;

import java.util.List;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dealim.cs.siren.bean.TestBean;
import dealim.cs.siren.sevice.TestService;



@Controller
public class TestController {
	@Inject
	TestService service;
	//사용할 service를 inject(삽입)
	@RequestMapping(value="/test",method = RequestMethod.GET)//value는 사이트 주소 /test 입력시 이동
	public String test(Model model) throws Exception {
		System.out.println("가나");
		List<TestBean> list;		
		list = service.user_db();	
		model.addAttribute("list",list);	
		//DB에서 불러온 값은 Model에 담는다.
		return "/test";
	}

}
