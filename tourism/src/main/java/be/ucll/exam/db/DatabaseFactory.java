package be.ucll.exam.db;

public class DatabaseFactory {

    public Database createDatabase(String type, String className) throws DatabaseException {
        Database db = null;
        if ("Memory".equals(type)) {
            if ("Country".equals(className)) {
                db = new CountryMemoryDatabase();

            }
            if ("Specialty".equals(className)) {
                db = new SpecialtyMemoryDatabase();

            }
        }
        return db;
    }
}
