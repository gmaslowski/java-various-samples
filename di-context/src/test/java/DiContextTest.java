import com.gmaslowski.di.DiContext;
import com.gmaslowski.di.beans.Service;
import org.junit.Test;

public class DiContextTest {

    @Test
    public void test() {
        // given
        DiContext context = DiContext.start();

        // when
        Service service = (Service) context.getBean("com.gmaslowski.di.beans.Service");

        // then
        service.call();
    }

}
