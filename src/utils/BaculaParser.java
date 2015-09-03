/*
 * BaculaParser
 * 
 * Author : Yuanbo Wang
 * 2015-08
 */

package utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaculaParser {

	/**
	 * Given a Bacula configuration file and its type, return an ArrayList of all 
	 * start line corresponding to this type
	 * 
	 * @param	f		Bacula configuration file
	 * @param	type	file type, ex. "Pool"
	 * @return	ArrayList of all start line of given type
	 */
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
	
	/**
	 * Returns true if current line contains input type name
	 * 
	 * @param	type			Bacula configuration file type. ex. "Pool"
	 * @param	currentline	The current line read in file
	 * @return	true if current line contains input type name
	 */
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

	/**
	 * Returns map of all start and end line pairs of given type
	 * 
	 * @param	f		Bacula configuration file
	 * @param	type	Bacula configuration file type. ex. "Pool"
	 * @return	A map Map<Integer, Integer> of all start and end line pairs of given type
	 */
	public static Map<Integer, Integer> getBlockStartEnd(File f, String type) 
			throws FileNotFoundException{

		boolean found = false ;
		boolean findPoolStartLine = false ;
        int lineNumber = 1;
		int counter = 0 ;
		
	    Stack<String> stack = new Stack<String>();
		ArrayList<Integer> startLineArray = new ArrayList<Integer>();
        String currentLine = null ;
        
    	@SuppressWarnings("resource")
    	Scanner fileScanner = new Scanner(f);
    	Map<Integer, Integer> lineNumberMap = new TreeMap<Integer, Integer>();
		startLineArray = BaculaParser.getStartLineNumber(f,type);

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

	/**
	 * Returns a list of string of all names of given type
	 * 
	 * @param	f		Bacula configuration file
	 * @param	type	Bacula configuration file type. ex. "Pool"
	 * @return	ArrayList<String> containing all names of given type
	 */
	public static ArrayList<String> getName(File f, String type) {
		ArrayList<String> name_list = new ArrayList<String>();
	    @SuppressWarnings("unused")
		int lineNumber = 1;
	    String currentLine = null ;
	    try{
	    @SuppressWarnings("resource")
		Scanner fileScanner = new Scanner(f);
	    
	    while(fileScanner.hasNextLine()){
	    	currentLine = fileScanner.nextLine();
	    	if(currentLine != null && currentLine.trim().length() >= 1){
	    		currentLine = currentLine.replaceAll("\\s+","");
				if(currentLine.trim().charAt(0) != '#'){
		        	String regex = "\\s*"+type+"\\s+=\\s+";
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
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	    return name_list ;
	}

	/**
	 * Delete content in a file
	 */
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

	/**
	 * Get start and end line number of given name
	 */
	public static Integer[] getStartEndLineNumberByName(File f, String type, String option, String name) 
			throws FileNotFoundException{
		Integer[] startEndMapMatched = new Integer[2];
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		map = BaculaParser.getBlockStartEnd(f,type);
		for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
			Integer startLineNumber = entry.getKey();
			Integer endLineNumber = entry.getValue();
			Integer matchedLineNumber = BaculaParser.getLineNumberByName(f, option, name);
			if((matchedLineNumber < endLineNumber) && (matchedLineNumber > startLineNumber)){
				startEndMapMatched[0]=startLineNumber ;
				startEndMapMatched[1]=endLineNumber;
			}
		}
		return startEndMapMatched ;
	}

	/**
	 * Get line number of given name
	 */
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

	/**
	 * Return true if brackets in given string are well matched
	 */
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

}