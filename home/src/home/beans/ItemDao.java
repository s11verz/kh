package home.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ItemDao {

	//계정 정보
	public static final String USERNAME = "study";
	public static final String PASSWORD = "study";
	
	//등록 기능
	public void insert(ItemDto itemDto) throws Exception {
		Connection con = JdbcUtils.getConnection();;
		
		String sql = "insert into item values(item_seq.nextval, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, itemDto.getItemName());
		ps.setInt(2, itemDto.getItemPrice());
		ps.execute();
		
		con.close();
	}
	
	//목록 기능
	public List<ItemDto> list() throws Exception {
		Connection con = JdbcUtils.getConnection();;
		
		String sql = "select * from item order by item_no asc";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		List<ItemDto> itemList = new ArrayList<>();
		
		while(rs.next()) {
			ItemDto itemDto = new ItemDto();
			itemDto.setItemNo(rs.getInt("item_no"));
			itemDto.setItemName(rs.getString("item_name"));
			itemDto.setItemPrice(rs.getInt("item_price"));
			
			itemList.add(itemDto);
		}
		
		con.close();
		
		return itemList;
	}
	
	//단일조회 기능
	public ItemDto get(int itemNo) throws Exception {
		Connection con = JdbcUtils.getConnection();;
		
		String sql = "select * from item where item_no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, itemNo);
		ResultSet rs = ps.executeQuery();
		
		//rs ---> dto
		ItemDto itemDto;
		if(rs.next()) {
			itemDto = new ItemDto();
			
			itemDto.setItemNo(rs.getInt("item_no"));
			itemDto.setItemName(rs.getString("item_name"));
			itemDto.setItemPrice(rs.getInt("item_price"));
		}
		else {
			itemDto = null;
		}
		
		con.close();
		
		return itemDto;
	}
	
	//삭제 기능
	public boolean delete(int itemNo) throws Exception {
		Connection con = JdbcUtils.getConnection();;
		
		String sql = "delete item where item_no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, itemNo);
		int count = ps.executeUpdate();
		
		con.close();
		
		return count > 0;
	}
	
	//가격 수정 기능
	public boolean editPrice(ItemDto itemDto) throws Exception {
		Connection con = JdbcUtils.getConnection();;
		
		String sql = "update item set item_price = ? where item_no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, itemDto.getItemPrice());
		ps.setInt(2, itemDto.getItemNo());
		int count = ps.executeUpdate();
		
		con.close();
		
		return count > 0;
	}
	
	//정보 수정 기능
	public boolean edit(ItemDto itemDto) throws Exception {
		Connection con = JdbcUtils.getConnection();;
		
		String sql = "update item set item_name=? , item_price=? where item_no=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, itemDto.getItemName());
		ps.setInt(2, itemDto.getItemPrice());
		ps.setInt(3, itemDto.getItemNo());
		int count = ps.executeUpdate();
		
		con.close();
		
		return count > 0;
	}
	
	//시퀀스 번호 생성 기능
	public int sequence() throws Exception {
		Connection con = JdbcUtils.getConnection();;
		
		String sql = "select item_seq.nextval from dual";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		rs.next();
		int number = rs.getInt(1);
//		int number = rs.getInt("NEXTVAL");
		
		con.close();
		
		return number;
	}
	
	public void insert2(ItemDto itemDto) throws Exception {
		Connection con = JdbcUtils.getConnection();;

		String sql = "insert into item values(?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, itemDto.getItemNo());
		ps.setString(2, itemDto.getItemName());
		ps.setInt(3, itemDto.getItemPrice());
		ps.execute();
		
		con.close();
	}
	
}




