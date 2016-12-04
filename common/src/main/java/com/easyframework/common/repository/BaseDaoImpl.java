package com.easyframework.common.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

/**
 * @todo
 * @createdBy zhanglj
 * @Date 2015/11/26.
 */
@Repository("baseDao")
public class BaseDaoImpl<T> implements IBaseDao<T> {
    @PersistenceContext
    private EntityManager entityManager;
    //private EntityManagerFactory emf;
    /*public  EntityManager getEntityManager(){
        return emf.createEntityManager();
    }*/
    /**
     * 保存数据
     */
    @Override
    @Transactional
    public void save(T o) {
        if (o != null) {
            entityManager.persist(o);
        }
    }
    /**
     * 删除数据
     */
    @Override
    @Transactional
    public void delete(T o) {
        if (o != null) {
            entityManager.remove(o);
        }
    }
    
    /**
     * 更新
     */
    @Override
    @Transactional
    public void update(T o) {
        if (o != null) {
            entityManager.merge(o);
        }
    }
    /**
     * 保存更新
     */
    @Override
    public void saveOrUpdate(T o) {

    }
    /**
     * 立即加载，通过ID获得对象
     */
    @Override
    public T get(Class<T> c, Serializable id) {
        return entityManager.find(c, id);
    }

    @Override
    public T get(String jpql) {
        Query query = entityManager.createQuery(jpql);
        List<T> _list = query.getResultList();
        if ((_list != null) && (_list.size() > 0)) {
            return _list.get(0);
        }
        return null;
    }

    @Override
    public T get(String jpql, Map<String, Object> params) {
        Query query = entityManager.createQuery(jpql);
        if ((params != null) && !params.isEmpty()) {
            for (String key : params.keySet()) {
                query.setParameter(key, params.get(key));
            }
        }
        List<T> _list = query.getResultList();
        if ((_list != null) && (_list.size() > 0)) {
            return _list.get(0);
        }
        return null;
    }

    @Override
    public List<T> find(String jpql) {
        Query query = entityManager.createQuery(jpql);
        return query.getResultList();
    }

    @Override
    public List<T> find(String jpql, Map<String, Object> params) {
        Query query = entityManager.createQuery(jpql);
        if ((params != null) && !params.isEmpty()) {
            for (String key : params.keySet()) {
                query.setParameter(key, params.get(key));
            }
        }

        return query.getResultList();
    }

    @Override
    public List<T> find(String jpql, int page, int rows) {
        Query query = entityManager.createQuery(jpql);
        query.setFirstResult((page - 1) * rows);
        query.setMaxResults(rows);
        return query.getResultList();
    }

    @Override
    public List<T> find(String jpql, Map<String, Object> params, int page, int rows) {
        Query query = entityManager.createQuery(jpql);
        if ((params != null) && !params.isEmpty()) {
            for (String key : params.keySet()) {
                query.setParameter(key, params.get(key));
            }
        }
        query.setFirstResult((page - 1) * rows);
        query.setMaxResults(rows);
        return query.getResultList();
    }

    @Override
    public Long count(String jpql) {
        Query query = entityManager.createQuery(jpql);
        return (Long)query.getSingleResult();
    }

    @Override
    public Long count(String jpql, Map<String, Object> params) {
        Query query = entityManager.createQuery(jpql);
        if ((params != null) && !params.isEmpty()) {
            for (String key : params.keySet()) {
                query.setParameter(key, params.get(key));
            }
        }
        return (Long)query.getSingleResult();
    }

    @Override
    public int executejpql(String jpql) {
        Query query = entityManager.createQuery(jpql);
        return query.executeUpdate();
    }

    @Override
    public int executejpql(String jpql, Map<String, Object> params) {
        Query query = entityManager.createQuery(jpql);
        if ((params != null) && !params.isEmpty()) {
            for (String key : params.keySet()) {
                query.setParameter(key, params.get(key));
            }
        }
        return query.executeUpdate();
    }

    @Override
    public List<Object[]> findBySql(String sql) {
        Query sqlQuery=entityManager.createNativeQuery(sql);
        return sqlQuery.getResultList();
    }

    @Override
    public List<Object[]> findBySql(String sql, int page, int rows) {
        Query sqlQuery=entityManager.createNativeQuery(sql);
        sqlQuery.setFirstResult((page-1)*rows);
        sqlQuery.setMaxResults(rows);
        return sqlQuery.getResultList();
    }

    @Override
    public List<Object[]> findBySql(String sql, Map<String, Object> params, int page, int rows) {
        Query sqlQuery=entityManager.createNativeQuery(sql);
        if ((params != null) && !params.isEmpty()) {
            for (String key : params.keySet()) {
                sqlQuery.setParameter(key, params.get(key));
            }
        }
        sqlQuery.setFirstResult((page-1)*rows);
        sqlQuery.setMaxResults(rows);
        return sqlQuery.getResultList();
    }

    @Override
    public int executeSql(String sql) {
        Query sqlQuery=entityManager.createNativeQuery(sql);
        return sqlQuery.executeUpdate();
    }

    @Override
    public int executeSql(String sql, Map<String, Object> params) {
        Query sqlQuery=entityManager.createNativeQuery(sql);
        if ((params != null) && !params.isEmpty()) {
            for (String key : params.keySet()) {
                sqlQuery.setParameter(key, params.get(key));
            }
        }
        return sqlQuery.executeUpdate();
    }

    @Override
    public BigInteger countBySql(String sql) {
        Query sqlQuery=entityManager.createNativeQuery(sql);
        return (BigInteger) sqlQuery.getSingleResult();
    }

    @Override
    public BigInteger countBySql(String sql, Map<String, Object> params) {
        Query sqlQuery=entityManager.createNativeQuery(sql);
        if ((params != null) && !params.isEmpty()) {
            for (String key : params.keySet()) {
                sqlQuery.setParameter(key, params.get(key));
            }
        }
        return (BigInteger)sqlQuery.getSingleResult();
    }
}
