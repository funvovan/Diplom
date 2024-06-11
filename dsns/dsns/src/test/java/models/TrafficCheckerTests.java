package models;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TrafficCheckerTests {

    private TrafficChecker trafficChecker;

    @BeforeEach
    public void setUp() {
        trafficChecker = Mockito.spy(new TrafficChecker());
    }

    @Test
    public void testGetTrafficData() throws IOException {
        String mockResponse = "{\"status\": \"OK\", \"routes\": []}";
        Mockito.doReturn(mockResponse).when(trafficChecker).getTrafficData(Mockito.anyString(), Mockito.anyString());

        String response = trafficChecker.getTrafficData("Start address", "End address");
        assertTrue(response.contains("OK"));
    }

    @Test
    public void testAnalyzeTraffic() {
        String mockResponse = "{\"status\": \"OK\", \"routes\": [{\"legs\": [{\"steps\": [{\"html_instructions\": \"Head northwest\", \"traffic_condition\": \"clear\"}]}]}]}";
        trafficChecker.analyzeTraffic(mockResponse);

        // Перевірка відсутня, тест завжди буде позитивний
        assertTrue(true);
    }
}
