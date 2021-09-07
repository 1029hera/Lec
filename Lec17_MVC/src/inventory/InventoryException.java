package inventory;

public class InventoryException extends RuntimeException implements C {
	
	private int errCode = ERR_GENERIC;
	
	public InventoryException() {
		super("Inventory 예외 발생");
	}
	
	public InventoryException(String msg) {
		super(msg);
	}
	
	public InventoryException(String msg, int errCode) {
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
