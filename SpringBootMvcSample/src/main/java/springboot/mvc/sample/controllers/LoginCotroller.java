package springboot.mvc.sample.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * ログインコントローラークラス
 */
@Controller
public class LoginCotroller {

    /**
     * ログイン
     * @param error ログインエラー時パラメータ
     * @return モデル＆ビュー
     */
    @RequestMapping("/login")
    public ModelAndView login(
            @RequestParam(required = false) String error) {
        ModelAndView mav = new ModelAndView("contents/common/login");
        if (error != null) {
            // ログインエラー時
            mav.addObject("msg", "ユーザー名またはパスワードが不正です。");
        }
        mav.addObject("title", "ログイン");
        mav.addObject("username", "");
        mav.addObject("password", "");
        return mav;
    }

}
