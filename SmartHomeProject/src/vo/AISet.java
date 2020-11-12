package vo;

public class AISet {
	String room;
	String model;
	String temperature;
	String dust;
	String humidity;
	String temperatureRule;
	String dustRule;
	String humidityRule;
	String onoff;
	String day;
	String time;
	String interval;
	String execution;
	
	public AISet(){}
	
	public String getExecution() {
		return execution;
	}
	public String setExecutionm(String execution) {
		return this.execution=execution;
	}
	
	public String getRoom() {
		return room;
	}
	public String setRoom(String room) {
		return this.room=room;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getDust() {
		return dust;
	}
	public void setDust(String dust) {
		this.dust = dust;
	}
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	public String getTemperatureRule() {
		return temperatureRule;
	}
	public void setTemperatureRule(String temperatureRule) {
		this.temperatureRule = temperatureRule;
	}
	public String getDustRule() {
		return dustRule;
	}
	public void setDustRule(String dustRule) {
		this.dustRule = dustRule;
	}
	public String getHumidityRule() {
		return humidityRule;
	}
	public void setHumidityRule(String humidityRule) {
		this.humidityRule = humidityRule;
	}
	public String getOnoff() {
		return onoff;
	}
	public void setOnoff(String onoff) {
		this.onoff = onoff;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getInterval() {
		return interval;
	}
	public void setInterval(String interval) {
		this.interval = interval;
	}
}
