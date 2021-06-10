package home.beans;

public class StudentProfileDto {
	private int profileNo;
	private String profileUploadName;
	private String profileSaveName;
	private String profileContentType;
	private long profileSize;
	private int profileOrigin;
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
	public StudentProfileDto() {
		super();
	}
}