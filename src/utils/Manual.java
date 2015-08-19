package utils;

public class Manual {
	
	/* Device */
	
	public static String getDeviceLabelMediaInfo(){
		String info = "Let Bacula label unlabeled media";
		return info ;
	}
	
	public static String getDeviceArchiveDeviceInfo(){
		String info = "Full absolute path to the directory where backup files will be placed";
		return info ;
	}
	
	/* Pool */
	
	public static String getPoolLabelFormatInfo(){
		String info = "Default value : ${Poolname}-${Year}-${Month:p/2/0/r}-${Day:p/2/0/r}"
				+ ", on 20 June 2016 would give : Default-2016-06-20";
		return info ;
	}
	
	public static String getPoolVolumeRetentionInfo(){
		String info = "Default value : 365 days";
		return info ;
	}
	
	public static String getPoolMaxVolumeBytes(){
		String info = "Default value : 50G";
		return info ;
	}
	
	public static String getPoolMaxVolume(){
		String info = "Default value : 100";
		return info ;
	}
	
	/* Storage */
	
	public static String getStorageIpInfo(){
		String info = "Change if the SD daemon is not on localhost. Default value : "+Constant.getLocalhost_ip();
		return info ;
	}
	
	/* FileSet */
	
	public static String getFilesetBackupPath(){
		String info = "Devide path by comma. ex : /usr/local, /home";
		return info ;
	}
	
	public static String getFilesetExcludePath(){
		String info = "Devide path by comma. ex : /usr/local/apache*, /var/log";
		return info ;
	}
	
	/* JobDef */
	
	public static String getJobDefPriorityInfo(){
		String info = "The higher the number, the lower the job priority. The priority only affects waiting jobs that are queued to run. Default value : 10";
		return info ;
	}
	
	
}