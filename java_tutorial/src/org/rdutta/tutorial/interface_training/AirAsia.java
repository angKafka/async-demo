package org.rdutta.tutorial.interface_training;


import java.time.LocalDateTime;
import java.util.UUID;

public class AirAsia implements Airport{
    private UUID plain_UID;
    private String flightType;
    private LocalDateTime flightTimings;

    public UUID getPlain_UID() {
        this.plain_UID = UUID.randomUUID();
        return plain_UID;
    }

    public String getFlightType() {
        this.flightType = "Domestic";
        return flightType;
    }

    public LocalDateTime getFlightTimings() {
        return flightTimings;
    }

    public void setFlightTimings(LocalDateTime flightTimings) {
        this.flightTimings = flightTimings;
    }


    @Override
    public UUID registerPlainByUUID(UUID plain_UID) {
        if(plain_UID == null){
            return null;
        }
        return airportToken;
    }

    @Override
    public Boolean isPlanValid(UUID plain_UID) {
        return plain_UID != null;
    }

    public Boolean isValidAirportToken(UUID airportToken) {
        return airportToken != null;
    }

    public String provideFlightPersonalID() {
        String flightID = "AIR-ASIA-"+ UUID.randomUUID().toString().substring(0,8);
        if(!isValidAirportToken(airportToken)){
            return null;
        }

        return flightID;
    }

    @Override
    public String showFlightDetails() {
        return "\nFlight ID: " + provideFlightPersonalID()+ "\nFlight Type: "+getFlightType()+"\nToday flight time: " + getFlightTimings().toString().substring(11,16);
    }
}
