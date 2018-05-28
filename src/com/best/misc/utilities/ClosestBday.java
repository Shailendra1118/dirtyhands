/**
 * 
 */
package com.best.misc.utilities;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author Shailendra
 * 
 */

// Problem : Give person and Birthdates, you have to find two persons whose Bdays are closest to each other.
// Obiously you have to ignore year of their Bdate

public class ClosestBday {

	public static void main(String[] args) {
		Map<String, LocalDate> bdays = new HashMap<>();
		// Calendar sbday = Calendar.getInstance();
		// sbday.set(1990, 0, 21);

		LocalDate sbday = LocalDate.of(1990, 1, 21);
		bdays.put("Shyam", sbday);

		LocalDate rbday = LocalDate.of(1993, 2, 12);
		bdays.put("Ram", rbday);

		LocalDate pbday = LocalDate.of(1989, 12, 31);
		bdays.put("Punit", pbday);

		LocalDate vbday = LocalDate.of(1993, 2, 06);
		bdays.put("Vary", vbday);

		findClosest(bdays);

	}

	/**
	 * @param bdays
	 */
	private static void findClosest(Map<String, LocalDate> bdays) {

		// Logic : Ignore years and Sort the bdays with months and dates
		TreeSet<LocalDate> dats = new TreeSet<>();
		for (Map.Entry<String, LocalDate> entry : bdays.entrySet()) {
			dats.add(entry.getValue());
		}

		for (LocalDate d : dats) {
			System.out.println(d.toString());
		}

		Map<String, LocalDate> result = bdays
				.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByValue())
				.collect(
						Collectors.toMap(Map.Entry::getKey,
								Map.Entry::getValue, (ov, nv) -> ov,
								LinkedHashMap::new));

		// find the minimum diff
		int min = Integer.MAX_VALUE;
		int minIdx = 0;
		List<LocalDate> sorted = new ArrayList<>(result.values());
		for (int i = 0; i < sorted.size() - 1; i++) {
			int currDiff = Period.between(sorted.get(i), sorted.get(i + 1))
					.getDays();
			// System.out.println("currDiff: " + currDiff);
			if (currDiff < min) {
				System.out.println("days: " + currDiff + " indx: " + i + " & "
						+ (i + 1));
				min = currDiff;
				minIdx = i;
			}
		}

		// System.out.println("MinIdx " + minIdx);

		Iterator<Entry<String, LocalDate>> iter = result.entrySet().iterator();
		int idx = 0;
		while (iter.hasNext()) {
			Entry e = iter.next();
			if (idx == minIdx || idx == minIdx + 1) {
				System.out.println("Ans: " + e.toString());
			}
			idx++;
		}

	}
}
