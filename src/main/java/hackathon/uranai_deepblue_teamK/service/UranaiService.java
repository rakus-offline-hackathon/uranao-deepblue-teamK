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
	
	public int uranai(String name, String birth, LocalDateTime dateTime){
		int num = convertToUnicode(name);
		int num2 = Integer.parseInt(birth);
		int currentMinutes = dateTime.getMinute();
		return (num + num2 + currentMinutes)%27 + 1;
	}
}
