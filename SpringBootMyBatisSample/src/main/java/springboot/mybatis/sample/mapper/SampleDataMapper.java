package springboot.mybatis.sample.mapper;

import org.apache.ibatis.annotations.Mapper;
import springboot.mybatis.sample.domain.SampleData;

import java.util.List;

@SuppressWarnings("javadoc")
@Mapper
public interface SampleDataMapper {

    public void insert(SampleData data);

    public List<SampleData> selectAll();

}
