package practice.basics;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaBasics2_SPECIFIC_DATE_FORMAT {

	public static void main(String[] args) {
		Date dateObj = new Date();
		SimpleDateFormat sim =new SimpleDateFormat ("yyyy-MM-dd");
		String actDate = sim.format(dateObj);
		System.out.println(actDate);
		

	}

}
