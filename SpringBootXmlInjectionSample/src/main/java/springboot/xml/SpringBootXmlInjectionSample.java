package springboot.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springboot.xml.bean.SampleBean;

@SuppressWarnings("javadoc")
public class SpringBootXmlInjectionSample {

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SampleBean bean = (SampleBean) context.getBean("sampleBean");

        System.out.println(bean);
    }

}
