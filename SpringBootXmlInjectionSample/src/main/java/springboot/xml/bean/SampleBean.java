package springboot.xml.bean;

import lombok.Data;

import java.util.List;
import java.util.Map;

@SuppressWarnings("javadoc")
@Data
public class SampleBean {

    private int number;

    private String text;

    private ChildBean childBean;

    private List<ChildBean> childBeanList;

    private Map<String, ChildBean> childBeanMap;

}
