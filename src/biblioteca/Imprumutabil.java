package biblioteca;

import java.time.LocalDate;

public interface Imprumutabil {
	void imprumuta(LocalDate dataImprumut) throws PublicatieException;
	void returneaza(LocalDate dataRetur) throws PublicatieException;
	double calculPenalizare(LocalDate dataRetur);
	
}
