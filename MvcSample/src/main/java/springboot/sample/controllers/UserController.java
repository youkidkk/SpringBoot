package springboot.sample.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import springboot.sample.common.security.LoginUser;
import springboot.sample.models.entities.User;
import springboot.sample.models.enums.Sex;
import springboot.sample.models.repositories.UserRepository;

import javax.validation.Valid;

import java.security.Principal;

/**
 * ユーザーコントローラークラス
 */
@Controller
public class UserController {

    /** テンプレートパス */
    private static final String TEMPLATES_PATH = "contents/user/";

    /** 一覧ページサイズ */
    private static final int PAGE_SIZE = 20;

    /** ユーザーリポジトリー */
    @Autowired
    UserRepository repository;

    /** パスワードエンコーダー */
    @Autowired
    PasswordEncoder passwordEncoder;

    /**
     * 一覧
     * @param page ページ番号
     * @return モデル＆ビュー
     */
    @RequestMapping(value = { "/list", "/" })
    public ModelAndView list(
            @RequestParam(required = false, defaultValue = "1") int page) {
        ModelAndView mav = new ModelAndView(UserController.TEMPLATES_PATH + "list");
        mav.addObject("title", "一覧ページ");
        Iterable<User> list = this.repository
                .findAll(new PageRequest(page - 1, UserController.PAGE_SIZE));
        mav.addObject("users", list);
        mav.addObject("sex_items_map", Sex.getItemsMap());
        mav.addObject("page", page);
        mav.addObject("max_page", (this.repository.count() - 1) / UserController.PAGE_SIZE + 1);
        return mav;
    }

    /**
     * 新規作成
     * @return モデル＆ビュー
     */
    @RequestMapping("/create")
    public ModelAndView create() {
        return new ModelAndView("redirect:/edit/0");
    }

    /**
     * 編集
     * @param id ID
     * @return モデル＆ビュー
     */
    @RequestMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable int id) {
        ModelAndView mav = new ModelAndView(UserController.TEMPLATES_PATH + "edit");
        mav.addObject("title", "編集ページ");
        User user = this.repository.findOne(id);
        if (user == null) {
            user = new User();
        }
        user.setPassword("");
        mav.addObject("user", user);
        mav.addObject("sex_items_map", Sex.getItemsMap());
        return mav;
    }

    /**
     * 登録
     * @param user ユーザーモデル
     * @param result バインド結果
     * @param redirectAttributes リダイレクトアトリビュート
     * @param principal プリンシパル
     * @return モデル＆ビュー
     */
    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public ModelAndView regist(
            @ModelAttribute("user") @Valid User user,
            BindingResult result,
            RedirectAttributes redirectAttributes,
            Principal principal) {
        ModelAndView mav = new ModelAndView();

        // 入力エラー
        if (result.hasErrors()) {
            mav.setViewName(UserController.TEMPLATES_PATH + "edit");
            mav.addObject("title", "編集ページ");
            mav.addObject("msg", "入力エラーがあります。");
            mav.addObject("user", user);
            mav.addObject("sex_items_map", Sex.getItemsMap());
            return mav;
        }

        // パスワードを暗号化
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        try {
            Authentication authentication = (Authentication) principal;
            LoginUser loginUser = (LoginUser) authentication.getPrincipal();
            user.setUpdateUserId(loginUser.getId());
            this.repository.save(user);
        } catch (ObjectOptimisticLockingFailureException e) {
            // 排他チェックエラー
            redirectAttributes.addFlashAttribute("msg", "登録前に他者による更新が行われました。再度編集を行ってください。");
            mav.setViewName("redirect:/edit/" + user.getId());
            return mav;
        }

        redirectAttributes.addFlashAttribute("msg", "登録しました。");
        mav.setViewName("redirect:/list");
        return mav;
    }

    /**
     * 削除
     * @param id ID
     * @param redirectAttributes リダイレクトアトリビュート
     * @return モデル＆ビュー
     */
    @RequestMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable int id, RedirectAttributes redirectAttributes) {
        this.repository.delete(id);
        ModelAndView mav = new ModelAndView("redirect:/list");
        redirectAttributes.addFlashAttribute("msg", "削除しました。");
        return mav;
    }

}