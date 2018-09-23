package fluxChrono_package;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class FluxChrono {

	public static void main(String[] args) {

		/*
		 * GREAT SCOTT, another cheesy greeting!!:
		 */

		/*
		 * I apologize for the crudity of the title flag: The little clock face was
		 * intended to resemble a flux capacitor, but since the backslash is an escape,
		 * the rendering got bungled. This is actually to explain the appearance of the
		 * code. The whole thing looks much better in runtime. End Doc Brown Rant Mode.
		 */

		System.out.println("  OOOOOO   ========================");
		System.out.println(" O \\  //O  ~~~~~~ The ~~~~~~~~~~~~~");
		System.out.println("O   \\//  O ****** Flux ************");
		System.out.println("O   ||   O ~~~~~~ Chronometer ~~~~~");
		System.out.println(" O  ||  O  ========================");
		System.out.println("  OOOOOO         by Matt Ward");
		System.out.println(" "); // Brief description of program's function:
		System.out.println("Get the distance between two dates in time!");
		System.out.println(" "); // User instructions below:

		Scanner scnr = new Scanner(System.in);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMMM-dd");

		/*
		 * The user will just punch in a date, but we'll take their string and turn it
		 * into a LocalDate object. Thanks, java.time!!!
		 */

		String startingDateInput;
		String endingDateInput;

		/*
		 * This input scheme could be easily broken by someone who can't spell... But in
		 * runtime it does look a lot prettier than BASIC_ISO_FORMAT!
		 */
		System.out.println("Please enter Date #1 in 'yyyy-MMMM-dd' format");
		System.out.println("(For example: 1955-November-05) and press Enter:");
		startingDateInput = scnr.next();
		System.out.println("Please enter Date #2 in same format as above:");
		endingDateInput = scnr.next();
		System.out.println(" ");

		// Containers for the soon-to-be parsed dates; Final LocalDate objects:
		LocalDate startingDate;
		LocalDate endingDate;

		// Parsing the dates from the text strings:
		startingDate = LocalDate.parse(startingDateInput, formatter);
		endingDate = LocalDate.parse(endingDateInput, formatter);

		// And this one line is where all the fun happens. Pretty anti-climactic, eh?
		Period duration = Period.between(startingDate, endingDate);

		isItPluralOrNot(scnr, duration);
	}

	public static void isItPluralOrNot(Scanner scnr, Period duration) {
		/*
		 * Now this is where OCD leads us, because we can't have a duration come out as
		 * "1 years, 1 months, and 1 days. Plus, since it's a rather serious-looking
		 * block of code for what is really not that important to the basic
		 * functionality of the program, I thought I could make things look neater by
		 * tucking this away in its own method."
		 */

		// If the Year counter is 1 and the others aren't:
		if (((duration.getYears() == 1) && (duration.getMonths() != 1)) && duration.getDays() != 1) {
			System.out.print("The duration between these two dates is " + duration.getYears() + " year, ");
			System.out.print(duration.getMonths() + " months, ");
			System.out.println("and " + duration.getDays() + " days.");
		}
		// If the Year and Month counters are 1 and the Day counter isn't:
		if (((duration.getYears() == 1) && (duration.getMonths() == 1)) && duration.getDays() != 1) {
			System.out.print("The duration between these two dates is " + duration.getYears() + " year, ");
			System.out.print(duration.getMonths() + " month, ");
			System.out.println("and " + duration.getDays() + " days.");
		}
		// If the Year and Day counters are 1 and the Month counter isn't:
		if (((duration.getYears() == 1) && (duration.getDays() == 1)) && duration.getMonths() != 1) {
			System.out.print("The duration between these two dates is " + duration.getYears() + " year, ");
			System.out.print(duration.getMonths() + " months, ");
			System.out.println("and " + duration.getDays() + " day.");
		}
		// If all three counters are 1:
		if (((duration.getYears() == 1) && (duration.getMonths() == 1)) && duration.getDays() == 1) {
			System.out.print("The duration between these two dates is " + duration.getYears() + " year, ");
			System.out.print(duration.getMonths() + " month, ");
			System.out.println("and " + duration.getDays() + " day.");
		}
		// If the Month counter is 1 and the others aren't:
		if (((duration.getMonths() == 1) && (duration.getYears() != 1)) && duration.getDays() != 1) {
			System.out.print("The duration between these two dates is " + duration.getYears() + " years, ");
			System.out.print(duration.getMonths() + " month, ");
			System.out.println("and " + duration.getDays() + " days.");
		}
		// If the Month and Day counters are 1 and the Year counter isn't:
		if (((duration.getMonths() == 1) && (duration.getDays() == 1)) && duration.getYears() != 1) {
			System.out.print("The duration between these two dates is " + duration.getYears() + " years, ");
			System.out.print(duration.getMonths() + " month, ");
			System.out.println("and " + duration.getDays() + " day.");
		}
		// If the Day counter is 1 and the others aren't:
		if (((duration.getDays() == 1) && (duration.getMonths() != 1)) && duration.getYears() != 1) {
			System.out.print("The duration between these two dates is " + duration.getYears() + " years, ");
			System.out.print(duration.getMonths() + " months, ");
			System.out.println("and " + duration.getDays() + " day.");
		}
		// Finally if NONE of them are 1:
		if (((duration.getDays() != 1) && (duration.getMonths() != 1)) && duration.getYears() != 1) {
			System.out.print("The duration between these two dates is " + duration.getYears() + " years, ");
			System.out.print(duration.getMonths() + " months, ");
			System.out.println("and " + duration.getDays() + " days.");
		}

		scnr.close();

		// TO BE CONTINUED...
	}

}
