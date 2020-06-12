import java.util.Scanner;

public class main {

    

    private static Scanner scanner = new Scanner(System.in);

    private static Operacje operacje = new Operacje();


    public static void main(String[] args) {
        boolean wyjscie = false;
        operacje.odczyt_pliku();
        menu();
        while (!wyjscie) {
                System.out.println("\nWcisnij klawisz 6 aby wyswietlic menu\n");
                
                int wybor = scanner.nextInt();
                scanner.nextLine();

            switch (wybor) {
                case 0:
                    System.out.println("\nWyjscie z aplikacji..");
                    wyjscie = true;
                    operacje.zapis_pliku();
                    break;
                case 1:
                    operacje.wypiszDane();
                    break;
                case 2:
                    dodajNowyAdres();
                    break;
                case 3:
                    Aktualizuj();
                    break;
                case 4:
                    Usun();
                    break;
                case 5:
                    wyszukaj();
                    break;
                case 6:
                    menu();
                    break;
                default:
                	System.out.println("Nie ma takiej opcji.");
                	break;
            }
            
                
        }
    }

    

    private static void menu() {
        System.out.println("\n_____Dostepne opcje_____\n");
        System.out.println("0 - Wylacz ksiaske adresowa\n" +
                "1 - Wyswietl wszystkie adresy\n" +
                "2 - Dodaj nowy adres\n" +
                "3 - Modyfikuj istniejacy adres\n" +
                "4 - Usun istniejacy adres\n" +
                "5 - Odszukaj adres po nazwisku\n"
                );
        System.out.println("Wybierz akcje z klawiatury: ");

    }

    private static void dodajNowyAdres() {
    	String nazwisko = null, imie = null, numer = null, ulica = null, nr_domu = null, nr_mieszkania = null, kod = null, urzad = null;
    	boolean naz = false;
    	while(!naz) {
        System.out.println("Podaj nazwisko: ");
         nazwisko = scanner.nextLine();
        if(!odpornosc.odpornosc_nazwisko(nazwisko)) {
        	System.out.println("Niepoprawne Nazwisko!");
        }
        else { naz = true;
        }
    	}
    	boolean im = false;
    	while(!im) {
        System.out.println("Podaj imie: ");
         imie = scanner.nextLine();
        if(!odpornosc.odpornosc_imie(imie)) {
        	System.out.println("Niepoprawne imie!");
    	}
        else { im = true;}
    	}
    	boolean nr_tel = false;
    	while(!nr_tel) {
        System.out.println("Podaj numer telefonu: ");
         numer = scanner.nextLine();
        if(!odpornosc.odpornosc_nrTel(numer)) {
        	System.out.println("Niepoprawny numer telefonu!");
    	}
        else { nr_tel = true;}
    	}
    	boolean ul = false;
    	while(!ul) {
        System.out.println("Podaj ulice: ");
         ulica = scanner.nextLine();
         if(!odpornosc.odpornosc_ulica(ulica)) {
         	System.out.println("Niepoprawny ulica!");
    	}
         else { ul=true;}
         }
    	boolean nr_d = false;
    	while(!nr_d) {
        System.out.println("Podaj numer domu: ");
         nr_domu = scanner.nextLine();
         if(!odpornosc.odpornosc_nrDomu(nr_domu)) {
          	System.out.println("Niepoprawny numer domu!");
     	}
          else { nr_d=true;}
    	}
    	boolean nr_m = false;
    	while(!nr_m) {
        System.out.println("Podaj numer mieszkania: ");
         nr_mieszkania = scanner.nextLine();
         if(!odpornosc.odpornosc_nrMieszkania(nr_mieszkania)) {
           	System.out.println("Niepoprawny numer mieszkania!");
      	}
           else { nr_m=true;}
     	}
    	boolean ko = false;
    	while(!ko) {
        System.out.println("Podaj kod pocztowy: ");
         kod = scanner.nextLine();
         if(!odpornosc.odpornosc_kodPocztowy(kod)) {
            	System.out.println("Niepoprawny kod pocztowy!");
       	}
            else { ko=true;}
      	}
    	boolean urz = false;
    	while(!urz) {
        System.out.println("Podaj urzad pocztowy: ");
         urzad = scanner.nextLine();
         if(!odpornosc.odpornosc_urzad(urzad)) {
         	System.out.println("Niepoprawny urzad pocztowy!");
    	}
         else { urz=true;}
    	}
		Dane noweDane = Dane.stworzDane(nazwisko, imie, numer, ulica, nr_domu, nr_mieszkania, kod, urzad);
        if (operacje.addNewDane(noweDane)) {
            System.out.println("Nowy adres zostal dodany");
        } else {
            System.out.println("Adres o tym nazwisku juz istnieje!");
        }

    }

    private static void Aktualizuj () {
        System.out.println("Podaj Nazwisko osoby ktora chcesz zaktualizowac: ");
        String naz = scanner.nextLine();
        Dane istniejacy = operacje.szukajDane(naz);
        if(istniejacy == null) {
            System.out.println("Nie znaleziono kontaktu o takim nazwisku.");
            return;
        }

        String nazwisko = null, imie = null, numer = null, ulica = null, nr_domu = null, nr_mieszkania = null, kod = null, urzad = null;
    	boolean nazw = false;
    	while(!nazw) {
        System.out.println("Podaj nazwisko: ");
         nazwisko = scanner.nextLine();
        if(!odpornosc.odpornosc_nazwisko(nazwisko)) {
        	System.out.println("Niepoprawne Nazwisko!");
        }
        else { nazw = true;}
    	}
    	boolean im = false;
    	while(!im) {
        System.out.println("Podaj imie: ");
         imie = scanner.nextLine();
        if(!odpornosc.odpornosc_imie(imie)) {
        	System.out.println("Niepoprawne imie!");
    	}
        else { im = true;}
    	}
    	boolean nr_tel = false;
    	while(!nr_tel) {
        System.out.println("Podaj numer telefonu: ");
         numer = scanner.nextLine();
        if(!odpornosc.odpornosc_nrTel(numer)) {
        	System.out.println("Niepoprawny numer telefonu!");
    	}
        else { nr_tel = true;}
    	}
    	boolean ul = false;
    	while(!ul) {
        System.out.println("Podaj ulice: ");
         ulica = scanner.nextLine();
         if(!odpornosc.odpornosc_ulica(ulica)) {
         	System.out.println("Niepoprawny ulica!");
    	}
         else { ul=true;}
         }
    	boolean nr_d = false;
    	while(!nr_d) {
        System.out.println("Podaj numer domu: ");
         nr_domu = scanner.nextLine();
         if(!odpornosc.odpornosc_nrDomu(nr_domu)) {
          	System.out.println("Niepoprawny numer domu!");
     	}
          else { nr_d=true;}
    	}
    	boolean nr_m = false;
    	while(!nr_m) {
        System.out.println("Podaj numer mieszkania: ");
         nr_mieszkania = scanner.nextLine();
         if(!odpornosc.odpornosc_nrMieszkania(nr_mieszkania)) {
           	System.out.println("Niepoprawny numer mieszkania!");
      	}
           else { nr_m=true;}
     	}
    	boolean ko = false;
    	while(!ko) {
        System.out.println("Podaj kod pocztowy: ");
         kod = scanner.nextLine();
         if(!odpornosc.odpornosc_kodPocztowy(kod)) {
            	System.out.println("Niepoprawny kod pocztowy!");
       	}
            else { ko=true;}
      	}
    	boolean urz = false;
    	while(!urz) {
        System.out.println("Podaj urzad pocztowy: ");
         urzad = scanner.nextLine();
         if(!odpornosc.odpornosc_urzad(urzad)) {
         	System.out.println("Niepoprawny urzad pocztowy!");
    	}
         else { urz=true;}
    	}

        Dane noweDane = Dane.stworzDane(nazwisko, imie, numer, ulica, nr_domu, nr_mieszkania, kod, urzad);
        if(operacje.updateDane(istniejacy,noweDane)) {
            System.out.println("Aktualzacja powiodla sie");
        } else {
            System.out.println("Cos poszlo nie tak.");
        }

    }

    private static void Usun () {
        System.out.println("Podaj nazwisko do usuniecia: ");
        String naz = scanner.nextLine();
        Dane istniejacy = operacje.szukajDane(naz);
        if (istniejacy == null) {
            System.out.println("Nie znaleziono osoby o podanym Nazwisku.");
            return;
        }

        if (operacje.deleteDane(istniejacy)) {
            System.out.println("Usuwanie....");
        } else {
            System.out.println("Cos poszlo nie tak.");
        }
    }

    private static void wyszukaj () {
        System.out.println("Podaj nazwisko szukanej osoby. ");
        String nazwisko = scanner.nextLine();
        Dane istniejacy = operacje.szukajDane(nazwisko);
        if (istniejacy == null) {
            System.out.println("Nie ma takiej osoby.");
            return;
        }
        System.out.println("Nazwisko: "+ istniejacy.getNazwisko());
        System.out.println("Imie: "+ istniejacy.getImie());
        System.out.println("Numer telefonu: "+ istniejacy.getNumer());
        System.out.println("Ulica: "+ istniejacy.getUlica());
        System.out.println("Numer domu: "+ istniejacy.getNrdomu());
        System.out.println("Numer mieszkania: "+ istniejacy.getNrmieszkania());
        System.out.println("Kod pocztowy: "+ istniejacy.getKodpocztowy());
        System.out.println("Urzad pocztowy: "+ istniejacy.getUrzadpocztowy());
    }
    
}