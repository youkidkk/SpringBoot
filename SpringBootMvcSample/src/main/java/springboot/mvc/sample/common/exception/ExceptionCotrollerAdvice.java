package springboot.mvc.sample.common.exception;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 例外コントローラーアドバイス
 */
@ControllerAdvice
public class ExceptionCotrollerAdvice {

    /**
     * 例外ハンドラー
     * @param e 例外
     * @return モデル＆ビュー
     */
    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception e) {
        // コンテキストクリア（ログアウト）
        SecurityContextHolder.clearContext();
        ModelAndView mav = new ModelAndView("contents/common/error");
        mav.addObject("title", "例外発生");
        mav.addObject("msg", e.getMessage());
        return mav;
    }

}
