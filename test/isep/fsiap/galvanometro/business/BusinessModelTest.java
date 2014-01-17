package isep.fsiap.galvanometro.business;



import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Daniel Lopes < 1070912@isep.ipp.pt >
 */
public class BusinessModelTest {

    /**
     *
     */
    public BusinessModelTest() {
    }

    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }

    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     *
     */
    @Before
    public void setUp() {
    }

    /**
     *
     */
    @After
    public void tearDown() {
    }

    /**
     * Test of mudarEscala method, of class BusinessModel. Testado para i = 1.0
     * Ampere.
     */
    @Test
    public void testMudarEscala() {
        System.out.println("mudarEscala para i = 1.0 A");
        double i_escala = 1.0;
        BusinessModel instance = new BusinessModel();
        instance.mudarEscala(i_escala);

        double expResult = 0.076142132;
        double result = instance.getR_s();

        assertEquals("sucesso", expResult, result, 0.001);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of mudarEscala method, of class BusinessModel. Testado para i = 0.5
     * Ampere.
     */
    @Test
    public void testMudarEscala_05() {
        System.out.println("mudarEscala para i= 0.5 A");
        double i_escala = 0.5;
        BusinessModel instance = new BusinessModel();
        instance.mudarEscala(i_escala);

        double expResult = 0.1546391753;
        double result = instance.getR_s();

        assertEquals("sucesso", expResult, result, 0.001);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of mudarEscala method, of class BusinessModel. Testado para i = 2
     * Ampere.
     */
    @Test
    public void testMudarEscala_2() {
        System.out.println("mudarEscala para i= 2.0 A");
        double i_escala = 2.0;
        BusinessModel instance = new BusinessModel();
        instance.mudarEscala(i_escala);

        double expResult = 0.0377833753;
        double result = instance.getR_s();

        assertEquals("sucesso", expResult, result, 0.001);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

   

    /**
     * Teste de movement() i_total = 0.5 A
     * I fundo de escala 2 A
     *
     */
    @Test
    public void testMovement_05_2() {
        System.out.println("movement para i_total = 0.5 A numa escala +/- 2 A");

        BusinessModel instance = new BusinessModel();
        instance.setArea(0.25);
        instance.setNumEspiras(100);
        instance.setB(5E-3);
        instance.setTensao(10);
        instance.setK(0.0023695525);
        instance.setR_p(19.9625);
        instance.mudarEscala(2);
        double expResult = 0.1978221624;
        double result = instance.movement();
        assertEquals(expResult, result, 0.0000001);
        
    }
    /**
     * Teste de movement() i_total = 1 A
     * I fundo de escala 2 A
     *
     */
    @Test
    public void testMovement_1_2() {
        System.out.println("movement para i_total = 1 A numa escala +/- 2 A");

        BusinessModel instance = new BusinessModel();
        instance.setArea(0.25);
        instance.setNumEspiras(100);
        instance.setB(5E-3);
        instance.setTensao(10);
        instance.setK(0.0023695525);
        instance.setR_p(9.9625);
        instance.mudarEscala(2);
        double expResult = 0.3956443248;
        double result = instance.movement();
        assertEquals(expResult, result, 0.0000001);
        //assertEquals(expResult, result, 0.001);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Teste de movement() i_total = 2 A 
     * I fundo de escala +/-2 A
     */
    @Test
    public void testMovement_2_2() {
        System.out.println("movement para i_total = 2 A numa escala +/- 2 A");

        BusinessModel instance = new BusinessModel();
        instance.setArea(0.25);
        instance.setNumEspiras(100);
        instance.setB(5E-3);
        instance.setTensao(10);
        instance.setK(0.0023695525);
        instance.setR_p(4.9625);
        instance.mudarEscala(2);
        double expResult = 0.7912886496;
        double result = instance.movement();
        assertEquals(expResult, result, 0.0000001);

        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Teste de movement() i_total = 0.5 A 
     * I fundo de escala +/-1 A
     */
    @Test
    public void testMovement_05_1() {
        System.out.println("movement para corrente que percorre o circuito = 0.5 A numa escala +/- 1 A");

        BusinessModel instance = new BusinessModel();
        instance.setArea(0.25);
        instance.setNumEspiras(100);
        instance.setB(5E-3);
        instance.setTensao(10);
        instance.setK(0.0023695525);
        instance.setR_p(19.925);
        instance.mudarEscala(1);
        double expResult = 0.3956443248;
        double result = instance.movement();
        assertEquals(expResult, result, 0.0000001);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    /**
     * Teste de movement() i_total = 1 A 
     * I fundo de escala +/-1 A
     */
    @Test
    public void testMovement_1_1() {
        System.out.println("movement para corrente que percorre o circuito = 1 A numa escala +/- 1 A");

        BusinessModel instance = new BusinessModel();
        instance.setArea(0.25);
        instance.setNumEspiras(100);
        instance.setB(5E-3);
        instance.setTensao(10);
        instance.setK(0.0023695525);
        instance.setR_p(9.925);
        instance.mudarEscala(1);
        double expResult = 0.7912886496;
        double result = instance.movement();
        assertEquals(expResult, result, 0.0000001);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    /**
     * Teste de movement() i_total = 2 A 
     * I fundo de escala +/-1 A
     */
    @Test
    public void testMovement_2_1() {
        System.out.println("movement para corrente que percorre o circuito = 2 A numa escala +/- 1 A");

        BusinessModel instance = new BusinessModel();
        instance.setArea(0.25);
        instance.setNumEspiras(100);
        instance.setB(5E-3);
        instance.setTensao(10);
        instance.setK(0.0023695525);
        instance.setR_p(4.925);
        instance.mudarEscala(1);
        double expResult = 1.5825772992;
        double result = instance.movement();
        assertEquals(expResult, result, 0.000001);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    /**
     * Teste de movement() i_total = 0.5 A 
     * I fundo de escala +/-0.5 A
     */
    @Test
    public void testMovement_05_05() {
        System.out.println("movement para corrente que percorre o circuito = 0.5 A numa escala +/- 0.5 A");

        BusinessModel instance = new BusinessModel();
        instance.setArea(0.25);
        instance.setNumEspiras(100);
        instance.setB(5E-3);
        instance.setTensao(10);
        instance.setK(0.0023695525);
        instance.setR_p(19.85);
        instance.mudarEscala(0.5);
        double expResult = 0.7912886496;
        double result = instance.movement();
        assertEquals(expResult, result, 0.000001);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
   /**
     * Teste de movement() i_total = 1 A 
     * I fundo de escala +/-0.5 A
     */
    @Test
    public void testMovement_1_05() {
        System.out.println("movement para corrente que percorre o circuito = 1 A numa escala +/- 0.5 A");

        BusinessModel instance = new BusinessModel();
        instance.setArea(0.25);
        instance.setNumEspiras(100);
        instance.setB(5E-3);
        instance.setTensao(10);
        instance.setK(0.0023695525);
        instance.setR_p(9.85);
        instance.mudarEscala(0.5);
        double expResult = 1.5825772992;
        double result = instance.movement();
        assertEquals(expResult, result, 0.000001);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
   /**
     * Teste de movement() i_total = 2 A 
     * I fundo de escala +/-0.5 A
     */
    @Test
    public void testMovement_2_05() {
        System.out.println("movement para corrente que percorre o circuito = 1 A numa escala +/- 0.5 A");

        BusinessModel instance = new BusinessModel();
        instance.setArea(0.25);
        instance.setNumEspiras(100);
        instance.setB(5E-3);
        instance.setTensao(10);
        instance.setK(0.0023695525);
        instance.setR_p(4.85);
        instance.mudarEscala(0.5);
        double expResult = 3.1651545985;
        double result = instance.movement();
        assertEquals(expResult, result, 0.000001);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
   
  

}
