package com.wd.erp.model;

public class EmrDocCordRecordComments {
    private String id;

    private String patentId;

    private String participants;

    private String participantsTitle;

    private String participantsDepart;

    private Integer status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatentId() {
        return patentId;
    }

    public void setPatentId(String patentId) {
        this.patentId = patentId;
    }

    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }

    public String getParticipantsTitle() {
        return participantsTitle;
    }

    public void setParticipantsTitle(String participantsTitle) {
        this.participantsTitle = participantsTitle;
    }

    public String getParticipantsDepart() {
        return participantsDepart;
    }

    public void setParticipantsDepart(String participantsDepart) {
        this.participantsDepart = participantsDepart;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}