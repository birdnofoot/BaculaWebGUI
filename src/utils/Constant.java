package utils;

public class Constant {
	
	/* Bacula config file path*/
	private static String pools = "/etc/bacula/conf.d/pools.conf";
	private static String filesets = "/etc/bacula/conf.d/filesets.conf";
	private static String storages = "/etc/bacula/conf.d/storages.conf";
	private static String devices = "/etc/bacula/devices.conf";
	private static String jobs = "/etc/bacula/conf.d/jobs.conf";
	private static String schedules = "/etc/bacula/conf.d/schedules.conf";
	private static String clients = "/etc/bacula/conf.d/clients.conf";
	private static String indexPage = "index.jsp";
	
	/* Bacula config variables*/
	private static String config_password = "baCu52c";
	private static String fd_port = "9102";
	private static String sd_port = "9103";
	
	/* Database variables*/
	private static String db_user = "bacula";
	private static String db_password = "root";
	private static String db_url = "localhost";
	private static String db_port = "3306";
	private static String db_name = "bacula";
	
	
	public static String getPools() {
		return pools;
	}
	public static String getFilesets() {
		return filesets;
	}
	public static String getStorages() {
		return storages;
	}
	public static String getDevices() {
		return devices;
	}
	public static String getJobs() {
		return jobs;
	}
	public static String getSchedules() {
		return schedules;
	}
	public static String getClients() {
		return clients;
	}
	public static String getIndexPage() {
		return indexPage;
	}
	public static String getConfig_password() {
		return config_password;
	}
	public static String getDb_user() {
		return db_user;
	}
	public static String getDb_password() {
		return db_password;
	}
	public static String getDb_url() {
		return db_url;
	}
	public static String getDb_port() {
		return db_port;
	}
	public static String getDb_name() {
		return db_name;
	}
	public static String getFd_port() {
		return fd_port;
	}
	public static String getSd_port() {
		return sd_port;
	}
	
	
}
