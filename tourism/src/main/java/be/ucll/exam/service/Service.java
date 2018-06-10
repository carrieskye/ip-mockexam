/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ucll.exam.service;

import be.ucll.exam.domain.Country;
import be.ucll.exam.domain.Specialty;

import java.util.List;

public interface Service {

    public void addCountry(Country country);

    public void removeCountry(long id) ;

    public void updateCountry(Country country);

    public List<Country> getCountries() ;

    public Country getCountry(long id);

    public void addSpecialty(Specialty speciality);

    public void removeSpecialty(long id);

    public List<Specialty> getSpecialties();

    public Specialty getSpecialty(long id);

    public void updateSpecialty(Specialty speciality);

    public void addSpecialtyToCountry(long specialtyId, long countryId);

}
