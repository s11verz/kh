package home.servlet.student;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import home.beans.StudentDao;
import home.beans.StudentDto;
import home.beans.StudentProfileDao;
import home.beans.StudentProfileDto;

@WebServlet(urlPatterns = "/student/studentInsert.kh")
public class StudentInsertServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
//			1. 기존 방식으로 데이터 수신이 가능한지 확인 -> 사용 불가능
//			String studentName = req.getParameter("studentName");
//			String studentEmail = req.getParameter("studentEmail");
//			String studentProfile = req.getParameter("studentProfile");
//			
//			System.out.println("studentName = " + studentName);
//			System.out.println("studentEmail = " + studentEmail);
//			System.out.println("studentProfile = " + studentProfile);
			
//			2. 라이브러리를 이용해서 multipart/form-data 방식의 요청을 해석
//			= multipart/form-data 방식은 기본적으로 "파일"이 전송된다고 봐야 한다
//			= 따라서, 파일을 저장할 위치와 기본 설정들을 미리 정해야 한다.
//			= 만약 이름이 겹칠 경우에 어떻게 처리할지도 설정할 수 있다.
			
//			String path = "C:/Users/user1";
			String path = "/Users/silverz/git/upload";
			int maximumSize = 10 * 1024 * 1024;
			String encoding = "UTF-8";
			DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
			
//			= 위의 설정값들을 이용해서 해석기를 생성하면 "파일 저장"까지 자동으로 수행해준다
//			MultipartRequest mRequest = new MultipartRequest(req, path, maximumSize, encoding);
			MultipartRequest mRequest = new MultipartRequest(req, path, maximumSize, encoding, policy);
			
//			해야할 일 : 사용자가 보낸 정보(studentName, studentEmail)와 업로드된 파일의 정보를 추출하여 DB에 저장
//			= 기존 파라미터는 동일한 명령으로 수신 가능
//			= 파일 정보는 수신 명령이 다름
			
//			String studentName = mRequest.getParameter("studentName");
//			String studentEmail = mRequest.getParameter("studentEmail");
//			
//			String fileSystemName = mRequest.getFilesystemName("studentProfile");//실제 저장된 이름
//			String fileOriginalName = mRequest.getOriginalFileName("studentProfile");//업로드한 이름
//			String fileContentType = mRequest.getContentType("studentProfile");//파일의 유형
//			File file = mRequest.getFile("studentProfile");//저장된 파일 객체
//			if(file != null) {
//				long fileSize = file.length();
//			}
			
//			받아서 데이터베이스에 저장
			
//			학생 정보 등록
			StudentDto studentDto = new StudentDto();
			studentDto.setStudentName(mRequest.getParameter("studentName"));
			studentDto.setStudentEmail(mRequest.getParameter("studentEmail"));
			
			StudentDao studentDao = new StudentDao();
			int studentNo = studentDao.getSequence();
			studentDto.setStudentNo(studentNo);
			
			studentDao.insert(studentDto);
			
//			학생 프로필 정보 등록(있으면)
			File file = mRequest.getFile("studentProfile");
			if(file != null) {
				StudentProfileDto studentProfileDto = new StudentProfileDto();
				studentProfileDto.setProfileSaveName(mRequest.getFilesystemName("studentProfile"));
				studentProfileDto.setProfileUploadName(mRequest.getOriginalFileName("studentProfile"));
				studentProfileDto.setProfileContentType(mRequest.getContentType("studentProfile"));
				studentProfileDto.setProfileSize(file.length());
				studentProfileDto.setProfileOrigin(studentNo);
				
				StudentProfileDao studentProfileDao = new StudentProfileDao();
				studentProfileDao.insert(studentProfileDto);
			}
			
			//출력
			resp.sendRedirect("studentInsertComplete.jsp");
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
