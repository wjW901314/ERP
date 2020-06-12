package com.wd.erp.model;

public class EmrDocCordRecordCommentsWithBLOBs extends EmrDocCordRecordComments {
    private String comments;

    private String historyComments;

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getHistoryComments() {
        return historyComments;
    }

    public void setHistoryComments(String historyComments) {
        this.historyComments = historyComments;
    }
}