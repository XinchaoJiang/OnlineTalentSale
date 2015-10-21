package com.frank.impl;

import java.util.List;

import com.frank.model.Resume;

public interface ResumeDAOImpl {

	// property constants
	public static final String CONTENT = "content";
	public static final String USER_NAME = "userName";
	public static final String TIME = "time";

	public abstract boolean save(Resume transientInstance);

	public abstract void delete(Resume persistentInstance);

	public abstract Resume findById(java.lang.Integer id);

	public abstract List<Resume> findByExample(Resume instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List<Resume> findByContent(Object content);

	public abstract List<Resume> findByUserName(Object userName);

	public abstract List<Resume> findByTime(Object time);

	public abstract List findAll();

	public abstract Resume merge(Resume detachedInstance);

	public abstract void attachDirty(Resume instance);

	public abstract void attachClean(Resume instance);

}