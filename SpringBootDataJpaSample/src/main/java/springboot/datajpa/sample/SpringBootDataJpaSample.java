package springboot.datajpa.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springboot.datajpa.sample.entity.Novel;
import springboot.datajpa.sample.entity.Novelist;
import springboot.datajpa.sample.repository.NovelistRepository;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("javadoc")
@SpringBootApplication
public class SpringBootDataJpaSample implements CommandLineRunner {

    @Autowired
    NovelistRepository novelistRepository;

    /**
     * (非 Javadoc)
     * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
     */
    @Override
    public void run(String... args) throws Exception {
        this.clearData();

        this.addNovelist("Soseki Natsume", "Kokoro", "Bocchan");
        this.addNovelist("Ogai Mori", "Mai Hime", "Utakata no Yume");
        this.addNovelist("Ryunosuke Akutagawa", "Rasho Mon", "Jigoku Hen");

        Novelist novelist = this.novelistRepository.findByName("Soseki Natsume");
        System.out.println(novelist);
        novelist.getNovels().add(new Novel("Wagahai ha Neko dearu", novelist));
        this.novelistRepository.save(novelist);

        this.printNovelists();
    }

    private void clearData() {
        Iterable<Novelist> novelists = this.novelistRepository.findAll();
        for (Novelist novelist : novelists) {
            this.novelistRepository.delete(novelist);
        }
    }

    private void addNovelist(String name, String... novelNames) {
        Novelist novelist = new Novelist(name);

        List<Novel> novels = new ArrayList<>();
        for (String novelName : novelNames) {
            novels.add(new Novel(novelName, novelist));
        }
        novelist.setNovels(novels);

        this.novelistRepository.save(novelist);
    }

    private void printNovelists() {
        this.novelistRepository.findAll().forEach(System.out::println);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDataJpaSample.class);
    }

}
