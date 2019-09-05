package biblioteca;

import java.time.LocalDate;

public abstract class Publicatie extends Item implements Imprumutabil {
			protected String autor;
			protected String titlu;
			protected String categorie;
			protected LocalDate dataImprumut = null;
			

			public String getAutor() {
				return autor;
			}
			
			public String getCategorie() {
				return categorie;
			}

			public LocalDate getDataImprumut() {
				return dataImprumut;
			}

			
}
