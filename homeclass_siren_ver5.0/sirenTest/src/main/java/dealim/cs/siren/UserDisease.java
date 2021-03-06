package dealim.cs.siren;

import java.util.List;

import javax.inject.Inject;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dealim.cs.siren.bean.TestBean;
import dealim.cs.siren.bean.DiseaseConnect;
import dealim.cs.siren.bean.MedicineConnect;
import dealim.cs.siren.sevice.TestService;

@Controller
public class UserDisease {
	@Inject
	TestService service;

	@RequestMapping(value = "/diseaseList", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody JSONObject tester(@RequestBody DiseaseConnect test) throws Exception {
		JSONObject json = new JSONObject();
		System.out.println(test.getUserNum());
		List<DiseaseConnect> list;
		List<MedicineConnect> list2;
		int i = 0;

		try {
			list = service.userDisease(test);
			System.out.println("병 리스트 성공");

			if (!list.isEmpty()) {
				for (DiseaseConnect diseaseConnect : list) {
					i++;// 리스트 수만큼 증가
					// 병코드에 있는
					// 약 리스트 받아오기
					list2 = service.userMedicine(diseaseConnect);
					System.out.println("약리스트 성공");
					json.put("medicine" + i, list2);
					// for (MedicineConnect testMedicine : list2) {
					// System.out.println(testMedicine);
					// json.put("userNum", testBean.getUserNum());
					// }

				}
				json.put("result", "T");
				json.put("number", i);
				System.out.println("성공");
				System.out.println(json);
			} else {
				System.out.println("공백");
				json.put("result", "null");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("실패");
			json.put("result", "F");

		}

		return json;
	}
}
