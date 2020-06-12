
public class odpornosc {

	public static boolean odpornosc_nazwisko(String nazwisko) {
		return nazwisko.matches("[a-zA-z]+(['-][a-zA-Z]+)*");
	}
	
	public static boolean odpornosc_imie(String imie) {
			return imie.matches("[A-Z][a-zA-Z]*");
	}
	
	public static boolean odpornosc_nrTel(String nrTel) {
		return nrTel.matches("(?:\\(?\\+?48)?(?:[-\\.\\(\\)\\s]*(\\d)){9}\\)?");
	}
	
	public static boolean odpornosc_ulica(String ulica) {
		return ulica.matches("[A-Za-z0-9\\s]+");
	}
	
	public static boolean odpornosc_nrDomu(String nrDomu) {
		return nrDomu.matches("[0-9]+[a-z]?");
	}
	
	public static boolean odpornosc_nrMieszkania(String nrMieszkania) {
		return nrMieszkania.matches("[0-9]+[a-z]?");
	}
	
	public static boolean odpornosc_kodPocztowy(String kodPocztowy) {
		return kodPocztowy.matches("[0-9]{2}-[0-9]{3}");
	}
	
	public static boolean odpornosc_urzad(String urzad) {
		return urzad.matches("[A-Za-z0-9\\s]+");
	}
	
}
