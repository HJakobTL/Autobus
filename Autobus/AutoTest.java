import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class AutoTest.
 *
 * @author  Evicted&EST
 * @version (a version number or a date)
 */
public class AutoTest
{

    public Person Jakob;
    public Person Fat1;
    public Person Fat2;
    public Person Fat3;
    public Person Fat4;
    public Person Fat5;
    public Autobus BMW;

    @BeforeEach
    public void setUp() 
    {
        Jakob = new Person("Jakob", true, 180,80);
        Fat1 = new Person("Fat1",true,170,200);
        Fat2 = new Person("Fat2",true,170,200);
        Fat3 = new Person("Fat3",true,170,201);
        Fat4 = new Person("Fat4",true,170,200);
        Fat5 = new Person("Fat5",true,170,201);
        BMW = new Autobus("BMW", 2900);
        System.out.println("----");
        System.out.println("Setup complete");
        System.out.println("Beginnt zu Testen");
    }

    @Test
    public void sameperson(){
        {
            try{
                BMW.einsteigen(Jakob);
                BMW.einsteigen(Jakob);
            }

            catch(Exception j){
                System.out.println("Exception gefangen: " + j.getMessage());
            }
        }
    }

    @Test
    public void TestAutoAussteigenPerson(){
        try {
            BMW.einsteigen(Jakob);
            BMW.aussteigen(Jakob);
            BMW.aussteigen(Jakob);
        }
        catch (Exception a){
            System.out.println("Exception gefange " + a.getMessage());
        }
    }

    @Test
    public void TestGesamtGewichtAutobus(){
        try {
            BMW.einsteigen(Fat1);
            BMW.einsteigen(Fat2);
            BMW.einsteigen(Fat3);
            BMW.einsteigen(Fat4);
            BMW.einsteigen(Fat5);
            BMW.autobusAushalten();
        } 
        catch (Exception e){
            System.out.println("Exception gefangen: " + e.getMessage());
        }   
    }

    @Test
    public void TestAutobus(){
        // Autoname null Test
        try{
            BMW.setName(null);
        }
        catch (Exception n){
            System.out.println("Exception gefange: " + n.getMessage());
        }
    }

    public void TestEigengewicht(){
        try {
            BMW.setEigengewicht(3001);
        }
        catch (Exception k){
            System.out.println("Exception gefangen: " + k.getMessage());
        }
    }

    @Test
    public void TestAussteigenString(){
        try {
            BMW.einsteigen(Jakob);
            BMW.aussteigen("Bob");
        }
        catch (Exception p){
            System.out.println("Exception gefangen: " + p.getMessage());
        }
    }

    @Test
    public void TestNull(){
        try {
            Jakob = null;
            BMW.einsteigen(Jakob);
        }
        catch (Exception t){
            System.out.println("Exception gefangen: " + t.getMessage());
        }
    }

    @AfterEach
    public void tearDown()
    {
        System.out.println("Test Ende");
    }
}