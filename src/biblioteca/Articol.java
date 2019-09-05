package biblioteca;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


public class Articol extends Publicatie {
	
	    public static int TERMEN_IMPRUMUT = 2;
	    public static double PENALIZARE = 0.1;
		protected String publicatie;
		protected LocalDate dataPublicatie;
		
		public Articol(String autor, String titlu, String categorie, String publicatie, LocalDate dataPublicatie) {
			this.autor = autor;
			this.titlu = titlu;
			this.categorie = categorie;
			this.publicatie = publicatie;
			this.dataPublicatie = dataPublicatie;
			
		}
		public String toString(){
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
			String newData = dataPublicatie.format(formatter);
			String string= this.getId() + ". " +  autor + "  " + titlu + "    " + publicatie + "    " + newData;
			return string;
		}
		@Override
		public void imprumuta(LocalDate dataImprumut) throws PublicatieException  {
			if( this.isDisponibil() == true ) {
				this.setDisponibil(false);
				this.dataImprumut = dataImprumut;
				System.out.println("Publicatia "+ this.getId() + " a fost imprumutata.");
			}else {
				throw new PublicatieException("Publicatia "+ this.getId() + " este indisponibila!");
			}

		}
		
		
		@Override
		public void returneaza(LocalDate dataRetur) throws PublicatieException {	
			if( this.isDisponibil() == false ) {
				this.setDisponibil(true);
				System.out.println("Publicatia "+ this.getId() + " a fost returnata.");
				if(ChronoUnit.DAYS.between(this.dataImprumut, dataRetur) > 2) {
				throw new PublicatieException("Termen depasit pentru publicatia " + this.getId() + " !\nPenalizare: " + this.calculPenalizare(dataRetur)+ " lei");
				}
			}else if (this.isDisponibil()  == true ){
				throw new PublicatieException("Publicatia " + this.getId() +  " nu poate fi returnata (nu a fost imprumutata)!");
			}
	}
		
		@Override
		public double calculPenalizare(LocalDate dataRetur) {
			double result;
			long daysBetween = ChronoUnit.DAYS.between(this.dataImprumut, dataRetur);
			if(daysBetween <= 2) {
				result = 0;
			}else {
			    result = Math.round(((daysBetween - TERMEN_IMPRUMUT ) * PENALIZARE) * 10) / 10.0;
			}
			
			return result;
		}
}
