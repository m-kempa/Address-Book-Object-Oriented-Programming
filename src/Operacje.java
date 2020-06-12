import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Operacje {

	 private ArrayList<Dane> mojeDane;
	 
	 //konstruktor przechowuje wszystkie nasze dane 
	 public Operacje() {
		 this.mojeDane = new ArrayList<>();
		 
	 }
	 
	 //metoda wypisujaca dane.
	 public void wypiszDane() {
	        for (int i = 0; i < this.mojeDane.size(); i++) {
	        	int nr = i+1;
	            System.out.println(nr +".");
	            System.out.println("Nazwisko: " + this.mojeDane.get(i).getNazwisko());
	            System.out.println("Imie: " + this.mojeDane.get(i).getImie());
	        	System.out.println("Numer telefonu: " + this.mojeDane.get(i).getNumer());
	        	System.out.println("Ulica: " + this.mojeDane.get(i).getUlica());
	        	System.out.println("Numer Domu: " + this.mojeDane.get(i).getNrdomu());
	        	System.out.println("Numer mieszkania: " + this.mojeDane.get(i).getNrmieszkania());
	        	System.out.println("Kod pocztowy: " + this.mojeDane.get(i).getKodpocztowy());
	        	System.out.println("Urzad pocztowy: " + this.mojeDane.get(i).getUrzadpocztowy());
	        	System.out.println(" ");
	        }
	 }
	 
	 
	 //metoda dodajca obiekt do naszej listy. Nie mo¿e byæ duplikacji nazwiska (nwm czy tak powinno byæ ale tak zrobi³em).
	 public boolean addNewDane (Dane dane) {
	        if (findDane(dane.getNazwisko()) >= 0) {
	            System.out.println("Takie nazwisko Ju¿ widnieje");
	            return false;
	        }

	        mojeDane.add(dane);
	        return true;
	    }
	 
	 //odszukuje pozycje
	 private int findDane(Dane dane) {
	        return this.mojeDane.indexOf(dane);
	    }
	 
	 //zwraca pozycje po nazwisku a nie po numerze.
	 private int findDane(String daneNazwisko) {
	        for (int i = 0; i < this.mojeDane.size(); i++) {
	            Dane dane = this.mojeDane.get(i);
	            if (dane.getNazwisko().equals(daneNazwisko)) {
	                return i;
	            }
	        }
	        return -1;
	    }
	 //metoda ktora zwraca szukany obiekt 
	 public Dane szukajDane(String nazwisko) {
	        int poz = findDane(nazwisko);
	        if (poz >= 0) {
	            return this.mojeDane.get(poz);
	        }
	        return null;
	    }
	 
	 //metoda usuwajaca Adres
	 public boolean deleteDane (Dane dane) {
	        int poz = findDane(dane);
	        if (poz < 0) {
	            System.out.println(dane.getNazwisko() + "nie znaleziono.");
	            return false;
	        }
	        this.mojeDane.remove(poz);
	        System.out.println(dane.getNazwisko() + " , zosta³ usuniety.");
	        return true;
	    }
	 
	 //Metoda akutalizujaca dane
	 public boolean updateDane (Dane stareNazwisko, Dane noweNazwisko) {
	        int poz = findDane(stareNazwisko);
	        if (poz < 0) {
	            System.out.println(stareNazwisko.getNazwisko() + ", nie znaleziono.");
	            return false;
	        } 

	        this.mojeDane.set(poz, noweNazwisko);
	        return true;
	    }
	 
	 public void odczyt_pliku() {
		   FileReader fr = null;
		   String linia = "";
		    
		   // OTWIERANIE PLIKU:
		   try {
		     fr = new FileReader("plik.txt");
		   } catch (FileNotFoundException e) {
		       System.out.println("B£¥D PRZY OTWIERANIU PLIKU!");
		       System.exit(1);
		   }

		   BufferedReader bfr = new BufferedReader(fr);
		   // ODCZYT KOLEJNYCH LINII Z PLIKU:
		   try {
		     while((linia = bfr.readLine()) != null){
		    	String[] tab = linia.split(" ");
		    	for (int i=0;tab.length>i;i++)
		    	{
		    		tab[i]=tab[i].replace("_"," ");
		    	}
		    	Dane noweDane1 = Dane.stworzDane(tab[0],tab[1],tab[2],tab[3],tab[4],tab[5],tab[6],tab[7]);
		        this.mojeDane.add(noweDane1);
		     }
		    } catch (IOException e) {
		        System.out.println("B£¥D ODCZYTU Z PLIKU!");
		        System.exit(2);
		   }

		   // ZAMYKANIE PLIKU
		   try {
		     fr.close();
		    } catch (IOException e) {
		         System.out.println("B£¥D PRZY ZAMYKANIU PLIKU!");
		         System.exit(3);
		        }
		    }
	 public void zapis_pliku() {
		 
	     FileWriter fw = null;

	    try {
	       fw = new FileWriter("plik.txt");
	          } catch (IOException e) {
	        e.printStackTrace();
	     }
	 
	   BufferedWriter bw = new BufferedWriter(fw);
	   try {
	       for (int i = 0; i < this.mojeDane.size(); i++) {
	         bw.write(this.mojeDane.get(i).getNazwisko().replace(" ", "_")+" "+this.mojeDane.get(i).getImie().replace(" ", "_")+" "+
	        		 this.mojeDane.get(i).getNumer().replace(" ", "_")+" "+this.mojeDane.get(i).getUlica().replace(" ", "_")+" "+this.mojeDane.get(i).getNrdomu().replace(" ", "_")+" "+
	        		 this.mojeDane.get(i).getNrmieszkania().replace(" ", "_")+" "+this.mojeDane.get(i).getKodpocztowy().replace(" ", "_")+" "+
	        		 this.mojeDane.get(i).getUrzadpocztowy().replace(" ", "_"));
	         if(i-1<this.mojeDane.size()) {
	        	 bw.newLine();
	         }
	       }
	     } catch (IOException e) {
	        e.printStackTrace();
	     }

	     try {
	        bw.close();
	        fw.close();
	     } catch (IOException e) {
	           e.printStackTrace();
	     }
	  }
		 
		 
	 }


