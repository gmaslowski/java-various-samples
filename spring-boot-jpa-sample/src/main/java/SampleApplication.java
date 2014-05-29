import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.gmaslowski.sample")
@EnableTransactionManagement(proxyTargetClass = true)
@EnableJpaRepositories("com.gmaslowski.sample.repo")
@EntityScan("com.gmaslowski.sample.entity")
public class SampleApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleApplication.class, args);
    }


    @Bean
    @ConditionalOnClass(name = "ClassToExist")
    public CreatedService classToExist() {
        return new CreatedService();
    }
}