package my.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//import org.jeecgframework.core.common.controller.BaseController;
//import org.jeecgframework.web.system.manager.ClientManager;
//import org.jeecgframework.web.system.pojo.base.Client;
//import org.jeecgframework.web.system.pojo.base.TSConfig;
//import org.jeecgframework.web.system.pojo.base.TSFunction;
//import org.jeecgframework.web.system.pojo.base.TSRole;
//import org.jeecgframework.web.system.pojo.base.TSRoleFunction;
//import org.jeecgframework.web.system.pojo.base.TSRoleUser;
//import org.jeecgframework.web.system.pojo.base.TSUser;
//import org.jeecgframework.web.system.service.SystemService;
//import org.jeecgframework.web.system.service.UserService;

//import org.jeecgframework.core.common.model.json.AjaxJson;
//import org.jeecgframework.core.constant.Globals;
//import org.jeecgframework.core.extend.datasource.DataSourceContextHolder;
//import org.jeecgframework.core.extend.datasource.DataSourceType;
//import org.jeecgframework.core.util.ContextHolderUtils;
//import org.jeecgframework.core.util.IpUtil;
//import org.jeecgframework.core.util.ListtoMenu;
//import org.jeecgframework.core.util.NumberComparator;
//import org.jeecgframework.core.util.ResourceUtil;
//import org.jeecgframework.core.util.oConvertUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import my.core.ContextHolderUtils;

/**
 * 登陆初始化控制器
 *
 * @author 张代浩
 */
@Scope("prototype")
@Controller
@RequestMapping("/loginController")
//@RequestMapping("/loginController")
public class LoginController {


    @RequestMapping(params = "body")
    @ResponseBody
    public String gobody() {
        return "hello word";
    }

    @RequestMapping(params = "nobody")
    public String gonobody() {
        return "hello word";
    }

    @RequestMapping(params = "golink")
    public String goPwdInit() {
        return "login/pwd_init";
    }

    @RequestMapping(params = "pwdInit")
    public ModelAndView pwdInit(HttpServletRequest request) {
        ModelAndView modelAndView = null;
        modelAndView = new ModelAndView(new RedirectView(
                "loginController.do?login"));
        return modelAndView;
    }

//	@RequestMapping(params = "checkuser")
//	@ResponseBody
//	public AjaxJson checkuser(HttpServletRequest req) {
//		HttpSession session = ContextHolderUtils.getSession();
//		DataSourceContextHolder
//				.setDataSourceType(DataSourceType.dataSource_jeecg);
//		AjaxJson j = new AjaxJson();
//		return j;
//	}

    @RequestMapping(params = "login")
    public String login(ModelMap modelMap, HttpServletRequest request) {
//		DataSourceContextHolder
//				.setDataSourceType(DataSourceType.dataSource_jeecg);
        return "login/login";
    }

    /**
     * 退出系统
     *
     * @param request
     * @return
     */
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
     * 无权限页面提示跳转
     *
     * @return
     */
    @RequestMapping(params = "noAuth")
    public ModelAndView noAuth(HttpServletRequest request) {
        return new ModelAndView("common/noAuth");
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

    /**
     * @return AjaxJson
     * @throws
     * @Title: top
     * @author:gaofeng
     * @Description: shortcut头部菜单一级菜单列表，并将其用ajax传到页面，实现动态控制一级菜单列表
     */
    @RequestMapping(params = "primaryMenu")
    @ResponseBody
    public String getPrimaryMenu() {
//		List<TSFunction> primaryMenu = getFunctionMap(
//				ResourceUtil.getSessionUserName()).get(0);
//		String floor = "";
//		for (TSFunction function : primaryMenu) {
//			if (function.getFunctionLevel() == 0) {
//
//				if ("Online 开发".equals(function.getFunctionName())) {
//
//					floor += " <li><img class='imag1' src='plug-in/login/images/online.png' /> "
//							+ " <img class='imag2' src='plug-in/login/images/online_up.png' style='display: none;' />"
//							+ " </li> ";
//				} else if ("统计查询".equals(function.getFunctionName())) {
//
//					floor += " <li><img class='imag1' src='plug-in/login/images/guanli.png' /> "
//							+ " <img class='imag2' src='plug-in/login/images/guanli_up.png' style='display: none;' />"
//							+ " </li> ";
//				} else if ("系统管理".equals(function.getFunctionName())) {
//
//					floor += " <li><img class='imag1' src='plug-in/login/images/xtgl.png' /> "
//							+ " <img class='imag2' src='plug-in/login/images/xtgl_up.png' style='display: none;' />"
//							+ " </li> ";
//				} else if ("常用示例".equals(function.getFunctionName())) {
//
//					floor += " <li><img class='imag1' src='plug-in/login/images/cysl.png' /> "
//							+ " <img class='imag2' src='plug-in/login/images/cysl_up.png' style='display: none;' />"
//							+ " </li> ";
//				} else if ("系统监控".equals(function.getFunctionName())) {
//
//					floor += " <li><img class='imag1' src='plug-in/login/images/xtjk.png' /> "
//							+ " <img class='imag2' src='plug-in/login/images/xtjk_up.png' style='display: none;' />"
//							+ " </li> ";
//				} else {
//					// 其他的为默认通用的图片模式
//					String s = "";
//					if (function.getFunctionName().length() >= 5
//							&& function.getFunctionName().length() < 7) {
//						s = "<div style='width:67px;position: absolute;top:40px;text-align:center;color:#909090;font-size:12px;'><span style='letter-spacing:-1px;'>"
//								+ function.getFunctionName() + "</span></div>";
//					} else if (function.getFunctionName().length() < 5) {
//						s = "<div style='width:67px;position: absolute;top:40px;text-align:center;color:#909090;font-size:12px;'>"
//								+ function.getFunctionName() + "</div>";
//					} else if (function.getFunctionName().length() >= 7) {
//						s = "<div style='width:67px;position: absolute;top:40px;text-align:center;color:#909090;font-size:12px;'><span style='letter-spacing:-1px;'>"
//								+ function.getFunctionName().substring(0, 6)
//								+ "</span></div>";
//					}
//					floor += " <li style='position: relative;'><img class='imag1' src='plug-in/login/images/default.png' /> "
//							+ " <img class='imag2' src='plug-in/login/images/default_up.png' style='display: none;' />"
//							+ s + "</li> ";
//				}
//			}
//		}
        return "floor";
    }


}
