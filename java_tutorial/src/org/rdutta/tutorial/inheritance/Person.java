package org.rdutta.tutorial.inheritance;

import java.util.UUID;

public class Person extends JobRole{
    private UUID person_Uid = UUID.randomUUID();
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String applyFor = "JAVA";
    public Person() {}

    public Person(String firstName, String lastName, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public static void main(String[] args) {
        Person personObj = new Person();
        personObj.firstName = "Raj";
        personObj.lastName = "Dutta";
        personObj.email = "rdutta@orderapp.com";
        personObj.phone = "+555-555-555";
        System.out.println("Person_UID: "+personObj.person_Uid+"\nfirstName: "+personObj.firstName+"\nlastName: "+personObj.lastName
        +"\nemail: "+personObj.email+"\nphone: "+personObj.phone);
        System.out.println("========================================\n");
        System.out.println(personObj.companyDetails());
        System.out.println("========================================\n");
        System.out.println(personObj.showRequirementDetails());
        System.out.println("========================================\n");
        if(personObj.applyFor.equals("JAVA")){
            personObj.setJava(true);
            String selectedOrNot = personObj.isSelected(personObj.firstName);
            System.out.println(selectedOrNot);
        }else{
            personObj.setJava(false);
            String selectedOrNot = personObj.isSelected(personObj.firstName);
            System.out.println(selectedOrNot);
        }

    }
}
