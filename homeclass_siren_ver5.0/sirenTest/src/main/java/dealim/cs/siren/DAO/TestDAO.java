package dealim.cs.siren.DAO;

import java.util.List;
import dealim.cs.siren.bean.TestBean;
import dealim.cs.siren.bean.DiseaseConnect;

public interface TestDAO {
	public List<TestBean> user_db() throws Exception;
	public void user_insert(TestBean vo) throws Exception;
	public List<TestBean> user_login(TestBean vo) throws Exception;
	public List<TestBean> userinfo(TestBean vo) throws Exception;
	public List<TestBean> emailoverlap(TestBean vo) throws Exception;
	public void update_detail(TestBean vo) throws Exception;
	public void email_send(TestBean vo) throws Exception;
	public List<DiseaseConnect> userDisease(DiseaseConnect vo) throws Exception;
}

//TestDAO �������̽����� DB���� ������� �޼ҵ���� �Է����ݴϴ�.
//��ȯ �Ǵ� DB���� ���� row�̱� ������ List<E>�� ���ϰ����� �������ݴϴ�.
//<E>�� ��ü�� ������� Bean�� import�ؼ� �־��ݴϴ�.