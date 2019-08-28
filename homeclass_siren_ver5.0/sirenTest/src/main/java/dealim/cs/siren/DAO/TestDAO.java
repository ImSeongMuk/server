package dealim.cs.siren.DAO;

import java.util.List;
import dealim.cs.siren.bean.TestBean;
import dealim.cs.siren.bean.DiseaseConnect;
import dealim.cs.siren.bean.MedicineConnect;
import dealim.cs.siren.bean.Detail;
import dealim.cs.siren.bean.ProtectorTel;

public interface TestDAO {
	public List<TestBean> user_db() throws Exception;
	//회원가입
	public void user_insert(TestBean vo) throws Exception;
	public List<TestBean> emailoverlap(TestBean vo) throws Exception;
	//로그인
	public List<TestBean> user_login(TestBean vo) throws Exception;
	//유저 정보
	public List<TestBean> userinfo(TestBean vo) throws Exception;
	//유저정보 업데이트
	public void userInfoUpdate(TestBean vo) throws Exception;
	//비밀번호 업데이트
	public void passwordUpdate(TestBean vo) throws Exception;
	
	//비밀번호 찾기
	public void email_send(TestBean vo) throws Exception;
	public List<TestBean> emailBirthCheak(TestBean vo) throws Exception;
	
	//사용않함
	public List<DiseaseConnect> userDisease(DiseaseConnect vo) throws Exception;
	public List<MedicineConnect> userMedicine(DiseaseConnect vo) throws Exception;
	//
	//디테일 병
	public List<Detail> detailInfo(Detail vo) throws Exception;
	public void detailUpdate(Detail vo) throws Exception; 
	public void detailInsert(Detail vo) throws Exception; 
	public void detailDelete(Detail vo) throws Exception; 
	public List<Detail> detailTest(TestBean vo) throws Exception;
	//보호자
	public List<ProtectorTel> protectInfo(ProtectorTel vo) throws Exception;
	public void protectUpdate(ProtectorTel vo) throws Exception; 
	public void protectInsert(ProtectorTel vo) throws Exception; 
	public void protectDelete(ProtectorTel vo) throws Exception; 
	public List<ProtectorTel> protectTest(TestBean vo) throws Exception;
}

//TestDAO 인터페이스에서 DB값을 출력해줄 메소드명을 입력해줍니다.
//반환 되는 DB값이 여러 row이기 때문에 List<E>를 리턴값으로 지정해줍니다.
//<E>의 객체는 출력해줄 Bean을 import해서 넣어줍니다.