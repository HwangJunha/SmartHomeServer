package vo;

public class Device extends Room{

    String name;
    String deviceKind;
    String model;
    int state;
    int device_re_ref;
    public Device(String room, int size, String kind, String address, String user,String name, String deviceKind, String model, int state){
        super(room, size, kind,address,user);
        this.name = name;
        this.deviceKind =deviceKind;
        this.model = model;
        this.state = state;
    }

    public Device() {}
    
    
    public void setDevice_re_ref(int device_re_ref) {
    	this.device_re_ref=device_re_ref;
    }
    public int getDevice_re_ref() {
    	return this.device_re_ref;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public String toString(){
		
		return name+"/"+deviceKind+"/"+model+"/"+super.getRoom()+"/"+state+"/";
	}

    public void setDeviceKind(String deviceKind){this.deviceKind=deviceKind;}

    public String getDeviceKind(){return this.deviceKind;}

    public void setModel(String model){this.model=model;}

    public String getModel(){return this.model;}

    public void setState(int state){this.state=state;}

    public int getState(){return this.state;}
}
