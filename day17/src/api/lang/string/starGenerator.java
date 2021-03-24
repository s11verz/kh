package api.lang.string;

public class starGenerator {
	public static String generate(int size) {
		String str="";
		for(int i=0;i< size;i++) {
		str+="*";
		}
		return str;
	}

}
