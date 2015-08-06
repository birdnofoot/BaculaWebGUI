package utils ;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.*;
import java.io.*;

public class parse
{
public static void main(String[] args) {
	char []c=new char[90];
	try{           
        File f = new File("/home/yuanbo/pools.conf");
        Scanner fileScanner = new Scanner(f);
        HashMap<String, Integer> hash = new HashMap<>();
        
        int lineNumber = 1;
        while(fileScanner.hasNextLine()){
        	String p="\\[(.*?)\\]";
        	Pattern p1=Pattern.compile(p);
        	String k = null;
        	Matcher m = null;
        	m = p1.matcher(fileScanner.nextLine());
        	if(m.find()){
                System.out.println(fileScanner.nextLine());
                System.out.println(lineNumber+1);
        	}
            lineNumber++;
        	}
            fileScanner.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
		}
	}
}