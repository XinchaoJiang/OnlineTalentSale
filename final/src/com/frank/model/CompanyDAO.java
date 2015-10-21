package com.frank.model;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.frank.impl.CompanyDAOImpl;

/**
 * A data access object (DAO) providing persistence and search support for
 * Company entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.frank.model.Company
 * @author MyEclipse Persistence Tools
 */

public class CompanyDAO extends HibernateDaoSupport implements CompanyDAOImpl {
	private static final Logger log = LoggerFactory.getLogger(CompanyDAO.class);
	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.frank.model.CompanyDAOImpl#save(com.frank.model.Company)
	 */
	@Override
	public void save(Company transientInstance) {
		log.debug("saving Company instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.frank.model.CompanyDAOImpl#delete(com.frank.model.Company)
	 */
	@Override
	public void delete(Company persistentInstance) {
		log.debug("deleting Company instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.frank.model.CompanyDAOImpl#findById(java.lang.Integer)
	 */
	@Override
	public Company findById(java.lang.Integer id) {
		log.debug("getting Company instance with id: " + id);
		try {
			Company instance = (Company) getHibernateTemplate().get(
					"com.frank.model.Company", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.frank.model.CompanyDAOImpl#findByExample(com.frank.model.Company)
	 */
	@Override
	public List<Company> findByExample(Company instance) {
		log.debug("finding Company instance by example");
		try {
			List<Company> results = (List<Company>) getHibernateTemplate()
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
	 * @see com.frank.model.CompanyDAOImpl#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Company instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Company as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.frank.model.CompanyDAOImpl#findByName(java.lang.Object)
	 */
	@Override
	public List<Company> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	/* (non-Javadoc)
	 * @see com.frank.model.CompanyDAOImpl#findByRoleId(java.lang.Object)
	 */
	@Override
	public List<Company> findByRoleId(Object roleId) {
		return findByProperty(ROLE_ID, roleId);
	}

	/* (non-Javadoc)
	 * @see com.frank.model.CompanyDAOImpl#findByPassword(java.lang.Object)
	 */
	@Override
	public List<Company> findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	/* (non-Javadoc)
	 * @see com.frank.model.CompanyDAOImpl#findByDescription(java.lang.Object)
	 */
	@Override
	public List<Company> findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	/* (non-Javadoc)
	 * @see com.frank.model.CompanyDAOImpl#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all Company instances");
		try {
			String queryString = "from Company";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.frank.model.CompanyDAOImpl#merge(com.frank.model.Company)
	 */
	@Override
	public Company merge(Company detachedInstance) {
		log.debug("merging Company instance");
		try {
			Company result = (Company) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.frank.model.CompanyDAOImpl#attachDirty(com.frank.model.Company)
	 */
	@Override
	public void attachDirty(Company instance) {
		log.debug("attaching dirty Company instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.frank.model.CompanyDAOImpl#attachClean(com.frank.model.Company)
	 */
	@Override
	public void attachClean(Company instance) {
		log.debug("attaching clean Company instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CompanyDAOImpl getFromApplicationContext(ApplicationContext ctx) {
		return (CompanyDAOImpl) ctx.getBean("CompanyDAO");
	}
}