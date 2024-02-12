package fr.ensma.a3.ia.element.personnage.humain;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;


import fr.ensma.a3.ia.element.personnages.humains.Guerrier;
import fr.ensma.a3.ia.element.personnages.humains.Ouvrier;
import fr.ensma.a3.ia.element.personnages.humains.PersonnageHumain;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;



import fr.ensma.a3.ia.map.Base;
import fr.ensma.a3.ia.map.ECouleur;
import fr.ensma.a3.ia.utils.ValParamException;

/**
 * Test de la classe Ouvrier
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
public class TestOuvrier {

    private Ouvrier hodor, ouv1;
    // Normalement pas à faire dans le cadsre des tests unitaires
    private Base bse;

    private Base bmock;

    @BeforeEach
    public void initEach() throws ValParamException {
        bse = new Base("B", ECouleur.rouge);
        hodor = new Ouvrier(200f, bse, "Hodor", 500);
    }

    @AfterEach
    public void afterEach() {
        hodor = null;
        bse = null;
        System.gc();
    }

    @Test
    public void t01_testConstructeur() {
        assertAll(() -> assertEquals("Hodor", hodor.getIdentifiantPerson()), () -> assertEquals(200f, hodor.getNivVie()));
        assertThrows(ValParamException.class, () -> new Ouvrier(null, null, null, null));
        assertThrows(ValParamException.class, () -> new Ouvrier(null, null, "Hodor", null));
        assertThrows(ValParamException.class, () -> new Ouvrier(null, null,null, 500));
        assertThrows(ValParamException.class, () -> new Ouvrier(null, null, "Hodor", 500));
        assertThrows(ValParamException.class, () -> new Ouvrier(null, bse, null, null));
        assertThrows(ValParamException.class, () -> new Ouvrier(null, bse, "hodor", null));
        assertThrows(ValParamException.class, () -> new Ouvrier(null, bse, null, 500));
        assertThrows(ValParamException.class, () -> new Ouvrier(null, bse,"Hodor", 500));
        assertThrows(ValParamException.class, () -> new Ouvrier(200f, null, null, null));
        assertThrows(ValParamException.class, () -> new Ouvrier(200f, null, "hodor", null));
        assertThrows(ValParamException.class, () -> new Ouvrier(200f, null, null, 500));
        assertThrows(ValParamException.class, () -> new Ouvrier(200f, null, "Hodor", 500));
        assertThrows(ValParamException.class, () -> new Ouvrier(200f, bse, null, null));
        assertThrows(ValParamException.class, () -> new Ouvrier(200f, bse,"Hodor", null));
        assertThrows(ValParamException.class, () -> new Ouvrier(200f, bse, null, 500));
    }

    @Test
    public void t02_testConstructeur() throws ValParamException {
        ouv1 = new Ouvrier(200f, bse, 300);
        assertAll(() -> assertEquals("Ouvrier3", ouv1.getIdentifiantPerson()), () -> assertEquals(200f, ouv1.getNivVie()));
        assertThrows(ValParamException.class, () -> new Ouvrier(null, null, null));
        assertThrows(ValParamException.class, () -> new Ouvrier(null, null, 300));
        assertThrows(ValParamException.class, () -> new Ouvrier(null, bse, null));
        assertThrows(ValParamException.class, () -> new Ouvrier(null, bse, 300));
        assertThrows(ValParamException.class, () -> new Ouvrier(200f, null, null));
        assertThrows(ValParamException.class, () -> new Ouvrier(200f, null, 300));
        assertThrows(ValParamException.class, () -> new Ouvrier(200f, bse, null));
    }

    @Test
    public void t05_testEqual() throws ValParamException {
        ouv1 = new Ouvrier(200f, bse, "Hodor", 500);
        assertTrue(hodor.equals(hodor));
        assertTrue(hodor.equals(ouv1));
        assertFalse(hodor.equals(null));
        assertFalse(hodor.equals(Integer.valueOf(0)));
        //assertFalse(hodor.equals(new Catapulte(200f, bse, 800)));
        assertFalse(hodor.equals(new Guerrier(200f, bse, 500, "Hodor")));
        // Attention à l'égalité de Base -> Test Intégration
        ouv1 = new Ouvrier(250f, bse, "Hodor", 500);
        assertFalse(hodor.equals(ouv1));
        ouv1 = new Ouvrier(200f, bse, "Hodor", 200);
        assertFalse(hodor.equals(ouv1));
        ouv1 = new Ouvrier(200f, bse, "Bob", 500);
        assertFalse(hodor.equals(ouv1));
        bse = new Base("BB", ECouleur.jaune);
        ouv1 = new Ouvrier(200f, bse, "Hodor", 500);
        assertFalse(hodor.equals(ouv1));
    }

    @Test
    public void t06_testHashCode() throws ValParamException {
        ouv1 = new Ouvrier(200f, bse,  "Hodor", 500);
        assertEquals(hodor.hashCode(), hodor.hashCode());
        assertEquals(ouv1.hashCode(), hodor.hashCode());
        // Suite Optionnelle car on ne demande pas un hashage parfait
        ouv1 = new Ouvrier(250f, bse, "Hodor", 500);
        assertNotEquals(ouv1.hashCode(), hodor.hashCode());
        ouv1 = new Ouvrier(200f, bse, "Hodor", 200);
        assertNotEquals(ouv1.hashCode(), hodor.hashCode());
        ouv1 = new Ouvrier(200f, bse,"Bob", 200);
        assertNotEquals(ouv1.hashCode(), hodor.hashCode());
        bse = new Base("BB", ECouleur.jaune);
        ouv1 = new Ouvrier(200f, bse, "Hodor", 500);
        assertNotEquals(ouv1.hashCode(), hodor.hashCode());
    }

    
}
