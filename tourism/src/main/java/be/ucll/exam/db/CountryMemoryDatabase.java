package be.ucll.exam.db;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import be.ucll.exam.domain.Country;
import be.ucll.exam.domain.Specialty;

public class CountryMemoryDatabase implements Database<Country>  {

    private static long currentId = 1;
    private static Map<Long, Country> records = new HashMap<Long, Country>();

    public CountryMemoryDatabase() throws DatabaseException {
        if (records.isEmpty()) {
            Specialty chocolate = new Specialty("chocolate");
            new SpecialtyMemoryDatabase().add(chocolate);
            Country belgium = new Country("Belgium", 11000000);
            belgium.addSpeciality(chocolate);
            add(belgium);
            Country austria = new Country("Austria", 800000);
            add(austria); 
        }
    }

    @Override
    public Collection<Country> getAll() {
        return records.values();
    }

    @Override
    public long add(Country object) {
        if (!records.containsValue(object)) {
            object.setId(currentId);
            records.put(currentId, (Country)object);
            currentId++;
        }
        return currentId - 1;
    }

    @Override
    public void update(Country updated) {
        if (updated == null) {
            throw new DatabaseException("Cannot be empty.");
        }
        long id = updated.getId();

        records.put(id, (Country)updated);
    }

    @Override
    public Country get(long id) {
        if (id == 0) {
            throw new DatabaseException("Id cannot be 0.");
        }
        return records.get(id);
    }

    @Override
    public void delete(long id) {
        if (id == 0) {
            throw new DatabaseException("Id cannot be 0.");
        }
        records.remove(id);
    }
}
