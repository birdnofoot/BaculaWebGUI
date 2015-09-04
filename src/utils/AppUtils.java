package utils;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Comparator;
import org.apache.commons.lang.StringEscapeUtils;
import controller.DatabaseController;
import model.Status;

public class AppUtils {
	
	public AppUtils(){
	}

	public static String formatDate(String s){
		String[] parts = s.split("\\.");
		String formatedDate = parts[0];
		return formatedDate ;
	}
	
	public static String formatFileSize(String input) {
		long size = Long.parseLong(input);
	    if(size == 0){
	    	return "0";
	    }
	    String[] units = new String[] { "B", "KB", "MB", "GB", "TB" };
	    int group = (int) (Math.log10(size)/Math.log10(1024));
	    String formatedSize = new DecimalFormat("#,##0.#").format(size/Math.pow(1024, group)) + " " + units[group];
	    return formatedSize ;
	}
	
    public static HashMap<String,Status> getJobStatusLong(){
    	HashMap<String,Status> statusMap = new HashMap<String,Status>();
    	try {
	    	String query = "SELECT * FROM Status ; " ;
	    	DatabaseController m = new DatabaseController();
				m.openConnection();
			Statement statement = m.getConnexion().createStatement();
			ResultSet resultset = statement.executeQuery(query);
			while(resultset.next()){
				statusMap.put(resultset.getString("JobStatus"), new Status(resultset.getString("JobStatus"),
						resultset.getString("JobStatusLong"),Integer.parseInt(resultset.getString("Severity"))));
			}
    	resultset.close();
    	statement.close();
    	m.closeConnection();
    	return statusMap ;
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	return null ;
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
    
	public static String printConfigHighlight(String filename, String type){
		
		StringBuilder sb = new StringBuilder();
		File f = new File(filename);
		try {
		Scanner fileScanner = new Scanner(f);
		String currentLine = null ;
		while(fileScanner.hasNext()){
			currentLine = StringEscapeUtils.escapeHtml(fileScanner.nextLine());
			if(currentLine.length() >= 1){
				if(currentLine.trim().charAt(0) == '#'){
		        	sb.append("<font color=\"#929492\">"+currentLine+"</font>");
		        	sb.append("</br>");
				}
				else if(currentLine.trim().matches("}")) {
					sb.append("<b>"+currentLine+"</b>");
		        	sb.append("</br>");
				}
				else if(BaculaParser.findName(type, currentLine)){
		        	sb.append("</br>");
					sb.append("<b>"+currentLine+"</b>");
		        	sb.append("</br>");
				}
				else
				{
					String[] parts = currentLine.split("=");
					sb.append("&nbsp;&nbsp;<i>"+parts[0]+"</i>");
		        	if(parts.length > 1){
						if(parts[1].contains("#")){
							String[] commentParts = parts[1].split("#");
							sb.append("<font color=\"#333\">"+" = "+commentParts[0]+"</font>");
				        	if(commentParts.length>1){
				        		sb.append("<font color=\"#929492\">"+" # "+commentParts[1]+"</font>");
				        	}
				        	else{
				        		sb.append("<font color=\"#929492\">"+" # "+"</font>");
				        	}
						}
			        	else{
			        		sb.append("<font color=\"#333\">"+" = "+parts[1]+"</font>");
			        	}
		        	}
		        	sb.append("</br>");
				}
        	}
		}
		fileScanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	public static String formatTime(String in) {
		String time = "";
		long seconds = Long.parseLong(in);
	    int day = (int) TimeUnit.SECONDS.toDays(seconds);
	    long hours = TimeUnit.SECONDS.toHours(seconds) - TimeUnit.DAYS.toHours(day);
	    long minute = TimeUnit.SECONDS.toMinutes(seconds) - TimeUnit.DAYS.toMinutes(day) - TimeUnit.HOURS.toMinutes(hours);
	    long second = TimeUnit.SECONDS.toSeconds(seconds) - TimeUnit.DAYS.toSeconds(day) -
	                  TimeUnit.HOURS.toSeconds(hours) - TimeUnit.MINUTES.toSeconds(minute);
	    if(day != 0){
	    	time += day +" days";
	    }
	    if(hours != 0){
	    	time += hours + " ,hours" ;
	    }
	    if(minute != 0){
	    	time += minute + " ,minutes";
	    }
	    if(second != 0){
	    	time += second + " ,seconds";
	    }
	    return time ;
	}

	
	public static String getDate(){
		DateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy");
		Date date = new Date();
		return dateFormat.format(date);
	}
	

	public static String getConfigPathByType(String type){
		String path = null ;
		if(type.equals("Client")){
			path = Constant.getClients();
		}
		if(type.equals("FileSet")){
			path = Constant.getFilesets();
		}
		if(type.equals("Storage")){
			path = Constant.getStorages();
		}
		if(type.equals("Schedule")){
			path = Constant.getSchedules();
		}
		if(type.equals("Pool")){
			path = Constant.getPools();
		}
		if(type.equals("JobDefs")){
			path = Constant.getJobdefs();
		}
		if(type.equals("Device")){
			path = Constant.getDevices();
		}
		if(type.equals("Job")){
			path = Constant.getJobs();
		}
		return path ;
	}
	
	public static long folderSize(File directory) {
	    long length = 0;
	    for (File file : directory.listFiles()) {
	        if (file.isFile())
	            length += file.length();
	        else
	            length += folderSize(file);
	    }
	    return length;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map sortByValue(Map unsortMap) {	 
		List list = new LinkedList(unsortMap.entrySet());
	 
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Map.Entry) (o1)).getValue()).compareTo(((Map.Entry) (o2)).getValue());
			}
		});
		Map sortedMap = new LinkedHashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}
	
	@SuppressWarnings("unchecked")
	public static HashMap<String,Long> getSortedClientSizeMap(String f){
		return (HashMap<String, Long>) AppUtils.sortByValue(AppUtils.getClientSize(f));
	}
	
	public static HashMap<String,Long> getClientSize(String file){
		HashMap<String,Long> clientSizeList = new HashMap<String,Long>();
		File folder = new File(file);
		File[] listOfFiles = folder.listFiles();
		int i ;
		for (i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				// on ne fait rien
			}
			else if (listOfFiles[i].isDirectory()) {
				clientSizeList.put(listOfFiles[i].getName(),
						AppUtils.folderSize(listOfFiles[i]));
			}
		}
		return clientSizeList;
	}
	
	public static ArrayList<String>[] runShell(String cmd, String file, String param){
		@SuppressWarnings("unchecked")
		ArrayList<String>[] result = (ArrayList<String>[])new ArrayList[2];
		ArrayList<String> cmd_output = new ArrayList<String>();
		ArrayList<String> error_output = new ArrayList<String>();
		try {
			Runtime rt = Runtime.getRuntime();
			String[] commands = {cmd, file, param};

			Process proc;
			proc = rt.exec(commands);
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
			String s = null;
			while ((s = stdInput.readLine()) != null) {
				cmd_output.add(s);
			}
			while ((s = stdError.readLine()) != null) {
			    error_output.add(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		result[0] = cmd_output;
		result[1] =  error_output;
		return result;
	}
}
	