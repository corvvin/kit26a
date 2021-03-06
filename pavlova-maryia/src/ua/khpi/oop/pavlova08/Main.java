package ua.khpi.oop.pavlova08;

import java.io.IOException;
import java.util.Scanner;

import ua.khpi.oop.pavlova06.NewContainerOfStrings;
import ua.khpi.oop.pavlova08.util.ChoiceUtil;

public class Main {
	public Scanner scanner = new Scanner(System.in);

	public static void main(final String[] args) throws IOException {
		int command = 0;
		NewContainerOfStrings hotelGuests = new NewContainerOfStrings();
		while (command < 15) {
			command = ChoiceUtil.listOfCommands(command);
			CommandParser.doCommand(command, hotelGuests);
		}

	}
}
