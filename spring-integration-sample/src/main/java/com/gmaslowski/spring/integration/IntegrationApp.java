package com.gmaslowski.spring.integration;

@Configuration
@SpringBootApplication
@IntegrationComponentScan
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
        TempConverter converter = ctx.getBean(TempConverter.class);
        System.out.println(converter.fahrenheitToCelcius(68.0f));
        ctx.close();
    }

    @MessagingGateway
    public interface TempConverter {

        @Gateway(requestChannel = "convert.input")
        float fahrenheitToCelcius(float fahren);

    }

    @Bean
    public IntegrationFlow convert() {
        return f -> f
                .transform(payload ->
                        "<FahrenheitToCelsius xmlns=\"http://www.w3schools.com/webservices/\">"
                                +     "<Fahrenheit>" + payload +"</Fahrenheit>"
                                + "</FahrenheitToCelsius>")
                .enrichHeaders(h -> h
                        .header(WebServiceHeaders.SOAP_ACTION,
                                "http://www.w3schools.com/webservices/FahrenheitToCelsius"))
                .handle(new SimpleWebServiceOutboundGateway(
                        "http://www.w3schools.com/webservices/tempconvert.asmx"))
                .transform(Transformers.xpath("/*[local-name()=\"FahrenheitToCelsiusResponse\"]"
                        + "/*[local-name()=\"FahrenheitToCelsiusResult\"]"));
    }

}