package dealim.cs.siren.sevice;

import java.util.List;
import dealim.cs.siren.bean.TestBean;


public interface TestService {
	public List<TestBean> user_db() throws Exception;
	public void user_insert(TestBean vo) throws Exception;
	public List<TestBean> user_login(TestBean vo) throws Exception;
	public List<TestBean> userinfo(TestBean vo) throws Exception;
	public List<TestBean> emailoverlap(TestBean vo) throws Exception;
	public void update_detail(TestBean vo) throws Exception;
}
