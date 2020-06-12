package com.wd.erp.model;

import java.util.Date;

public class EmrDocCoreRecode {
    private String id;

    private String registerationId;

    private String docId;

    private String discussAdders;

    private Date discussDate;

    private String registrant;

    private String registrantTitle;

    private String registrantDepart;

    private String disease;

    private String operation;

    private String narcosis;

    private String recorder;

    private String recorderDepart;

    private Date recordDate;

    private String registrantReview;

    private Date reviveDate;

    private Integer status;

    private Integer coreType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRegisterationId() {
        return registerationId;
    }

    public void setRegisterationId(String registerationId) {
        this.registerationId = registerationId;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getDiscussAdders() {
        return discussAdders;
    }

    public void setDiscussAdders(String discussAdders) {
        this.discussAdders = discussAdders;
    }

    public Date getDiscussDate() {
        return discussDate;
    }

    public void setDiscussDate(Date discussDate) {
        this.discussDate = discussDate;
    }

    public String getRegistrant() {
        return registrant;
    }

    public void setRegistrant(String registrant) {
        this.registrant = registrant;
    }

    public String getRegistrantTitle() {
        return registrantTitle;
    }

    public void setRegistrantTitle(String registrantTitle) {
        this.registrantTitle = registrantTitle;
    }

    public String getRegistrantDepart() {
        return registrantDepart;
    }

    public void setRegistrantDepart(String registrantDepart) {
        this.registrantDepart = registrantDepart;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getNarcosis() {
        return narcosis;
    }

    public void setNarcosis(String narcosis) {
        this.narcosis = narcosis;
    }

    public String getRecorder() {
        return recorder;
    }

    public void setRecorder(String recorder) {
        this.recorder = recorder;
    }

    public String getRecorderDepart() {
        return recorderDepart;
    }

    public void setRecorderDepart(String recorderDepart) {
        this.recorderDepart = recorderDepart;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public String getRegistrantReview() {
        return registrantReview;
    }

    public void setRegistrantReview(String registrantReview) {
        this.registrantReview = registrantReview;
    }

    public Date getReviveDate() {
        return reviveDate;
    }

    public void setReviveDate(Date reviveDate) {
        this.reviveDate = reviveDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCoreType() {
        return coreType;
    }

    public void setCoreType(Integer coreType) {
        this.coreType = coreType;
    }
}