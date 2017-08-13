package springboot.mvc.sample.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * 性別列挙型
 */
@AllArgsConstructor
@Getter
public enum Sex {

    /** 男性 */
    MALE("1", "男性"),
    /** 女性 */
    FEMALE("2", "女性");

    /** 値 */
    private String value;

    /** テキスト */
    private String text;

    /**
     * アイテムマップを取得
     * @return アイテムマップ
     */
    public static Map<String, String> getItemsMap() {
        Map<String, String> map = new HashMap<>();
        map.put("", "");
        for (Sex sex : Sex.values()) {
            map.put(sex.getValue(), sex.getText());
        }
        return map;
    }

}
