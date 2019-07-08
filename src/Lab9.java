import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Lab9 {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);

		Map<String, Double> items = new HashMap<>();
		ArrayList<String> itemOrdered = new ArrayList<>(8);
		ArrayList<Double> itemValue = new ArrayList<>(8);

		items.put("beans", 0.59);
		items.put("bananas", 0.59);
		items.put("cauliflower", 1.59);
		items.put("grapes", 2.00);
		items.put("rice", 1.79);
		items.put("lettuce", 2.59);
		items.put("cabbage", 2.39);
		items.put("milk", 2.50);

		boolean valid = false;

		do {

			System.out.println("Welcome to Guether's Market!\n");

			System.out.println("Item                Price");
			System.out.println("==================================");

			for (Map.Entry<String, Double> me : items.entrySet()) {

				System.out.printf("%-20s %-10.2f\n", me.getKey(), me.getValue());
			}

			System.out.print("\nWhat item would you like to order?: ");

			String custItem = scnr.nextLine();

			if (items.get(custItem) == null) {
				System.out.println("Sorry, we don't have those. Please try again.");

			} else {

				System.out.printf("Adding " + custItem + " to cart at $%.2f", items.get(custItem));
				System.out.println(".");

				itemOrdered.add(custItem);
				itemValue.add(items.get(custItem));

				// System.out.println(itemOrdered);
				// System.out.println(itemValue);
			}

			int flag = 0;

			do {
				System.out.print("\nWould you like to order anything else (y/n)?: ");
				String userInput = scnr.nextLine();

				if (userInput.equalsIgnoreCase("y")) {
					flag = 1;
				} else if (userInput.equalsIgnoreCase("n")) {
					flag = 1;
					System.out.println("\nThanks for your order!");
					valid = true;
				} else if ((!userInput.equalsIgnoreCase("y")) || (!userInput.equalsIgnoreCase("n"))) {
					System.out.println("\nInvalid response. Please type \"y\" or \"n\".");
					continue;
				}
			} while (flag != 1);

		} while (!valid);

		scnr.close();

		System.out.println("Here's what you got:\n");

		for (int i = 0; i < itemOrdered.size(); i++) {
			System.out.printf("%-20s %-10.2f\n", itemOrdered.get(i), itemValue.get(i));
		}
		System.out.println();

		costAvg(itemValue);
		maxCost(itemValue);
		leastCost(itemValue);

	}

	public static void costAvg(ArrayList<Double> average) {

		double sum = 0;
		double avg = 0;

		for (int i = 0; i < average.size(); i++) {
			sum = sum + average.get(i);
		}

		avg = sum / average.size();
		System.out.printf("Your average cost is $%.2f", avg);
		System.out.printf(". ");

	}

	public static void maxCost(ArrayList<Double> items) {

		double maxValue = 0;
		int i;
		int j = 0;
		for (i = 0; i < items.size(); i++) {

			if (maxValue <= items.get(i)) {
				maxValue = items.get(i);
				j = i;
			}

		}
		System.out.printf("\nThe highest cost item is $ %.2f", maxValue);
		System.out.printf(" at index " + j + ".");
	}

	public static void leastCost(ArrayList<Double> items) {

		double leastValue = 0;
		int i;
		int j = 0;
		for (i = 0; i < items.size() - 1; i++) {

			if (items.get(i) < items.get(i + 1)) {
				leastValue = items.get(i);
				j = i;
			}

		}
		System.out.println("\nThe lowest cost item is $" + leastValue + " at index " + j + ".");
	}

}
