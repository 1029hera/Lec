package inventory.file;

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


public class InventoryController implements Controller, C, Closeable {
	
	private List<InventoryModel> ivList = new ArrayList<InventoryModel>();
	
	// 저장할 파일, 디렉토리에 대한 변수
	private static final String DATA_DIR = "data";
	private static final String DATA_FILE = "inventory.dat";
	private File ivDir;
	private File ivFile;
	
	private static InventoryController instance = null;
	private InventoryController() {
		initFile();
	}
	
	public static InventoryController getInstance() {
		if(instance == null) {
			instance = new InventoryController();
		}
		return instance;
	}
	
	private void initFile() {
		// 데이터 저장 폴더 생성 (없었다면!)
		ivDir = new File(DATA_DIR);
		if(!ivDir.exists()) {
			if(ivDir.mkdir()) {
				System.out.println("폴더 생성 성공");
			} else {
				System.out.println("폴더 생성 실패");
			}
		} else {
			System.out.println("폴더 존재: " + ivDir.getAbsolutePath());
		}
		
		// 데이터 저장 파일 생성 (없었다면)
		ivFile = new File(ivDir, DATA_FILE);
		if(!ivFile.exists()) {
			System.out.println("데이터 파일 새로 생성");
		} else {			
			System.out.println("데이터 파일 존재 : " + ivFile.getAbsolutePath());
			// 기존에 저장된 파일 데이터 읽어오기
			getDataFromFile();
		}		
	}
	
	private void getDataFromFile() {
		try(
				InputStream in = new FileInputStream(ivFile);
				ObjectInputStream oin = new ObjectInputStream(in);
				){
			ivList = (List<InventoryModel>)oin.readObject();  // 파일 -> List 읽어오기
			
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
				OutputStream out = new FileOutputStream(ivFile);
				ObjectOutputStream oout = new ObjectOutputStream(out);
				){
			oout.writeObject(ivList);  // List -> 파일 저장
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	// 상품 등록
	@Override
	public int insert(String name, int price, int stock) {
		int result = 0; 
		
		if(name == null || name.trim().length() == 0)
			throw new InventoryException("insert() 이름 입력 오류: ", ERR_EMPTY_STRING);
		if(price < 0)
			throw new InventoryException("insert() 상품 가격 입력 오류: ", ERR_MINUS_INT);
		
		InventoryModel iv = new InventoryModel();
		iv.setId(getMaxId() + 1);
		iv.setName(name);
		iv.setPrice(price);
		iv.setStock(stock);
		iv.setRegDate(LocalDateTime.now());
		
		ivList.add(iv);
		
		result = 1;
		
		return result;
	}
	
	// 상품 열람
	@Override
	public List<InventoryModel> selectAll() {
		return ivList;
	}
	
	// 특정 id의 상품 데이터 검색
	@Override
	public InventoryModel selectById(int id) {
		InventoryModel iv = null;
		
		for (int i = 0; i < ivList.size(); i++) {
			iv = ivList.get(i);
			if(iv.getId() == id) return iv;
		}
		
		throw new InventoryException("존재하지 않는 상품번호: " + id, ERR_INVALID_ID);
	}
	
	// 상품 정보 갱신
	@Override
	public int update(int id, String name, int price, int stock) {
		int result = ERR_GENERIC;
		
		if (id < 1)
			throw new InventoryException("update() 상품번호 오류: " + id, ERR_INVALID_ID);
		if (name == null || name.trim().length() == 0)
			throw new InventoryException("update() 이름입력 오류: ", ERR_EMPTY_STRING);
		if (price < 0)
			throw new InventoryException("update() 전화번호입력 오류: ", ERR_MINUS_INT);
		
		int index = findIndexById(id);
		if(index < 0) 
			throw new InventoryException("update() 존재하지 않는 상품번호 : " + id, ERR_INVALID_ID);
		
		InventoryModel iv = ivList.get(index);
		iv.setName(name);
		iv.setPrice(price);
		iv.setStock(stock);
		result = 1;
		
		return result;
	}
	
	// 상품 삭제
	@Override
	public int delete(int id) {
		int result = ERR_GENERIC; 
		
		if (id < 1)
			throw new InventoryException("update() 상품번호 오류: " + id, ERR_INVALID_ID);
		
		int index = findIndexById(id);
		if(index < 0)
			throw new InventoryException("update() 존재하지 않는 상품번호 : " + id, ERR_INVALID_ID);
		
		ivList.remove(index);
		result = 1;
			
		return result;	
	}
	
	@Override
	public void close() throws IOException {
		saveDataToFile(); // 데이터 파일 저장
	}
	
	private int getMaxId() {
		if(ivList.size() == 0) return 0;
		return ivList.get(ivList.size() - 1).getId();
	}
	
	private int findIndexById(int id) {
		for (int i = 0; i < ivList.size(); i++) {
			if(ivList.get(i).getId() == id) return i;
		}
		return -1;
	}

}
