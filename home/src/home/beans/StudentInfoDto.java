package home.beans;

public class StudentInfoDto {
	private int studentNo;
	private String studentName;
	private String studentEmail;
	
	private int profileNo;
	private String profileUploadName;
	private String profileSaveName;
	private String profileContentType;
	private long profileSize;
	private int profileOrigin;
	
	public int getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentEmail() {
		return studentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	public int getProfileNo() {
		return profileNo;
	}
	public void setProfileNo(int profileNo) {
		this.profileNo = profileNo;
	}
	public String getProfileUploadName() {
		return profileUploadName;
	}
	public void setProfileUploadName(String profileUploadName) {
		this.profileUploadName = profileUploadName;
	}
	public String getProfileSaveName() {
		return profileSaveName;
	}
	public void setProfileSaveName(String profileSaveName) {
		this.profileSaveName = profileSaveName;
	}
	public String getProfileContentType() {
		return profileContentType;
	}
	public void setProfileContentType(String profileContentType) {
		this.profileContentType = profileContentType;
	}
	public long getProfileSize() {
		return profileSize;
	}
	public void setProfileSize(long profileSize) {
		this.profileSize = profileSize;
	}
	public int getProfileOrigin() {
		return profileOrigin;
	}
	public void setProfileOrigin(int profileOrigin) {
		this.profileOrigin = profileOrigin;
	}
	public StudentInfoDto() {
		super();
	}
}