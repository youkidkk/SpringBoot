package springboot.mybatis.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springboot.mybatis.sample.domain.SampleData;
import springboot.mybatis.sample.mapper.SampleDataMapper;

import java.util.stream.IntStream;

@SuppressWarnings("javadoc")
@SpringBootApplication
public class SpringBootMyBatisSample implements CommandLineRunner {

    /**
     * ※ 重要
     * マッパーを @Autowired する場合、
     * マッパーを @SpringBootApplication のクラスの配下のパッケージに配置すること。
     */
    @Autowired
    SampleDataMapper sampleDataMapper;

    /**
     * (非 Javadoc)
     * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
     */
    @Override
    public void run(String... args) throws Exception {
        IntStream.range(1, 100).forEach(i -> {
            SampleData data = new SampleData();
            data.setName("hoge" + i);
            data.setValue("fuga fuga " + i);

            this.sampleDataMapper.insert(data);
        });

        this.sampleDataMapper.selectAll().forEach(data -> {
            System.out.println(data);
        });
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMyBatisSample.class, args);
    }

}