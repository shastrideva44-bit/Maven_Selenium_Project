package practice.basics;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JavaBasics_Calender {

	public static void main(String[] args) {
			Date dateObj = new Date();
			SimpleDateFormat sim =new SimpleDateFormat ("yyyy-MM-dd");
			String actDate = sim.format(dateObj);
			System.out.println(actDate);
			 
			Calendar cal = sim.getCalendar();
			cal.add(Calendar.DAY_OF_MONTH,-30);
			
			String dateRequires = sim.format(cal.getTime());
			System.out.println(dateRequires);
			
			cal.add(Calendar.DAY_OF_MONTH,+30);
			String dateRequires1 = sim.format(cal.getTime());
			System.out.println(dateRequires1);
			cal.add(Calendar.DAY_OF_MONTH,+30);
			String dateRequires2 = sim.format(cal.getTime());
			System.out.println(dateRequires2);
	}

}

