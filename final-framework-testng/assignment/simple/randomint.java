package simple;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.annotations.Test;


public class randomint {
	
	@Test
	public void testphonenumvalidation() {
		
		String s = "asssss";
		Pattern p = Pattern.compile("[7-9]{1}[0-9]{9}"); 
		Matcher m = p.matcher(s);
		boolean flag = m.matches();
		System.out.println("flag"+flag);
		
	}

	
/*	@Test
	public void stringverify() {
		
		String s = "vidya@gmail.com";
		if(!s.contains("@"))
			System.out.println("Invalid mail missing @");
		else if(!s.contains(".com"))
			System.out.println("Invalid mail missing .com");
		else
		{Random rand = new Random(1000); 
		Integer rand_int  = rand.nextInt();
		if(rand_int<1)
			rand_int=rand_int*-1;
		String ran = rand_int.toString();
		
		System.out.println(ran);
				String newmail= s.replace("@",ran+"@");
		System.out.println(newmail);}
		
	}*/

}
