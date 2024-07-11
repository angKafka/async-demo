package org.rdutta.tutorial.inheritance;

import java.util.UUID;

public class JobRole extends Company{
    private UUID jobCode;
    private String jobRole;

    private boolean isJava = false;

    @Override
    public String companyDetails() {
        return super.companyDetails();
    }

    public UUID getJobCode() {
        this.jobCode = UUID.randomUUID();
        return jobCode;
    }

    public String getJobRole() {
        this.jobRole = "JAVA DEVELOPER";
        return jobRole;
    }

    public boolean isJava() {
        return isJava;
    }

    public void setJava(boolean java) {
        isJava = java;
    }

    public String showRequirementDetails(){
        return "Job Code : " + getJobCode() + "\nJob Role : " + getJobRole();
    }

    public String isSelected(String name){
        if(isJava()){
            return "Hello "+name+",\nYou got selected for the next round.";
        }
        return "Sorry "+name+" you are not selected.\nBecause required skill is not fulfilled";
    }
}
