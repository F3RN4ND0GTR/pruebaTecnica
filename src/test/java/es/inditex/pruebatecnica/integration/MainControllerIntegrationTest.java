package es.inditex.pruebatecnica.integration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import es.inditex.pruebatecnica.domain.Prices;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MainControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String buildUrl(String fecha, Integer producto, Integer cadena) {
        return String.format("http://localhost:%d/api/getPrices?fecha=%s&identificador=%d&cadena=%d",
                port, fecha, producto, cadena);
    }

    @Test
    @DisplayName("Caso 1: 14/06/2020 10:00 → precio 35.50")
    void testGetPrices1() {
        String url = buildUrl("2020-06-14 10:00:00", 35455, 1);
        ResponseEntity<Prices[]> response = restTemplate.getForEntity(url, Prices[].class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        Prices[] prices = response.getBody();
        assertThat(prices).isNotNull();
        assertThat(prices).hasSize(1);
        assertThat(prices[0].getPrice()).isEqualTo(35.50);
    }

    @Test
    @DisplayName("Caso 2: 14/06/2020 16:00 → precio 25.45")
    void testGetPrices2() {
        String url = buildUrl("2020-06-14 16:00:00", 35455, 1);
        ResponseEntity<Prices[]> response = restTemplate.getForEntity(url, Prices[].class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        Prices[] prices = response.getBody();
        assertThat(prices).isNotNull();
        assertThat(prices).hasSize(2);
        assertThat(prices[0].getPrice()).isEqualTo(25.45);
    }

    @Test
    @DisplayName("Caso 3: 14/06/2020 21:00 → precio 35.50")
    void testGetPrices3() {
        String url = buildUrl("2020-06-14 21:00:00", 35455, 1);
        ResponseEntity<Prices[]> response = restTemplate.getForEntity(url, Prices[].class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        Prices[] prices = response.getBody();
        assertThat(prices).isNotNull();
        assertThat(prices).hasSize(1);
        assertThat(prices[0].getPrice()).isEqualTo(35.50);
    }

    @Test
    @DisplayName("Caso 4: 15/06/2020 10:00 → precio 30.50")
    void testGetPrices4() {
        String url = buildUrl("2020-06-15 10:00:00", 35455, 1);
        ResponseEntity<Prices[]> response = restTemplate.getForEntity(url, Prices[].class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        Prices[] prices = response.getBody();
        assertThat(prices).isNotNull();
        assertThat(prices).hasSize(2);
        assertThat(prices[0].getPrice()).isEqualTo(30.50);
    }

    @Test
    @DisplayName("Caso 5: 16/06/2020 21:00 → precio 38.95")
    void testGetPrices5() {
        String url = buildUrl("2020-06-16 21:00:00", 35455, 1);
        ResponseEntity<Prices[]> response = restTemplate.getForEntity(url, Prices[].class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        Prices[] prices = response.getBody();
        assertThat(prices).isNotNull();
        assertThat(prices).hasSize(2);
        assertThat(prices[0].getPrice()).isEqualTo(38.95);
    }
}