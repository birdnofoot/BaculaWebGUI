package utils;

public class Constant {
	
	private static String pools = "/etc/bacula/conf.d/pools.conf";
	private static String filesets = "/etc/bacula/conf.d/filesets.conf";
	private static String storages = "/etc/bacula/conf.d/storages.conf";
	private static String devices = "/etc/bacula/devices.conf";
	private static String jobs = "/etc/bacula/conf.d/jobs.conf";
	private static String schedules = "/etc/bacula/conf.d/schedules.conf";
	private static String clients = "/etc/bacula/conf.d/clients.conf";
	
	
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
	
	
}
