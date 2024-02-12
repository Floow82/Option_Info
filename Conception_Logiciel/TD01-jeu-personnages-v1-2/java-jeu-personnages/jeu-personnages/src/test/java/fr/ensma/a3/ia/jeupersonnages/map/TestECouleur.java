package fr.ensma.a3.ia.jeupersonnages.map;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Tests ECouleur")
public class TestECouleur {

	@Test
	public void testGetCouleurFamille() {
		assertAll(() -> assertEquals (ECouleur.bleu, ECouleur.getCouleurFamille("Stark")),
				() -> assertEquals (ECouleur.rouge, ECouleur.getCouleurFamille("Lannister")),
				() -> assertEquals (ECouleur.noir, ECouleur.getCouleurFamille("Targaryen"))
				);
	}

}
