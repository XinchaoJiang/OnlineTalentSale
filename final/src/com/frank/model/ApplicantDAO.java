package com.frank.model;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.frank.impl.ApplicantDAOImpl;

/**
 * A data access object (DAO) providing persistence and search support for
 * Applicant entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.frank.model.Applicant
 * @author MyEclipse Persistence Tools
 */

public class ApplicantDAO extends HibernateDaoSupport implements ApplicantDAOImpl {
	private static final Logger log = LoggerFactory
			.getLogger(ApplicantDAO.class);
	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.frank.model.ApplicantDAOImpl#save(com.frank.model.Applicant)
	 */
	@Override
	public boolean save(Applicant transientInstance) {
		boolean flag=true;
		log.debug("saving Applicant instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			flag=false;
			log.error("save failed", re);
			throw re;			
		}
		return flag;
	}

	/* (non-Javadoc)
	 * @see com.frank.model.ApplicantDAOImpl#delete(com.frank.model.Applicant)
	 */
	@Override
	public void delete(Applicant persistentInstance) {
		log.debug("deleting Applicant instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.frank.model.ApplicantDAOImpl#findById(java.lang.Integer)
	 */
	@Override
	public Applicant findById(java.lang.Integer id) {
		log.debug("getting Applicant instance with id: " + id);
		try {
			Applicant instance = (Applicant) getHibernateTemplate().get(
					"com.frank.model.Applicant", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.frank.model.ApplicantDAOImpl#findByExample(com.frank.model.Applicant)
	 */
	@Override
	public List<Applicant> findByExample(Applicant instance) {
		log.debug("finding Applicant instance by example");
		try {
			List<Applicant> results = (List<Applicant>) getHibernateTemplate()
					.findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.frank.model.ApplicantDAOImpl#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Applicant instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Applicant as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.frank.model.ApplicantDAOImpl#findByProjectName(java.lang.Object)
	 */
	@Override
	public List<Applicant> findByProjectName(Object projectName) {
		return findByProperty(PROJECT_NAME, projectName);
	}

	/* (non-Javadoc)
	 * @see com.frank.model.ApplicantDAOImpl#findByUserName(java.lang.Object)
	 */
	@Override
	public List<Applicant> findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	/* (non-Javadoc)
	 * @see com.frank.model.ApplicantDAOImpl#findByPublisher(java.lang.Object)
	 */
	@Override
	public List<Applicant> findByPublisher(Object publisher) {
		return findByProperty(PUBLISHER, publisher);
	}

	/* (non-Javadoc)
	 * @see com.frank.model.ApplicantDAOImpl#findByTime(java.lang.Object)
	 */
	@Override
	public List<Applicant> findByTime(Object time) {
		return findByProperty(TIME, time);
	}

	/* (non-Javadoc)
	 * @see com.frank.model.ApplicantDAOImpl#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all Applicant instances");
		try {
			String queryString = "from Applicant";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.frank.model.ApplicantDAOImpl#merge(com.frank.model.Applicant)
	 */
	@Override
	public Applicant merge(Applicant detachedInstance) {
		log.debug("merging Applicant instance");
		try {
			Applicant result = (Applicant) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.frank.model.ApplicantDAOImpl#attachDirty(com.frank.model.Applicant)
	 */
	@Override
	public void attachDirty(Applicant instance) {
		log.debug("attaching dirty Applicant instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.frank.model.ApplicantDAOImpl#attachClean(com.frank.model.Applicant)
	 */
	@Override
	public void attachClean(Applicant instance) {
		log.debug("attaching clean Applicant instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ApplicantDAOImpl getFromApplicationContext(ApplicationContext ctx) {
		return (ApplicantDAOImpl) ctx.getBean("ApplicantDAO");
	}
}