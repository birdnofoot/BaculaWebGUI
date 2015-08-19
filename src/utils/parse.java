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
		Integer[] startEndMapMatched = new Integer[2];
		File f = new File(Constant.getFilesets());
		startEndMapMatched = BaculaParser.getStartEndLineNumberByName(f,"FileSet","Name","\"Test\"");
		System.out.println("start : "+startEndMapMatched[0]+" end : "+startEndMapMatched[1]);
}
}