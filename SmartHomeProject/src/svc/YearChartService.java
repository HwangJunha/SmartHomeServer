package svc;

import java.util.ArrayList;

import vo.DeviceData;

public class YearChartService {
	public ArrayList<DeviceData> ChartService(ArrayList<DeviceData> articleList){ //정렬된 상태의 데이터가 넘어옴 
		ArrayList<DeviceData> dayChart = new ArrayList<>();
		
		String str= articleList.get(0).getTimeYMD().substring(0,4);
		
		
		int count=0;
		int tempDust=0;
		int tempHumidity=0;
		int tempTemperature=0;
		int size=articleList.size()-1;
		
		
		for(int i=0; i<articleList.size()-1; i++) {
			if(str.equals(articleList.get(i+1).getTimeYMD().substring(0,4))) {
				count++; //증가 
				tempDust+=articleList.get(i).getDust();
				tempHumidity+=articleList.get(i).getHumidity();
				tempTemperature+=articleList.get(i).getTemperature();
			}else {
				DeviceData deviceData= new DeviceData();
				count++;
				tempDust+=articleList.get(i).getDust();
				tempHumidity+=articleList.get(i).getHumidity();
				tempTemperature+=articleList.get(i).getTemperature();
				deviceData.setDust(tempDust/count);
				deviceData.setHumidity(tempHumidity/count);
				deviceData.setTemperature(tempTemperature/count);
				deviceData.setTimeYMD(str);
				dayChart.add(deviceData);
				
				count=0;
				str=articleList.get(i+1).getTimeYMD().substring(0,4); //새로운날짜 
				tempDust=0;
				tempHumidity=0;
				tempTemperature=0;
			}
		}
		DeviceData deviceData= new DeviceData();
		count++;
		tempDust+=articleList.get(size).getDust();
		tempHumidity+=articleList.get(size).getHumidity();
		tempTemperature+=articleList.get(size).getTemperature();
		deviceData.setDust(tempDust/count);
		deviceData.setHumidity(tempHumidity/count);
		deviceData.setTemperature(tempTemperature/count);
		deviceData.setTimeYMD(str);
		dayChart.add(deviceData);
		
		return dayChart;
	}
	
	
}
