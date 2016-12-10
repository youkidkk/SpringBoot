package springboot.sample.common.thymeleaf;

/**
 * カスタムエクスプレッション
 */
public class CustomExpression {

	/**
	 * 文字列を数値に変換
	 * @param string 文字列
	 * @return 変換後数値
	 */
	public Integer parseInt(String string) {
		return Integer.valueOf(string);
	}

}
