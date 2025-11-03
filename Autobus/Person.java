/**
 * Write a description of class Student here.
 *
 * @author (Jakob C)
 * @version (29.09.2025)
 */
public class Person
{
    // Meine Variablen
    private String name;
    private double kg;
    private double cm;
    private char gender;

    //Person Objekt
    public Person(){
        this.setName("Test");
        this.setKg(80);
        this.setCm(180);
        this.setGender('m');
    }
    
    public Person(String name,boolean isMale,double cm, double kg){
        this.setName(name);
        this.setKg(kg);
        this.setCm(cm);
        if (isMale){
            this.setGender('m');
        }
        else this.setGender('f');
    }  
    
    //Die Getter
    public String getName(){
        return name;
    }
    
    public double getKg(){
        return kg;
    }
    
    //Die Setter
    public void setName(String name){
        // TODO: Seperate Meldung zu kurz oder zu lang
        if (name.length() < 3){
            throw new IllegalArgumentException("Name muss mind. 3 Buchstaben haben");
        }
        else if (name.length() > 50){
            throw new IllegalArgumentException("Name darf max 50 Buchstaben haben");
        }   
        this.name = name;
    }

    public void setKg(double kilogramm){
        if (kilogramm > 635) {
            throw new IllegalArgumentException("Mehr als 635kg nicht möglich");
        } else if (kilogramm < 2) {
            throw new IllegalArgumentException("Weniger als 2kg nicht möglich");
        }
        this.kg = kilogramm;
    }

    public void setCm(double centimeter){
        if (centimeter > 250) {
            throw new IllegalArgumentException("Größer als 250cm ist nicht möglich");
        } else if (centimeter < 50) {
            throw new IllegalArgumentException("Kleiner als 54cm ist nicht möglich");
        }
        this.cm = centimeter;
    }

    public void setGender(char gender){
        gender = Character.toLowerCase(gender);
        if (gender != 'm' && gender != 'f'){
            throw new IllegalArgumentException("m oder f eingeben");
        }
        this.gender = gender;
    }

    //Print Person Info
    public void printPerson(){
        System.out.println("Name: " + this.name);
        System.out.println("Gewicht: " + this.kg);
        System.out.println("Größe: " + this.cm);
        System.out.println("BMI: " + this.bmiRechner());
        System.out.println("Dein Geschlecht: " + this.mannOderFrau());
        System.out.println("Du bist: " + this.bmiWerter());
    }
    //BMI Rechner
    public double bmiRechner(){
        double cmInMetern = this.cm / 100.0f;
        double ergebnis = (this.kg / (cmInMetern*cmInMetern));
        return ergebnis;
    }
    //Test ob Mann oder Frau
    private String mannOderFrau(){
        if (this.gender == 'm'){
            return "Männlich";  
        }
        else if (this.gender == 'f'){
            return "Weiblich";
        }
        else throw new IllegalArgumentException("Geben Sie 'm' oder 'f' ein");
    }
    //BMI Schauen ob unter/über/normalgewicht
    public String bmiWerter(){
        int normalMaxM = 25;
        int normalMinM = 20;
        int normalMaxF = 24;
        int normalMinF = 19;
        double bmi = this.bmiRechner();
        if (gender == 'm'){
            if (bmi < normalMinM){
                return "Untergewicht";
            }
            if (bmi > normalMaxM){
                return "Übergewicht";
            }
            return "Normal";
        }
        if(gender == 'f'){
            if (bmi < normalMinF){
                return "Untergewicht";
            }
            if (bmi > normalMaxF){
                return "Übergewicht";
            }
            return "Normal";
        }
        else return "Error";
    }
}
 