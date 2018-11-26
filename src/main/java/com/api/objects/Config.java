package com.api.objects;

public abstract class Config {

    public static final String API_MAIN_URL = "https://maps.googleapis.com/maps/api/directions/";
    public static final String API_KEY = "";
    public static final String GEOCODED_LOCATION_FOR_DISNEYLAND = "{\"types\":[\"amusement_park\",\"establishment\",\"point_of_interest\"],\"geocoder_status\":\"OK\",\"place_id\":\"ChIJa147K9HX3IAR-lwiGIQv9i4\"}";
    public static final String GEOCODED_LOCATION_FOR_UNIVERSAL = "{\"types\":[\"amusement_park\",\"establishment\",\"point_of_interest\"],\"geocoder_status\":\"OK\",\"place_id\":\"ChIJzzgyJU--woARcZqceSdQ3dM\"}";
    public static final String START_ADDRESS = "1313 Disneyland Dr, Anaheim, CA 92802, USA";
    public static final String END_ADDRESS = "100 Universal City Plaza, Universal City, CA 91608, USA";

    private Config() {
    }
}
