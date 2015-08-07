package utils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

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
 
			//String buffer to store contents of the file
			StringBuffer sb=new StringBuffer("");
 
			//Keep track of the line number
			int linenumber=1;
			String line;
 
			while((line=br.readLine())!=null)
			{
				//Store each valid line in the string buffer
				if(linenumber<startline||linenumber>=startline+numlines)
					sb.append(line+"\n");
				linenumber++;
			}
			if(startline+numlines>linenumber)
				System.out.println("End of file reached.");
			br.close();
 
			FileWriter fw = new FileWriter(new File(filename));
			//Write entire string buffer into the file
			fw.write(sb.toString());
			fw.close();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
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