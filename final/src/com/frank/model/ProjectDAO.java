package com.frank.model;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.frank.impl.ProjectDAOImpl;

/**
 * A data access object (DAO) providing persistence and search support for
 * Project entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.frank.model.Project
 * @author MyEclipse Persistence Tools
 */

public class ProjectDAO extends HibernateDaoSupport implements ProjectDAOImpl {
	private static final Logger log = LoggerFactory.getLogger(ProjectDAO.class);
	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.frank.model.ProjectDaoImpl#save(com.frank.model.Project)
	 */
	@Override
	public boolean save(Project transientInstance) {
		boolean flag=false;
		log.debug("saving Project instance");
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
	 * @see com.frank.model.ProjectDaoImpl#delete(com.frank.model.Project)
	 */
	@Override
	public void delete(Project persistentInstance) {
		log.debug("deleting Project instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.frank.model.ProjectDaoImpl#findById(java.lang.Integer)
	 */
	@Override
	public Project findById(java.lang.Integer id) {
		log.debug("getting Project instance with id: " + id);
		try {
			Project instance = (Project) getHibernateTemplate().get(
					"com.frank.model.Project", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.frank.model.ProjectDaoImpl#findByExample(com.frank.model.Project)
	 */
	@Override
	public List<Project> findByExample(Project instance) {
		log.debug("finding Project instance by example");
		try {
			List<Project> results = (List<Project>) getHibernateTemplate()
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
	 * @see com.frank.model.ProjectDaoImpl#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Project instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Project as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.frank.model.ProjectDaoImpl#findByPublisher(java.lang.Object)
	 */
	@Override
	public List<Project> findByPublisher(Object publisher) {
		return findByProperty(PUBLISHER, publisher);
	}

	/* (non-Javadoc)
	 * @see com.frank.model.ProjectDaoImpl#findByName(java.lang.Object)
	 */
	@Override
	public List<Project> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	/* (non-Javadoc)
	 * @see com.frank.model.ProjectDaoImpl#findByDescription(java.lang.Object)
	 */
	@Override
	public List<Project> findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	/* (non-Javadoc)
	 * @see com.frank.model.ProjectDaoImpl#findByTime(java.lang.Object)
	 */
	@Override
	public List<Project> findByTime(Object time) {
		return findByProperty(TIME, time);
	}

	/* (non-Javadoc)
	 * @see com.frank.model.ProjectDaoImpl#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all Project instances");
		try {
			String queryString = "from Project";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.frank.model.ProjectDaoImpl#merge(com.frank.model.Project)
	 */
	@Override
	public Project merge(Project detachedInstance) {
		log.debug("merging Project instance");
		try {
			Project result = (Project) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.frank.model.ProjectDaoImpl#attachDirty(com.frank.model.Project)
	 */
	@Override
	public void attachDirty(Project instance) {
		log.debug("attaching dirty Project instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.frank.model.ProjectDaoImpl#attachClean(com.frank.model.Project)
	 */
	@Override
	public void attachClean(Project instance) {
		log.debug("attaching clean Project instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ProjectDAOImpl getFromApplicationContext(ApplicationContext ctx) {
		return (ProjectDAOImpl) ctx.getBean("ProjectDAO");
	}
}