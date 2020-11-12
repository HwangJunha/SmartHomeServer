package vo;

public class Admin {
	private String code;
	private String pwd;
	private String addr;
	private String addr2;
	private String room;
	private String phone;
	private String ip;
	private String id;
	private String email;
	private String zip_code;
	private String name;
	private String city_id;
	private String nickname;
	private int user_re_ref;
	
	
	public Admin() {
		this.code="temp";
		this.ip="temp";
		this.city_id="temp";
	}
	public String toString() {
		return "id:"+this.id+" pwd:"+this.pwd+" code"+this.code+" phone:"+this.phone+" ip:"+this.ip+" email:"+this.email+" zipCode:"+this.zip_code+" name:"+this.name
				+" cityId:"+this.city_id+" addr:"+this.addr+" addr2:"+this.addr2;
	}
	
	public String getNickname() {
		return this.nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname=nickname;
	}
	
	public String getCityId() {
		return this.city_id;
	}
	public void setCityId(String city_id) {
		this.city_id=city_id;
	}
	
	public void setUser_re_ref(int user_re_ref) {
		this.user_re_ref=user_re_ref;
	}
	
	public int getUser_re_ref() {
		return this.user_re_ref;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name=name;
	}
	
	public String getZip_code() {
		return zip_code;
	}
	public void setZip_code(String zip_code) {
		this.zip_code=zip_code;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id=id;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip=ip;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room=room;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone=phone;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd=pwd;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr=addr;
	}
	
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2=addr2;
	}
}
