package com.api;


import com.api.helpers.BaseApiTest;
import org.junit.Test;
import unirest.HttpResponse;
import unirest.JsonNode;
import unirest.Unirest;
import unirest.UnirestException;

import static com.api.objects.Config.*;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class ApiTest extends BaseApiTest {

   @Test
   public void shouldGiveMeDirectionsFromDisneylandToUniversal() throws UnirestException {
      HttpResponse<JsonNode> jsonResponse = Unirest.get( API_MAIN_URL + "json?origin=Disneyland&destination=Universal+Studios+Hollywood" )
              .header("accept", "application/json")
              .queryString("key", API_KEY)
              .asJson();

      assertTrue(jsonResponse.getHeaders().size() > 0);
      assertTrue(jsonResponse.getBody().toString().length() > 0);
      assertEquals(200, jsonResponse.getStatus());
      JsonNode response = jsonResponse.getBody();

      String geoCodedLocationOfDisnaylandFromResponse = response.getObject().getJSONArray("geocoded_waypoints").getJSONObject(0).toString();
      assertEquals( GEOCODED_LOCATION_FOR_DISNEYLAND , geoCodedLocationOfDisnaylandFromResponse );

      String geoCodedLocationOfUniversalFromResponse = response.getObject().getJSONArray("geocoded_waypoints").getJSONObject(1).toString();
      assertEquals(GEOCODED_LOCATION_FOR_UNIVERSAL, geoCodedLocationOfUniversalFromResponse);

      String startAddress = response.getObject().getJSONArray("routes").getJSONObject(0).getJSONArray("legs").getJSONObject(0).getString("start_address");
      String endAddress = response.getObject().getJSONArray("routes").getJSONObject(0).getJSONArray("legs").getJSONObject(0).getString("end_address");
      assertEquals(START_ADDRESS , startAddress);
      assertEquals(END_ADDRESS , endAddress);
   }

}
