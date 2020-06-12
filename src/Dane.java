
public class Dane extends Adres  {
String nazwisko;
String imie;
String numer;




public Dane(String nazwisko, String imie, String numer, String ulica, String nr_domu, String nr_mieszkania, String kod_pocztowy, String urzad_pocztowy) {
	super(ulica, nr_domu, nr_mieszkania, kod_pocztowy, urzad_pocztowy);
	this.nazwisko = nazwisko;
	this.imie = imie;
	this.numer = numer;
}

public String getNazwisko() {
	return nazwisko;
}

public String getImie() {
	return imie;
}

public String getNumer() {
	return numer;
}
public String getUlica() {
	return ulica;
}
public String getNrdomu() {
	return nr_domu;
}
public String getNrmieszkania() {
	return nr_mieszkania;
}
public String getKodpocztowy() {
	return kod_pocztowy;
}
public String getUrzadpocztowy() {
	return urzad_pocztowy;
}

//specjalna metoda przyjmujaca parametry jak konstruktor ale zwracajaca obiekt Dane.
public static Dane stworzDane(String nazwisko, String imie, String numer, String ulica, String nr_domu, String nr_mieszkania, String kod_pocztowy, String urzad_pocztowy)
{
	return new Dane( nazwisko, imie, numer, ulica, nr_domu, nr_mieszkania, kod_pocztowy, urzad_pocztowy);
}

}
