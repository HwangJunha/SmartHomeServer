<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="vo.DeviceData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.net.URLEncoder"%>

<%
	ArrayList<DeviceData> articleList=(ArrayList<DeviceData>)request.getAttribute("articleList");
	String date=(String)request.getAttribute("date");
	String room=(String)request.getAttribute("room");
	String code=(String)request.getAttribute("code");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- jQuery -->
    <script src="https://code.jquery.com/jquery.min.js"></script>
    <!-- google charts -->
       <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

<title>chart</title>
</head>
<body bgcolor="#FFFFFF">
 <h4>일별차트</h4>
 	<div>
 	<select name="jump" onchange="location.href=this.value">
 	<option>선택</option>
	<option value="DeviceDataChart.bo?room=<%=room+"&date=day"+"&code="+code%>">일</option>
	<option value="DeviceDataChart.bo?room=<%=room+"&date=month"+"&code="+code%>">월</option>
	<option value="DeviceDataChart.bo?room=<%=room+"&date=year"+"&code="+code%>">년</option>
	</select>
 	</div>
    <div id="Line_Controls_Chart">
      <!-- 라인 차트 생성할 영역 -->
          <div id="lineChartArea" style="padding:0px 20px 0px 0px;"></div>
          <div id="controlsArea" style="padding:0px 20px 0px 0px;"></div>
       </div>   
       <div id="Line_Controls_Chart2">
          <div id="lineChartArea2" style="padding:0px 40px 0px 0px;"></div>
          <div id="controlsArea2" style="padding:0px 40px 0px 0px;"></div>
        </div>
        <div id="Line_Controls_Chart3">  
          <div id="lineChartArea3" style="padding:0px 60px 0px 0px;"></div>
          <div id="controlsArea3" style="padding:0px 60px 0px 0px;"></div> 
        </div>
        <div id="Line_Controls_Chart4">  
          <div id="lineChartArea4" style="padding:0px 80px 0px 0px;"></div>
          <div id="controlsArea4" style="padding:0px 80px 0px 0px;"></div> 
        </div>

</body>

<script>

  var charttype= 'LineChart';
  var chartDrowFun = {
    chartDrow : function(){
        var chartData = '';
 
        //날짜형식 변경하고 싶으시면 이 부분 수정하세요.
        var chartDateformat     = 'yyyy년MM월dd일';
        //라인차트의 라인 수
        var chartLineCount    = 10;
        //컨트롤러 바 차트의 라인 수
        var controlLineCount    = 10;
 
      
        function drawDashboard() {
 
          var data = new google.visualization.DataTable();
          //그래프에 표시할 컬럼 추가
          data.addColumn('datetime' , '날짜');
          data.addColumn('number'   , '온도');
 
          //그래프에 표시할 데이터
          var dataRow = [];
 		  <%
          for(int i = 0; i <articleList.size(); i++){ //
        	
            int temperature     = articleList.get(i).getTemperature();
            
 			String str= articleList.get(i).getTimeYMD();
 			
            String year= str.substring(0,4);
            String month=Integer.toString((Integer.parseInt(str.substring(5,6))-1));
            String day=str.substring(6,8);
            %>
           	
           	var temperature=<%=temperature%>
           	
           	
           	
 			dataRow = [new Date(<%=year%>, <%=month%>, <%=day%>, '10'), temperature];
            data.addRow(dataRow);
            <%
          	}
 			%>
 			
            var chart = new google.visualization.ChartWrapper({
              chartType   : charttype,
              containerId : 'lineChartArea', //라인 차트 생성할 영역
              options     : {
                              isStacked   : 'percent',
                              focusTarget : 'category',
                              height          : 400,
                              width              : '100%',
                              legend          : { position: "top", textStyle: {fontSize: 13}},
                              pointSize        : 5,
                              tooltip          : {textStyle : {fontSize:12}, showColorCode : true,trigger: 'both'},
                              hAxis              : {format: chartDateformat, gridlines:{count:chartLineCount,units: {
                                                                  years : {format: ['yyyy년']},
                                                                  months: {format: ['MM월']},
                                                                  days  : {format: ['dd일']},
                                                                  hours : {format: ['HH시']}}
                                                                },textStyle: {fontSize:12}},
                vAxis              : {minValue: 100,viewWindow:{min:0},gridlines:{count:-1},textStyle:{fontSize:12}},
                animation        : {startup: true,duration: 1000,easing: 'in' },
                annotations    : {pattern: chartDateformat,
                                textStyle: {
                                fontSize: 15,
                                bold: true,
                                italic: true,
                                color: '#871b47',
                                auraColor: '#d799ae',
                                opacity: 0.8,
                                pattern: chartDateformat
                              }
                            },
              series: { //선 색깔 변경  
                                0: { color: '#e2431e' },
                                1: { color: '#e7711b' },
                                2: { color: '#f1ca3a' },
                                3: { color: '#6f9654' },
                                4: { color: '#1c91c0' },
                                5: { color: '#43459d' },
                              }
                              
              }
            });
 
            var control = new google.visualization.ControlWrapper({
              controlType: 'ChartRangeFilter',
              containerId: 'controlsArea',  //control bar를 생성할 영역
              options: {
                  ui:{
                        chartType: 'LineChart',
                        chartOptions: {
                        chartArea: {'width': '60%','height' : 64},
                          hAxis: {format: chartDateformat, textStyle: {fontSize:12},
                            gridlines:{count:controlLineCount,units: {
                                  years : {format: ['yyyy년']},
                                  months: {format: ['MM월']},
                                  days  : {format: ['dd일']},
                                  hours : {format: ['HH시']}}
                            }},
                        series: { //선 색깔 변경  
                            0: { color: '#e2431e' },
                            1: { color: '#e7711b' },
                            2: { color: '#f1ca3a' },
                            3: { color: '#6f9654' },
                            4: { color: '#1c91c0' },
                            5: { color: '#43459d' },
                        },
                       }
                  },
                    filterColumnIndex: 0
                    
                }
            });
 
            var date_formatter = new google.visualization.DateFormat({ pattern: chartDateformat});
            date_formatter.format(data, 0);
 
            var dashboard = new google.visualization.Dashboard(document.getElementById('Line_Controls_Chart'));
            window.addEventListener('resize', function() { dashboard.draw(data); }, false); //화면 크기에 따라 그래프 크기 변경
            dashboard.bind([control], [chart]);
            dashboard.draw(data);
 
        }
          google.charts.setOnLoadCallback(drawDashboard);
 
      }
    }
  
  var chartDrowFun2 = {
		    chartDrow : function(){
		        var chartData = '';
		 
		        //날짜형식 변경하고 싶으시면 이 부분 수정하세요.
		        var chartDateformat     = 'yyyy년MM월dd일';
		        //라인차트의 라인 수
		        var chartLineCount    = 10;
		        //컨트롤러 바 차트의 라인 수
		        var controlLineCount    = 10;
		 
		      
		        function drawDashboard2() {
		 
		          var data = new google.visualization.DataTable();
		          //그래프에 표시할 컬럼 추가
		          data.addColumn('datetime' , '날짜');
		          data.addColumn('number'   , '습도');
		 
		          //그래프에 표시할 데이터
		          var dataRow = [];
		 		  <%
		          for(int i = 0; i <articleList.size(); i++){ //
		            int humidity   = articleList.get(i).getHumidity();
		 			String str= articleList.get(i).getTimeYMD();
		 			
		            String year= str.substring(0,4);
		            String month=Integer.toString((Integer.parseInt(str.substring(5,6))-1));
		            String day=str.substring(6,8);
		 			%>
		           	var humidity=<%=humidity%>
		           	
		           	
		 			dataRow = [new Date(<%=year%>, <%=month%>, <%=day%>, '10'), humidity];
		            data.addRow(dataRow);
		            <%
		          	}
		 			%>
		 			
		            var chart = new google.visualization.ChartWrapper({
		              chartType   : charttype,
		              containerId : 'lineChartArea2', //라인 차트 생성할 영역
		              options     : {
		                              isStacked   : 'percent',
		                              focusTarget : 'category',
		                              height          : 400,
		                              width              : '100%',
		                              legend          : { position: "top", textStyle: {fontSize: 13}},
		                              pointSize        : 5,
		                              tooltip          : {textStyle : {fontSize:12}, showColorCode : true,trigger: 'both'},
		                              hAxis              : {format: chartDateformat, gridlines:{count:chartLineCount,units: {
		                                                                  years : {format: ['yyyy년']},
		                                                                  months: {format: ['MM월']},
		                                                                  days  : {format: ['dd일']},
		                                                                  hours : {format: ['HH시']}}
		                                                                },textStyle: {fontSize:12}},
		                vAxis              : {minValue: 100,viewWindow:{min:0},gridlines:{count:-1},textStyle:{fontSize:12}},
		                animation        : {startup: true,duration: 1000,easing: 'in' },
		                annotations    : {pattern: chartDateformat,
		                                textStyle: {
		                                fontSize: 15,
		                                bold: true,
		                                italic: true,
		                                color: '#871b47',
		                                auraColor: '#d799ae',
		                                opacity: 0.8,
		                                pattern: chartDateformat
		                              }
		                            },
		                            series: { //선 색깔 변경  
		                                4: { color: '#e2431e' },
		                                5: { color: '#e7711b' },
		                                0: { color: '#f1ca3a' },
		                                1: { color: '#6f9654' },
		                                2: { color: '#1c91c0' },
		                                3: { color: '#43459d' },
		                              }
		              }
		            });
		 
		            var control = new google.visualization.ControlWrapper({
		              controlType: 'ChartRangeFilter',
		              containerId: 'controlsArea2',  //control bar를 생성할 영역
		              options: {
		                  ui:{
		                        chartType: 'LineChart',
		                        chartOptions: {
		                        chartArea: {'width': '60%','height' : 64},
		                          hAxis: {'baselineColor': 'none', format: chartDateformat, textStyle: {fontSize:12},
		                            gridlines:{count:controlLineCount,units: {
		                                  years : {format: ['yyyy년']},
		                                  months: {format: ['MM월']},
		                                  days  : {format: ['dd일']},
		                                  hours : {format: ['HH시']}}
		                         }},
		                        series: { //선 색깔 변경  
		                            4: { color: '#e2431e' },
		                            5: { color: '#e7711b' },
		                            0: { color: '#f1ca3a' },
		                            1: { color: '#6f9654' },
		                            2: { color: '#1c91c0' },
		                            3: { color: '#43459d' },
		                        },
		                        }
		                  },
		                    filterColumnIndex: 0
		                }
		            });
		 
		            var date_formatter = new google.visualization.DateFormat({ pattern: chartDateformat});
		            date_formatter.format(data, 0);
		 
		            var dashboard = new google.visualization.Dashboard(document.getElementById('Line_Controls_Chart2'));
		            window.addEventListener('resize', function() { dashboard.draw(data); }, false); //화면 크기에 따라 그래프 크기 변경
		            dashboard.bind([control], [chart]);
		            dashboard.draw(data);
		 
		        }
		          google.charts.setOnLoadCallback(drawDashboard2);
		 
		      }
		    }
  
  var chartDrowFun3 = {
		    chartDrow : function(){
		        var chartData = '';
		 
		        //날짜형식 변경하고 싶으시면 이 부분 수정하세요.
		        var chartDateformat     = 'yyyy년MM월dd일';
		        //라인차트의 라인 수
		        var chartLineCount    = 10;
		        //컨트롤러 바 차트의 라인 수
		        var controlLineCount    = 10;
		 
		      
		        function drawDashboard3() {
		 
		          var data = new google.visualization.DataTable();
		          //그래프에 표시할 컬럼 추가
		          data.addColumn('datetime' , '날짜');
		          data.addColumn('number'   , '미세먼지');
		 
		          //그래프에 표시할 데이터
		          var dataRow = [];
		 		  <%
		          for(int i = 0; i <articleList.size(); i++){ //
		        	int dust   = articleList.get(i).getDust();
		           
		 			String str= articleList.get(i).getTimeYMD();
		 			
		            String year= str.substring(0,4);
		            String month=Integer.toString((Integer.parseInt(str.substring(5,6))-1));
		            String day=str.substring(6,8);
		            
		 			%>
		           	var dust=<%=dust%>
		           	
		           	
		 			dataRow = [new Date(<%=year%>, <%=month%>, <%=day%>, '10'), dust];
		            data.addRow(dataRow);
		            <%
		          	}
		 			%>
		 			
		            var chart = new google.visualization.ChartWrapper({
		              chartType   : charttype,
		              containerId : 'lineChartArea3', //라인 차트 생성할 영역
		              options     : {
		                              isStacked   : 'percent',
		                              focusTarget : 'category',
		                              height          : 400,
		                              width              : '100%',
		                              legend          : { position: "top", textStyle: {fontSize: 13}},
		                              pointSize        : 5,
		                              tooltip          : {textStyle : {fontSize:12}, showColorCode : true,trigger: 'both'},
		                              hAxis              : {format: chartDateformat, gridlines:{count:chartLineCount,units: {
		                                                                  years : {format: ['yyyy년']},
		                                                                  months: {format: ['MM월']},
		                                                                  days  : {format: ['dd일']},
		                                                                  hours : {format: ['HH시']}}
		                                                                },textStyle: {fontSize:12}},
		                vAxis              : {minValue: 100,viewWindow:{min:0},gridlines:{count:-1},textStyle:{fontSize:12}},
		                animation        : {startup: true,duration: 1000,easing: 'in' },
		                annotations    : {pattern: chartDateformat,
		                                textStyle: {
		                                fontSize: 15,
		                                bold: true,
		                                italic: true,
		                                color: '#871b47',
		                                auraColor: '#d799ae',
		                                opacity: 0.8,
		                                pattern: chartDateformat
		                              }
		                            },
		                            series: { //선 색깔 변경  
		                                2: { color: '#e2431e' },
		                                0: { color: '#e7711b' },
		                                1: { color: '#f1ca3a' },
		                                3: { color: '#6f9654' },
		                                4: { color: '#1c91c0' },
		                                5: { color: '#43459d' },
		                              }
		              }
		            });
		 
		            var control = new google.visualization.ControlWrapper({
		              controlType: 'ChartRangeFilter',
		              containerId: 'controlsArea3',  //control bar를 생성할 영역
		              options: {
		                  ui:{
		                        chartType: 'LineChart',
		                        chartOptions: {
		                        chartArea: {'width': '60%','height' : 64},
		                          hAxis: {'baselineColor': 'none', format: chartDateformat, textStyle: {fontSize:12},
		                            gridlines:{count:controlLineCount,units: {
		                                  years : {format: ['yyyy년']},
		                                  months: {format: ['MM월']},
		                                  days  : {format: ['dd일']},
		                                  hours : {format: ['HH시']}}
		                            }},
		                            series: { //선 색깔 변경  
		                                2: { color: '#e2431e' },
		                                0: { color: '#e7711b' },
		                                1: { color: '#f1ca3a' },
		                                3: { color: '#6f9654' },
		                                4: { color: '#1c91c0' },
		                                5: { color: '#43459d' },
		                            },
		                        }
		                  },
		                    filterColumnIndex: 0
		                }
		            });
		 
		            var date_formatter = new google.visualization.DateFormat({ pattern: chartDateformat});
		            date_formatter.format(data, 0);
		 
		            var dashboard = new google.visualization.Dashboard(document.getElementById('Line_Controls_Chart3'));
		            window.addEventListener('resize', function() { dashboard.draw(data); }, false); //화면 크기에 따라 그래프 크기 변경
		            dashboard.bind([control], [chart]);
		            dashboard.draw(data);
		 
		        }
		          google.charts.setOnLoadCallback(drawDashboard3);
		 
		      }
		    }
 
  var chartDrowFun4 = {
		    chartDrow : function(){
		        var chartData = '';
		 
		        //날짜형식 변경하고 싶으시면 이 부분 수정하세요.
		        var chartDateformat     = 'yyyy년MM월dd일';
		        //라인차트의 라인 수
		        var chartLineCount    = 10;
		        //컨트롤러 바 차트의 라인 수
		        var controlLineCount    = 10;
		 
		      
		        function drawDashboard3() {
		 
		          var data = new google.visualization.DataTable();
		          //그래프에 표시할 컬럼 추가
		          data.addColumn('datetime' , '날짜');
		          data.addColumn('number'   , '불쾌지수');
		 
		          //그래프에 표시할 데이터
		          var dataRow = [];
		 		  <%
		          for(int i = 0; i <articleList.size(); i++){ //
		        	int humidity   = articleList.get(i).getHumidity(); //습도
		        	int temperature     = articleList.get(i).getTemperature();
		 			
		        	double discomfort=(1.8*temperature)-(0.55*(1-humidity/100))*(1.8*temperature-26)+32;//불쾌지수
		        	String str= articleList.get(i).getTimeYMD();
		 			
		 			
		            String year= str.substring(0,4);
		            String month=Integer.toString((Integer.parseInt(str.substring(5,6))-1));
		            String day=str.substring(6,8);
		            
		 			%>
		           	var discomfort=<%=discomfort%>
		           	
		           	
		 			dataRow = [new Date(<%=year%>, <%=month%>, <%=day%>, '10'), discomfort];
		            data.addRow(dataRow);
		            <%
		          	}
		 			%>
		 			
		            var chart = new google.visualization.ChartWrapper({
		              chartType   : charttype,
		              containerId : 'lineChartArea4', //라인 차트 생성할 영역
		              options     : {
		                              isStacked   : 'percent',
		                              focusTarget : 'category',
		                              height          : 400,
		                              width              : '100%',
		                              legend          : { position: "top", textStyle: {fontSize: 13}},
		                              pointSize        : 5,
		                              tooltip          : {textStyle : {fontSize:12}, showColorCode : true,trigger: 'both'},
		                              hAxis              : {format: chartDateformat, gridlines:{count:chartLineCount,units: {
		                                                                  years : {format: ['yyyy년']},
		                                                                  months: {format: ['MM월']},
		                                                                  days  : {format: ['dd일']},
		                                                                  hours : {format: ['HH시']}}
		                                                                },textStyle: {fontSize:12}},
		                vAxis              : {minValue: 100,viewWindow:{min:0},gridlines:{count:-1},textStyle:{fontSize:12}},
		                animation        : {startup: true,duration: 1000,easing: 'in' },
		                annotations    : {pattern: chartDateformat,
		                                textStyle: {
		                                fontSize: 15,
		                                bold: true,
		                                italic: true,
		                                color: '#871b47',
		                                auraColor: '#d799ae',
		                                opacity: 0.8,
		                                pattern: chartDateformat
		                              }
		                            },
		                            series: { //선 색깔 변경  
		                                2: { color: '#e2431e' },
		                                3: { color: '#e7711b' },
		                                1: { color: '#f1ca3a' },
		                                0: { color: '#6f9654' },
		                                4: { color: '#1c91c0' },
		                                5: { color: '#43459d' },
		                              }
		              }
		            });
		 
		            var control = new google.visualization.ControlWrapper({
		              controlType: 'ChartRangeFilter',
		              containerId: 'controlsArea4',  //control bar를 생성할 영역
		              options: {
		                  ui:{
		                        chartType: 'LineChart',
		                        chartOptions: {
		                        chartArea: {'width': '60%','height' : 64},
		                          hAxis: {'baselineColor': 'none', format: chartDateformat, textStyle: {fontSize:12},
		                            gridlines:{count:controlLineCount,units: {
		                                  years : {format: ['yyyy년']},
		                                  months: {format: ['MM월']},
		                                  days  : {format: ['dd일']},
		                                  hours : {format: ['HH시']}}
		                            }},
		                            series: { //선 색깔 변경  
		                                2: { color: '#e2431e' },
		                                3: { color: '#e7711b' },
		                                1: { color: '#f1ca3a' },
		                                0: { color: '#6f9654' },
		                                4: { color: '#1c91c0' },
		                                5: { color: '#43459d' },
		                            },
		                        }
		                  },
		                    filterColumnIndex: 0
		                }
		            });
		 
		            var date_formatter = new google.visualization.DateFormat({ pattern: chartDateformat});
		            date_formatter.format(data, 0);
		 
		            var dashboard = new google.visualization.Dashboard(document.getElementById('Line_Controls_Chart3'));
		            window.addEventListener('resize', function() { dashboard.draw(data); }, false); //화면 크기에 따라 그래프 크기 변경
		            dashboard.bind([control], [chart]);
		            dashboard.draw(data);
		 
		        }
		          google.charts.setOnLoadCallback(drawDashboard3);
		 
		      }
		    }
$(document).ready(function(){
  google.charts.load('current', {'packages':['line','controls']});
  chartDrowFun.chartDrow(); //chartDrow() 실행
  chartDrowFun2.chartDrow(); //chartDrow() 실행
  chartDrowFun3.chartDrow(); //chartDrow() 실행
  chartDrowFun4.chartDrow(); //chartDrow() 실행
});
 </script>



</html>