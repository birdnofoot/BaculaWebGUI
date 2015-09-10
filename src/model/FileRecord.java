package model;

public class FileRecord {
	
	private String fileName ;
	private String clientName ;
	private String path ;
	private String jobId ;
	private String jobName; 
	private String startTime; 
	private String endTime ;
	
	public FileRecord(String fileName, String clientName, String path, String jobId, String jobName, String startTime,
			String endTime) {
		super();
		this.fileName = fileName;
		this.clientName = clientName;
		this.path = path;
		this.jobId = jobId;
		this.jobName = jobName;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

}
