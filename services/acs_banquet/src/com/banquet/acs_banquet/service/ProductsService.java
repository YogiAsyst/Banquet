/*Copyright (c) 2017-2018 asyst.co.id All Rights Reserved.
 This software is the confidential and proprietary information of asyst.co.id You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with asyst.co.id*/
package com.banquet.acs_banquet.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.banquet.acs_banquet.PackageEntity;
import com.banquet.acs_banquet.Products;

/**
 * Service object for domain model class {@link Products}.
 */
public interface ProductsService {

    /**
     * Creates a new Products. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Products if any.
     *
     * @param products Details of the Products to be created; value cannot be null.
     * @return The newly created Products.
     */
	Products create(@Valid Products products);


	/**
	 * Returns Products by given id if exists.
	 *
	 * @param productsId The id of the Products to get; value cannot be null.
	 * @return Products associated with the given productsId.
     * @throws EntityNotFoundException If no Products is found.
	 */
	Products getById(Integer productsId) throws EntityNotFoundException;

    /**
	 * Find and return the Products by given id if exists, returns null otherwise.
	 *
	 * @param productsId The id of the Products to get; value cannot be null.
	 * @return Products associated with the given productsId.
	 */
	Products findById(Integer productsId);


	/**
	 * Updates the details of an existing Products. It replaces all fields of the existing Products with the given products.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on Products if any.
     *
	 * @param products The details of the Products to be updated; value cannot be null.
	 * @return The updated Products.
	 * @throws EntityNotFoundException if no Products is found with given input.
	 */
	Products update(@Valid Products products) throws EntityNotFoundException;

    /**
	 * Deletes an existing Products with the given id.
	 *
	 * @param productsId The id of the Products to be deleted; value cannot be null.
	 * @return The deleted Products.
	 * @throws EntityNotFoundException if no Products found with the given id.
	 */
	Products delete(Integer productsId) throws EntityNotFoundException;

    /**
	 * Deletes an existing Products with the given object.
	 *
	 * @param products The instance of the Products to be deleted; value cannot be null.
	 */
	void delete(Products products);

	/**
	 * Find all Products matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Products.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<Products> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all Products matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Products.
     *
     * @see Pageable
     * @see Page
	 */
    Page<Products> findAll(String query, Pageable pageable);

    /**
	 * Exports all Products matching the given input query to the given exportType format.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param exportType The format in which to export the data; value cannot be null.
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return The Downloadable file in given export type.
     *
     * @see Pageable
     * @see ExportType
     * @see Downloadable
	 */
    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the Products in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the Products.
	 */
	long count(String query);

	/**
	 * Retrieve aggregated values with matching aggregation info.
     *
     * @param aggregationInfo info related to aggregations.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
	 * @return Paginated data with included fields.

     * @see AggregationInfo
     * @see Pageable
     * @see Page
	 */
	Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable);

    /*
     * Returns the associated packageEntitiesForProduct1 for given Products id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated PackageEntity instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<PackageEntity> findAssociatedPackageEntitiesForProduct1(Integer id, Pageable pageable);

    /*
     * Returns the associated packageEntitiesForProduct2 for given Products id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated PackageEntity instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<PackageEntity> findAssociatedPackageEntitiesForProduct2(Integer id, Pageable pageable);

    /*
     * Returns the associated packageEntitiesForProduct3 for given Products id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated PackageEntity instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<PackageEntity> findAssociatedPackageEntitiesForProduct3(Integer id, Pageable pageable);

    /*
     * Returns the associated packageEntitiesForProduct4 for given Products id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated PackageEntity instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<PackageEntity> findAssociatedPackageEntitiesForProduct4(Integer id, Pageable pageable);

    /*
     * Returns the associated packageEntitiesForProduct5 for given Products id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated PackageEntity instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<PackageEntity> findAssociatedPackageEntitiesForProduct5(Integer id, Pageable pageable);

}

