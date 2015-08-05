package model;

public class Client {
	
	private int clientId ;
	private String name ;
	private String uname ;
	private int isAutoPrune ; 
	private int fileRetention ;
	private int jobRetention ;
	
	private String address;
	private int fdPort ;
	private String catalog ;
	private String password ;
	
	public Client(String name, int isAutoPrune, int fileRetention, int jobRetention, String address, int fdPort,
			String catalog, String password) {
		super();
		this.name = name;
		this.isAutoPrune = isAutoPrune;
		this.fileRetention = fileRetention;
		this.jobRetention = jobRetention;
		this.address = address;
		this.fdPort = fdPort;
		this.catalog = catalog;
		this.password = password;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public int getIsAutoPrune() {
		return isAutoPrune;
	}

	public void setIsAutoPrune(int isAutoPrune) {
		this.isAutoPrune = isAutoPrune;
	}

	public int getFileRetention() {
		return fileRetention;
	}

	public void setFileRetention(int fileRetention) {
		this.fileRetention = fileRetention;
	}

	public int getJobRetention() {
		return jobRetention;
	}

	public void setJobRetention(int jobRetention) {
		this.jobRetention = jobRetention;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getFdPort() {
		return fdPort;
	}

	public void setFdPort(int fdPort) {
		this.fdPort = fdPort;
	}

	public String getCatalog() {
		return catalog;
	}

	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
