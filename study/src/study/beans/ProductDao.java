package study.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
	
	//사용자 계정
	public static final String USERNAME = "study", PASSWORD = "study";

	//등록 기능
	public void registItem(ProductDto productDto) throws Exception {
		Connection con = JdbcUtils.getConnection(USERNAME, PASSWORD);
		
		String sql = "insert into product values(product_seq.nextval, ?, ?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, productDto.getName());
		ps.setString(2, productDto.getType());
		ps.setInt(3, productDto.getPrice());
		ps.setString(4, productDto.getMade());
		ps.setString(5, productDto.getExpire());
		ps.execute();
		
		con.close();
	}
	
	//목록 기능
	public List<ProductDto> list() throws Exception {
		Connection con = JdbcUtils.getConnection(USERNAME, PASSWORD);
		
		String sql = "select * from product order by no asc";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		//List로 변환
		List<ProductDto> productList = new ArrayList<>();
		while(rs.next()) {
			ProductDto productDto = new ProductDto();
			productDto.setNo(rs.getInt("no"));
			productDto.setName(rs.getString("name"));
			productDto.setType(rs.getString("type"));
			productDto.setPrice(rs.getInt("price"));
			productDto.setMade(rs.getString("made"));
			productDto.setExpire(rs.getString("expire"));
			
			productList.add(productDto);
		}
		
		con.close();
		
		return productList;
	}
	
	//구간조회 기능
	public List<ProductDto> rank(int begin, int end) throws Exception {
		Connection con = JdbcUtils.getConnection(USERNAME, PASSWORD);
		
		String sql = "select * from ("
							+ "select rownum rn, TMP.* from ("
								+ "select * from product order by price desc, no asc"
							+ ") TMP"
						+ ") where rn between ? and ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, begin);
		ps.setInt(2, end);
		ResultSet rs = ps.executeQuery();
		
		//List로 변환
		List<ProductDto> productList = new ArrayList<>();
		while(rs.next()) {
			ProductDto productDto = new ProductDto();
			productDto.setNo(rs.getInt("no"));
			productDto.setName(rs.getString("name"));
			productDto.setType(rs.getString("type"));
			productDto.setPrice(rs.getInt("price"));
			productDto.setMade(rs.getString("made"));
			productDto.setExpire(rs.getString("expire"));
			
			productList.add(productDto);
		}
		
		con.close();
		
		return productList;
	}
	
	//검색 기능
	public List<ProductDto> search(String type, String keyword) throws Exception {
		Connection con = JdbcUtils.getConnection(USERNAME, PASSWORD);
		
		String sql = "select * from product where instr(#1, ?) > 0 order by #1 asc";
		sql = sql.replace("#1", type);
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, keyword);
		ResultSet rs = ps.executeQuery();
		
		//List로 변환
		List<ProductDto> productList = new ArrayList<>();
		while(rs.next()) {
			ProductDto productDto = new ProductDto();
			productDto.setNo(rs.getInt("no"));
			productDto.setName(rs.getString("name"));
			productDto.setType(rs.getString("type"));
			productDto.setPrice(rs.getInt("price"));
			productDto.setMade(rs.getString("made"));
			productDto.setExpire(rs.getString("expire"));
			
			productList.add(productDto);
		}
		
		con.close();
		
		return productList;
	}
	public ProductDto get(int no) throws Exception {
		Connection con = JdbcUtils.getConnection(USERNAME, PASSWORD);
		
		String sql = "select * from product where no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, no);
		ResultSet rs = ps.executeQuery();
		
		//rs ---> dto
		ProductDto productDto;
		if(rs.next()) {
			productDto = new ProductDto();
			
			productDto.setNo(rs.getInt("no"));
			productDto.setName(rs.getString("name"));
			productDto.setType(rs.getString("type"));
			productDto.setPrice(rs.getInt("price"));
			productDto.setMade(rs.getString("made"));
			productDto.setExpire(rs.getString("expire"));
		}
		else {
			productDto = null;
		}
		
		con.close();
		
		return productDto;
	}
	public boolean delete(int no) throws Exception{
		Connection con=JdbcUtils.getConnection(USERNAME, PASSWORD);
		
		String sql="delete product where no=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1,no);
		int count=ps.executeUpdate();
		
		con.close();
		return count>0;
	}
	
}














