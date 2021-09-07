package phonebook02.file;

public class PhonebookException extends RuntimeException implements C {
	
	private int errCode = ERR_GENERIC;
	
	public PhonebookException() {
		super("Phonebook 예외 발생");
	}
	
	public PhonebookException(String msg) {
		super(msg);
	}
	
	public PhonebookException(String msg, int errCode) {
		super(msg);
		this.errCode = errCode;
	}
	
	@Override
	public String getMessage() {
		String msg = "ERR-" + errCode + "]" + ERR_STR[errCode]
				+ " " + super.getMessage(); 
		return msg;
	}

}
