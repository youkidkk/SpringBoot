package springboot.rest.sample.mapper;

import org.apache.ibatis.annotations.Mapper;
import springboot.rest.sample.domain.SampleData;

@SuppressWarnings("javadoc")
@Mapper
public interface SampleDataMapper {

    public void insert(SampleData data);

    public SampleData select(int id);

}
