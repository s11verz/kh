package beans;

public class MusicDto {

	private int no;
	private String name;
	private String artist;
	private String album;
	private int play_count;
	private int like_count;
	
	public MusicDto() {
		super();
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public int getPlay_count() {
		return play_count;
	}

	public void setPlay_count(int play_count) {
		this.play_count = play_count;
	}

	public int getLike_count() {
		return like_count;
	}

	public void setLike_count(int like_count) {
		this.like_count = like_count;
	}
	
}
