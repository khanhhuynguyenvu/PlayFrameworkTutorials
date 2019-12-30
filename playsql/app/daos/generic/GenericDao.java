package daos.generic;

public interface GenericDao<T> {
    T findById(String id,Class<T> t);
    T save(T t);
    void remove(T t);
    T update(T t);
}
