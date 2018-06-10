package be.ucll.exam.db;

import java.util.Collection;

public interface Database<T> {

    public long add(T object);

    public void update(T updated);

    public void delete(long id);

    public T get(long id);

    public Collection getAll();
}
