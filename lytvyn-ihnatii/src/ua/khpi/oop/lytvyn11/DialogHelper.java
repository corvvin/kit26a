package ua.khpi.oop.lytvyn11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import ua.khpi.oop.lytvyn.util.Console;

/**
 * Забезпечує обробку команд користувача у вигляді інтерактивного діалогового
 * меню.
 * 
 * @author student Lytvyn I.I. KIT-26A
 */
public class DialogHelper {

	/**
	 * Перелік команд
	 * 
	 * @author student Lytvyn I.I. KIT-26A
	 */
	public enum ACTION {
		add, generate, clean, exit, read, remove, save, sort, show
	}

	/**
	 * 
	 */
	static int DEFAULT_SIZE = 10;

	/**
	 * Бюро знайомств
	 */
	static Bureau bureau = new Bureau();

	/**
	 * Клієнти
	 */
	static LinkedList<Client> clients = new LinkedList<>();

	/**
	 * Розмежувач
	 */
	public static String LINE = "----------------------------------------------"
	        + "--------------------------\n";
	/**
	 * Сканування вводу
	 */
	public static Scanner sc = new Scanner(System.in);
	/**
	 * Підтвердження завершення роботи
	 */
	public static boolean exit = false;

	/**
	 * Реєстраційний номер
	 */
	private static int regNum = 0;

	/**
	 * Додавання нового клієнту
	 */
	public static void add() {
		final Client temp = ClientUtil.build();
		if (temp != null) {
			temp.setRegNum(regNum);
			clients.addLast(temp);
			bureau.setClients(clients);
			regNum++;
		} else {
			System.out.println("Введено некоректні дані!");
		}
	}

	/**
	 * Генерування нових клієнтів
	 * 
	 * @param count
	 *            кількість клієнтів
	 */
	public static void generate(int count) {
		clients = new LinkedList<>(ClientUtil.buildClients(count));
		regNum = clients.size();
		bureau.setClients(clients);
	}

	/**
	 * Отримує відповідь від користувача
	 * 
	 * @return answer відповідь від користувача
	 * @throws IOException
	 *             виняткова ситуація при роботі з вводом
	 */
	public static String getInput() throws IOException {
		System.out.format("\nВаша відповідь: ");
		final BufferedReader br = new BufferedReader(
		        new InputStreamReader(System.in));
		final String answer = br.readLine(); // Запис тексту до буферу
		return answer;
	}

	/**
	 * Виконує обробку введеної команди
	 * 
	 * @param action
	 *            введена команда
	 * @throws Exception
	 *             будь-яка виникаюча виняткова ситуація
	 */
	public static void handleAction(ACTION action) throws Exception {
		switch (action) {
		case add:
			add();
			break;
		case generate:
			System.out.println("Введіть кількість клієнтів.");
			final String size = getInput();
			final int count = Integer.parseInt(size);
			generate(count);
			break;
		case clean:
			clients.clear();
			regNum = clients.size();
			bureau.setClients(clients);
			break;
		case read:
			/* Зчитування екземпляру контейнеру */
			System.out.println("Виберіть варіант:");
			System.out.println("1. Стандартна серіалізація");
			System.out.println("2. Без використання протоколу серіалізації");
			final int serNum = Integer.parseInt(getInput());
			if (serNum == 1) {
				read(true, null);
			} else if (serNum == 2) {
				read(false, null);
			} else {
				throw new IllegalArgumentException();
			}
			break;
		case remove:
			/* Видалення */
			System.out.println("Введіть реєстраційний номер");
			final String num = getInput();
			final int regNum = Integer.parseInt(num);
			final Client remove = ClientUtil.build();
			remove.setRegNum(regNum);
			remove(remove);
			break;
		case save:
			/* Запис контейнеру */
			System.out.println("Виберіть варіант:");
			System.out.println("1. Стандартна серіалізація");
			System.out.println("2. Без використання протоколу серіалізації");
			final int dserNum = Integer.parseInt(getInput());
			if (dserNum == 1) {
				save(true, null);
			} else if (dserNum == 2) {
				save(false, null);
			} else {
				throw new IllegalArgumentException();
			}
			break;
		case sort:
			/* Запис контейнеру */
			System.out.println("Виберіть варіант:");
			System.out.println("1. date");
			System.out.println("2. hobby");
			System.out.println("3. reqs");
			final int sortNum = Integer.parseInt(getInput());
			if (sortNum == 1) {
				ClientUtil.sort(clients,
				        ComparatorFactory.getComparator("date"));
			} else if (sortNum == 2) {
				ClientUtil.sort(clients,
				        ComparatorFactory.getComparator("hobby"));
			} else if (sortNum == 3) {
				ClientUtil.sort(clients,
				        ComparatorFactory.getComparator("reqs"));
			} else {
				throw new IllegalArgumentException();
			}
			bureau.setClients(clients);
			break;
		case show:
			show();
			break;
		case exit:
			exit = true;
			break;
		default:
			System.err.println("Error data ^-(");
			break;
		}
	}

	/**
	 * @param isStandart
	 *            чи стандартна серіалізація
	 * @param path
	 */
	public static void read(boolean isStandart, String path) {
		if (isStandart) {
			clients = SerializationUtil.deserialize(path);
		} else {
			clients = SerializationUtil.read(path);
		}
		bureau.setClients(clients);
	}

	/**
	 * Видалення клієнту
	 * 
	 * @param client
	 *            який потрібно видалити
	 */
	public static void remove(Client client) {
		clients.remove(client);
		bureau.setClients(clients);
	}

	/**
	 * @param isStandart
	 *            чи стандартна десеріалізація
	 * @param path
	 */
	public static void save(boolean isStandart, String path) {
		if (isStandart) {
			SerializationUtil.serialize(bureau.getClients(), path);
		} else {
			SerializationUtil.save(bureau.getClients(), path);
		}
	}

	/**
	 * Показ клієнтів
	 */
	public static void show() {
		if (bureau.getClients().isEmpty()) {
			System.out.println("Контейнер порожній!");
		} else {
			/* Виведення клієнтів */
			System.out.println("\nПоточний вміст контейнеру:\n");
			System.out.println(bureau);
		}
	}

	/**
	 * Реалізує інтерактивне діалогове меню для забезпечення отримання команд
	 * від користувача
	 * 
	 * @param isAuto
	 * @param initSize
	 */
	public static void start(boolean isAuto, int initSize) {
		if (isAuto) {
			Console.clean();
			if (Explorer.auto()) {
				read(false, Explorer.DEFAULT_PATH);
				if (clients.size() == 0) {
					System.out.println("Дані відсутні! "
					        + "Буде згенеровано список клієнтів!");
					generate(DEFAULT_SIZE);
				} else {
					System.out.println(
					        "#-----------------------------------------------------#");
					System.out.println(
					        "| Зчитано список клієнтів в автоматичному режимі! |");
					System.out.println(
					        "#-----------------------------------------------------#");
				}

			} else {
				System.out.println(
				        "#-----------------------------------------------------#");
				System.out.println(
				        "| Згенеровано список клієнтів в автоматичному режимі! |");
				System.out.println(
				        "#-----------------------------------------------------#");
				if (initSize == 0) {
					generate(DEFAULT_SIZE);
				} else {
					generate(initSize);
				}
				// save(false, Explorer.DEFAULT_PATH);
			}
			Console.pause();
		}
		do {
			Console.clean();
			comands();
			System.out.format("\nВведіть команду: ");
			sc = new Scanner(System.in);
			final ACTION cur = ACTION.valueOf(sc.next());
			try {
				handleAction(cur);
				Console.pause();
			} catch (final Exception ex) {
				System.out.println(ex.toString());
			}
		} while (!exit);
	}

	/**
	 * Список команд очищення контейнера, перетворення у масив, перетворення у
	 * рядок, перевірку на наявність елементів
	 */
	private static void comands() {
		System.out.format("Список доступних команд:\n\n");
		System.out.format("add - додавання новогу клієнту\n");
		System.out.format("generate - додавання згенерованих клієнтів\n");
		System.out.format("read - зчитування бюро з файлу\n");
		System.out.format("remove - видалення клієнту\n");
		System.out.format("show - перегляд бюро\n");
		System.out.format("sort - сортування бюро\n");
		System.out.format("save - збереження бюро\n");
		System.out.format("exit - завершення програми\n");
		System.out.format("clean - очищення клієнтів\n");
		System.out.format("sort - сортуванння клієнтів\n");
	}
}