package fr.ensma.a3.ia.jeupersonnages.map;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import fr.ensma.a3.ia.jeupersonnages.elements.IElementJeu;
import fr.ensma.a3.ia.jeupersonnages.outils.ValParamException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Tests Base")
public class TestBase {

	private Base baseTest;
	private IElementJeu elem1;

	@BeforeEach
    public void initEach() throws ValParamException {
        baseTest = new Base("Base", ECouleur.bleu);
    }

    @AfterEach
    public void freeEach() {
        baseTest = null;
        System.gc();
    }

    @Test
    @Order(1)
    public void testConstructeur() {
        assertAll(() -> assertEquals("Base", baseTest.getNomBase()),
                () -> assertEquals(ECouleur.bleu, baseTest.getCoulBase()),
                () -> assertEquals(0, baseTest.getNbElem()));
        assertThrows(ValParamException.class, () -> new Base(null, ECouleur.rouge));
        assertThrows(ValParamException.class, () -> new Base("B", null));
        assertThrows(ValParamException.class, () -> new Base(null, null));
    }

    @Test
    @Order(2)
    public void testToString() {
        assertEquals("Base " + baseTest.getNomBase() + ": " + baseTest.getCoulBase(),
                        baseTest.toString());
    }
    
    @Test
    @Order(3)
    public void testAddElement_Inte() {
        assertEquals(0, baseTest.getNbElem());
    	baseTest.addElementJeu(elem1);
        assertEquals(1, baseTest.getNbElem());
    }
    
    @Test
    @Order(4)
    public void testAfficheElements() {
    	assertEquals("Base " + baseTest.getNomBase() + ": " 
    			+ baseTest.getCoulBase() + "\nÉléments jeu :\n",
                baseTest.afficheElements());
    }
}
