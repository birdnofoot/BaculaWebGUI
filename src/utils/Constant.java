package utils;

public class Constant {
	
	/* Server */
	private static String root = "/bacula";
	private static String host_name = "lxsauve";
	
	/* Bacula config file path*/
	private static String pools = "/etc/bacula/conf.d/pools.conf";
	private static String filesets = "/etc/bacula/conf.d/filesets.conf";
	private static String storages = "/etc/bacula/conf.d/storages.conf";
	private static String devices = "/etc/bacula/devices.conf";
	private static String jobs = "/etc/bacula/conf.d/jobs.conf";
	private static String schedules = "/etc/bacula/conf.d/schedules.conf";
	private static String clients = "/etc/bacula/conf.d/clients.conf";
	private static String jobdefs = "/etc/bacula/conf.d/jobdefs.conf";
	private static String indexPage = "index.jsp";

	/* Bacula config variables*/
	private static String config_password = "baCu52c";
	private static String fd_port = "9102";
	private static String sd_port = "9103";
	private static String localhost_ip = "10.0.15.45";
	private static String default_backup_path = "/bacula/bacula/backup/";
	
	/* Database variables*/
	private static String db_user = "bacula";
	private static String db_password = "root";
	private static String db_url = "localhost";
	private static String db_port = "3306";
	private static String db_name = "bacula";
	
	/* Unix command */
	private static String bash = "/bin/bash" ;
	private static String runJobScritpt = "/etc/bacula/scripts/runjob.sh";
	private static String restartDaemonScritpt = "/etc/bacula/scripts/restartDaemon.sh";
	private static String viewUpcomingJobs = "/etc/bacula/scripts/viewUpcomingJobs.sh";
	
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
	public static String getJobdefs() {
		return jobdefs;
	}
	public static String getLocalhost_ip() {
		return localhost_ip;
	}
	public static String getDefault_backup_path() {
		return default_backup_path;
	}
	public static String getDefault_backup_path_test() {
		String path = "/home/yuanbo/backup/";
		return path ;
	}
	public static void setPools(String pools) {
		Constant.pools = pools;
	}
	public static void setFilesets(String filesets) {
		Constant.filesets = filesets;
	}
	public static void setStorages(String storages) {
		Constant.storages = storages;
	}
	public static void setDevices(String devices) {
		Constant.devices = devices;
	}
	public static void setJobs(String jobs) {
		Constant.jobs = jobs;
	}
	public static void setSchedules(String schedules) {
		Constant.schedules = schedules;
	}
	public static void setClients(String clients) {
		Constant.clients = clients;
	}
	public static void setJobdefs(String jobdefs) {
		Constant.jobdefs = jobdefs;
	}
	public static void setIndexPage(String indexPage) {
		Constant.indexPage = indexPage;
	}
	public static void setConfig_password(String config_password) {
		Constant.config_password = config_password;
	}
	public static void setFd_port(String fd_port) {
		Constant.fd_port = fd_port;
	}
	public static void setSd_port(String sd_port) {
		Constant.sd_port = sd_port;
	}
	public static void setLocalhost_ip(String localhost_ip) {
		Constant.localhost_ip = localhost_ip;
	}
	public static void setDefault_backup_path(String default_backup_path) {
		Constant.default_backup_path = default_backup_path;
	}
	public static void setDb_user(String db_user) {
		Constant.db_user = db_user;
	}
	public static void setDb_password(String db_password) {
		Constant.db_password = db_password;
	}
	public static void setDb_url(String db_url) {
		Constant.db_url = db_url;
	}
	public static void setDb_port(String db_port) {
		Constant.db_port = db_port;
	}
	public static void setDb_name(String db_name) {
		Constant.db_name = db_name;
	}
	public static String getRoot() {
		return root;
	}
	public static String getHost_name() {
		return host_name;
	}
	public static String getRunJobScritpt() {
		return runJobScritpt;
	}
	public static void setRunJobScritpt(String runJobScritpt) {
		Constant.runJobScritpt = runJobScritpt;
	}
	public static String getBash() {
		return bash;
	}
	public static void setBash(String bash) {
		Constant.bash = bash;
	}
	public static String getRestartDaemonScritpt() {
		return restartDaemonScritpt;
	}
	public static void setRestartDaemonScritpt(String restartDaemonScritpt) {
		Constant.restartDaemonScritpt = restartDaemonScritpt;
	}
	public static String getViewUpcomingJobs() {
		return viewUpcomingJobs;
	}
}