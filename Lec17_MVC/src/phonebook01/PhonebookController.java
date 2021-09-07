package phonebook01;

import java.io.Closeable;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// CONTROLLER

// 출력?? 입력?? 없음! <-- Controller 는 사용자 입출력을 하는 곳이 아니다!!
public class PhonebookController implements Controller, C, Closeable {

	// 전화번호부 항목 데이터
	private List<PhonebookModel> pbList = new ArrayList<PhonebookModel>();
	
	// singleton
	private static PhonebookController instance = null;
	private PhonebookController() {}
	public static PhonebookController getInstance() {
		if(instance == null) {
			instance = new PhonebookController();
		}
		return instance;
	}
	
	// 전화번호부 등록
	@Override
	public int insert(String name, String phoneNum, String memo) {

		int result = 0; // 리턴할 결과값
		
		// 매개변수 검증, 이름, 전화번호는 필수!
		if(name == null || name.trim().length() == 0)
			throw new PhonebookException("insert() 이름 입력 오류: ", ERR_EMPTY_STRING);
		if(phoneNum == null || phoneNum.trim().length() == 0)
			throw new PhonebookException("insert() 전화번호 입력 오류: ", ERR_EMPTY_STRING);
		
		PhonebookModel pb = new PhonebookModel();
		pb.setName(name);
		pb.setPhoneNum(phoneNum);
		pb.setMemo(memo);
		pb.setUid(getMaxUid() + 1);
		pb.setRegDate(LocalDateTime.now());
		
		pbList.add(pb);
		
		result = 1;
		
		return result;
	}

	// 전화번호부 열람
	@Override
	public List<PhonebookModel> selectAll() {
		return pbList;
	}

	// 특정 uid 의 전화번호부 데이터 검색
	@Override
	public PhonebookModel selectByUid(int uid) {
		PhonebookModel pb = null;
		
		for(int index = 0; index < pbList.size(); index++) {
			pb = pbList.get(index);
			if(pb.getUid() == uid) return pb;
		}

		throw new PhonebookException("존재하지 않는 uid : " + uid, ERR_INVALID_UID);
	}

	// 전화번호부 갱신
	@Override
	public int update(int uid, String name, String phoneNum, String memo) {
		int result = ERR_GENERIC;
		
		// 매개변수 검증
		if (uid < 1)
			throw new PhonebookException("update() uid 오류: " + uid, ERR_INVALID_UID);
		
		// 매개변수 검증 : 이름, 전화번호 필수
		if (name == null || name.trim().length() == 0)
			throw new PhonebookException("update() 이름입력 오류: ", ERR_EMPTY_STRING);
		if (phoneNum == null || phoneNum.trim().length() == 0)
			throw new PhonebookException("update() 전화번호입력 오류: ", ERR_EMPTY_STRING);
		
		int index = findIndexByUid(uid);
		if(index < 0) 
			throw new PhonebookException("update() 존재하지 않는 uid : " + uid, ERR_INVALID_UID);
		
		PhonebookModel pb = pbList.get(index);
		pb.setName(name);
		pb.setPhoneNum(phoneNum);
		pb.setMemo(memo);
		result = 1;
		
		return result;
	}

	// 전화번호부 삭제
	@Override
	public int delete(int uid) {
		int result = ERR_GENERIC; // 리턴할 결과값
		
		// 매개변수 검증
		if (uid < 1)
			throw new PhonebookException("update() uid 오류: " + uid, ERR_INVALID_UID);

		int index = findIndexByUid(uid);  // uid 값을 가진 데이터의 배열 인덱스 찾기
		if(index < 0)
			throw new PhonebookException("update() 존재하지 않는 uid : " + uid, ERR_INVALID_UID);

		pbList.remove(index); // List<> 에서 삭제
		
		result = 1;
		
		return result;
	}
	
	// Controller 종료시 처리할 코드
	@Override
	public void close() throws IOException {
		
		
	}
	
	// 컨트롤러에서만 사용하는 메소든 private 으로 만들자.
	// 현재 데이터 중 가장 큰 uid 값을 찾아서 리턴
	private int getMaxUid() {
		if(pbList.size() == 0) return 0; // 아무것도 없으면 0
		
		// List<>의 경우 항상 가장 마지막 요소의 uid가 최댓값
		return pbList.get(pbList.size() - 1).getUid();
	}
	
	// 특정 uid 를 가진 데이터의 index 값을 알아야 한다.
	private int findIndexByUid(int uid) {
		for(int index = 0; index < pbList.size(); index++) {
			if(pbList.get(index).getUid() == uid) {
				return index; // 찾았다!
			}
		}
		return -1; // 못찾으면 -1
	}

}
