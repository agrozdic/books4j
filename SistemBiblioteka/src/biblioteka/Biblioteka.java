package biblioteka;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import osobe.Administrator;
import osobe.Bibliotekar;
import osobe.Clan;
import osobe.Pol;
import osobe.TipClanarine;
import osobe.Zaposleni;
import knjige.Knjiga;
import knjige.Zanr;
import knjige.Primerak;
import knjige.TipPoveza;
import knjige.Iznajmljivanje;

public class Biblioteka {

	private String id;
	private String naziv;
	private String adresa;
	private String telefon;
	private String radnoVreme;
	private ArrayList<Administrator> administratori;
	private ArrayList<Bibliotekar> bibliotekari;
	private ArrayList<Zaposleni> zaposleniList;
	private ArrayList<Clan> clanovi;
	private ArrayList<Knjiga> knjige;
	private ArrayList<Zanr> zanrovi;
	private ArrayList<Primerak> primerci;
	private ArrayList<Iznajmljivanje> iznajmljivanja;
	Map<TipClanarine, Integer> cene;
	
	public Biblioteka() {
		this.id = "";
		this.naziv = "";
		this.adresa = "";
		this.telefon = "";
		this.radnoVreme = "";
		this.administratori = new ArrayList<Administrator>();
		this.bibliotekari = new ArrayList<Bibliotekar>();
		this.zaposleniList = new ArrayList<Zaposleni>();
		this.clanovi = new ArrayList<Clan>();
		this.knjige = new ArrayList<Knjiga>();
		this.zanrovi = new ArrayList<Zanr>();
		this.primerci = new ArrayList<Primerak>();
		this.iznajmljivanja = new ArrayList<Iznajmljivanje>();
		this.cene = new HashMap<TipClanarine, Integer>();
	}
	
	public Biblioteka(String id, String naziv, String adresa, String telefon, String radnoVreme) {
		this.id = id;
		this.naziv = naziv;
		this.adresa = adresa;
		this.telefon = telefon;
		this.radnoVreme = radnoVreme;
		this.administratori = new ArrayList<Administrator>();
		this.bibliotekari = new ArrayList<Bibliotekar>();
		this.zaposleniList = new ArrayList<Zaposleni>();
		this.clanovi = new ArrayList<Clan>();
		this.knjige = new ArrayList<Knjiga>();
		this.zanrovi = new ArrayList<Zanr>();
		this.primerci = new ArrayList<Primerak>();
		this.iznajmljivanja = new ArrayList<Iznajmljivanje>();
		this.cene = new HashMap<TipClanarine, Integer>();
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

	public ArrayList<Administrator> getAdministratori() {
		return administratori;
	}
	
	public void dodajAdministratora(Administrator administrator) {
		this.administratori.add(administrator);
		this.zaposleniList.add(administrator);
	}
	
	public void ukloniAdministratora(Administrator administrator) {
		this.administratori.remove(administrator);
		this.zaposleniList.remove(administrator);
	}

	public ArrayList<Bibliotekar> getBibliotekari() {
		return bibliotekari;
	}

	public void dodajBibliotekara(Bibliotekar bibliotekar) {
		this.bibliotekari.add(bibliotekar);
		this.zaposleniList.add(bibliotekar);
	}
	
	public void ukloniBibliotekara(Bibliotekar bibliotekar) {
		this.bibliotekari.remove(bibliotekar);
		this.zaposleniList.remove(bibliotekar);
	}

	public ArrayList<Zaposleni> getZaposleni() {
		return zaposleniList;
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

	public Map<TipClanarine, Integer> getCene() {
		return cene;
	}
	
	public Zaposleni login(String korisnickoIme, String lozinka) {
		for(Administrator adm : administratori) {
			if(adm.getKorisnickoIme().equalsIgnoreCase(korisnickoIme) &&
			adm.getLozinka().equals(lozinka)) {
				return adm;
			}
		}
		for(Bibliotekar bib : bibliotekari) {
			if(bib.getKorisnickoIme().equalsIgnoreCase(korisnickoIme) &&
			bib.getLozinka().equals(lozinka)) {
				return bib;
			}
		}
		return null;
	}

	public void ucitajZaposlene(String fajl) {
		try {
			File file = new File("src/fajlovi/" + fajl);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] split = line.split("\\|");
				String id = split[0];
				String ime = split[1];
				String prezime = split[2];
				String jmbg = split[3];
				String pol = split[4];
				String adresa = split[5];
				double plata = Double.parseDouble(split[6]);
				String korisnickoIme = split[7];
				String lozinka = split[8];
				Pol polZaposlenog = null;
				switch(pol) {
					case " ":
						polZaposlenog = Pol.NEIZJASNJENI;
						break;
					case "Z":
						polZaposlenog = Pol.ZENSKI;
						break;
					case "M":
						polZaposlenog = Pol.MUSKI;
						break;
				}
				if(id.contains("ADM")) {
					Administrator administrator = new Administrator(id, ime, prezime, jmbg, adresa, polZaposlenog, plata, korisnickoIme, lozinka);
					administratori.add(administrator);
					zaposleniList.add(administrator);
				}
				else {
					Bibliotekar bibliotekar = new Bibliotekar(id, ime, prezime, jmbg, adresa, polZaposlenog, plata, korisnickoIme, lozinka);
					bibliotekari.add(bibliotekar);
					zaposleniList.add(bibliotekar);
				}
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom ucitavanja podataka o knjigama");
			e.printStackTrace();
		}
	}

	public void snimiZaposlene(String fajl) {
		try {
			File file = new File("src/fajlovi/" + fajl);
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			String text = "";
			for (Administrator adm : administratori) {
				String pol = adm.getPol().toString();
				if(pol == "NEIZJASNJENI") pol = " ";
				text +=
					adm.getId() + "|" +
					adm.getIme() + "|" +
					adm.getPrezime() + "|" +
					adm.getJmbg() + "|" +
					pol.substring(0, 1).toUpperCase() + '|' +
					adm.getAdresa() + "|" +
					adm.getPlata() + "|" +
					adm.getKorisnickoIme() + "|" +
					adm.getLozinka() + "\n";
			}
			for (Bibliotekar bib : bibliotekari) {
				String pol = bib.getPol().toString();
				if(pol == "NEIZJASNJENI") pol = " ";
				text +=
					bib.getId() + "|" +
					bib.getIme() + "|" +
					bib.getPrezime() + "|" +
					bib.getJmbg() + "|" +
					pol.substring(0, 1).toUpperCase() + '|' +
					bib.getAdresa() + "|" +
					bib.getPlata() + "|" +
					bib.getKorisnickoIme() + "|" +
					bib.getLozinka() + "\n";
			}
			bw.write(text);
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void ucitajClanove(String fajl) {
		try {
			File file = new File("src/fajlovi/" + fajl);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] split = line.split("\\|");
				String id = split[0];
				String ime = split[1];
				String prezime = split[2];
				String jmbg = split[3];
				String pol = split[4];
				String adresa = split[5];
				String brojClanskeKarte = split[6];
				String tipClanarine = split[7];
				LocalDate datumPoslednjeUplateClanarine = LocalDate.parse(split[8]);
				int brojUplacenihMeseci = Integer.parseInt(split[9]);
				boolean aktivnost = Boolean.parseBoolean(split[10]);
				Pol polClana = null;
				switch(pol) {
					case " ":
						polClana = Pol.NEIZJASNJENI;
						break;
					case "Z":
						polClana = Pol.ZENSKI;
						break;
					case "M":
						polClana = Pol.MUSKI;
						break;
				}
				TipClanarine tipClanarineObj = null;
				switch(tipClanarine) {
					case "osnovna":
						tipClanarineObj = TipClanarine.OSNOVNA;
						break;
					case "deca":
						tipClanarineObj = TipClanarine.DECA;
						break;
					case "penzioneri":
						tipClanarineObj = TipClanarine.PENZIONERI;
						break;
				}
				LocalDate from = datumPoslednjeUplateClanarine;
				LocalDate to = LocalDate.now();
				Period period = Period.between(from, to);
				if(period.getMonths() > brojUplacenihMeseci){
					aktivnost = false;
				}
				Clan clan = new Clan(id, ime, prezime, jmbg, adresa, polClana, brojClanskeKarte, tipClanarineObj, datumPoslednjeUplateClanarine, brojUplacenihMeseci, aktivnost);
				clanovi.add(clan);
				
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom ucitavanja podataka o knjigama");
			e.printStackTrace();
		}
	}

	public void snimiClanove(String fajl) {
		try {
			File file = new File("src/fajlovi/" + fajl);
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			String content = "";
			for (Clan clan : clanovi) {
				String text = "";
				String pol = clan.getPol().toString();
				if(pol == "NEIZJASNJENI") pol = " ";
				text +=
						clan.getId() + '|' +
						clan.getIme() + '|' +
						clan.getPrezime() + '|' +
						clan.getJmbg() + '|' +
						pol.substring(0, 1).toUpperCase() + '|' +
						clan.getAdresa() + '|' +
						clan.getBrojClanskeKarte() + '|' +
						clan.getTipClanarine().toString().toLowerCase() + '|' +
						clan.getDatumPoslednjeUplateClanarine() + '|' +
						clan.getBrojUplacenihMeseci() + '|' +
						clan.isAktivnost() + "\n";
				content += text;
				}
				bw.write(content);
				bw.close();
			} catch (IOException e) {
				System.out.println("Greska prilikom dodavanja clana!");
				e.printStackTrace();
			}
	}
	
	public void ucitajKnjige(String fajl) {
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

	public void snimiKnjige(String fajl) {
		try {
			File file = new File("src/fajlovi/" + fajl);
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			String content = "";
			for (Knjiga knjiga : knjige) {
				String text = "";
				text +=
						knjiga.getId() + '|' +
						knjiga.getNaslov() + '|' +
						knjiga.getOriginalniNaslov() + '|' +
						knjiga.getPisac() + '|' +
						knjiga.getGodinaObjave() + '|' +
						knjiga.getJezikOriginala() + '|' +
						knjiga.getOpis() + '|' +
						knjiga.getZanr().getNaziv() + "\n";
				content += text;
				}
				bw.write(content);
				bw.close();
			} catch (IOException e) {
				System.out.println("Greska prilikom dodavanja knjige!");
				e.printStackTrace();
			}
	}
	
	public void ucitajZanrove(String fajl) {
		try {
			File file = new File("src/fajlovi/" + fajl);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] split = line.split("\\|");
				String naziv = split[0];
				String oznaka = split[1];
				String opis = split[2];
				Zanr zanr = new Zanr(naziv, oznaka, opis);
				zanrovi.add(zanr);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom ucitavanja podataka o knjigama");
			e.printStackTrace();
		}
	}

	public void snimiZanrove(String fajl) {
		try {
			File file = new File("src/fajlovi/" + fajl);
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			String content = "";
			for (Zanr zanr : zanrovi) {
				String text = "";
				text +=
						zanr.getNaziv() + '|' +
						zanr.getOznaka() + '|' +
						zanr.getOpis() + "\n";
				content += text;
			}
			bw.write(content);
			bw.close();
			} catch (IOException e) {
				System.out.println("Greska prilikom dodavanja knjige!");
				e.printStackTrace();
			}
	}
	
	public void ucitajPrimerke(String fajl) {
		try {
			File file = new File("src/fajlovi/" + fajl);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] split = line.split("\\|");
				String id = split[0];
				String knjigaID = split[1];
				String tipPoveza = split[2];
				int godinaStampe = Integer.parseInt(split[3]);
				boolean izdat = Boolean.parseBoolean(split[4]);
				Knjiga knjigaObj = null;
				for(Knjiga knjiga : knjige) {
					if(knjiga.getId().equals(knjigaID)) {
						knjigaObj = knjiga;
						break;
					}
				}
				TipPoveza tpObj = null;
				switch(tipPoveza) {
					case "MEKI":
						tpObj = TipPoveza.MEKI;
						break;
					case "TVRDI":
						tpObj = TipPoveza.TVRDI;
						break;
					case "KOZNI":
						tpObj = TipPoveza.KOZNI;
						break;
					case "PLATNENI":
						tpObj = TipPoveza.PLATNENI;
						break;
				}
				Primerak primerak = new Primerak(id, knjigaObj, tpObj, godinaStampe, izdat);
				primerci.add(primerak);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom ucitavanja podataka o knjigama");
			e.printStackTrace();
		}
	}

	public void snimiPrimerke(String fajl) {
		try {
			File file = new File("src/fajlovi/" + fajl);
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			String content = "";
			for (Primerak prim : primerci) {
				String text = "";
				text +=
						prim.getId() + '|' +
						prim.getKnjiga().getId() + '|' +
						prim.getTipPoveza() + '|' +
						prim.getGodinaStampe() + '|' +
						prim.isIzdat() + "\n";
				content += text;
			}
			bw.write(content);
			bw.close();
			} catch (IOException e) {
				System.out.println("Greska prilikom dodavanja knjige!");
				e.printStackTrace();
			}
	}
	
	public void ucitajIznajmljivanja(String fajl) {
		try {
			File file = new File("src/fajlovi/" + fajl);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] split = line.split("\\|");
				String id = split[0];
				String zaposleni = split[1];
				String clan = split[2];
				LocalDate datum = LocalDate.parse(split[3]);
				String primerak = split[4];
				Zaposleni zaposleniObj = null;
				for(Administrator adm : administratori) {
					if(adm.getId().equals(zaposleni)) {
						zaposleniObj = adm;
						break;
					}
				}
				if(zaposleniObj == null) {
					for(Bibliotekar bib : bibliotekari) {
						if(bib.getId().equals(zaposleni)) {
							zaposleniObj = bib;
							break;
						}
					}
				}
				Clan clanObj = null;
				for(Clan cln : clanovi) {
					if(cln.getId().equals(clan)) {
						clanObj = cln;
						break;
					}
				}
				Primerak primerakObj = null;
				for(Primerak prim : primerci) {
					if(prim.getId().equals(primerak)) {
						primerakObj = prim;
						break;
					}
				}
				Iznajmljivanje iznajmljivanje = new Iznajmljivanje(id, zaposleniObj, clanObj, datum, primerakObj);
				iznajmljivanja.add(iznajmljivanje);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom ucitavanja podataka o knjigama");
			e.printStackTrace();
		}
	}

	public void snimiIznajmljivanja(String fajl) {
		try {
			File file = new File("src/fajlovi/" + fajl);
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			String content = "";
			for (Iznajmljivanje izn : iznajmljivanja) {
				String text = "";
				text +=
						izn.getId() + '|' +
						izn.getZaposleni().getId() + '|' +
						izn.getClan().getId() + '|' +
						izn.getDatum().toString() + '|' +
						izn.getPrimerak().getId() + "\n";
				content += text;
			}
			bw.write(content);
			bw.close();
			} catch (IOException e) {
				System.out.println("Greska prilikom dodavanja knjige!");
				e.printStackTrace();
			}
	}

	public void ucitajCene(String fajl) {
		try {
			File file = new File("src/fajlovi/" + fajl);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] split = line.split("\\|");
				String tipClanarine = split[0];
				int cena = Integer.parseInt(split[1]);
				TipClanarine tipClanarineObj = null;
				switch(tipClanarine) {
					case "OSNOVNA":
						tipClanarineObj = TipClanarine.OSNOVNA;
						break;
					case "DECA":
						tipClanarineObj = TipClanarine.DECA;
						break;
					case "PENZIONERI":
						tipClanarineObj = TipClanarine.PENZIONERI;
						break;
				}
				cene.put(tipClanarineObj, cena);
				
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom ucitavanja podataka o cenama");
			e.printStackTrace();
		}
	}
	
}