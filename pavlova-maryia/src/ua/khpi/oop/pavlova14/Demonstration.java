package ua.khpi.oop.pavlova14;

import java.util.Random;

import ua.khpi.oop.pavlova10.HotelGuest;
import ua.khpi.oop.pavlova10.LinkedList;
import ua.khpi.oop.pavlova10.util.Comparators;
import ua.khpi.oop.pavlova10.util.SortUtil;

public class Demonstration {
	static FirstThread firstThread;
	static SecondThread secondThread;
	private static Random random = new Random();

	public static void demonstrateParallel(int num) {

		for (int i = 0; i < num; i++) {
			firstThread = new FirstThread(); // Создание потока
			secondThread = new SecondThread();
			firstThread.start(); // Запуск потока
			secondThread.start();

		}
	}

	public static void demonstrateSequential(int num) {
		LinkedList<HotelGuest> list = ExtraFunctions.createDefaultList();
		int i = 0;
		while (i < num) {
			int value = Integer.valueOf(random.nextInt(6));
			switch (value) {
			case 1:
				list = SortUtil.sort(list, Comparators.sortToBigByDays);
				break;
			case 2:
				list = SortUtil.sort(list, "MOTHERLAND");
				break;
			case 3:
				list = SortUtil.sort(list, "SURNAME");
				break;
			case 4:
				list = SortUtil.sort(list, "REASON");
				break;
			case 5:
				list = SortUtil.sort(list, Comparators.sortToBigByRoomNum);
				break;
			default:
				list = SortUtil.sort(list, "ROOM_CLASS");
				break;
			}
			switch (value) {
			case 1:
				RegexSearch.search(list, "[А-Я][а-я]+(,\\sУкраина)");
				break;
			case 2:
				RegexSearch.search(list, "Петров((\\s[А-Я][а-я]?\\.)([А-Я][а-я]?\\.){1,})");
				break;
			case 3:
				RegexSearch.search(list, "[А-Я][а-я]+((\\s[А]\\.)([Р]\\.){1,})");
				break;
			case 4:
				RegexSearch.search(list, "[5][1]");
				break;
			case 5:
				RegexSearch.search(list, "МТ\\-[4][5][2][1-8]{3}");
				break;
			default:
				RegexSearch.search(list, "Эконом");
				break;
			}
			i++;
		}

	}
}
