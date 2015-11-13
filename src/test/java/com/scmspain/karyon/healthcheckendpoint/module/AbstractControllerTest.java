package com.scmspain.karyon.healthcheckendpoint.module;

import com.netflix.governator.guice.BootstrapModule;
import com.scmspain.karyon.healthcheckendpoint.module.server.AppServerForTesting;
import io.netty.buffer.ByteBuf;
import io.reactivex.netty.RxNetty;
import io.reactivex.netty.protocol.http.client.HttpClient;
import netflix.karyon.Karyon;
import netflix.karyon.KaryonServer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

abstract public class AbstractControllerTest {
    private static KaryonServer server;

    @BeforeClass
    public static void setUpBefore() throws Exception {
        server = Karyon.forApplication(AppServerForTesting.class, HealthCheckEndPointModule.asBootstrapModule());
        server.start();
    }

    @AfterClass
    public static void tearDownAfter() throws Exception {
        if (server != null) {
            server.shutdown();
        }
    }

    @Before
    public void setUp() throws Exception {
        fixturesUp();
    }

    @After
    public void tearDown() throws Exception {
        fixturesDown();
    }

    protected HttpClient<ByteBuf, ByteBuf> createHttpClient() {
        return RxNetty.createHttpClient("localhost", AppServerForTesting.KaryonRestRouterModuleImpl.DEFAULT_PORT);
    }

    private void fixturesUp() throws Exception {
        Runtime.getRuntime().exec("gradle resetFixtures").waitFor();
        Runtime.getRuntime().exec("gradle loadFixtures").waitFor();
    }

    private void fixturesDown() throws Exception {
    }
}
