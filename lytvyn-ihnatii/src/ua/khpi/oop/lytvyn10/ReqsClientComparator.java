package ua.khpi.oop.lytvyn10;

/**
 * Компаратор за вимогами
 * 
 * @author student Lytvyn I.I. KIT-26A
 */
public class ReqsClientComparator implements ClientComparator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see ua.khpi.oop.lytvyn09.ClientComparator#compare(ua.khpi.oop.lytvyn09.
	 * Client, ua.khpi.oop.lytvyn09.Client)
	 */
	@Override
	public int compare(Client first, Client second) {
		return first.getRequirements().length - second.getRequirements().length;
	}
}
