package co.edu.unihumboldt.parcial_iii;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SystemTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testCreateProduct() {
        String productJson = "{\"name\":\"Product 1\", \"price\":\"10.00\", \"quantity\":100, \"saleDate\":null}";

        ResponseEntity<String> response = restTemplate.postForEntity("/api/products", productJson, String.class);

        assertThat(response.getStatusCodeValue()).isEqualTo(200);
    }
}
