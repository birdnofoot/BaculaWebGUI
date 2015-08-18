package utils;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
		long size = Long.parseLong(input);
	    if(size == 0){
	    	return "0";
	    }
	    String[] units = new String[] { "B", "KB", "MB", "GB", "TB" };
	    int group = (int) (Math.log10(size)/Math.log10(1024));
	    String formatedSize = new DecimalFormat("#,##0.#").format(size/Math.pow(1024, group)) + " " + units[group];
	    return formatedSize ;
	}
	
	public static ArrayList<Integer> getStartLineNumber(File f, String type)
			throws FileNotFoundException {
        int lineNumber = 1;
        ArrayList<Integer> lineMatchArray = new ArrayList<Integer>();
        String currentLine = null ;
        @SuppressWarnings("resource")
		Scanner fileScanner = new Scanner(f);
        while(fileScanner.hasNextLine()){
        	currentLine = fileScanner.nextLine();
        	String regex = "^\\s*"+type+"\\s+\\{\\s*";
        	Pattern pattern = Pattern.compile(regex);
        	Matcher matcher = null;
        	matcher = pattern.matcher(currentLine);
        	if(matcher.find()){
        		lineMatchArray.add(lineNumber);
        	}
            lineNumber++ ;
        	}
        return lineMatchArray ;
	}
	
	public static boolean findName(String type, String currentLine){
    	String regex = "^\\s*"+type+"\\s+\\{\\s*";
    	Pattern pattern = Pattern.compile(regex);
    	Matcher matcher = null;
    	matcher = pattern.matcher(currentLine);
    	if(matcher.find()){
    		return true ;
    	}
    	else {
    		return false ;
    	}
	}
	
    public static HashMap<String,Status> getJobStatusLong(){
    	HashMap<String,Status> statusMap = new HashMap<String,Status>();
    	String jobStatusLong = null ;
    	try {
	    	String query = "SELECT * FROM Status ; " ;
	    	DatabaseController m = new DatabaseController();
				m.connectoDatabase();
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
				else if(AppUtils.findName(type, currentLine)){
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
	
	
	
	public static int getLineNumberByName(File f, String option, String name)
			throws FileNotFoundException {
        int lineNumber = 1;
        int lineMatch = 0 ;
        String currentLine = null ;
        @SuppressWarnings("resource")
		Scanner fileScanner = new Scanner(f);
        
        while(fileScanner.hasNextLine()){
        	currentLine = fileScanner.nextLine();
        	String regex = "\\s*"+option+"\\s+=\\s+"+name+"\\s*";
        	Pattern pattern = Pattern.compile(regex);
        	Matcher matcher = null;
        	matcher = pattern.matcher(currentLine);
        	if(matcher.find()){
        		lineMatch = lineNumber ;
        	}
            lineNumber++ ;
        	}
        return lineMatch ;
	}
	
	public static ArrayList<String> getName(File f, String option) throws FileNotFoundException{
		ArrayList<String> name_list = new ArrayList<String>();
        @SuppressWarnings("unused")
		int lineNumber = 1;
        String currentLine = null ;
        @SuppressWarnings("resource")
		Scanner fileScanner = new Scanner(f);
        
        while(fileScanner.hasNextLine()){
        	currentLine = fileScanner.nextLine();
        	if(currentLine.length() >= 1){
				if(currentLine.trim().charAt(0) != '#'){
		        	String regex = "\\s*"+option+"\\s+=\\s+";
		        	Pattern pattern = Pattern.compile(regex);
		        	Matcher matcher = null;
		        	matcher = pattern.matcher(currentLine);
		        	if(matcher.find()){
		        		String name = "" ;
		        		String[] parts = currentLine.split(" +");
		        		int j ;
		        		for(j=3;j<parts.length;j++){
		        			if(parts[j] != null){
		        				if(parts[j].charAt(0) == '"'){
		        					parts[j] = parts[j].substring(1);
		        				}
		        			    if (parts[j].length() > 0 && parts[j].charAt(parts[j].length()-1)=='"') {
		        			    	parts[j] = parts[j].substring(0, parts[j].length()-1);
		        			      }
		        			    name = name + " "+ parts[j] ;
		        			}
		        		}
		        		name_list.add(name);
		        	}
				}
        	}
        lineNumber++ ;
        }
        return name_list ;
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

	public static void showLineNumber(File f, String name) 
			throws FileNotFoundException {
		ArrayList<Integer> lineMatchArray = new ArrayList<Integer>();
		lineMatchArray = getStartLineNumber(f,name);
		for (Integer nb : lineMatchArray){
			System.out.println(nb) ;
		}
	}
	
	public static boolean isBracketMatch(String str) {
	    Stack<Character> stack = new Stack<Character>();
	    char c;
	    for(int i=0; i < str.length(); i++) {
	        c = str.charAt(i);
	        if(c == '{')
	            stack.push(c);
	        else if(c == '}')
	            if(stack.empty())
	                return false;
	            else if(stack.peek() == '{')
	                stack.pop();
	            else
	                return false;
	    }
	    return stack.empty();
	}
	
	public static Integer[] getStartEndLineNumberByName(File f, String type, String option, String name) 
			throws FileNotFoundException{
		Integer[] startEndMapMatched = new Integer[2];
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		map = AppUtils.getBlockStartEnd(f,type);
		for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
			Integer startLineNumber = entry.getKey();
			Integer endLineNumber = entry.getValue();
			Integer matchedLineNumber = AppUtils.getLineNumberByName(f, option, name);
			if((matchedLineNumber < endLineNumber) && (matchedLineNumber > startLineNumber)){
				startEndMapMatched[0]=startLineNumber ;
				startEndMapMatched[1]=endLineNumber;
			}
		}
		return startEndMapMatched ;
	}
	
	public static void deleteLinesFromFile(String filename, int startline, int numlines){
		try
		{
			BufferedReader br=new BufferedReader(new FileReader(filename));
			StringBuffer sb=new StringBuffer("");
			int linenumber=1;
			String line;
			while((line=br.readLine())!=null)
			{
				if(linenumber<startline||linenumber>=startline+numlines)
					sb.append(line+"\n");
				linenumber++;
			}
			br.close();
			FileWriter fw = new FileWriter(new File(filename));
			fw.write(sb.toString());
			fw.close();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public static String getDate(){
		DateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	public static Map<Integer, Integer> getBlockStartEnd(File f, String type) 
			throws FileNotFoundException{
		
	    Stack<String> stack = new Stack<String>();
		ArrayList<Integer> startLineArray = new ArrayList<Integer>();
		
		boolean found = false ;
		boolean findPoolStartLine = false ;
		
        int lineNumber = 1;
		int counter = 0 ;
        String currentLine = null ;
        
    	@SuppressWarnings("resource")
    	Scanner fileScanner = new Scanner(f);
    	Map<Integer, Integer> lineNumberMap = new TreeMap<Integer, Integer>();
		startLineArray = getStartLineNumber(f,type);

		for (Integer i : startLineArray){
		        while(fileScanner.hasNextLine() && !found){
		        	while(lineNumber != startLineArray.get(counter) && !findPoolStartLine){
			        	currentLine = fileScanner.nextLine();
						lineNumber++;
		        	}
					findPoolStartLine = true ;
		        	currentLine = fileScanner.nextLine();

		        	if(currentLine.contains("{")){
		        		stack.push("{");
		        	}
		        	
		        	if(currentLine.contains("}")){
		    			stack.pop();
		        	}
		        	
		        	if(lineNumber > i && stack.empty()){
		        		lineNumberMap.put(i, lineNumber);
		        		found = true ;
		        	}
		            lineNumber++ ;
		        }
				found = false ;
				counter ++ ;
    	}
		return lineNumberMap ;
	}
}