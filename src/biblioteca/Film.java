package biblioteca;

public class Film extends Media{
	
		protected String titlu;
		protected int an;
		protected String gen;
		protected String regizor;
		
		public Film( String suport, String  titlu,int an, String gen, String regizor){
				this.suport = suport;
				this.titlu= titlu;
				this.an = an;
				this.gen = gen;
				this.regizor = regizor;
		}
		
		public String toString() {
			String string = this.getId() + ". " + suport + " " + titlu + " " + an + " " + gen + " " + regizor;
			return string;
		}
		@Override
		public void consulta() {
			if(this.isDisponibil()) {
				this.setDisponibil(false);
				System.out.println("Media " + this.getId()+ " este in consultare." );
			}				
		}
		
		@Override
		public void elibereaza() {
			if(!this.isDisponibil()) {
				this.setDisponibil(true);
				System.out.println("Media " + this.getId()+ " este libera." );
			}	
		}
}
