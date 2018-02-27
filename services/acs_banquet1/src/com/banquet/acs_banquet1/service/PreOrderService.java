/*Copyright (c) 2017-2018 asyst.co.id All Rights Reserved.
 This software is the confidential and proprietary information of asyst.co.id You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with asyst.co.id*/
package com.banquet.acs_banquet1.service;

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

import com.banquet.acs_banquet1.PreOrder;

/**
 * Service object for domain model class {@link PreOrder}.
 */
public interface PreOrderService {

    /**
     * Creates a new PreOrder. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on PreOrder if any.
     *
     * @param preOrder Details of the PreOrder to be created; value cannot be null.
     * @return The newly created PreOrder.
     */
	PreOrder create(@Valid PreOrder preOrder);


	/**
	 * Returns PreOrder by given id if exists.
	 *
	 * @param preorderId The id of the PreOrder to get; value cannot be null.
	 * @return PreOrder associated with the given preorderId.
     * @throws EntityNotFoundException If no PreOrder is found.
	 */
	PreOrder getById(Integer preorderId) throws EntityNotFoundException;

    /**
	 * Find and return the PreOrder by given id if exists, returns null otherwise.
	 *
	 * @param preorderId The id of the PreOrder to get; value cannot be null.
	 * @return PreOrder associated with the given preorderId.
	 */
	PreOrder findById(Integer preorderId);


	/**
	 * Updates the details of an existing PreOrder. It replaces all fields of the existing PreOrder with the given preOrder.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on PreOrder if any.
     *
	 * @param preOrder The details of the PreOrder to be updated; value cannot be null.
	 * @return The updated PreOrder.
	 * @throws EntityNotFoundException if no PreOrder is found with given input.
	 */
	PreOrder update(@Valid PreOrder preOrder) throws EntityNotFoundException;

    /**
	 * Deletes an existing PreOrder with the given id.
	 *
	 * @param preorderId The id of the PreOrder to be deleted; value cannot be null.
	 * @return The deleted PreOrder.
	 * @throws EntityNotFoundException if no PreOrder found with the given id.
	 */
	PreOrder delete(Integer preorderId) throws EntityNotFoundException;

    /**
	 * Deletes an existing PreOrder with the given object.
	 *
	 * @param preOrder The instance of the PreOrder to be deleted; value cannot be null.
	 */
	void delete(PreOrder preOrder);

	/**
	 * Find all PreOrders matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching PreOrders.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<PreOrder> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all PreOrders matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching PreOrders.
     *
     * @see Pageable
     * @see Page
	 */
    Page<PreOrder> findAll(String query, Pageable pageable);

    /**
	 * Exports all PreOrders matching the given input query to the given exportType format.
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
	 * Retrieve the count of the PreOrders in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the PreOrder.
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

