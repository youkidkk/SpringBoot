package springboot.rest.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.rest.sample.async.AsyncExecutor;
import springboot.rest.sample.domain.SampleData;
import springboot.rest.sample.mapper.SampleDataMapper;

@RestController
@SuppressWarnings("javadoc")
@RequestMapping("/SampleRest")
public class SampleRestController {

    @Autowired
    SampleDataMapper sampleDataMapper;

    @Autowired
    AsyncExecutor asyncExecutor;

    @GetMapping
    @RequestMapping("/get/{id}")
    public SampleData getById(@PathVariable int id) {
        return this.sampleDataMapper.select(id);
    }

    @PostMapping
    @RequestMapping("/add")
    public void add(@RequestBody SampleData sampleData) {
        this.sampleDataMapper.insert(sampleData);
        return;
    }

    @PostMapping
    @RequestMapping("/addAsync")
    public String addAsync(@RequestBody SampleData sampleData) {
        this.asyncExecutor.add(sampleData);
        return "Async Task Started...";
    }

}
