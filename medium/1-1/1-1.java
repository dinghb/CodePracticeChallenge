import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Main {

	public static void main(String[] args) {
		Map<String, Integer[]> countryDetailList = new HashMap<String, Integer[]>();
		int countryNum = 0;
		int countryDetailRow = 0 ;

		Scanner sc =new Scanner(System.in);
		while(sc.hasNext()){
			String input = sc.nextLine();
			boolean isCountryCountInput = Pattern.matches("^\\d+", input);

			if (isCountryCountInput) {
				if (countryNum != 0) {
					continue;
				}

				int inputNum = Integer.parseInt(input, 10);
				if (inputNum > 0 && inputNum < 21) {
					countryNum = inputNum;
				}
			} else {
				if (countryDetailRow < countryNum) {
					String[] countryDetailArr = splitCountryDetail(input);
					if (countryDetailArr != null) {
						int goldMedalNum = Integer.parseInt(countryDetailArr[1], 10);
						int sliverMedalNum = Integer.parseInt(countryDetailArr[2], 10);
						int bronzeMedalNum = Integer.parseInt(countryDetailArr[3], 10);

						Integer[] medalNumArr = {goldMedalNum, sliverMedalNum, bronzeMedalNum};
						countryDetailList.put(countryDetailArr[0], medalNumArr);

						countryDetailRow++;

						// if this is the last input
						if (countryDetailRow  == countryNum) {
							outputMedalRank(countryDetailList);

							// clean input.
							countryNum = 0;
							countryDetailRow = 0;
							countryDetailList = new HashMap<String, Integer[]>();
						}
						continue;
					}
				}
			}
		}
		sc.close();
	}

	/**
	 * transfer String "China 32 28 34" to Array ["China", "32", "28", "34"]
	 * @param countryDetailStr
	 * @return e.g ["China", "32", "28", "34"]
	 */
	public static String[] splitCountryDetail(String countryDetailStr) {
		if (countryDetailStr == null || "".equals(countryDetailStr)) {
			return null;
		}

		String[] ret = countryDetailStr.split(" ");
		if (ret.length != 4) {
			return null;
		}

		return ret;
	}

	/**
	 * China [32, 28, 34]
	 * England [12, 34, 22]
	 * France [23, 33, 2]
	 * Japan [12, 34, 25]
	 * Rusia [23, 43, 0]
	 *
	 * @param countryDetailList
	 * @return ["China", "Rusia", "France", "Japan", "England"]
	 */
	public static void outputMedalRank(Map<String, Integer[]> countryDetailList) {
		ArrayList<Map.Entry<String, Integer[]>> list = new ArrayList<Map.Entry<String, Integer[]>>(countryDetailList.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<String, Integer[]>>() {
			@Override
			public int compare(Entry<String, Integer[]> o1, Entry<String, Integer[]> o2) {

				Integer[] o1medalArr= o1.getValue();
				Integer[] o2medalArr= o2.getValue();
				if (Arrays.equals(o1medalArr, o2medalArr)) {
					return o1.getKey().compareTo(o2.getKey());
				} else {
					// compare goldMetal number
					if (o1medalArr[0] > o2medalArr[0]) {
						return -1;
					} else if (o1medalArr[0] == o2medalArr[0]) {
						// compare silverMetal number
						if (o1medalArr[1] > o2medalArr[1]) {
							return -1;
						} else if (o1medalArr[1] == o2medalArr[1]) {
							// compare brozeMetal number
							if (o1medalArr[2] > o2medalArr[2]) {
								return -1;
							} else {
								return 1;
							}
						} else {
							return 1;
						}
					} else {
						return 1;
					}
				}
			}
		});

		// output
		for(Map.Entry<String, Integer[]> countryDetail : list) {
			System.out.println(countryDetail.getKey());
		}
	}
}