package quiz.beans;

public class MusicDto {
	private long musicNo;
	private String musicName;
	private String musicArtist;
	private String musicAlbum;
	private long musicPlayCount;
	private long musicLikeCount;
	public MusicDto() {
		super();
	}
	public long getMusicNo() {
		return musicNo;
	}
	public void setMusicNo(long musicNo) {
		this.musicNo = musicNo;
	}
	public String getMusicName() {
		return musicName;
	}
	public void setMusicName(String musicName) {
		this.musicName = musicName;
	}
	public String getMusicArtist() {
		return musicArtist;
	}
	public void setMusicArtist(String musicArtist) {
		this.musicArtist = musicArtist;
	}
	public String getMusicAlbum() {
		return musicAlbum;
	}
	public void setMusicAlbum(String musicAlbum) {
		this.musicAlbum = musicAlbum;
	}
	public long getMusicPlayCount() {
		return musicPlayCount;
	}
	public void setMusicPlayCount(long musicPlayCount) {
		this.musicPlayCount = musicPlayCount;
	}
	public long getMusicLikeCount() {
		return musicLikeCount;
	}
	public void setMusicLikeCount(long musicLikeCount) {
		this.musicLikeCount = musicLikeCount;
	}
	@Override
	public String toString() {
		return "MusicDto [musicNo=" + musicNo + ", musicName=" + musicName + ", musicArtist=" + musicArtist
				+ ", musicAlbum=" + musicAlbum + ", musicPlayCount=" + musicPlayCount + ", musicLikeCount="
				+ musicLikeCount + "]";
	}
	
}