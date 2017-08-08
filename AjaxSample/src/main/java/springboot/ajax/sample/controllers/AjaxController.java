package springboot.ajax.sample.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.ajax.sample.models.entities.Feature;
import springboot.ajax.sample.models.repositories.FeatureRepository;

import java.util.List;

/**
 * Ajaxコントローラ
 */
@RestController
@RequestMapping("/ajax")
public class AjaxController {

    /** フィーチャーリポジトリー */
    @Autowired
    FeatureRepository repository;

    /**
     * Ajax GETメソッド
     * @return レスポンスマップ
     */
    @RequestMapping("/getFeatures")
    public String get() {
        List<Feature> featureList = this.repository.findAll();
        ObjectMapper mapper = new ObjectMapper();
        String text = "";
        try {
            text = mapper.writeValueAsString(featureList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return text;
    }

}
