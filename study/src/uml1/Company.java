package uml1;

//회사는 다음 구성요소를 가져야 한다.
//= 판매점(Seller) - 설립 시 생성
//= 판매직원(Person) - 설립 전부터 존재하며 연결만 수행
public class Company {
	
	private Seller seller;
	private Person person;
	
	public Company(Person person) {
		this.seller = new Seller();//판매점은 직접 생성
		this.person = person;//판매사원은 외부에서 연결
	}
	
}