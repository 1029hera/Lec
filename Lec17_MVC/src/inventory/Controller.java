package inventory;

import java.util.List;


public interface Controller {
	public abstract int insert(String name, int price, int stock);
	public abstract List<InventoryModel> selectAll();
	public abstract InventoryModel selectById(int id);
	public abstract int update(int id, String name, int price, int stock);
	public abstract int delete(int id);
}
