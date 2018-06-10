package be.ucll.exam.domain;

import java.util.HashSet;
import java.util.Set;

public class Country  {
    private long id;
    private String name;
    private int numberInhabitants;
    private Set<Specialty> specialities = new HashSet<Specialty>();

    public Country() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Country(String name, int numberInhabitants) throws DomainException {
        setName(name);
        setNumberInhabitants(numberInhabitants);
    }
    
    public Country(long id, String name, int numberInhabitants) throws DomainException {
        this(name, numberInhabitants);
        setId(id);
    }

    public int getNumberInhabitants() {
        return numberInhabitants;
    }

    public void setNumberInhabitants(int numberInhabitants) throws DomainException {
        if (numberInhabitants < 0) {
            throw new DomainException("Aantal inwoners mag niet negatief zijn.");
        }
        this.numberInhabitants = numberInhabitants;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws DomainException {
        if (name == null || name.isEmpty()) {
            throw new DomainException("Naam mag niet leeg zijn.");
        }
        this.name = name;
    }

    public void setSpecialties(Set<Specialty> specialities) {
        this.specialities = specialities;
    }

    public Set<Specialty> getSpecialties() {
        return specialities;
    }

    public void addSpeciality(Specialty speciality) throws DomainException {
        if (speciality == null) {
            throw new DomainException("Speciality mag niet leeg zijn.");
        }
        this.specialities.add(speciality);
    }

    public int compareTo(Country country) {
        return getName().compareTo(country.getName());
    }
    
    @Override
    public boolean equals(Object object){
        boolean equal = false;
        if(object instanceof Country){
            equal = super.equals(object);
        }
        return equal;
    }

    @Override
    public String toString() {
        String result = getName() + " (" + getNumberInhabitants() + " inwoners)";
        for (Specialty s : specialities) {
            result += "\n" + s.getName();
        }
        return result;
    }
}
