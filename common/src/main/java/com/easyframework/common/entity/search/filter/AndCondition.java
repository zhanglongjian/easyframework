
package com.easyframework.common.entity.search.filter;

import com.google.common.collect.Lists;

import java.util.List;


/**
 * <p>And条件</p>
 * <p> @author zhang longjian</p>
 * <p> @createTime 2016年10月11日 上午11:29:45 </p>
 * <p></p>
 */
public class AndCondition implements SearchFilter {

    private List<SearchFilter> andFilters = Lists.newArrayList();

    AndCondition() {
    }

    public AndCondition add(SearchFilter filter) {
        this.andFilters.add(filter);
        return this;
    }

    public List<SearchFilter> getAndFilters() {
        return andFilters;
    }

    @Override
    public String toString() {
        return "AndCondition{" + andFilters + '}';
    }
}
