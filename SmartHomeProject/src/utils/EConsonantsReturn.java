package utils;

public class EConsonantsReturn {
	public static String getInitEngilsh(String text) {
	    String[] chs = { 
	        "ㄱ", "ㄲ", "ㄴ", "ㄷ", "ㄸ", 
	        "ㄹ", "ㅁ", "ㅂ", "ㅃ", "ㅅ", 
	        "ㅆ", "ㅇ", "ㅈ", "ㅉ", "ㅊ", 
	        "ㅋ", "ㅌ", "ㅍ", "ㅎ" 
	    };
	    String[] Echs= {
	    		"G","KK","N","D","TT",
	    		"L","M","B","PP","S",
	    		"SS","O","J","JJ","CH",
	    		"K","T","P","H"
	    };
			
	    if(text.length() > 0) {
	        char chName = text.charAt(0);
	        if(chName >= 0xAC00)
	        {
	            int uniVal = chName - 0xAC00;
	            int cho = ((uniVal - (uniVal % 28))/28)/21;

	            return Echs[cho];
	        }
	    }
	   		
	    return null; 
	}
	
	public static String getCityNumber(String city) {
		String cityId="";
		String [] cityList= {
				"서울", "부산", "대구","인천","광주","대전","울산",
				"세종", "경기", "강원","충북","충남","전북","전남",
				"경북", "경남", "제주특별자치도"
		};
		String [] cityNumber= {
				"02", "051", "053","032","062","042","052",
				"044", "031", "033","043","041","063","061",
				"054", "055", "064"
		};
		for(int i=0; i<cityList.length; i++) {
			if(city.equals(cityList[i])) { //해당 지역의 지역 번호 리턴
				return cityNumber[i];
			}
		}
		
		
		return cityId;
	}

	
}
