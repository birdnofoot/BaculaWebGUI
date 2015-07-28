package Tables;

public class FileSet {
	
	private int FileSetId;
	private String FileSetName ;
	private String MD5 ;
	private String CreateTime ;
	
	public FileSet(int FileSetId, String FileSetName, String MD5, String CreateTime){
		this.FileSetId = FileSetId ;
		this.FileSetName = FileSetName ;
		this.MD5 = MD5 ;
		this.CreateTime = CreateTime ;
	}

	public int getFileSetId() {
		return FileSetId;
	}

	public void setFileSetId(int fileSetId) {
		FileSetId = fileSetId;
	}

	public String getFileSetName() {
		return FileSetName;
	}

	public void setFileSetName(String fileSetName) {
		FileSetName = fileSetName;
	}

	public String getMD5() {
		return MD5;
	}

	public void setMD5(String MD5) {
		this.MD5 = MD5;
	}

	public String getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}

}
