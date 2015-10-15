package com.scmspain.karyon.healthcheckendpoint;

import io.netty.handler.codec.http.HttpResponseStatus;
import io.reactivex.netty.protocol.http.client.HttpClientRequest;
import org.junit.Assert;
import org.junit.Test;

/**
 */
public class HealthCheckControllerTest extends AbstractControllerTest {

    @Test
    public void itShouldBeHealthy() throws Exception {

    createHttpClient()
                .submit(HttpClientRequest.createGet("/healthcheck"))
                .doOnNext(response -> Assert.assertEquals(HttpResponseStatus.OK, response.getStatus()))
                .toBlocking().single();
    }
}
