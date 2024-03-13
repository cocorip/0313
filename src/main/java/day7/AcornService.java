package day7;

import java.util.ArrayList;

public class AcornService {
	AcornDAO dao = new AcornDAO();
	//학생정보 가져오기

	
	public ArrayList<Acorn> getMemberListReal(){
		ArrayList<Acorn> list = null;
		list = dao.selectAll();
		return list;
	}
	
	public void registerMember(Acorn acorn) {
		dao.insertMember(acorn);
	}
	
	public Acorn getMember(String id) {
		Acorn acorn = dao.selectOne(id);
		return acorn;
	}
	
	public void modifyMember(String id, String newpw) {
		dao.update(id, newpw);
	}
	
	public void deleteMember(String id) {
		dao.delete(id);
	}
}
