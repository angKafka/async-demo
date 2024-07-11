package org.rdutta.tutorial.encapsulation;

public class TeamSelection {
    private String team;

    public TeamSelection(String team) {
        this.team = team;
    }
    public static void main(String[] args) {
        Person object = new Person();
        object.setFirstName("Raj");
        object.setLastName("Dutta");
        TeamSelection teamSelection = new TeamSelection("TSS");
        object.setEmail("rdutta@orderapp.com");
        object.setPhone("7992204910");
        object.setDob("10-11-1997");
        System.out.println(object.assignTeamToPerson(teamSelection.team));
    }
}
