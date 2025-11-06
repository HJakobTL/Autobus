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
    public Person Alex;
    public Person Fat1;
    public Person Fat2;
    public Person Fat3;
    public Person Fat4;
    public Person Fat5;
    public Autobus Bus;
    public Autobus LargeBus;
    public Person[] persons;

    @BeforeEach
    public void setUp()
    {
        Jakob = new Person("Jakob", true, 180,80);
        Alex = new Person("Alex", true, 175, 80);
        Fat1 = new Person("Fat1",true,170,200);
        Fat2 = new Person("Fat2",true,170,200);
        Fat3 = new Person("Fat3",true,170,201);
        Fat4 = new Person("Fat4",true,170,200);
        Fat5 = new Person("Fat5",true,170,201);
        Bus = new Autobus("Bus", 1300, 2);
        LargeBus = new Autobus("GroßBus", 2000, 7);
        System.out.println("----");
        System.out.println("Setup complete");
        System.out.println("Beginnt zu Testen");
    }

    @Test
    public void TestSamePersonEinsteigen(){
        {
            try{
                Bus.einsteigen(Jakob);
                // Jakob kann nicht 2mal einsteigen
                Bus.einsteigen(Jakob);
            }

            catch(Exception j){
                System.out.println("Exception gefangen: " + j.getMessage());
            }
        }
    }

    @Test
    public void TestBusAussteigenSamePerson(){
        try {
            Bus.einsteigen(Jakob);
            Bus.aussteigen(Jakob);
            // Jakob kann nicht nochmal aussteigen
            Bus.aussteigen(Jakob);
        }
        catch (Exception a){
            System.out.println("Exception gefange " + a.getMessage());
        }
    }

    @Test
    public void TestBusAussteigenNichtDaPerson(){
        try {
            Bus.einsteigen(Jakob);
            Bus.einsteigen(Alex);
            // Fat1 kann nicht einsteigen, da er NIE eingestiegen ist
            Bus.aussteigen(Fat1);
        }
        catch (Exception a){
            System.out.println("Exception gefange " + a.getMessage());
        }
    }

    @Test
    public void TestZuVieleImBus(){
        try {
            Bus.einsteigen(Jakob);
            Bus.einsteigen(Alex);
            // Fat1 darf nicht einsteigen, weil nur für 2 Platz ist
            Bus.einsteigen(Fat1);
        }
        catch (Exception e){
            System.out.println("Exception gefangen: " + e.getMessage());
        }
    }

    @Test
    public void TestAutobus(){
        // Autoname null Test
        try{
            Bus.setName(null);
        }
        catch (Exception n){
            System.out.println("Exception gefange: " + n.getMessage());
        }
    }

    @Test
    public void TestAnzahlLeute(){
        try{
            LargeBus.einsteigen(Jakob); // 1
            LargeBus.einsteigen(Alex); // 2
            LargeBus.einsteigen(Fat1); // 3
            LargeBus.aussteigen(Jakob); // 2
            LargeBus.einsteigen(Fat2); // 3
            LargeBus.einsteigen(Fat3); // 4
            LargeBus.aussteigen(Fat3); // 3
            LargeBus.einsteigen(Fat4); // 4
            LargeBus.einsteigen(Fat5); // 5
            LargeBus.aussteigen(Alex); // 4
            // Es sollten 4 Leute im Bus sein
        }

        catch (Exception n){
            System.out.println("Exception gefange: " + n.getMessage());
        }
        if (LargeBus.anzahlPassagiere() == 4){
            System.out.println("Es ist nichts schief gelaufen!");
        }
    }

     @Test
    public void TestGewichtBus(){
        try{
            // Bus = 1300
            Bus.einsteigen(Jakob); // 80
            Bus.einsteigen(Alex); // 80
            // Gesamt = 1460
        }

        catch (Exception n){
            System.out.println("Exception gefange: " + n.getMessage());
        }
        if (Bus.nutzlast() == 1460){
            System.out.println("GesamtGewicht ist Richtig");
        }
    }

    @AfterEach
    public void tearDown()
    {
        System.out.println("Test Ende");
    }
}