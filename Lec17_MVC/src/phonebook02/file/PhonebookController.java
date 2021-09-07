package phonebook02.file;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


// CONTROLLER

// 출력???   입력???  없드아!  <-- Controller 는 사용자 입출력을 하는 곳이 아니다!!!!
public class PhonebookController implements Controller, C, Closeable {

	// 전화번호부 항목 데이터
	private List<PhonebookModel> pbList = new ArrayList<PhonebookModel>();
	
	// 저장할 파일, 디렉토리에 대한 변수
	private static final String DATA_DIR = "data";
	private static final String DATA_FILE = "phonebook.dat";
	private File pbDir;
	private File pbFile;
	
	
	// singleton 
	private static PhonebookController instance = null;
	private PhonebookController() {
		// 프로그램 시작시
		// - 폰북이 저장될 디렉토리가 없으면 새로 생성, 데이터 파일 없으면 생성
		// - 데이터 파일 있으면 읽어 들어와서 데이터 파일 저장 -> List
		// - 프로그램 종료시 List -> 데이터 파일 저장
		// - 필요한 메소드 등이 필요하면 추가로 작성하세요. 단 private 로!

		initFile();
	}

	public static PhonebookController getInstance() {
		if(instance == null) {
			instance = new PhonebookController();
		}
		return instance;
	}

	private void initFile() {
		// 데이터 저장 폴더 생성 (없었다면!)
		pbDir = new File(DATA_DIR);
		if(!pbDir.exists()) {
			if(pbDir.mkdir()) {
				System.out.println("폴더 생성 성공");
			} else {
				System.out.println("폴더 생성 실패");
			}
		} else {
			System.out.println("폴더 존재: " + pbDir.getAbsolutePath());
		}
		
		// 데이터 저장 파일 생성 (없었다면)
		pbFile = new File(pbDir, DATA_FILE);
		if(!pbFile.exists()) {
			System.out.println("데이터 파일 새로 생성");
		} else {			
			System.out.println("데이터 파일 존재 : " + pbFile.getAbsolutePath());
			// 기존에 저장된 파일 데이터 읽어오기
			getDataFromFile();
		}		
	}
	
	private void getDataFromFile() {
		try(
				InputStream in = new FileInputStream(pbFile);
				ObjectInputStream oin = new ObjectInputStream(in);
				){
			pbList = (List<PhonebookModel>)oin.readObject();  // 파일 -> List 읽어오기
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void saveDataToFile() {
		try(
				OutputStream out = new FileOutputStream(pbFile);
				ObjectOutputStream oout = new ObjectOutputStream(out);
				){
			oout.writeObject(pbList);  // List -> 파일 저장
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

	// 전화번호부 등록
	@Override
	public int insert(String name, String phoneNum, String memo) {
		
		int result = 0;   // 리턴할 결괏값
		
		// 매개변수 검증, 이름, 전화번호는 필수!
		if(name == null || name.trim().length() == 0)
			throw new PhonebookException("insert() 이름입력 오류: ", ERR_EMPTY_STRING);
		if(phoneNum == null || phoneNum.trim().length() == 0)
			throw new PhonebookException("insert() 전화번호입력 오류: ", ERR_EMPTY_STRING);
		
		PhonebookModel pb = new PhonebookModel();
		pb.setName(name);
		pb.setPhoneNum(phoneNum);
		pb.setMemo(memo);
		pb.setUid(getMaxUid() + 1); 
		pb.setRegDate(LocalDateTime.now());  // 생성된 현재시간 저장
		
		pbList.add(pb);  // List<> 에 추가
		
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
		saveDataToFile(); // 데이터 파일 저장
		
	}
	
	
	// 컨트롤러에서만 사용하는 메소드는 private 으로 만들자.
	// 현재 데이터 중 가장 큰 uid 값을 찾아서 리턴
	private int getMaxUid() {
		if(pbList.size() == 0) return 0;  // 아무것도 없으면 0
		
		// List<> 의 경우 항상 가장 마지막 요소의 uid 가 최댓값
		return pbList.get(pbList.size() - 1).getUid();
	}
	
	// 특정 uid 를 가진 데이터의 index 값을 알아얀 한다
	private int findIndexByUid(int uid) {
		for(int index = 0; index < pbList.size(); index++) {
			if(pbList.get(index).getUid() == uid) {
				return index;   //  찾았다!
			}
		}
		
		return -1;   // 못찾으면 -1
	}
	

}
