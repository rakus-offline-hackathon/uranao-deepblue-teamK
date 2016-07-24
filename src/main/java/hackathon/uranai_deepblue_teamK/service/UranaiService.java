package hackathon.uranai_deepblue_teamK.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class UranaiService {
 
	/**
	 * Unicode文字列に変換する("あ" -> "\u3042")
	 * @param original
	 * @return
	 */
	private int convertToUnicode(String original)
	{
		int total = 0;
	    for (int i = 0; i < original.length(); i++) {
	    	String str = String.format("\\u%04X", Character.codePointAt(original, i));
	        total += changeNum(str);
	    }
	    return total;
	}
	
	private int changeNum(String num){
		
		int i = 0;
		try{
			i = Integer.parseInt(num.replace("\\u", ""), 16);
		}catch(Exception ex){
			System.err.println("error");
		}
		return i;
	}
	
	public String uranai(String name, String birth){
		int num = convertToUnicode(name);
		int num2 = Integer.parseInt(birth);
		int currentMinutes = LocalDateTime.now().getMinute();
		int answer = (num + num2 + currentMinutes)%27 + 1;
		String img = null;
		if(String.valueOf(answer).length() > 1){
			img = "/img/0" + answer + ".gif";
		}else{
			img = "/img/00" + answer + ".gif";
		}
		return img;
	}
}
