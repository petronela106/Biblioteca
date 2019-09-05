package biblioteca;

public class AlbumMuzica extends Media{
	
		protected String artist;
		protected String titlu;
		protected String gen;
		
		public AlbumMuzica(String suport, String artist, String titlu, String gen){
			this.suport= suport;
			this.artist = artist;
			this.titlu = titlu;
			this.gen= gen;
		}
		public String toString() {
			
			String string = this.getId() + ". " + suport + " " + artist + " " + titlu;
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
			this.setDisponibil(true);
			System.out.println("Media " + this.getId()+ " este libera." );
					
		}
}
