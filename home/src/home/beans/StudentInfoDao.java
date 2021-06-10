package home.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentInfoDao {
	
	//목록 기능 : 학생정보 + 프로필정보
	public List<StudentInfoDto> list() throws Exception{
		Connection con = JdbcUtils.getConnection();
		
		String sql = "select * from "
							+ "student S "
								+ "left outer join student_profile P on S.student_no = P.profile_origin "
							+ "order by S.student_no asc";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		List<StudentInfoDto> list = new ArrayList<>();
		while(rs.next()) {
			StudentInfoDto studentInfoDto = new StudentInfoDto();
			studentInfoDto.setStudentNo(rs.getInt("student_no"));
			studentInfoDto.setStudentName(rs.getString("student_name"));
			studentInfoDto.setStudentEmail(rs.getString("student_email"));
			studentInfoDto.setProfileNo(rs.getInt("profile_no"));
			studentInfoDto.setProfileSaveName(rs.getString("profile_save_name"));
			studentInfoDto.setProfileUploadName(rs.getString("profile_upload_name"));
			studentInfoDto.setProfileContentType(rs.getString("profile_content_type"));
			studentInfoDto.setProfileSize(rs.getLong("profile_size"));
			studentInfoDto.setProfileOrigin(rs.getInt("profile_origin"));
			list.add(studentInfoDto);
		}
		con.close();
		return list;
	}
	
}



