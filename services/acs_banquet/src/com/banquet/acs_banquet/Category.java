/*Copyright (c) 2017-2018 asyst.co.id All Rights Reserved.
 This software is the confidential and proprietary information of asyst.co.id You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with asyst.co.id*/
package com.banquet.acs_banquet;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PostPersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Category generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`category`")
public class Category implements Serializable {

    private Integer id;
    private String catName;
    private Integer code;
    private List<Products> productses;

    @Id
    @SequenceGenerator(name = "generator", sequenceName = "\"category_ID_seq\"" , schema = "public", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`cat_name`", nullable = true, length = 255)
    public String getCatName() {
        return this.catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    @Column(name = "`code`", nullable = true, scale = 0, precision = 10)
    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "category")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    public List<Products> getProductses() {
        return this.productses;
    }

    public void setProductses(List<Products> productses) {
        this.productses = productses;
    }

    @PostPersist
    public void onPostPersist() {
        if(productses != null) {
            for(Products products : productses) {
                products.setCategory(this);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;
        final Category category = (Category) o;
        return Objects.equals(getId(), category.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
