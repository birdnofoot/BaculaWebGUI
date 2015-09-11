package model ;

public class Job {
	
	/* MySQL columns */
	
	private int jobId ;
	private String job ;
	private String name ;
	private String type ;
	private String level ;
	private int clientId ;
	private char jobStatus ;
	private String schedTime ;
	private String startTime ;
	private String endTime ;
	private String realEndTime ;
	private String jobTDate ;
	private int volSessionId ;
	private String volSessionTime ;
	private String jobFiles ;
	private int jobBytes ;
	private int readBytes ;
	private String jobErrors ;
	private String jobMissingFiles ;
	private int poolId ;
	private int fileSetId ;
	private int priorJobId ;
	private String purgedFiles ;
	private int hasBase ;
	private int hasCache ;
	private int reviewed ;
	private String comment ;
	private String volume ;
	private String priority ;
	
	/* Configuration file */
	
	private String typeConf ;
	private String client ;
	private String pool ;
	private String jobDef ;
	private String levelConf ;
	private String schedule ;
	private String fileSet ;
	private String where ;
	private String storage ;
	
	public Job(){
	}

	public Job(String name, String typeConf, String client, String pool, String jobDef, String levelConf,
			String schedule, String fileSet, String where, String storage) {
		this.name = name;
		this.typeConf = typeConf;
		this.client = client;
		this.pool = pool;
		this.jobDef = jobDef;
		this.levelConf = levelConf;
		this.schedule = schedule;
		this.fileSet = fileSet;
		this.where = where;
		this.storage = storage;
	}
	
	public Job(String level, String type, String priority, String schedTime, String name, String volume) {
		this.level = level ;
		this.type = type;
		this.priority = priority ;
		this.schedTime = schedTime ;
		this.name = name;
		this.volume = volume ;
	}
	
	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public char getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(char jobStatus) {
		this.jobStatus = jobStatus;
	}

	public String getSchedTime() {
		return schedTime;
	}

	public void setSchedTime(String schedTime) {
		this.schedTime = schedTime;
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

	public String getRealEndTime() {
		return realEndTime;
	}

	public void setRealEndTime(String realEndTime) {
		this.realEndTime = realEndTime;
	}

	public String getJobTDate() {
		return jobTDate;
	}

	public void setJobTDate(String jobTDate) {
		this.jobTDate = jobTDate;
	}

	public int getVolSessionId() {
		return volSessionId;
	}

	public void setVolSessionId(int volSessionId) {
		this.volSessionId = volSessionId;
	}

	public String getVolSessionTime() {
		return volSessionTime;
	}

	public void setVolSessionTime(String volSessionTime) {
		this.volSessionTime = volSessionTime;
	}

	public String getJobFiles() {
		return jobFiles;
	}

	public void setJobFiles(String jobFiles) {
		this.jobFiles = jobFiles;
	}

	public int getJobBytes() {
		return jobBytes;
	}

	public void setJobBytes(int jobBytes) {
		this.jobBytes = jobBytes;
	}

	public int getReadBytes() {
		return readBytes;
	}

	public void setReadBytes(int readBytes) {
		this.readBytes = readBytes;
	}

	public String getJobErrors() {
		return jobErrors;
	}

	public void setJobErrors(String jobErrors) {
		this.jobErrors = jobErrors;
	}

	public String getJobMissingFiles() {
		return jobMissingFiles;
	}

	public void setJobMissingFiles(String jobMissingFiles) {
		this.jobMissingFiles = jobMissingFiles;
	}

	public int getPoolId() {
		return poolId;
	}

	public void setPoolId(int poolId) {
		this.poolId = poolId;
	}

	public int getFileSetId() {
		return fileSetId;
	}

	public void setFileSetId(int fileSetId) {
		this.fileSetId = fileSetId;
	}

	public int getPriorJobId() {
		return priorJobId;
	}

	public void setPriorJobId(int priorJobId) {
		this.priorJobId = priorJobId;
	}

	public String getPurgedFiles() {
		return purgedFiles;
	}

	public void setPurgedFiles(String purgedFiles) {
		this.purgedFiles = purgedFiles;
	}

	public int getHasBase() {
		return hasBase;
	}

	public void setHasBase(int hasBase) {
		this.hasBase = hasBase;
	}

	public int getHasCache() {
		return hasCache;
	}

	public void setHasCache(int hasCache) {
		this.hasCache = hasCache;
	}

	public int getReviewed() {
		return reviewed;
	}

	public void setReviewed(int reviewed) {
		this.reviewed = reviewed;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getTypeConf() {
		return typeConf;
	}

	public void setTypeConf(String typeConf) {
		this.typeConf = typeConf;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getPool() {
		return pool;
	}

	public void setPool(String pool) {
		this.pool = pool;
	}

	public String getJobDef() {
		return jobDef;
	}

	public void setJobDef(String jobDef) {
		this.jobDef = jobDef;
	}

	public String getLevelConf() {
		return levelConf;
	}

	public void setLevelConf(String levelConf) {
		this.levelConf = levelConf;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public String getFileSet() {
		return fileSet;
	}

	public void setFileSet(String fileSet) {
		this.fileSet = fileSet;
	}

	public String getWhere() {
		return where;
	}

	public void setWhere(String where) {
		this.where = where;
	}

	public String getStorage() {
		return storage;
	}

	public void setStorage(String storage) {
		this.storage = storage;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}
	
}
