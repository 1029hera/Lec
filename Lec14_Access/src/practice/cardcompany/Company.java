package practice.cardcompany;

public class Company {
	
	static int cnum = 10001;
	
	// 필요한 변수, 메소드, 생성자 정의하기
	public Company() {}
	
	private static Company instance = null;
	public static Company getInstance() {
		if(instance == null) {
			instance = new Company(); //  인스턴스 생성
		}
		return instance;
	}
	
	public Card createCard() {
		Card card = new Card(cnum);
		cnum++;
		return card;
	}
		
} // end class
