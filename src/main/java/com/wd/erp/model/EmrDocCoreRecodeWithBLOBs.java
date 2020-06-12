package com.wd.erp.model;

public class EmrDocCoreRecodeWithBLOBs extends EmrDocCoreRecode {
    private String briefIllness;

    private String registrantSummary;

    public String getBriefIllness() {
        return briefIllness;
    }

    public void setBriefIllness(String briefIllness) {
        this.briefIllness = briefIllness;
    }

    public String getRegistrantSummary() {
        return registrantSummary;
    }

    public void setRegistrantSummary(String registrantSummary) {
        this.registrantSummary = registrantSummary;
    }
}