package biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Biblioteca {
	private List<Publicatie> publicatii;
	private List<Media> media;
	private int count = 1;
	
	public Biblioteca() {
		publicatii = new ArrayList<>();
		media = new ArrayList<>();
	}
	
	public void adaugaPublicatie(Publicatie publicatie) {
		publicatii.add(publicatie);
		publicatie.setId(count);
		count ++;
		
	}
	public void adaugaMedia(Media media) {
		this.media.add( media);
		media.setId(count);
		count ++; 
		
	}
	
	public void catalogPublicatii() {
		for (Publicatie p : publicatii)
         System.out.println(p);
	}
	
	public void catalogMedia() {
		for (Media m : media)
	         System.out.println(m);
		
	}
	public void publicatiiDisponibile() {
		System.out.println("Publicatii disponibile:");
		for (Publicatie p : publicatii) {
			if(p.isDisponibil() )
	         System.out.println(p);
		}
	}
		
	public void publicatiiImprumutate() {
		System.out.println("Publicatii imprumutate: ");
		for (Publicatie p : publicatii) {
			if( p.isDisponibil() == false )
	         System.out.println(p);
		}
		
	}
	public void consultarePublicatieDupaCategorie(String categorie) {
		System.out.println("Publicatii din categoria "+ categorie);
		for (Publicatie p : publicatii) {
			if(p.getCategorie() == categorie ) {
				System.out.println(p);
				}
		}
		
	}
	
	public void consultarePublicatieDupaAutor(String autor) {
		System.out.println("Publicatii scrise de "+ autor);
		for (Publicatie p : publicatii) {
			if(p.getAutor() == autor ) {
				System.out.println(p);
				}
		}
	}
		
	
	public void imprumutaPublicatie(int id, LocalDate dataImprumut) {
		int nr = 0;
		for (Publicatie p : publicatii) {
			if(p.getId() == id ) {
				nr++;
				
					try {
						p.imprumuta(dataImprumut);		
					} catch (PublicatieException pe) {
						System.out.println(pe.getMessage());
					}
							}
		}
		if(nr == 0) {
		System.out.println("Publicatia " + id + " nu a fost gasita!");	
		}
	}
	
	public void returneazaPublicatie(int id, LocalDate dataRetur) {
		int nr = 0;
		for (Publicatie p : publicatii) {
			if(p.getId() == id ) {
				nr++;
				try {
					p.returneaza(dataRetur);
					
				} catch (PublicatieException pe) {	
					System.out.println(pe.getMessage());
				}
				
				
			}
		}
		if(nr ==0) {
			System.out.println("Publicatia " + id + " nu a fost gasita!");
		}
		
	}
	
	public void consultaMedia(int id) {
		int nr = 0;
		for (Media m : media) {
			if(m.getId() == id) {
				nr++;
				m.consulta();
			}
		}
		if(nr == 0) {
			System.out.println("Media " + id + " nu a fost gasita!");
		}
		
	}
	
	public void elibereazaMedia(int id) {
		int nr =0;
		for (Media m : media) {
			if(m.getId() == id) {
				nr++;
			m.elibereaza();
			}
		}
		if(nr == 0) {
			System.out.println("Media " + id + " nu a fost gasita!");
		}
		
	}	
}
