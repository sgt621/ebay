package com.sghazi.ebay.controller;

import com.sghazi.ebay.model.Item;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ImageControllerTest
{
    @LocalServerPort
    int randomServerPort;

    @Test
    public void testAllItems() throws URISyntaxException
    {
        RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = "http://localhost:" + randomServerPort + "/imageURL/getImagesByItem/1";
        URI uri = new URI(baseUrl);

        ResponseEntity<Item> result = restTemplate.getForEntity(uri, Item.class);

        //Verify request succeed
        Assert.assertEquals(200, result.getStatusCodeValue());
    }
}
