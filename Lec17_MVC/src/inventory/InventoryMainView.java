package inventory;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InventoryMainView implements C {
	private Scanner sc;
	private InventoryController ivCtrl;
	
	public static void main(String[] args) {
		InventoryMainView app = new InventoryMainView();
		
		app.init(); // 초기화
		app.run(); // 실행
		app.exit(); // 종료

	} // end main

	// 응용프로그램 초기화
	private void init() {
		sc = new Scanner(System.in);
		ivCtrl = InventoryController.getInstance();
		
	} // end init()

	// 응용프로그램 실행 (구동)
	private void run() {
		while(true) {
			showList();
			
			try {
				int menu = sc.nextInt();
				sc.nextLine();
				
				switch(menu) {
				case MENU_INSERT:
					insertInventory();
					break;
				case MENU_LIST:
					listInventory();
					break;
				case MENU_UPDATE:
					updateInventory();
					break;
				case MENU_DELETE:
					deleteInventory();
					break;
				case MENU_QUIT: 
					ivCtrl.close();
					System.out.println("프로그램을 종료합니다.");
					return;
				default:
					System.out.println("잘못 입력하셨습니다.");
				} // end switch	
			} catch (InventoryException ex) {
				System.out.println(ex.getMessage());
			} catch (InputMismatchException e) {
				System.out.println("잘못 입력하셨습니다.");
				sc.nextLine();
			} catch (IOException e) {
				e.printStackTrace();
			} // end try-catch
			
		} // end while
		
	} // end run()

	private void insertInventory() {
		System.out.println("-- 등록 메뉴 --");
		System.out.print("상품명 입력: ");
		String name = sc.nextLine();
		
		System.out.print("상품 가격 입력: ");
		int price = sc.nextInt();
		
		System.out.print("재고 입력: ");
		int stock = sc.nextInt();
		
		int result = ivCtrl.insert(name, price, stock);
		System.out.println(result + "개의 상품 정보 등록 성공");
	}
	
	private void listInventory() {
		List<InventoryModel> list = ivCtrl.selectAll();
		
		System.out.println("총 " + list.size() + "개의 데이터 출력");
		for(InventoryModel m : list) {
			System.out.println(m);
		}
		
	}

	private void updateInventory() {
		System.out.println("-- 수정 메뉴 --");
		System.out.print("수정할 상품번호 입력: ");
		int id = sc.nextInt();
		sc.nextLine();
		
		ivCtrl.selectById(id);
		
		System.out.print("상품명 입력: ");
		String name = sc.nextLine();
		
		System.out.print("상품 가격 입력: ");
		int price = sc.nextInt();
		
		System.out.print("재고 입력: ");
		int stock = sc.nextInt();
		
		int result = ivCtrl.update(id, name, price, stock);
		System.out.println(result + " 개의 상품 수정 성공");
		
	}

	private void deleteInventory() {
		System.out.println("--- 삭제 메뉴 ---");	
		System.out.println("삭제할 상품번호 입력:");
		int id = sc.nextInt();
		sc.nextLine();
		
		ivCtrl.selectById(id);
		
		int result = ivCtrl.delete(id);
		System.out.println(result + " 개의 상품 삭제 성공");
		
	}

	private void exit() {
		sc.close();
	} // end exit
	
	// 상품목록 보여주기
	public void showList() {
		System.out.println();
		System.out.println("상품정보 관리 프로그램");
		System.out.println("---------------");
		System.out.println(" [1] 등록");
		System.out.println(" [2] 열람");
		System.out.println(" [3] 수정");
		System.out.println(" [4] 삭제");
		System.out.println(" [0] 종료");
		System.out.println("---------------");
		System.out.print("선택: ");
	}

}
