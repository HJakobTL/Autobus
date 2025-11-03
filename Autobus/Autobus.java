// Autoren: Biegel Alexander und Cezawa Jakob
//
public class Autobus
{
    // Variable
    private String name;
    private double eigengewicht;
    private int busSize;
    private Person[] persons;

    // Auto Objekte
    public Autobus(){
        this.setName("n/A");
        this.setEigengewicht(1300); 
        this.setBusSize(2);
    }

    public Autobus(String name, double eigengewicht, int busSize){
        this.setName(name);
        this.setEigengewicht(eigengewicht);
        this.setBusSize(busSize);
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
        if (this.busSize != busSize || this.persons == null){
            this.persons = new Person[busSize];
        }
        this.busSize = busSize;
    }

    public int stelleFinden(Person person){
        for (int i = 0; i < busSize; i++){
            if (persons[i] != null && person.equals(persons[i])){
                return i;
            }
        }
        return -1;
    }

    // Einsteigen
    public Person einsteigen(Person person){
        if (stelleFinden(person) >= 0){
                throw new IllegalArgumentException("Person schon im Bus");
            }
        for (int i = 0; i < busSize; i++){
            if (null == persons[i]){
                persons[i] = person;
                return person;
            }
        }
        throw new IllegalArgumentException("Bus ist voll");
    }

    // Aussteigen
    public Person aussteigen(Person person){
        for (int i = 0; i < busSize; i++){
            if (persons[i] != null && person.equals(persons[i])){
                persons[i] = null;
                return null;
            }
        }
        throw new IllegalArgumentException("Person nicht im Bus");
    }

    // Person ist im Array
    public boolean isDrinnen(Person person){
        for (int i = 0; i < busSize; i++){
            if (persons[i] != null && person.equals(persons[i])){
                return true;
            }
        }
        return false;
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
