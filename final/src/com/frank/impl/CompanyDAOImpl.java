package com.frank.impl;

import java.util.List;

import com.frank.model.Company;

public interface CompanyDAOImpl {

	// property constants
	public static final String NAME = "name";
	public static final String ROLE_ID = "roleId";
	public static final String PASSWORD = "password";
	public static final String DESCRIPTION = "description";

	public abstract void save(Company transientInstance);

	public abstract void delete(Company persistentInstance);

	public abstract Company findById(java.lang.Integer id);

	public abstract List<Company> findByExample(Company instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List<Company> findByName(Object name);

	public abstract List<Company> findByRoleId(Object roleId);

	public abstract List<Company> findByPassword(Object password);

	public abstract List<Company> findByDescription(Object description);

	public abstract List findAll();

	public abstract Company merge(Company detachedInstance);

	public abstract void attachDirty(Company instance);

	public abstract void attachClean(Company instance);

}