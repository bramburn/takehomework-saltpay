package co.saltpay.UI;

import co.saltpay.Infrastructure.Repository.Driver.JsonDriver;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ParseException, java.text.ParseException {
        System.out.println("Hello world!");
        JsonDriver jd = new JsonDriver();
        jd.readFile();
    }
}
