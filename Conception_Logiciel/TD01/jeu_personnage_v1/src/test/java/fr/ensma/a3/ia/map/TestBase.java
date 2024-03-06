package fr.ensma.a3.ia.map;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import fr.ensma.a3.ia.element.IElementJeu;
import fr.ensma.a3.ia.utils.ValParamException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Field;
import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Tests Base")
public class TestBase {

    private Base baseTest;
    private IElementJeu elem1;
    @Mock
    ECouleur coulSim;
    IElementJeu elemSim1;
    IElementJeu elemSim2;

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

    //Integration
    @Test
    @Order(5)
    public void textToString_Inte() throws ValParamException{

        Base baseTemp = new Base("Base", coulSim);
        when(coulSim.toString()).thenReturn("Base");
        assertEquals("Base" + baseTemp.getNomBase() + ":" + baseTemp.getCoulBase(), baseTemp.toString());
    }

    @Test
    @Order(6)
    public void testGetCoulBase() throws ValParamException{
        Base baseTemp = new Base("Base", coulSim);
        assertEquals(coulSim, baseTemp.getCoulBase());
    }

    @Test
    @Order(7)
    public void testAfficheElements_Inte(){
        baseTest.addElementJeu((elemSim1));
        baseTest.addElementJeu(elemSim2);
        when(elemSim1.toString()).thenReturn("Eleme1");
        when(elemSim2.toString()).thenReturn("Eleme1");
        assertEquals("Base" + baseTest.getNomBase() + ";" + baseTest.getCoulBase() + "\nElements jeu :\n",
                baseTest.afficheElements());
    }
    @Mock
    ArrayList<IElementJeu> mockElem;
    @Test
    @Order(8)
    public void testAdElements_Inte(){
        Field f_elem = baseTest.getClass().getDeclaredFields()[2];
        f_elem.setAccessible(true);
        try{
            f_elem.set(baseTest, mockElem);
        }
        catch (IllegalAccessException ex){
            ex.printStackTrace();
        }
        when (mockElem.size()).thenReturn(1, 2);
        baseTest.addElementJeu(elemSim1);
        assertEquals(1, baseTest.getNbElem());
        baseTest.addElementJeu(elemSim2);
        assertEquals(2, baseTest.getNbElem());
        ArgumentCaptor<IElementJeu> args= ArgumentCaptor.forClass(IElementJeu.class);
        verify(mockElem,times(2)).add(args.capture());
        assertEquals(elemSim1, args.getAllValues().get(0));
        assertEquals(elemSim2, args.getAllValues().get(1));
    }

}

