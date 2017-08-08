package springboot.sample.common.thymeleaf;

import org.thymeleaf.context.IProcessingContext;
import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.dialect.IExpressionEnhancingDialect;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * カスタムエクスプレッション ダイアレクト
 */
public class CustomExpressionDialect extends AbstractDialect
        implements IExpressionEnhancingDialect {

    /* (非 Javadoc)
     * @see org.thymeleaf.dialect.IDialect#getPrefix()
     */
    @Override
    public String getPrefix() {
        return "";
    }

    /* (非 Javadoc)
     * @see org.thymeleaf.dialect.IExpressionEnhancingDialect#getAdditionalExpressionObjects(org.thymeleaf.context.IProcessingContext)
     */
    @Override
    public Map<String, Object> getAdditionalExpressionObjects(
            IProcessingContext processingContext) {
        Map<String, Object> map = new HashMap<>();
        map.put("customEx", new CustomExpression());
        return Collections.unmodifiableMap(map);
    }

}
