package utils;

import java.text.DecimalFormat;

public class AppUtils {
	
	public AppUtils(){
	}

	public static String formatDate(String s){
		String[] parts = s.split("\\.");
		String formatedDate = parts[0];
		return formatedDate ;
	}
	
	public static String getDate(String s){
		String[] parts = formatDate(s).split(" ");
		String date = parts[0];
		return date ;
	}
	
	public static String getTime(String s){
		String[] parts = formatDate(s).split(" ");
		String time = parts[1];
		return time ;
	}
	
	public static String formatFileSize(String input) {
		int size = Integer.parseInt(input);
	    if(size == 0){
	    	return "0";
	    }
	    String[] units = new String[] { "B", "kB", "MB", "GB", "TB" };
	    int group = (int) (Math.log10(size)/Math.log10(1024));
	    String formatedSize = new DecimalFormat("#,##0.#").format(size/Math.pow(1024, group)) + " " + units[group];
	    return formatedSize ;
	}
}