/*Copyright (c) 2017-2018 asyst.co.id All Rights Reserved.
 This software is the confidential and proprietary information of asyst.co.id You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with asyst.co.id*/
package com.banquet.acs_banquet1.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import com.banquet.acs_banquet1.PreOrder;
import com.banquet.acs_banquet1.service.PreOrderService;


/**
 * Controller object for domain model class PreOrder.
 * @see PreOrder
 */
@RestController("acs_banquet1.PreOrderController")
@Api(value = "PreOrderController", description = "Exposes APIs to work with PreOrder resource.")
@RequestMapping("/acs_banquet1/PreOrder")
public class PreOrderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PreOrderController.class);

    @Autowired
	@Qualifier("acs_banquet1.PreOrderService")
	private PreOrderService preOrderService;

	@ApiOperation(value = "Creates a new PreOrder instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public PreOrder createPreOrder(@RequestBody PreOrder preOrder) {
		LOGGER.debug("Create PreOrder with information: {}" , preOrder);

		preOrder = preOrderService.create(preOrder);
		LOGGER.debug("Created PreOrder with information: {}" , preOrder);

	    return preOrder;
	}

    @ApiOperation(value = "Returns the PreOrder instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public PreOrder getPreOrder(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting PreOrder with id: {}" , id);

        PreOrder foundPreOrder = preOrderService.getById(id);
        LOGGER.debug("PreOrder details with id: {}" , foundPreOrder);

        return foundPreOrder;
    }

    @ApiOperation(value = "Updates the PreOrder instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public PreOrder editPreOrder(@PathVariable("id") Integer id, @RequestBody PreOrder preOrder) throws EntityNotFoundException {
        LOGGER.debug("Editing PreOrder with id: {}" , preOrder.getId());

        preOrder.setId(id);
        preOrder = preOrderService.update(preOrder);
        LOGGER.debug("PreOrder details with id: {}" , preOrder);

        return preOrder;
    }

    @ApiOperation(value = "Deletes the PreOrder instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deletePreOrder(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting PreOrder with id: {}" , id);

        PreOrder deletedPreOrder = preOrderService.delete(id);

        return deletedPreOrder != null;
    }

    /**
     * @deprecated Use {@link #findPreOrders(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of PreOrder instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<PreOrder> searchPreOrdersByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering PreOrders list");
        return preOrderService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of PreOrder instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<PreOrder> findPreOrders(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering PreOrders list");
        return preOrderService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of PreOrder instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<PreOrder> filterPreOrders(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering PreOrders list");
        return preOrderService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportPreOrders(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return preOrderService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of PreOrder instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countPreOrders( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting PreOrders");
		return preOrderService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getPreOrderAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return preOrderService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service PreOrderService instance
	 */
	protected void setPreOrderService(PreOrderService service) {
		this.preOrderService = service;
	}

}
