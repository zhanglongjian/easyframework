
package com.easyframework.common.repository.callback;


import javax.persistence.Query;

import com.easyframework.common.entity.search.Searchable;


/**
 * 
 * <p></p>
 * <p> @author zhang longjian</p>
 * <p> @createTime 2016年10月11日 下午2:48:12 </p>
 * <p></p>
 */
public interface SearchCallback {

    public static final SearchCallback NONE = new NoneSearchCallback();
    public static final SearchCallback DEFAULT = new DefaultSearchCallback();


    /**
     * 动态拼HQL where、group by having
     *
     * @param ql
     * @param search
     */
    public void prepareQL(StringBuilder ql, Searchable search);

    public void prepareOrder(StringBuilder ql, Searchable search);

    /**
     * 根据search给query赋值及设置分页信息
     *
     * @param query
     * @param search
     */
    public void setValues(Query query, Searchable search);

    public void setPageable(Query query, Searchable search);

}
