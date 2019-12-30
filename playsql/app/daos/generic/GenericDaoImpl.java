package daos.generic;

import config.SingletonPersistenceConfig;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class GenericDaoImpl<T> implements GenericDao<T> {
    protected EntityManager entityManager = SingletonPersistenceConfig.getInstance().getEntityManager();

    public GenericDaoImpl() {
    }

    @Override
    public T findById(String id, Class<T> t) {
        return entityManager.find(t, id);
    }

    @Override
    public T save(T t) {
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(t);
            entityManager.flush();
            transaction.commit();
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void remove(T t) {
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.remove(entityManager.contains(t) ? t : entityManager.merge(t));
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public T update(T t) {
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.merge(t);
            entityManager.flush();
            transaction.commit();
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
