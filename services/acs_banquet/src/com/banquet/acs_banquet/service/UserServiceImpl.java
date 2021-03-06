/*Copyright (c) 2017-2018 asyst.co.id All Rights Reserved.
 This software is the confidential and proprietary information of asyst.co.id You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with asyst.co.id*/
package com.banquet.acs_banquet.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.banquet.acs_banquet.Order;
import com.banquet.acs_banquet.PackageEntity;
import com.banquet.acs_banquet.User;


/**
 * ServiceImpl object for domain model class User.
 *
 * @see User
 */
@Service("acs_banquet.UserService")
@Validated
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Lazy
    @Autowired
	@Qualifier("acs_banquet.PackageEntityService")
	private PackageEntityService packageEntityService;

    @Lazy
    @Autowired
	@Qualifier("acs_banquet.OrderService")
	private OrderService orderService;

    @Autowired
    @Qualifier("acs_banquet.UserDao")
    private WMGenericDao<User, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<User, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "acs_banquetTransactionManager")
    @Override
	public User create(User user) {
        LOGGER.debug("Creating a new User with information: {}", user);

        User userCreated = this.wmGenericDao.create(user);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(userCreated);
    }

	@Transactional(readOnly = true, value = "acs_banquetTransactionManager")
	@Override
	public User getById(Integer userId) throws EntityNotFoundException {
        LOGGER.debug("Finding User by id: {}", userId);
        return this.wmGenericDao.findById(userId);
    }

    @Transactional(readOnly = true, value = "acs_banquetTransactionManager")
	@Override
	public User findById(Integer userId) {
        LOGGER.debug("Finding User by id: {}", userId);
        try {
            return this.wmGenericDao.findById(userId);
        } catch(EntityNotFoundException ex) {
            LOGGER.debug("No User found with id: {}", userId, ex);
            return null;
        }
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "acs_banquetTransactionManager")
	@Override
	public User update(User user) throws EntityNotFoundException {
        LOGGER.debug("Updating User with information: {}", user);

        List<PackageEntity> packageEntities = user.getPackageEntities();
        List<Order> _orders = user.get_orders();

        if(packageEntities != null && Hibernate.isInitialized(packageEntities)) {
            if(!packageEntities.isEmpty()) {
                for(PackageEntity _packageEntity : packageEntities) {
                    _packageEntity.setUser(user);
                }
            }
        }

        if(_orders != null && Hibernate.isInitialized(_orders)) {
            if(!_orders.isEmpty()) {
                for(Order _order : _orders) {
                    _order.setUser(user);
                }
            }
        }

        this.wmGenericDao.update(user);
        this.wmGenericDao.refresh(user);

        return user;
    }

    @Transactional(value = "acs_banquetTransactionManager")
	@Override
	public User delete(Integer userId) throws EntityNotFoundException {
        LOGGER.debug("Deleting User with id: {}", userId);
        User deleted = this.wmGenericDao.findById(userId);
        if (deleted == null) {
            LOGGER.debug("No User found with id: {}", userId);
            throw new EntityNotFoundException(String.valueOf(userId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "acs_banquetTransactionManager")
	@Override
	public void delete(User user) {
        LOGGER.debug("Deleting User with {}", user);
        this.wmGenericDao.delete(user);
    }

	@Transactional(readOnly = true, value = "acs_banquetTransactionManager")
	@Override
	public Page<User> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Users");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "acs_banquetTransactionManager")
    @Override
    public Page<User> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Users");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "acs_banquetTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service acs_banquet for table User to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "acs_banquetTransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "acs_banquetTransactionManager")
	@Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }

    @Transactional(readOnly = true, value = "acs_banquetTransactionManager")
    @Override
    public Page<PackageEntity> findAssociatedPackageEntities(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated packageEntities");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("user.id = '" + id + "'");

        return packageEntityService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "acs_banquetTransactionManager")
    @Override
    public Page<Order> findAssociated_orders(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated _orders");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("user.id = '" + id + "'");

        return orderService.findAll(queryBuilder.toString(), pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service PackageEntityService instance
	 */
	protected void setPackageEntityService(PackageEntityService service) {
        this.packageEntityService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service OrderService instance
	 */
	protected void setOrderService(OrderService service) {
        this.orderService = service;
    }

}

