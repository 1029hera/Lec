package inventory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InventoryModel {
	private int id; // 상품고유 일련번호
	private String name; // 상품 이름
	private int price; // 상품 가격
	private int stock; // 상품 재고
	private LocalDateTime regDate; // 상품 등록일

	@Override
	public String toString() {
		return String.format("%d] %s %d원 %d개",
				id, name, price, stock,
				regDate.format(DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss")));
	}
}
