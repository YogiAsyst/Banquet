/*Copyright (c) 2017-2018 asyst.co.id All Rights Reserved.
 This software is the confidential and proprietary information of asyst.co.id You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with asyst.co.id*/
package com.banquet.acs_banquet.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
        return this.wmGenericDao.create(user);
    }

	@Transactional(readOnly = true, value = "acs_banquetTransactionManager")
	@Override
	public User getById(Integer userId) throws EntityNotFoundException {
        LOGGER.debug("Finding User by id: {}", userId);
        User user = this.wmGenericDao.findById(userId);
        if (user == null){
            LOGGER.debug("No User found with id: {}", userId);
            throw new EntityNotFoundException(String.valueOf(userId));
        }
        return user;
    }

    @Transactional(readOnly = true, value = "acs_banquetTransactionManager")
	@Override
	public User findById(Integer userId) {
        LOGGER.debug("Finding User by id: {}", userId);
        return this.wmGenericDao.findById(userId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "acs_banquetTransactionManager")
	@Override
	public User update(User user) throws EntityNotFoundException {
        LOGGER.debug("Updating User with information: {}", user);


        this.wmGenericDao.update(user);

        Integer userId = user.getId();

        return this.wmGenericDao.findById(userId);
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



}
