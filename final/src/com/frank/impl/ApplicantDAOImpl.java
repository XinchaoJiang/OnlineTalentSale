package com.frank.impl;

import java.util.List;

import com.frank.model.Applicant;

public interface ApplicantDAOImpl {

	// property constants
	public static final String PROJECT_NAME = "projectName";
	public static final String USER_NAME = "userName";
	public static final String PUBLISHER = "publisher";
	public static final String TIME = "time";

	public abstract boolean save(Applicant transientInstance);

	public abstract void delete(Applicant persistentInstance);

	public abstract Applicant findById(java.lang.Integer id);

	public abstract List<Applicant> findByExample(Applicant instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List<Applicant> findByProjectName(Object projectName);

	public abstract List<Applicant> findByUserName(Object userName);

	public abstract List<Applicant> findByPublisher(Object publisher);

	public abstract List<Applicant> findByTime(Object time);

	public abstract List findAll();

	public abstract Applicant merge(Applicant detachedInstance);

	public abstract void attachDirty(Applicant instance);

	public abstract void attachClean(Applicant instance);

}