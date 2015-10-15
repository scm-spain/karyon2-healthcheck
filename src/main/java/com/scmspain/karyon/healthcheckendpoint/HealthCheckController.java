package com.scmspain.karyon.healthcheckendpoint;

import com.google.inject.Inject;
import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.reactivex.netty.protocol.http.server.HttpServerResponse;
import netflix.karyon.health.HealthCheckHandler;
import rx.Observable;
import scmspain.karyon.restrouter.annotation.Endpoint;
import scmspain.karyon.restrouter.annotation.Path;

import javax.ws.rs.HttpMethod;

@Endpoint
public class HealthCheckController {

    private final HealthCheckHandler healthCheckHandler;

    @Inject
    public HealthCheckController(HealthCheckHandler healthCheckHandler) {
        this.healthCheckHandler = healthCheckHandler;
    }

    @Path(value = "/healthcheck", method = HttpMethod.GET)
    public Observable<Void> healthcheck(HttpServerResponse<ByteBuf> response) {
        response.setStatus(HttpResponseStatus.valueOf(healthCheckHandler.getStatus()));
        return Observable.empty();
    }
}
