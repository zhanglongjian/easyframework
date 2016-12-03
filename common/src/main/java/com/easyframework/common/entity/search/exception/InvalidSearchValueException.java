
package com.easyframework.common.entity.search.exception;


/**
 * <p></p>
 * <p> @author zhang longjian</p>
 * <p> @createTime 2016年10月11日 上午11:26:20 </p>
 * <p></p>
 */
public final class InvalidSearchValueException extends SearchException {

    public InvalidSearchValueException(String searchProperty, String entityProperty, Object value) {
        this(searchProperty, entityProperty, value, null);
    }

    public InvalidSearchValueException(String searchProperty, String entityProperty, Object value, Throwable cause) {
        super("Invalid Search Value, searchProperty [" + searchProperty + "], " +
                "entityProperty [" + entityProperty + "], value [" + value + "]", cause);
    }

}
