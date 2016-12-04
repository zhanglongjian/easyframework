package com.easyframework.common.repository;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

/**
 * @todo 统一接口，实体类访问接口
 * @createdBy zhujinmei
 * @Date 2016年10月21日22:09:53
 */
public interface IBaseDao<T> {
    /**
     * 保存数据
     *
     * @param o
     * @return
     */
    public void save(T o);

    /**
     * 删除数据
     *
     * @param o
     */
    public void delete(T o);

    /**
     * 更新数据
     *
     * @param o
     */
    public void update(T o);

    /**
     * 保存更新数据
     *
     * @param o
     */
    public void saveOrUpdate(T o);

    /**
     * 立即加载，通过ID获得对象
     *
     * @param c
     * @param id
     * @return
     */
    public T get(Class<T> c, Serializable id);

    /**
     * 通过jpql获得对象
     *
     * @param jpql
     * @return
     */
    public T get(String jpql);

    /**
     * 通过参数查询对象
     *
     * @param jpql
     * @param params
     * @return
     */
    public T get(String jpql, Map<String, Object> params);

    /**
     * 通过jpql查询数据集合
     *
     * @param jpql
     * @return
     */
    public List<T> find(String jpql);

    /**
     * 通过参数查询数据集合
     *
     * @param jpql
     * @param params
     * @return
     */
    public List<T> find(String jpql, Map<String, Object> params);

    /**
     * 数据分页
     *
     * @param jpql
     * @param page
     * @param rows
     * @return
     */
    public List<T> find(String jpql, int page, int rows);

    /**
     * 查询分页
     *
     * @param jpql    jpql语句
     * @param params 参数列表
     * @param page
     * @param rows
     * @return
     */
    public List<T> find(String jpql, Map<String, Object> params, int page, int rows);

    /**
     * 根据jpql计算总记录数
     *
     * @param jpql
     * @return
     */
    public Long count(String jpql);

    /**
     * 查询总记录数
     *
     * @param jpql
     * @param params
     * @return
     */
    public Long count(String jpql, Map<String, Object> params);

    /**
     * 执行jpql
     *
     * @param jpql
     * @return
     */
    public int executejpql(String jpql);

    /**
     * @param jpql
     * @param params
     * @return
     */
    public int executejpql(String jpql, Map<String, Object> params);

    /**
     * 通过sql查询
     *
     * @param sql
     * @return
     */
    public List<Object[]> findBySql(String sql);

    /**
     * sql分页查询
     *
     * @param sql
     * @param page
     * @param rows
     * @return
     */
    public List<Object[]> findBySql(String sql, int page, int rows);

    /**
     * sql分页参数查询
     *
     * @param sql
     * @param params
     * @param page
     * @param rows
     * @return
     */
    public List<Object[]> findBySql(String sql, Map<String, Object> params, int page, int rows);

    /**
     * 普通sql查询
     *
     * @param sql
     * @return
     */
    public int executeSql(String sql);

    /**
     * 参数查询
     *
     * @param sql
     * @param params
     * @return
     */
    public int executeSql(String sql, Map<String, Object> params);

    /**
     * 通过sql计算总记录数
     *
     * @param sql
     * @return
     */
    public BigInteger countBySql(String sql);

    /**
     * 通过参数列表查询总记录数
     *
     * @param sql
     * @param params
     * @return
     */
    public BigInteger countBySql(String sql, Map<String, Object> params);
}
