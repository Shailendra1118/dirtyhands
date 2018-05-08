/**
 * 
 */
package com.best.misc.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Shailendra
 *
 */
public class ScrambledLogs {

	/**
	 * Problem : Given unordered (on timestamp) log files, make it sorted. E.g.
	 * 
	 * @throws FileNotFoundException
	 */
	// 2018-05-08 03:52:02 [Worker-17] DistStripedExecutorService [DEBUG] Removed serial executor - cfa265a9-1e26-4902-8421-c43d422df1be
	// 2018-05-08 02:52:02 [Worker-17] DistStripedExecutorService [DEBUG] Removed serial executor - cfa265a9-1e26-4902-8421-c43d422df1be
	/*
	 * Points - Time varies from 09:00:00 to 21:59:59 File could be very large in GBs
	 */

	public static void main(String[] args) throws FileNotFoundException {

		Pattern pat = Pattern
				.compile("^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}");

		Scanner scan = new Scanner(new File(
				"D:\\Keppler\\WorkInProgram\\src\\log.txt"));

		TreeMap<LocalDateTime, String> map = new TreeMap<LocalDateTime, String>();

		while (scan.hasNextLine()) {
			String curLine = scan.nextLine();
			String text = curLine.substring(curLine.indexOf("[Worker"),
					curLine.length());
			System.out.println("Text: " + text);
			Matcher matcher = pat.matcher(curLine); // pat.matcher("2018-05-08 03:52:02 334343");
			while (matcher.find()) {
				String curDt = "";
				System.out.println(curDt = matcher.group());
				DateTimeFormatter formatter = DateTimeFormatter
						.ofPattern("uuuu-MM-dd HH:mm:ss");

				LocalDateTime dateTime = LocalDateTime.parse(curDt, formatter);
				System.out.println(dateTime.toString());
				map.put(dateTime, text);

			}
		}

		System.out.println(map.toString());

	}
}
