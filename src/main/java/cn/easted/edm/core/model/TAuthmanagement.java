package cn.easted.edm.core.model;

import java.util.Date;

public class TAuthmanagement {
    private Long id;

    private String name;

    private String product;

    private String serinumber;

    private String version;

    private Date date;

    private String authorizationcode;

    private String servernumber;

    private String aclient;

    private String type;

    private Short status;

    private String bclientMachinecode;

    private String bauthSerilizenumber;

    private String contractnumber;

    private String superveneNumber;

    private String authTimeout;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product == null ? null : product.trim();
    }

    public String getSerinumber() {
        return serinumber;
    }

    public void setSerinumber(String serinumber) {
        this.serinumber = serinumber == null ? null : serinumber.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAuthorizationcode() {
        return authorizationcode;
    }

    public void setAuthorizationcode(String authorizationcode) {
        this.authorizationcode = authorizationcode == null ? null : authorizationcode.trim();
    }

    public String getServernumber() {
        return servernumber;
    }

    public void setServernumber(String servernumber) {
        this.servernumber = servernumber == null ? null : servernumber.trim();
    }

    public String getAclient() {
        return aclient;
    }

    public void setAclient(String aclient) {
        this.aclient = aclient == null ? null : aclient.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getBclientMachinecode() {
        return bclientMachinecode;
    }

    public void setBclientMachinecode(String bclientMachinecode) {
        this.bclientMachinecode = bclientMachinecode == null ? null : bclientMachinecode.trim();
    }

    public String getBauthSerilizenumber() {
        return bauthSerilizenumber;
    }

    public void setBauthSerilizenumber(String bauthSerilizenumber) {
        this.bauthSerilizenumber = bauthSerilizenumber == null ? null : bauthSerilizenumber.trim();
    }

    public String getContractnumber() {
        return contractnumber;
    }

    public void setContractnumber(String contractnumber) {
        this.contractnumber = contractnumber == null ? null : contractnumber.trim();
    }

    public String getSuperveneNumber() {
        return superveneNumber;
    }

    public void setSuperveneNumber(String superveneNumber) {
        this.superveneNumber = superveneNumber == null ? null : superveneNumber.trim();
    }

    public String getAuthTimeout() {
        return authTimeout;
    }

    public void setAuthTimeout(String authTimeout) {
        this.authTimeout = authTimeout == null ? null : authTimeout.trim();
    }
}