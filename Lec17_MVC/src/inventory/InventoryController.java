package inventory;

import java.io.Closeable;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class InventoryController implements Controller, C, Closeable {
	
	private List<InventoryModel> ivList = new ArrayList<InventoryModel>();
	
	private static InventoryController instance = null;
	private InventoryController() {}
	public static InventoryController getInstance() {
		if(instance == null) {
			instance = new InventoryController();
		}
		return instance;
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
	public void close() throws IOException {}
	
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
