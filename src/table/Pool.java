package table;

public class Pool {
	
	private String name ;
	private String type ;
	private int isRecycle ;
	private int isAutoPrune ;
	private int volumeRetention ;
	private int maximumVolumeBytes ;
	private int maximumVolumes ;
	
	public Pool(String name, String type, int isRecycle, int isAutoPrune, int volumeRetention, int maximumVolumeBytes,
			int maximumVolumes) {
		this.name = name;
		this.type = type;
		this.isRecycle = isRecycle;
		this.isAutoPrune = isAutoPrune;
		this.volumeRetention = volumeRetention;
		this.maximumVolumeBytes = maximumVolumeBytes;
		this.maximumVolumes = maximumVolumes;
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

	public int getIsRecycle() {
		return isRecycle;
	}

	public void setIsRecycle(int isRecycle) {
		this.isRecycle = isRecycle;
	}

	public int getIsAutoPrune() {
		return isAutoPrune;
	}

	public void setIsAutoPrune(int isAutoPrune) {
		this.isAutoPrune = isAutoPrune;
	}

	public int getVolumeRetention() {
		return volumeRetention;
	}

	public void setVolumeRetention(int volumeRetention) {
		this.volumeRetention = volumeRetention;
	}

	public int getMaximumVolumeBytes() {
		return maximumVolumeBytes;
	}

	public void setMaximumVolumeBytes(int maximumVolumeBytes) {
		this.maximumVolumeBytes = maximumVolumeBytes;
	}

	public int getMaximumVolumes() {
		return maximumVolumes;
	}

	public void setMaximumVolumes(int maximumVolumes) {
		this.maximumVolumes = maximumVolumes;
	}

}
