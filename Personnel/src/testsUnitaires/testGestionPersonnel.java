package testsUnitaires;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import personnel.*;

public class testGestionPersonnel {
	
	GestionPersonnel gestionPersonnel = GestionPersonnel.getGestionPersonnel();
	
	@Test
	void getLigue() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fl�chettes");
		Employe employe = ligue.addEmploye("root", "", "g.bouchard@gmail.com", "azerty");
		assertEquals("root", ligue.getAdministrateur());
	}
	
	@Test
	void addLigue() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Flechettes");
		assertEquals("Flechettes", ligue.getNom());
	}
	
	@Test
	void addEmploye() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fl�chettes");
		Employe employe = ligue.addEmploye(gestionPersonnel, ligue, "Bouchard", "G�rard", "g.bouchard@gmail.com", "azerty", null, LocalDate.now(), LocalDate.now()); 
		assertEquals(employe, ligue.getEmployes().first());
	}
}