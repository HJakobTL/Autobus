// Autoren: Biegel Alexander und Cezawa Jakob
//
public class Autobus
{
    // Variable
    private String name;
    private double eigengewicht;
    private int stelle;
    private int busSize;
    private Person[] persons;

    // Auto Objekte
    public Autobus(){
        this.setName("n/A");
        this.setEigengewicht(1300); 
        this.setBusSize(10);
        this.setPersonenArray(persons);
    }

    public Autobus(String name, double eigengewicht, int busSize){
        this.setName(name);
        this.setEigengewicht(eigengewicht);
        this.setBusSize(busSize);
        this.setPersonenArray(persons);
    }

    // Die Getter
    public String getName(){
        return name;
    }

    public double getEigengewicht(){
        return eigengewicht;
    }

    public int getBusSize(){
        return busSize;
    }

    public Person[] getPerson(){
        return persons;
    }
    
    // Die Setter
    public void setName(String name){
        if (name == null){
            throw new IllegalArgumentException("Autoname darf nicht null sein");
        }
        this.name = name;
    }

    public void setEigengewicht(double eigengewicht){
        if (eigengewicht < 600 || eigengewicht > 3000){
            throw new IllegalArgumentException("Eigengewicht nur zwischen 600 und 3000 möglich");
        }
        this.eigengewicht = eigengewicht;
    }

    public void setBusSize(int busSize){
        if (busSize < 1 || busSize > 100){
            throw new IllegalArgumentException("Bus darf nur zwischen 1 und 100 sein");
        }
        this.busSize = busSize;
    }
    
    public void setPersonenArray(Person[] persons){
        this.persons = new Person[busSize];
    }
    
    public int stelleFinden(Person person){
        for (int i = 0; i < busSize; i++){
            if (persons[i] == person){
                stelle = i;
            }
        }
        return stelle;
    }

    // Einsteigen
    public Person einsteigen(Person person){
        for (int i = 0; i < busSize; i++){
            if (persons[stelleFinden(person)] == person){
                throw new IllegalArgumentException("Person schon im Bus");
            }
            if (null == persons[i]){
                return persons[i] = person;
            }
        }
        return null;
    }

    // Aussteigen
    public Person aussteigen(Person person){
        for (int i = 0; i < busSize; i++){
            if (person == persons[i]){
                return persons[i] = null;
            }
        }
        return person;
    }

    // Person ist im Array
    public boolean isDrinnen(Person person){
        boolean drinnen = false;
        for (int i = 0; i < busSize; i++){
            if (person == persons[i]){
                drinnen = true;
            }
        }
        return drinnen;
    }

    // Anzahl der Personen im Array
    public int anzahlPassagiere(){
        int anzahl = 0;
        for (int i = 0; i < busSize; i++){
            if (persons[i] != null){
                anzahl++;
            }
        }
        return anzahl;
    }

    //Gesamt Gewicht des Buses ausrechnen (Bus + Personen im Bus)
    public double nutzlast(){
        double gesamtGewicht = getEigengewicht(); 
        for (Person person: persons){
            if (person != null){
                gesamtGewicht += person.getKg();
            }
        }
        return gesamtGewicht;
    }
}
