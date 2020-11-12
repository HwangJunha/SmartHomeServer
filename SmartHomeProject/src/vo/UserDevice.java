package vo;

public class UserDevice {
	private String id;
	private String roomName;
	private String room;
	private String name;
	private String kind;
	private String model;
	private String pcDate;
	private int state;
	private int devicePossession_re_ref;
	
	public UserDevice() {
		
	}
	public void setId(String id) {
		this.id=id;
	}
	public String getId() {
		return this.id;
	}
	public void setRoomName(String roomName) {
		this.roomName=roomName;
	}
	public String getRoomName() {
		return this.roomName;
	}
	public void setRoom(String room) {
		this.room=room;
	}
	public String getRoom() {
		return this.room;
	}
	public void setKind(String kind) {
		this.kind=kind;
	}
	public String getKind() {
		return this.kind;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return this.name;
	}
	public void setModel(String model) {
		this.model=model;
	}
	public String getModel() {
		return this.model;
	}
	public void setPcDate(String pcDate) {
		this.pcDate=pcDate;
	}
	public String getPcDate() {
		return this.pcDate;
	}
	public void setState(int state) {
		this.state=state;
	}
	public int getState() {
		return this.state;
	}
	public void setDevicePossession_re_ref(int devicePossession_re_ref) {
		this.devicePossession_re_ref=devicePossession_re_ref;
	}
	public int getDevicePossession_re_ref() {
		return this.devicePossession_re_ref;
	}
	
}
