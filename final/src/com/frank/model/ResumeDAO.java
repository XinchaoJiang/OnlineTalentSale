package com.frank.model;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.frank.impl.ResumeDAOImpl;

/**
 * A data access object (DAO) providing persistence and search support for
 * Resume entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.frank.model.Resume
 * @author MyEclipse Persistence Tools
 */

public class ResumeDAO extends HibernateDaoSupport implements ResumeDAOImpl {
	private static final Logger log = LoggerFactory.getLogger(ResumeDAO.class);
	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.frank.model.ResumeDaoImpl#save(com.frank.model.Resume)
	 */
	@Override
	public boolean save(Resume transientInstance) {
		boolean flag=false;
		log.debug("saving Resume instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
			flag=true;
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
		return flag;
	}

	/* (non-Javadoc)
	 * @see com.frank.model.ResumeDaoImpl#delete(com.frank.model.Resume)
	 */
	@Override
	public void delete(Resume persistentInstance) {
		log.debug("deleting Resume instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.frank.model.ResumeDaoImpl#findById(java.lang.Integer)
	 */
	@Override
	public Resume findById(java.lang.Integer id) {
		log.debug("getting Resume instance with id: " + id);
		try {
			Resume instance = (Resume) getHibernateTemplate().get(
					"com.frank.model.Resume", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.frank.model.ResumeDaoImpl#findByExample(com.frank.model.Resume)
	 */
	@Override
	public List<Resume> findByExample(Resume instance) {
		log.debug("finding Resume instance by example");
		try {
			List<Resume> results = (List<Resume>) getHibernateTemplate()
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
	 * @see com.frank.model.ResumeDaoImpl#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Resume instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Resume as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.frank.model.ResumeDaoImpl#findByContent(java.lang.Object)
	 */
	@Override
	public List<Resume> findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	/* (non-Javadoc)
	 * @see com.frank.model.ResumeDaoImpl#findByUserName(java.lang.Object)
	 */
	@Override
	public List<Resume> findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	/* (non-Javadoc)
	 * @see com.frank.model.ResumeDaoImpl#findByTime(java.lang.Object)
	 */
	@Override
	public List<Resume> findByTime(Object time) {
		return findByProperty(TIME, time);
	}

	/* (non-Javadoc)
	 * @see com.frank.model.ResumeDaoImpl#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all Resume instances");
		try {
			String queryString = "from Resume";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.frank.model.ResumeDaoImpl#merge(com.frank.model.Resume)
	 */
	@Override
	public Resume merge(Resume detachedInstance) {
		log.debug("merging Resume instance");
		try {
			Resume result = (Resume) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.frank.model.ResumeDaoImpl#attachDirty(com.frank.model.Resume)
	 */
	@Override
	public void attachDirty(Resume instance) {
		log.debug("attaching dirty Resume instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.frank.model.ResumeDaoImpl#attachClean(com.frank.model.Resume)
	 */
	@Override
	public void attachClean(Resume instance) {
		log.debug("attaching clean Resume instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ResumeDAOImpl getFromApplicationContext(ApplicationContext ctx) {
		return (ResumeDAOImpl) ctx.getBean("ResumeDAO");
	}
}