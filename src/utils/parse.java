package utils ;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.*;
import java.io.*;

public class parse
{
	public static void main(String[] args) throws FileNotFoundException {
		
		File f = new File("/home/yuanbo/pools.conf");
		/*Map<Integer, Integer> lineMap = new TreeMap<Integer, Integer>();
		lineMap = AppUtils.getBlockStartEnd(f,"Pool");
		for (Map.Entry<Integer,Integer> entry : lineMap.entrySet()) {
		  Integer key = entry.getKey();
		  Integer value = entry.getValue();
		  System.out.println("start line :"+key+" end line : "+value);
		}
		AppUtils.showLineNumber(f,"File");*/
		
		Integer[] startEndMapMatched = new Integer[2];
		startEndMapMatched = AppUtils.getStartEndLineNumberByName(f, "Pool","Name","fff");
		System.out.println("start : "+startEndMapMatched[0]+" end : "+startEndMapMatched[1]);
		AppUtils.deleteLinesFromFile("/home/yuanbo/pools.conf",startEndMapMatched[0],1+startEndMapMatched[1]-startEndMapMatched[0]);
	}
}