package module;

import beans.ProductDao;

public class Test05 {
	public static void main(String[] args) throws Exception {
		String name="스크류바";
		String type="아이스크림";
		int price=1700;
		String made="2021-02-21";
		String expire="2021-09-02";
		
		ProductDao productDao=new ProductDao();
		productDao.registItem(name,type,price,made,expire);
		
		System.out.println("등록 완료");
		
	}

}
