package dealim.cs.siren.sevice;

import java.util.List;
import dealim.cs.siren.bean.TestBean;
import dealim.cs.siren.bean.DiseaseConnect;
import dealim.cs.siren.bean.MedicineConnect;
import dealim.cs.siren.bean.Detail;
import dealim.cs.siren.bean.ProtectorTel;


public interface TestService {
	public List<TestBean> user_db() throws Exception;
	public void user_insert(TestBean vo) throws Exception;
	public List<TestBean> user_login(TestBean vo) throws Exception;
	public List<TestBean> userinfo(TestBean vo) throws Exception;
	public List<TestBean> emailoverlap(TestBean vo) throws Exception;
	public void userInfoUpdate(TestBean vo) throws Exception;
	public void passwordUpdate(TestBean vo) throws Exception;
	
	//비밀번호 찾기
	public void email_send(TestBean vo) throws Exception;
	public List<TestBean> emailBirthCheak(TestBean vo) throws Exception;
	
	//사용않함
	public List<DiseaseConnect> userDisease(DiseaseConnect vo) throws Exception;
	public List<MedicineConnect> userMedicine(DiseaseConnect vo) throws Exception;
	////
	//디테일
	public List<Detail> detailInfo(Detail vo) throws Exception;
	public void detailUpdate(Detail vo) throws Exception;
	public void detailInsert(Detail vo) throws Exception;
	public void detailDelete(Detail vo) throws Exception;
	public List<Detail> detailTest(TestBean vo) throws Exception;
	
	//// 보호자
	public List<ProtectorTel> protectInfo(ProtectorTel vo) throws Exception;
	public void protectUpdate(ProtectorTel vo) throws Exception;
	public void protectInsert(ProtectorTel vo) throws Exception;
	public void protectDelete(ProtectorTel vo) throws Exception;
	public List<ProtectorTel> protectTest(TestBean vo) throws Exception;
	
}
