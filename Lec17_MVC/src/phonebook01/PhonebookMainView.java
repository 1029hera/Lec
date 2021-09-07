package phonebook01;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

// VIEW
// 사용자와의 입출력 / 사용자와의 인터페이스
public class PhonebookMainView implements C {
	
	private Scanner sc;
	private PhonebookController pbCtrl; // Controller

	public static void main(String[] args) {
		PhonebookMainView app = new PhonebookMainView();
		
		app.init(); // 초기화
		app.run(); // 실행
		app.exit(); // 종료
		
	} // end main

	// 응용프로그램 초기화
	private void init() {
		sc = new Scanner(System.in);
		pbCtrl = PhonebookController.getInstance();
		
	} // end init()
	
	// 응용프로그램 실행 (구동)
	private void run() {
		System.out.println(VERSION);
		while(true) {
			showMenu();
			
			try {
				int menu = sc.nextInt();
				sc.nextLine();

				switch(menu) {
				case MENU_INSERT:
					insertPhonebook();
					break;
				case MENU_LIST:
					listPhonebook();
					break;
				case MENU_UPDATE:
					updatePhonebook();
					break;
				case MENU_DELETE:
					deletePhonebook();
					break;
				case MENU_QUIT: 
					pbCtrl.close();
					System.out.println("프로그램을 종료합니다.");
					return;
				default:
					System.out.println("잘못 입력하셨습니다.");
				} // end switch
			} catch(PhonebookException ex) {
				System.out.println(ex.getMessage());
			} catch (InputMismatchException e) {
				System.out.println("잘못 입력하셨습니다.");
				sc.nextLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} // end while
		
	} // end run()
	
	private void insertPhonebook() {
		
		// VIEW의 역할  : 사용자 입출력
		System.out.println("-- 입력 메뉴 --");
		System.out.print("이름 입력: ");
		String name = sc.nextLine();
		
		System.out.print("전화번호 입력: ");
		String phoneNum = sc.nextLine();
		
		System.out.print("메모 입력: ");
		String memo = sc.nextLine();
		
		// CONTROLLER에 연결 (인터페이스로 연결된다)
		int result = pbCtrl.insert(name, phoneNum, memo);
		System.out.println(result + " 개의 전화번호 입력 성공");
		
	}
	
	private void listPhonebook() {
		
		// CONTROLLER
		List<PhonebookModel> list = pbCtrl.selectAll();
		
		// VIEW
		System.out.println("총" + list.size() + "명의 데이터 출력");
		for(PhonebookModel m : list) {
			System.out.println(m);
		}
	}
	
	private void updatePhonebook() {
		// VIEW
		System.out.println("-- 수정 메뉴 --");
		System.out.print("수정할 번호 입력: ");
		int uid = sc.nextInt();
		sc.nextLine();
		
		// CONTROLLER
		pbCtrl.selectByUid(uid);
		
		// VIEW
		System.out.print("이름 입력: ");
		String name = sc.nextLine();
		
		System.out.print("전화번호 입력:");
		String phoneNum = sc.nextLine();
		
		System.out.print("메모 입력:");
		String memo = sc.nextLine();
		
		// CONTROLLER
		int result = pbCtrl.update(uid, name, phoneNum, memo);
		System.out.println(result + " 개의 전화번호 수정 성공");
	}

	private void deletePhonebook() {
		// VIEW 의 역할 : 사용자 입출력
		System.out.println("--- 삭제 메뉴 ---");
		
		System.out.println("삭제할 번호 입력:");
		int uid = sc.nextInt();
		sc.nextLine();
		
		// CONTROLLER 에 연결  (인터페이스 로 연결된다)
		pbCtrl.selectByUid(uid);

		int result = pbCtrl.delete(uid);
		System.out.println(result + " 개의 전화번호 삭제 성공");
		
	}


	// 응용프로그램 종료
	private void exit() {
		sc.close();
	} // end exit()
	
	// 메뉴 보여주기
	public void showMenu() {
		System.out.println();
		System.out.println("전화번호부 프로그램");
		System.out.println("---------------");
		System.out.println(" [1] 입력");
		System.out.println(" [2] 열람");
		System.out.println(" [3] 수정");
		System.out.println(" [4] 삭제");
		System.out.println(" [0] 종료");
		System.out.println("---------------");
		System.out.print("선택: ");
		
	} // end showMenu()

} // end VIEW
