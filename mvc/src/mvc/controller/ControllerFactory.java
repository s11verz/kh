package mvc.controller;

public class ControllerFactory {

	public static Controller create(String uri) {
		switch(uri) {
		case "/product/productList.it":return new ProductListController();
		case "/product/productDetail.it":return new ProductDetailController();
		case "/product/productInsert.it":return new ProductInsertController();
		case "/product/productEdit.it":return new ProductEditController();
		case "/member/memberList.it":return new MemberListController();
		case "/member/memberJoin.it":return new MemberJoinController();
		default: return null;
		}
	}
}
