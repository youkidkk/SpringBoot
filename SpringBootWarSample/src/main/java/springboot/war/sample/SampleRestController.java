package springboot.war.sample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SuppressWarnings("javadoc")
@RequestMapping("/SampleRest")
public class SampleRestController {

    @GetMapping
    @RequestMapping("/get")
    public String getById() {
        return "SampleRestController GET";
    }

}
