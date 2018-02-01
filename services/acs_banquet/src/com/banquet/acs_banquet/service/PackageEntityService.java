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

/**
 * Service object for domain model class {@link PackageEntity}.
 */
public interface PackageEntityService {

    /**
     * Creates a new PackageEntity. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on PackageEntity if any.
     *
     * @param packageEntity Details of the PackageEntity to be created; value cannot be null.
     * @return The newly created PackageEntity.
     */
	PackageEntity create(@Valid PackageEntity packageEntity);


	/**
	 * Returns PackageEntity by given id if exists.
	 *
	 * @param packageentityId The id of the PackageEntity to get; value cannot be null.
	 * @return PackageEntity associated with the given packageentityId.
     * @throws EntityNotFoundException If no PackageEntity is found.
	 */
	PackageEntity getById(Integer packageentityId) throws EntityNotFoundException;

    /**
	 * Find and return the PackageEntity by given id if exists, returns null otherwise.
	 *
	 * @param packageentityId The id of the PackageEntity to get; value cannot be null.
	 * @return PackageEntity associated with the given packageentityId.
	 */
	PackageEntity findById(Integer packageentityId);


	/**
	 * Updates the details of an existing PackageEntity. It replaces all fields of the existing PackageEntity with the given packageEntity.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on PackageEntity if any.
     *
	 * @param packageEntity The details of the PackageEntity to be updated; value cannot be null.
	 * @return The updated PackageEntity.
	 * @throws EntityNotFoundException if no PackageEntity is found with given input.
	 */
	PackageEntity update(@Valid PackageEntity packageEntity) throws EntityNotFoundException;

    /**
	 * Deletes an existing PackageEntity with the given id.
	 *
	 * @param packageentityId The id of the PackageEntity to be deleted; value cannot be null.
	 * @return The deleted PackageEntity.
	 * @throws EntityNotFoundException if no PackageEntity found with the given id.
	 */
	PackageEntity delete(Integer packageentityId) throws EntityNotFoundException;

	/**
	 * Find all PackageEntities matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching PackageEntities.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<PackageEntity> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all PackageEntities matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching PackageEntities.
     *
     * @see Pageable
     * @see Page
	 */
    Page<PackageEntity> findAll(String query, Pageable pageable);

    /**
	 * Exports all PackageEntities matching the given input query to the given exportType format.
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
	 * Retrieve the count of the PackageEntities in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the PackageEntity.
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


}

