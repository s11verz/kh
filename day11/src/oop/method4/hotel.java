package oop.method4;

public class hotel {
	String room;
	int people,off_season,quasi,peak_season;
	int sum, avg;
	
	void setRoom(String room) {
		this.room=room;
	}
	void setPeople(int people) {
		if(people>=2) {
			this.people=people;
		}
	}
	void setOff_season(int off_season) {
		if(off_season>0) {
			this.off_season=off_season;
		}
	}
	void setQuasi(int quasi) {
		if(quasi>0) {
			this.quasi=quasi;
		}
	}
	void setPeak_season(int peak_season) {
		if(peak_season>0) {
			this.peak_season=peak_season;
		}
	}
	void set(String room, int people, int off_season, int quasi, int peak_season) {
		this.setRoom(room);
		this.setPeople(people);
		this.setOff_season(off_season);
		this.setQuasi(quasi);
		this.setPeak_season(peak_season);
	}
	void result() {
		System.out.println("kh호텔 객실 요금");
		System.out.println("객실명: "+this.room);
		System.out.println("이용 인원: "+this.people);
		System.out.println("비수기 요금: "+this.off_season);
		System.out.println("준성수기 요금: "+this.quasi);
		System.out.println("성수기 요금: "+this.peak_season);
		
		
	}
	
	
}
