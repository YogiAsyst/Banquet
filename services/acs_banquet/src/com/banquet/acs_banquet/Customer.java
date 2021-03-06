/*Copyright (c) 2017-2018 asyst.co.id All Rights Reserved.
 This software is the confidential and proprietary information of asyst.co.id You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with asyst.co.id*/
package com.banquet.acs_banquet;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

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
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Customer generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`customer`")
public class Customer implements Serializable {

    private Integer id;
    private String cname;
    private String caddress;
    private String cphone;
    private String cmail;
    private List<Order> _orders;

    @Id
    @SequenceGenerator(name = "generator", sequenceName = "`customer_ID_seq`" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`c_name`", nullable = false, length = 255)
    public String getCname() {
        return this.cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Column(name = "`c_address`", nullable = false, length = 255)
    public String getCaddress() {
        return this.caddress;
    }

    public void setCaddress(String caddress) {
        this.caddress = caddress;
    }

    @Column(name = "`c_phone`", nullable = false, length = 255)
    public String getCphone() {
        return this.cphone;
    }

    public void setCphone(String cphone) {
        this.cphone = cphone;
    }

    @Column(name = "`c_mail`", nullable = false, length = 255)
    public String getCmail() {
        return this.cmail;
    }

    public void setCmail(String cmail) {
        this.cmail = cmail;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    @Cascade({CascadeType.SAVE_UPDATE})
    public List<Order> get_orders() {
        return this._orders;
    }

    public void set_orders(List<Order> _orders) {
        this._orders = _orders;
    }

    @PostPersist
    public void onPostPersist() {
        if(_orders != null) {
            for(Order order : _orders) {
                order.setCustomer(this);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        final Customer customer = (Customer) o;
        return Objects.equals(getId(), customer.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

