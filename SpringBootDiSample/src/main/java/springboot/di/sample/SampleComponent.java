package springboot.di.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@SuppressWarnings("javadoc")
@Component
public class SampleComponent {

    public void exec() {
        Logger logger = LoggerFactory.getLogger(this.getClass());
        logger.error("SampleComponent executed!!!");
    }

}
