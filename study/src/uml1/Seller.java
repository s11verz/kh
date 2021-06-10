package uml1;
//휴대폰 판매기
public class Seller {
	
	//아이폰 판매기능
	public IPhone12 sell1(int money) {
		IPhone12 phone = new IPhone12();
		return phone;
	}
	
	//갤럭시 판매기능
	public Galaxy21s sell2(int money) {
		Galaxy21s phone = new Galaxy21s();
		return phone;
	}
	
}