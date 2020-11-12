package vo;

public class Room {
	private String room;
	private String name;
	private String address;
	private String zip_code;
	private String kind;
	private int size;
	
	
	public Room() {
		
	}
	
	public Room(String room, int size, String kind, String address, String user){
        this.room=room;
        this.size=size;
        this.kind=kind;
        this.address=address;

    }
	
	public String toString(){
		
		return room+"/"+name+"/"+kind+"/"+size+"/";
	}
	
	public String getRoom() {
		return this.room;
	}
	public void setRoom(String room) {
		this.room=room;
	}
	
	public String getRoomName() {
		return this.name;
	}
	public void setRoomName(String name) {
		this.name=name;
	}
	
	public String getAddr() {
		return address;
	}
	public void setAddr(String addr) {
		this.address=addr;
	}
	
	public String getZipCode() {
		return this.zip_code;
	}
	public void setZipCode(String zipCode) {
		this.zip_code=zipCode;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind=kind;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size=size;
	}
	
	
}
