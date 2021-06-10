package home.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentProfileDao {

	public void insert(StudentProfileDto studentProfileDto) throws Exception {
		Connection con = JdbcUtils.getConnection();
		
		String sql = "insert into student_profile values(student_profile_seq.nextval, ?, ?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, studentProfileDto.getProfileUploadName());
		ps.setString(2, studentProfileDto.getProfileSaveName());
		ps.setString(3, studentProfileDto.getProfileContentType());
		ps.setLong(4, studentProfileDto.getProfileSize());
		ps.setInt(5, studentProfileDto.getProfileOrigin());
		ps.execute();
		
		con.close();
	}
	
	//단일 조회 : profileNo, profileOrigin
	public StudentProfileDto getByProfileNo(int profileNo) throws Exception {
		Connection con = JdbcUtils.getConnection();
		
		String sql = "select * from student_profile where profile_no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, profileNo);
		ResultSet rs = ps.executeQuery();
		
		StudentProfileDto studentProfileDto;
		if(rs.next()) {
			studentProfileDto = new StudentProfileDto();
			studentProfileDto.setProfileNo(rs.getInt("profile_no"));
			studentProfileDto.setProfileUploadName(rs.getString("profile_upload_name"));
			studentProfileDto.setProfileSaveName(rs.getString("profile_save_name"));
			studentProfileDto.setProfileContentType(rs.getString("profile_content_type"));
			studentProfileDto.setProfileSize(rs.getLong("profile_size"));
			studentProfileDto.setProfileOrigin(rs.getInt("profile_origin"));
		}
		else {
			studentProfileDto = null;
		}
		
		con.close();
		return studentProfileDto;
	}
	
	public StudentProfileDto getByProfileOrigin(int profileOrigin) throws Exception {
		Connection con = JdbcUtils.getConnection();
		
		String sql = "select * from student_profile where profile_origin = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, profileOrigin);
		ResultSet rs = ps.executeQuery();
		
		StudentProfileDto studentProfileDto;
		if(rs.next()) {
			studentProfileDto = new StudentProfileDto();
			studentProfileDto.setProfileNo(rs.getInt("profile_no"));
			studentProfileDto.setProfileUploadName(rs.getString("profile_upload_name"));
			studentProfileDto.setProfileSaveName(rs.getString("profile_save_name"));
			studentProfileDto.setProfileContentType(rs.getString("profile_content_type"));
			studentProfileDto.setProfileSize(rs.getLong("profile_size"));
			studentProfileDto.setProfileOrigin(rs.getInt("profile_origin"));
		}
		else {
			studentProfileDto = null;
		}
		
		con.close();
		return studentProfileDto;
	}
	
}


