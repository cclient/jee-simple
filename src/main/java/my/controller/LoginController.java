package my.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import my.entity.Account;
import org.springframework.context.annotation.Scope;
import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


import my.core.ContextHolderUtils;

import java.util.List;

@Scope("prototype")
@Controller
@RequestMapping("/loginController")
public class LoginController {

    @RequestMapping(params = "body")
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String getString() {
        return "hello word";
    }


    //返回json数据格式
    @RequestMapping(params = "account")
    @ResponseBody
    public Account goAccount() {
        Account acc = new Account();
        acc.setId(55);
        acc.setUsername("jsontest");
        return acc;
    }

    //return link 未测
    @RequestMapping(params = "golink")
    public String goPwdInit() {
        return "login/body";
    }

    //return 数据
    @RequestMapping(params = "pwdInit")
    public ModelAndView pwdInit(HttpServletRequest request) {
        ModelAndView modelAndView = null;
        modelAndView = new ModelAndView(new RedirectView(
                "loginController.do?login"));
        return modelAndView;
    }

    @RequestMapping(params = "login")
    public String login(ModelMap modelMap, HttpServletRequest request) {
        //		HttpSession session = ContextHolderUtils.getSession();

//		DataSourceContextHolder
//				.setDataSourceType(DataSourceType.dataSource_jeecg);
        return "login/body";
    }

    @RequestMapping(params = "logout")
    public ModelAndView logout(HttpServletRequest request) {
        HttpSession session = ContextHolderUtils.getSession();

//		ClientManager.getInstance().removeClinet(session.getId());
        ModelAndView modelAndView = new ModelAndView(new RedirectView(
                "loginController.do?login"));
        return modelAndView;
    }

    @RequestMapping(params = "left")
    public ModelAndView left(HttpServletRequest request) {
        HttpSession session = ContextHolderUtils.getSession();
        ModelAndView modelAndView = new ModelAndView();
        // 登陆者的权限
//		if (user.getId() == null) {
//			session.removeAttribute(Globals.USER_SESSION);
//			modelAndView.setView(new RedirectView("loginController.do?login"));
//		} else {
//			List<TSConfig> configs = userService.loadAll(TSConfig.class);
//			for (TSConfig tsConfig : configs) {
//				request.setAttribute(tsConfig.getCode(), tsConfig.getContents());
//			}
//			modelAndView.setViewName("main/left");
//			request.setAttribute("menuMap", getFunctionMap(user));
//		}
        return modelAndView;
    }

    /**
     * 获取用户菜单列表
     *
     * @param user
     * @return
     */


    /**
     * 首页跳转
     *
     * @return
     */
    @RequestMapping(params = "home")
    public ModelAndView home(HttpServletRequest request) {

        return new ModelAndView("main/home");
    }

    /**
     * @param request
     * @return ModelAndView
     * @throws
     * @Title: top
     * @Description: bootstrap头部菜单请求
     */
    @RequestMapping(params = "top")
    public ModelAndView top(HttpServletRequest request) {
//		TSUser user = ResourceUtil.getSessionUserName();
//		HttpSession session = ContextHolderUtils.getSession();
//		// 登陆者的权限
//		if (user.getId() == null) {
//			session.removeAttribute(Globals.USER_SESSION);
//			return new ModelAndView(
//					new RedirectView("loginController.do?login"));
//		}
//		request.setAttribute("menuMap", getFunctionMap(user));
//		List<TSConfig> configs = userService.loadAll(TSConfig.class);
//		for (TSConfig tsConfig : configs) {
//			request.setAttribute(tsConfig.getCode(), tsConfig.getContents());
//		}
        return new ModelAndView("main/bootstrap_top");
    }

    /**
     * @param request
     * @return ModelAndView
     * @throws
     * @Title: top
     * @author gaofeng
     * @Description: shortcut头部菜单请求
     */
    @RequestMapping(params = "shortcut_top")
    public ModelAndView shortcut_top(HttpServletRequest request) {
//		TSUser user = ResourceUtil.getSessionUserName();
//		HttpSession session = ContextHolderUtils.getSession();
//		// 登陆者的权限
//		if (user.getId() == null) {
//			session.removeAttribute(Globals.USER_SESSION);
//			return new ModelAndView(
//					new RedirectView("loginController.do?login"));
//		}
//		request.setAttribute("menuMap", getFunctionMap(user));
//		List<TSConfig> configs = userService.loadAll(TSConfig.class);
//		for (TSConfig tsConfig : configs) {
//			request.setAttribute(tsConfig.getCode(), tsConfig.getContents());
//		}
        return new ModelAndView("main/shortcut_top");
    }

    @RequestMapping(params = "primaryMenu")
    @ResponseBody
    public String getPrimaryMenu() {
        return "floor";
    }
}







//
//
//package org.jeecgframework.core.common.model.json;
//
//        import java.util.Map;
//
//        import com.alibaba.fastjson.JSONObject;
//
///**
// * $.ajax后需要接受的JSON
// *
// * @author
// *
// */
//public class AjaxJson {
//
//    private boolean success = true;// 是否成功
//    private String msg = "操作成功";// 提示信息
//    private Object obj = null;// 其他信息
//    private Map<String, Object> attributes;// 其他参数
//    public Map<String, Object> getAttributes() {
//        return attributes;
//    }
//
//    public void setAttributes(Map<String, Object> attributes) {
//        this.attributes = attributes;
//    }
//
//    public String getMsg() {
//        return msg;
//    }
//
//    public void setMsg(String msg) {
//        this.msg = msg;
//    }
//
//    public Object getObj() {
//        return obj;
//    }
//
//    public void setObj(Object obj) {
//        this.obj = obj;
//    }
//
//    public boolean isSuccess() {
//        return success;
//    }
//
//    public void setSuccess(boolean success) {
//        this.success = success;
//    }
//    public String getJsonStr(){
//        JSONObject obj = new JSONObject();
//        obj.put("success", this.isSuccess());
//        obj.put("msg", this.getMsg());
//        obj.put("obj", this.obj);
//        obj.put("attributes", this.attributes);
//        return obj.toJSONString();
//    }
//}
