package co.saltpay.Infrastructure.Repository.Driver;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JsonDriverTest {

    @Test
    void readFileTestDoesNotThrow() {
        JsonDriver jd = new JsonDriver();
        //should not throw any errors, its not ideal but quick way to catch all file not found
        // this is because no configuration or the like, we assume this is static for life
        assertDoesNotThrow(()->jd.readFile());
    }

}
