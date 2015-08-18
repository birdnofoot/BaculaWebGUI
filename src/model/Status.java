package model;

public class Status {
	
	private String jobStatus ;
	private String jobStatusLong ;
	private int severity ;
	
	public Status(String jobStatus, String jobStatusLong, int severity){
		this.jobStatus = jobStatus ;
		this.jobStatusLong = jobStatusLong ;
		this.severity = severity ;
	}
	
	public String getJobStatus() {
		return jobStatus;
	}
	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}
	public String getJobStatusLong() {
		return jobStatusLong;
	}
	public void setJobStatusLong(String jobStatusLong) {
		this.jobStatusLong = jobStatusLong;
	}
	public int getSeverity() {
		return severity;
	}
	public void setSeverity(int severity) {
		this.severity = severity;
	}
}