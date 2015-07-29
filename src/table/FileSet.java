package table ;

public class FileSet {
	
	private int fileSetId;
	private String fileSetName ;
	private String md5 ;
	private String createTime ;
	
	public FileSet(int fileSetId, String fileSetName, String md5, String createTime) {
		super();
		this.fileSetId = fileSetId;
		this.fileSetName = fileSetName;
		this.md5 = md5;
		this.createTime = createTime;
	}

	public int getFileSetId() {
		return fileSetId;
	}

	public void setFileSetId(int fileSetId) {
		this.fileSetId = fileSetId;
	}

	public String getFileSetName() {
		return fileSetName;
	}

	public void setFileSetName(String fileSetName) {
		this.fileSetName = fileSetName;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

}
