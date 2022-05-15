package biblioteka;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import osobe.Administrator;
import osobe.Bibliotekar;
import osobe.Clan;
import knjige.Knjiga;
import knjige.Zanr;
import knjige.Primerak;
import knjige.Iznajmljivanje;

public class Biblioteka {

	private String id;
	private String naziv;
	private String adresa;
	private String telefon;
	private String radnoVreme;
	private ArrayList<Administrator> administatori;
	private ArrayList<Bibliotekar> bibliotekari;
	private ArrayList<Clan> clanovi;
	private ArrayList<Knjiga> knjige;
	private ArrayList<Zanr> zanrovi;
	private ArrayList<Primerak> primerci;
	private ArrayList<Iznajmljivanje> iznajmljivanja;
	
	public Biblioteka() {
		this.id = "";
		this.naziv = "";
		this.adresa = "";
		this.telefon = "";
		this.radnoVreme = "";
		this.administatori = new ArrayList<Administrator>();
		this.bibliotekari = new ArrayList<Bibliotekar>();
		this.clanovi = new ArrayList<Clan>();
		this.knjige = new ArrayList<Knjiga>();
		this.zanrovi = new ArrayList<Zanr>();
		this.primerci = new ArrayList<Primerak>();
		this.iznajmljivanja = new ArrayList<Iznajmljivanje>();
	}
	
	public Biblioteka(String id, String naziv, String adresa, String telefon, String radnoVreme) {
		this.id = id;
		this.naziv = naziv;
		this.adresa = adresa;
		this.telefon = telefon;
		this.radnoVreme = radnoVreme;
		this.administatori = new ArrayList<Administrator>();
		this.bibliotekari = new ArrayList<Bibliotekar>();
		this.clanovi = new ArrayList<Clan>();
		this.knjige = new ArrayList<Knjiga>();
		this.zanrovi = new ArrayList<Zanr>();
		this.primerci = new ArrayList<Primerak>();
		this.iznajmljivanja = new ArrayList<Iznajmljivanje>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getRadnoVreme() {
		return radnoVreme;
	}

	public void setRadnoVreme(String radnoVreme) {
		this.radnoVreme = radnoVreme;
	}

	public ArrayList<Administrator> getAdministatori() {
		return administatori;
	}
	
	public void dodajAdministratora(Administrator administrator) {
		this.administatori.add(administrator);
	}
	
	public void ukloniAdministratora(Administrator administrator) {
		this.administatori.remove(administrator);
	}

	public ArrayList<Bibliotekar> getBibliotekari() {
		return bibliotekari;
	}

	public void dodajBibliotekara(Bibliotekar bibliotekar) {
		this.bibliotekari.add(bibliotekar);
	}
	
	public void ukloniBibliotekara(Bibliotekar bibliotekar) {
		this.bibliotekari.remove(bibliotekar);
	}
	
	public ArrayList<Clan> getClanovi() {
		return clanovi;
	}
	
	public void dodajClana(Clan clan) {
		this.clanovi.add(clan);
	}
	
	public void ukloniClana(Clan clan) {
		this.clanovi.remove(clan);
	}

	public ArrayList<Knjiga> getKnjige() {
		return knjige;
	}
	
	public void dodajKnjigu(Knjiga knjiga) {
		this.knjige.add(knjiga);
	}
	
	public void ukloniKnjigu(Knjiga knjiga) {
		this.knjige.remove(knjiga);
	}

	public ArrayList<Zanr> getZanrovi() {
		return zanrovi;
	}

	public void dodajZanr(Zanr zanr) {
		this.zanrovi.add(zanr);
	}
	
	public void ukloniZanr(Zanr zanr) {
		this.zanrovi.remove(zanr);
	}

	public ArrayList<Primerak> getPrimerci() {
		return primerci;
	}
	
	public void dodajPrimerak(Primerak primerak) {
		this.primerci.add(primerak);
	}
	
	public void ukloniPrimerak(Primerak primerak) {
		this.primerci.remove(primerak);
	}

	public ArrayList<Iznajmljivanje> getIznajmljivanja() {
		return iznajmljivanja;
	}
	
	public void dodajIznajmljivanje(Iznajmljivanje iznajmljivanje) {
		this.iznajmljivanja.add(iznajmljivanje);
	}
	
	public void ukloniIznajmljivanje(Iznajmljivanje iznajmljivanje) {
		this.iznajmljivanja.remove(iznajmljivanje);
	}
	
	public void ucitajKnjigu(String fajl) {
		try {
			File file = new File("src/fajlovi/" + fajl);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] split = line.split("\\|");
				String id = split[0];
				String naslov = split[1];
				String originalniNaslov = split[2];
				String pisac = split[3];
				int godinaObjave = Integer.parseInt(split[4]);
				String jezikOriginala = split[5];
				String opis = split[6];
				String zanr = split[7];
				Zanr zanrKnjige = null;
				for(Zanr zanr1 : zanrovi) {
					if(zanr1.getNaziv().equals(zanr)) {
						zanrKnjige = zanr1;
						break;
					}
				}
				Knjiga knjiga = new Knjiga(id, naslov, originalniNaslov, pisac, godinaObjave, jezikOriginala, opis, zanrKnjige);
				knjige.add(knjiga);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom ucitavanja podataka o knjigama");
			e.printStackTrace();
		}
	}
	
}