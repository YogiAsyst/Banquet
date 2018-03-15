/*Copyright (c) 2017-2018 asyst.co.id All Rights Reserved.
 This software is the confidential and proprietary information of asyst.co.id You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with asyst.co.id*/
package com.banquet.acs_banquet;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;
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
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.wavemaker.runtime.data.annotations.WMValueInject;
import com.wavemaker.runtime.data.replacers.Scope;
import com.wavemaker.runtime.data.replacers.providers.VariableType;

/**
 * User generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`user`")
public class User implements Serializable {

    private Integer id;
    private String uname;
    private String upassword;
    private String ufirstName;
    private String ulastName;
    private String uaddress;
    private String uphone;
    private String uemail;
    private Date ubirthDate;
    @JsonProperty(access = Access.READ_ONLY)
    private byte[] upicture;
    private String urole;
    private String uloginStatus;
    @WMValueInject( type = VariableType.SERVER, name = "DATE_TIME", scopes = { Scope.INSERT, Scope.UPDATE })
    private LocalDateTime ulastLogin;
    private List<PackageEntity> packageEntities;
    private List<Order> _orders;

    @Id
    @SequenceGenerator(name = "generator", sequenceName = "`user_ID_seq`" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`u_name`", nullable = true, length = 255)
    public String getUname() {
        return this.uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    @Column(name = "`u_password`", nullable = false, length = 255)
    public String getUpassword() {
        return this.upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    @Column(name = "`u_first_name`", nullable = false, length = 255)
    public String getUfirstName() {
        return this.ufirstName;
    }

    public void setUfirstName(String ufirstName) {
        this.ufirstName = ufirstName;
    }

    @Column(name = "`u_last_name`", nullable = true, length = 255)
    public String getUlastName() {
        return this.ulastName;
    }

    public void setUlastName(String ulastName) {
        this.ulastName = ulastName;
    }

    @Column(name = "`u_address`", nullable = true, length = 255)
    public String getUaddress() {
        return this.uaddress;
    }

    public void setUaddress(String uaddress) {
        this.uaddress = uaddress;
    }

    @Column(name = "`u_phone`", nullable = false, length = 255)
    public String getUphone() {
        return this.uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone;
    }

    @Column(name = "`u_email`", nullable = false, length = 255)
    public String getUemail() {
        return this.uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    @Column(name = "`u_birth_date`", nullable = true)
    public Date getUbirthDate() {
        return this.ubirthDate;
    }

    public void setUbirthDate(Date ubirthDate) {
        this.ubirthDate = ubirthDate;
    }

    @Column(name = "`u_picture`", nullable = true)
    public byte[] getUpicture() {
        return this.upicture;
    }

    public void setUpicture(byte[] upicture) {
        this.upicture = upicture;
    }

    @Column(name = "`u_role`", nullable = false, length = 255)
    public String getUrole() {
        return this.urole;
    }

    public void setUrole(String urole) {
        this.urole = urole;
    }

    @Column(name = "`u_login_status`", nullable = true, length = 255)
    public String getUloginStatus() {
        return this.uloginStatus;
    }

    public void setUloginStatus(String uloginStatus) {
        this.uloginStatus = uloginStatus;
    }

    @Column(name = "`u_last_login`", nullable = true)
    public LocalDateTime getUlastLogin() {
        return this.ulastLogin;
    }

    public void setUlastLogin(LocalDateTime ulastLogin) {
        this.ulastLogin = ulastLogin;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    @Cascade({CascadeType.SAVE_UPDATE})
    public List<PackageEntity> getPackageEntities() {
        return this.packageEntities;
    }

    public void setPackageEntities(List<PackageEntity> packageEntities) {
        this.packageEntities = packageEntities;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    @Cascade({CascadeType.SAVE_UPDATE})
    public List<Order> get_orders() {
        return this._orders;
    }

    public void set_orders(List<Order> _orders) {
        this._orders = _orders;
    }

    @PostPersist
    public void onPostPersist() {
        if(packageEntities != null) {
            for(PackageEntity packageEntity : packageEntities) {
                packageEntity.setUser(this);
            }
        }
        if(_orders != null) {
            for(Order order : _orders) {
                order.setUser(this);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        final User user = (User) o;
        return Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

