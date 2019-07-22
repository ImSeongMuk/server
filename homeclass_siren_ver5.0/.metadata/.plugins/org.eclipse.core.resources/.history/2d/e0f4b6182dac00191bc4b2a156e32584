package dealim.cs.siren.sevice;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import dealim.cs.siren.DAO.TestDAO;
import dealim.cs.siren.bean.DiseaseConnect;
import dealim.cs.siren.bean.TestBean;



@Service

public class TestServiceImpl implements TestService {

	@Inject
	private TestDAO dao;
	
	@Override
	public List<TestBean> user_db() throws Exception {
		// TODO Auto-generated method stub
		return dao.user_db();

	}

	@Override
	public void user_insert(TestBean vo) throws Exception{
		// TODO Auto-generated method stub
		dao.user_insert(vo);
	}

	@Override
	public List<TestBean> user_login(TestBean vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.user_login(vo);
	}

	@Override
	public List<TestBean> userinfo(TestBean vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.userinfo(vo);
	}

	@Override
	public List<TestBean> emailoverlap(TestBean vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.emailoverlap(vo);
	}

	@Override
	public void update_detail(TestBean vo) throws Exception {
		// TODO Auto-generated method stub
		dao.update_detail(vo);
	}

	@Override
	public void email_send(TestBean vo) throws Exception {
		// TODO Auto-generated method stub
		dao.email_send(vo);
	}

	@Override
	public List<DiseaseConnect> userDisease(DiseaseConnect vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.userDisease(vo);
	}

	
	
}
