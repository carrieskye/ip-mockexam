package be.ucll.exam.service;

import be.ucll.exam.db.Database;
import be.ucll.exam.db.DatabaseFactory;
import be.ucll.exam.domain.Country;
import be.ucll.exam.domain.Specialty;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TourismService implements Service {
    
    private Database countryDb;
    private Database specialtyDb;

    private Database getSpecialityDb() {
        return specialtyDb;
    }

    private void setSpecialityDb(Database specialtyDb) {
        this.specialtyDb = specialtyDb;
    }

    private Database getCountryDb() {
        return countryDb;
    }

    private void setCountryDb(Database countryDb) {
        this.countryDb = countryDb;
    }

    public TourismService(String dbType) {
        DatabaseFactory databaseFactory = new DatabaseFactory();
        setCountryDb(databaseFactory.createDatabase(dbType, "Country"));
        setSpecialityDb(databaseFactory.createDatabase(dbType, "Specialty"));
    }

    public TourismService() {
        this("Memory");
    }

    @Override
    public void addCountry(Country country) {
        countryDb.add(country);
    }

    @Override
    public void updateCountry(Country country) {
        countryDb.update(country);
    }

    @Override
    public void removeCountry(long id) {
        countryDb.delete(id);
    }

    @Override
    public Country getCountry(long id) {
        return (Country)countryDb.get(id);
    }

    @Override
    public List<Country> getCountries() {
        List<Country> countries = new ArrayList<>();
        Collection<Country> objects = countryDb.getAll();
        for (Country i : objects) {
            countries.add((Country) i);
        }
        return countries;
    }

    @Override
    public void addSpecialty(Specialty specialty) {
        specialtyDb.add(specialty);
    }

    @Override
    public void updateSpecialty(Specialty specialty) {
        specialtyDb.update(specialty);
    }

    @Override
    public Specialty getSpecialty(long id) {
        return (Specialty) specialtyDb.get(id);
    }

    @Override
    public List<Specialty> getSpecialties() {

        List<Specialty> specialties = new ArrayList<>();
        Collection<Specialty> objects = specialtyDb.getAll();
        for (Specialty i : objects) {
            specialties.add((Specialty) i);
        }
        return specialties;
    }

    @Override
    public void removeSpecialty(long id) {
        //TODO check if specialty is not
        //referenced by any country
        //if so delete it from list in country
        //call update  for the country
        specialtyDb.delete(id);
    }


    @Override
    public void addSpecialtyToCountry(long specialtyId, long reserveId) {
        Specialty specialty = (Specialty) specialtyDb.get(specialtyId);
        Country country = (Country) countryDb.get(reserveId);
        country.addSpeciality(specialty);
        countryDb.update(country);
    }
}
