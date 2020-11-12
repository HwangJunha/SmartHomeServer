package vo;

public class ServiceUp {
	private String id;
	private String code;
	private String name;
	private String kind;
	private String model;
	private String pcDate;
	private String ip;
	private int state;
	private int devicePossession_re_ref;
	
	public ServiceUp() {
		
	}
	
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id=id;
	}
	public String getKind() {
		return this.kind;
	}
	public void setKind(String kind) {
		this.kind=kind;
	}
	public String getCode() {
		return this.code;
	}
	public void setCode(String code) {
		this.code=code;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip=ip;
	}
	public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setModel(String model){
    	this.model=model;
    }

    public String getModel(){
    	return this.model;
    }

    public void setState(int state){
    	this.state=state;
    }

    public int getState(){
    	return this.state;
    }
    public void setPcDate(String pcDate) {
    	this.pcDate=pcDate;
    }
    public String getPcDate() {
    	return this.pcDate;
    }
    public void setDevicePossession_re_ref(int devicePossession_re_ref) {
		this.devicePossession_re_ref=devicePossession_re_ref;
	}
	public int getDevicePossession_re_ref() {
		return this.devicePossession_re_ref;
	}
}
