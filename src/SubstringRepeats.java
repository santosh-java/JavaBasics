import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SubstringRepeats {
	public static void main(String[] args) {
		String s = "wre";
		boolean isUnique = false;
		String[] sArr = new String[]{"rew", "ff", "af", "AWd", "fda"};
		for(String str: sArr)
		{
			Pattern p = Pattern.compile(str);
			Matcher m = p.matcher(s+s);
			if(m.find()){
				isUnique = true;
				break;
			}
		}
		
		if(isUnique)
			System.out.println(s + " is unique string");
		else
			System.out.println(s + " is not unique");
	}

}
