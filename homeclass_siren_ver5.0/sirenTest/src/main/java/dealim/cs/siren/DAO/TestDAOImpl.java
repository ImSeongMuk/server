package dealim.cs.siren.DAO;

import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import dealim.cs.siren.bean.DiseaseConnect;
import dealim.cs.siren.bean.MedicineConnect;
import dealim.cs.siren.bean.ProtectorTel;
import dealim.cs.siren.bean.TestBean;
import dealim.cs.siren.bean.Detail;

@Repository//DAO를 스프링에 인식 시킴 //DAO라고 명시 (DAO를 스프링에서 인식시켜줌)
public class TestDAOImpl implements TestDAO{//사용할 *Mapper.xml의 namespace명
	private static final String namespace="dealim.cs.siren.mappers.testMapper";
	
	@Inject//DB커넥션과 클로즈를 자동으로 해주는 SqlSession // 의존관계를 자동으로 연결(JAVA에서 제공) ==@autowired (Spring에서 제공)
	private SqlSession sqlSession;
	
	@Override
	public List<TestBean> user_db() throws Exception {//*Mapper.xml 쿼리문의 id
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".user_db");
		//row가 1개 이상인 select문을 구동시키는 메소드
	}
    //memberMapper.xml의 namespace값
	@Override
	public void user_insert(TestBean vo) throws Exception{
		// TODO Auto-generated method stub
		 sqlSession.insert(namespace+".user_insert", vo);
	}
	@Override
	public List<TestBean> user_login(TestBean vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".user_login",vo);
	}
	@Override
	public List<TestBean> userinfo(TestBean vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".userinfo",vo);
	}
	@Override
	public List<TestBean> emailoverlap(TestBean vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".emailoverlap",vo);
	}
	@Override
	public void update_detail(TestBean vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(namespace+".update_detail", vo);
	}
	@Override
	public void email_send(TestBean vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(namespace+".email_send", vo);
		
	}
	@Override
	public List<DiseaseConnect> userDisease(DiseaseConnect vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".userDisease", vo);
	}
	@Override
	public List<MedicineConnect> userMedicine(DiseaseConnect vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".userMedicine", vo);
	}
	@Override
	public List<Detail> detailInfo(Detail vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".detailInfo", vo);
	}
	@Override
	public void detailUpdate(Detail vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(namespace+".detailUpdate", vo);
	}
	@Override
	public void detailInsert(Detail vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace+".detailInsert", vo);
	}
	@Override
	public void detailDelete(Detail vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace+".detailDelete", vo);
	}
	@Override
	public List<ProtectorTel> protectInfo(ProtectorTel vo) throws Exception {
		return sqlSession.selectList(namespace+".protectInfo", vo);
	}
	@Override
	public void protectUpdate(ProtectorTel vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(namespace+".protectUpdate", vo);
	}
	@Override
	public void protectInsert(ProtectorTel vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace+".protectInsert", vo);
	}
	@Override
	public void protectDelete(ProtectorTel vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace+".protectDelete", vo);
	}
	
	
}
