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
		
		File f = new File("/etc/bacula/conf.d/jobs.conf");
		/*Map<Integer, Integer> lineMap = new TreeMap<Integer, Integer>();
		lineMap = AppUtils.getBlockStartEnd(f,"Pool");
		for (Map.Entry<Integer,Integer> entry : lineMap.entrySet()) {
		  Integer key = entry.getKey();
		  Integer value = entry.getValue();
		  System.out.println("start line :"+key+" end line : "+value);
		}
		AppUtils.showLineNumber(f,"File");*/
		
		Integer[] startEndMapMatched = new Integer[2];
		startEndMapMatched = AppUtils.getStartEndLineNumberByName(f, "Job","Name","");
		System.out.println("start : "+startEndMapMatched[0]+" end : "+startEndMapMatched[1]);
		ArrayList<String> name_list = new ArrayList<String>();
		name_list = AppUtils.getName(f,"Name");
		int i = 0 ;
		for(i=0;i<name_list.size();i++){
			System.out.println(name_list.get(i));
		}
		//AppUtils.deleteLinesFromFile("/etc/bacula/conf.d/pools.conf",startEndMapMatched[0],1+startEndMapMatched[1]-startEndMapMatched[0]);
	}
}