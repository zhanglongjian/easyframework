
package com.easyframework.common.entity.search.filter;

import com.google.common.collect.Lists;

import java.util.List;


/**
 * <p>Or 条件</p>
 * <p> @author zhang longjian</p>
 * <p> @createTime 2016年10月11日 上午11:30:32 </p>
 * <p></p>
 */
public class OrCondition implements SearchFilter {

    private List<SearchFilter> orFilters = Lists.newArrayList();

    OrCondition() {
    }

    public OrCondition add(SearchFilter filter) {
        this.orFilters.add(filter);
        return this;
    }

    public List<SearchFilter> getOrFilters() {
        return orFilters;
    }

    @Override
    public String toString() {
        return "OrCondition{" + orFilters + '}';
    }
}
