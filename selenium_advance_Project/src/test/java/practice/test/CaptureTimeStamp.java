package practice.test;

import java.util.Date;

import org.testng.annotations.Test;

public class CaptureTimeStamp {
	@Test
	public void TimeTest() {
		String time = new Date().toString();
		System.out.println(time);
	}

	@Test
	public void TimeTest1() {
		String time = new Date().toString().replace(" ","_").replace(":", "_");
		System.out.println(time);
	}
}
