package com.frank.impl;

import java.util.List;

import com.frank.model.Project;

public interface ProjectDAOImpl {

	// property constants
	public static final String PUBLISHER = "publisher";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String TIME = "time";

	public abstract boolean save(Project transientInstance);

	public abstract void delete(Project persistentInstance);

	public abstract Project findById(java.lang.Integer id);

	public abstract List<Project> findByExample(Project instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List<Project> findByPublisher(Object publisher);

	public abstract List<Project> findByName(Object name);

	public abstract List<Project> findByDescription(Object description);

	public abstract List<Project> findByTime(Object time);

	public abstract List findAll();

	public abstract Project merge(Project detachedInstance);

	public abstract void attachDirty(Project instance);

	public abstract void attachClean(Project instance);

}