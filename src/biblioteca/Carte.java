package biblioteca;

import java.time.LocalDate;
import java.time.temporal.*;

public class Carte extends Publicatie {
	
		public static int TERMEN_IMPRUMUT = 4;
		public static double PENALIZARE = 0.5;
		protected int anPublicatie;
		
		public Carte(String autor, String titlu, int anPublicatie, String categorie){
			this.autor = autor;
			this.titlu = titlu;
			this.anPublicatie = anPublicatie;
			this.categorie = categorie;
		}
		public String toString() {
			String string= this.getId() + ".    " + autor+ "    "+titlu+ "   " + anPublicatie+ " " +categorie;
			return string ;
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
				if(ChronoUnit.DAYS.between(this.dataImprumut, dataRetur) > 4 ) {
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
