package com.gmaslowski.sdfcp;

import com.gmaslowski.camel.test.integration.CamelRouteIntegrationTestBase;
import com.gmaslowski.camel.test.integration.CamelRouteTestConfiguration;
import org.apache.camel.EndpointInject;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Date;

import static com.gmaslowski.sdfcp.EventProcessingRoute.PROCESS_EVENT_ROUTE;

public class EventProcessingIntegrationTest extends CamelRouteIntegrationTestBase {

    @Override
    protected CamelRouteTestConfiguration testConfiguration() {
        return CamelRouteTestConfiguration.builder()
                .routeName(PROCESS_EVENT_ROUTE)
                .mockScheme("mongodb")
                .mockFromEndpointName("direct:start")
                .mockToEndpoint("mongodb*", "mock:result")
                .build();
    }

    @EndpointInject(uri = "mock:result")
    private MockEndpoint resultEndpoint;

    @Test
    public void shouldStoreEventIntoMongoDB() throws Exception {
        // given
        Event event = new Event();
        event.setCreated(new Date());

        // expect
        resultEndpoint.expectedMessageCount(1);

        // when
        template.sendBody("direct:start", event);

        // then
        resultEndpoint.assertIsSatisfied();
        Assertions.assertThat(resultEndpoint.getExchanges().get(0).getIn().getBody(Event.class).getProcessed()).isNotNull();
    }


    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new EventProcessingRoute(new EventProcessingBean());
    }

}
