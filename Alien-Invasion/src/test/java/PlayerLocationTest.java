
import client.PlayerLocation;
import org.junit.Test;

import java.io.IOException;

import com.google.gson.JsonSyntaxException;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerLocationTest {

    private static final String VALID_FILE_PATH = "./static/gameLocations.json";

//    @Test(expected = IOException.class)
//    // IOException is thrown when the file path is empty, indicating correct error
//    // handling
//    public void loadLocationData_throwsIoException_whenFilePathEmpty() throws IOException {
//        PlayerLocation.loadLocationData("");
//    }
//
//    @Test(expected = IOException.class)
//    // IOException is thrown when the file doesn't exist, ensuring proper error
//    // handling
//    public void loadLocationData_throwsIoException_whenFileDoesntExist() throws IOException {
//        PlayerLocation.loadLocationData("randomfile.json");
//    }
//
//    @Test(expected = JsonSyntaxException.class)
//    // JsonSyntaxException is thrown for invalid data, verifying correct parsing
//    // behavior
//    public void loadLocationData_throwsJsonSyntaxException_whenDataInvalid() throws IOException {
//        PlayerLocation.loadLocationData("invalid_data.json");
//    }
//
//    @Test // method handles an empty locations list without issues
//    public void loadLocationData_handlesEmptyLocationsList() throws IOException {
//        PlayerLocation.loadLocationData("empty_locations.json");
//        System.out.println("loadLocationData_handlesEmptyLocationsList(): SUCCESS");
//    }
//
//    @Test // loading valid data from the correct file path works as expected
//    public void loadLocationData_loadsValidDataFromCorrectFilePath() throws IOException {
//        PlayerLocation.loadLocationData(VALID_FILE_PATH);
//        System.out.println("loadLocationData_loadsValidDataFromCorrectFilePath: SUCCESS");
//    }
//
//    @Test // displayCurrentLocation works as intended with an empty locations list
//    public void displayCurrentLocation_handlesEmptyLocationsList() {
//        PlayerLocation.locationData = new PlayerLocation.LocationsData();
//        PlayerLocation.locationData.setLocations(null);
//        PlayerLocation.displayCurrentLocation();
//    }
//
//    @Test(expected = IndexOutOfBoundsException.class)
//    // ndexOutOfBoundsException is thrown for an invalid index, ensuring proper
//    // error handling
//    public void displayCurrentLocation_throwsIndexOutOfBoundsException_whenIndexInvalid() {
//        PlayerLocation.locationData = new PlayerLocation.LocationsData();
//        ;
//        PlayerLocation.displayCurrentLocation(); // assuming currentLocationIndex is invalid
//    }
//
//    @Test // displayCurrentLocation handles unexpected data
//    public void displayCurrentLocation_handlesUnexpectedDataInLocations() {
//        PlayerLocation.locationData = new PlayerLocation.LocationsData();
//        PlayerLocation.Location unexpectedLocation = new PlayerLocation.Location(null, "Unexpected Data", 0, 0);
//        PlayerLocation.locationData.setLocations(Arrays.asList(unexpectedLocation));
//        PlayerLocation.displayCurrentLocation();
//        System.out.println("displayCurrentLocation_handlesUnexpectedDataInLocations(): SUCCESS");
//    }
//
//    @Test  // test case for 'Command Center'
//    public void displayCoordinatesCommandCenter_shouldReturn_X32_Y33() {
//        PlayerLocation.Location commandCenter = PlayerLocation.locationData.locations.get(0);
//        assertEquals("Command Center", commandCenter.getLocation());
//        assertEquals(32, commandCenter.getX());    //change values as needed when coordinates changes
//        assertEquals(33, commandCenter.getY());
//    }
//
//    @Test  // test case for 'VR Chamber'
//    public void displayCoordinatesVirtualRealityChamber_shouldReturn_X2_Y2() {
//        PlayerLocation.Location vrChamber = PlayerLocation.locationData.locations.get(1);
//        assertEquals("Virtual Reality Chamber", vrChamber.getLocation());
//        assertEquals(2, vrChamber.getX());
//        assertEquals(2, vrChamber.getY());
//    }
}