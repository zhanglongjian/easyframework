/**
 * Copyright (c) 2005-2012 https://github.com/zhangkaitao
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.easyframework.common.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.easyframework.common.utils.FastJSONUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 抽象实体基类，提供统一的ID，和相关的基本功能方法 如果是oracle请参考{@link BaseOracleEntity}
 * </p>
 * <p>
 * 
 * @author zhang longjian
 *         </p>
 *         <p>
 * @createTime 2016年10月11日 上午11:44:29
 *             </p>
 *             <p>
 *             </p>
 */
@MappedSuperclass
@DynamicInsert
@DynamicUpdate
public abstract class BaseEntity<ID extends Serializable>
        extends AbstractEntity<ID> {
	/**
	 * 实体主键
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private ID id;
	/**
	 * 是否删除状态
	 */
	@Column(columnDefinition = " bit default 0")
	private boolean deleteStatus = false;
	/**
	 * 实体版本
	 */
	@Version
	@Column(columnDefinition = "bigint default 0")
	private long version = 01;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 创建人
	 */
	private String createBy;
	/**
	 * 创建人
	 */
	private Long createByID;
	/**
	 * 最后修改时间
	 */
	private Date lastModifyTime;
	/**
	 * 最后修改人
	 */
	private String lastModifyBy;
	/**
	 * 最后修改人
	 */
	private Long lastModifyByID;

	@Override
	public ID getId() {
		return id;
	}

	@Override
	public void setId(ID id) {
		this.id = id;
	}

	public boolean isDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(boolean deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Long getCreateByID() {
		return createByID;
	}

	public void setCreateByID(Long createByID) {
		this.createByID = createByID;
	}

	public Date getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	public String getLastModifyBy() {
		return lastModifyBy;
	}

	public void setLastModifyBy(String lastModifyBy) {
		this.lastModifyBy = lastModifyBy;
	}

	public Long getLastModifyByID() {
		return lastModifyByID;
	}

	public void setLastModifyByID(Long lastModifyByID) {
		this.lastModifyByID = lastModifyByID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseEntity other = (BaseEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return FastJSONUtils.toJsonString(this);
	}

}
