package be.ucll.exam.db;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import be.ucll.exam.domain.Country;
import be.ucll.exam.domain.Specialty;

public class SpecialtyMemoryDatabase implements Database<Specialty> {

    private static long currentId = 1;
    private static Map<Long, Specialty> records = new HashMap<Long, Specialty>();

    public SpecialtyMemoryDatabase() throws DatabaseException {
        if (records.isEmpty()) {
            Specialty cheese = new Specialty("Cheese");
            add(cheese);
            Specialty beer = new Specialty("Beer");
            add(beer);   
            Specialty chocolate = new Specialty("Chocolate");
            add(chocolate);   
        }
    }

    @Override
    public Collection<Specialty> getAll() {
        return records.values();
    }

    @Override
    public long add(Specialty object) throws DatabaseException {
        if (!records.containsValue(object)) {
            object.setId(currentId);
            records.put(currentId, (Specialty)object);
            currentId++;
        }
        return currentId - 1;
    }

    @Override
    public void update(Specialty updated) {
        if (updated == null) {
            throw new DatabaseException("Cannot be empty.");
        }

        long id = updated.getId();

        records.put(id, (Specialty)updated);
    }

    @Override
    public Specialty get(long id) throws DatabaseException {
        if (id == 0) {
            throw new DatabaseException("Id cannot be 0.");
        }
        return records.get(id);
    }

    @Override
    public void delete(long id) throws DatabaseException {
        if (id == 0) {
            throw new DatabaseException("Id cannot be 0.");
        }
        records.remove(id);
    }
}
