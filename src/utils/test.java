package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test {

	public static void main(String[] args)  {
		try {
		 Runtime rt = Runtime.getRuntime();
		 String[] commands = {"/bin/bash", "/etc/bacula/scripts/connect.sh"};
		 Process proc;

		 proc = rt.exec(commands);
		 BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
		 BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
		 System.out.println("Here is the standard output of the command:\n");
		 String s = null;
		 while ((s = stdInput.readLine()) != null) {
		     System.out.println(s);
		 }
		 System.out.println("Here is the standard error of the command (if any):\n");
		 while ((s = stdError.readLine()) != null) {
		     System.out.println(s);
		 }
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
}
