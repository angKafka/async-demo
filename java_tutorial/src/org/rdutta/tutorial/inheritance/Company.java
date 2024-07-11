package org.rdutta.tutorial.inheritance;

import java.util.UUID;

public class Company {
    private UUID companyCode;
    private String companyName;

    public String companyDetails() {
        this.companyCode = UUID.randomUUID();
        this.companyName = "OpenText";

        return "\nCode: "+companyCode+"\nCompany: "+companyName;
    }
}
