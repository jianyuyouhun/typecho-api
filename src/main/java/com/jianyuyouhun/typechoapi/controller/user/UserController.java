package com.jianyuyouhun.typechoapi.controller.user;

import com.jianyuyouhun.typechoapi.config.UserRole;
import com.jianyuyouhun.typechoapi.controller.RestBaseController;
import com.jianyuyouhun.typechoapi.controller.RestResult;
import com.jianyuyouhun.typechoapi.dao.UserDao;
import com.jianyuyouhun.typechoapi.dao.UserInfo;
import com.jianyuyouhun.typechoapi.utils.cpt.PHPass;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController()
@RequestMapping("user")
public class UserController extends RestBaseController {

    @Resource
    private UserDao userDAO;

    @GetMapping("/loginAction")
    public String loginAction(@RequestParam("userName") String userName, @RequestParam("password") String password) {
        UserInfo userInfo = userDAO.findByUserName(userName);
        if (userInfo == null) {
            return buildResult(RestResult.RESULT_USER_NOT_EXIST, null).toString();
        } else {
            PHPass phPass = new PHPass(8);
            boolean checkPassword = phPass.CheckPassword(password, userInfo.getPassword());
            if (checkPassword) {
                JSONObject buildResult = buildResult(RestResult.RESULT_DATA_OK, userInfo);
                buildResult.optJSONObject("data").remove("password");
                return buildResult.toString();
            } else {
                try {
                    Thread.sleep(2000);//等待2秒，避免撞库
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return buildResult(RestResult.RESULT_PWD_NOT_MATCH, null).toString();
            }
        }
    }

    @GetMapping("/listUser")
    public String listUser(@RequestParam("authCode") String authCode) {
        UserInfo userInfo = userDAO.findByAuthCode(authCode);
        if (userInfo == null) {
            return buildResult(RestResult.RESULT_USER_NOT_EXIST, null).toString();
        } else if (!userInfo.getGroup().equals(UserRole.ADMIN.value)) {
            return buildResult(RestResult.RESULT_ACCESS_DENIED, null).toString();
        } else {
            List<UserInfo> userInfos = listUsers();
            if (userInfos.size() == 0) {
                return buildResult(RestResult.RESULT_DATA_EMPTY, userInfos).toString();
            } else {
                return buildResult(RestResult.RESULT_DATA_OK, userInfos).toString();
            }
        }
    }

    private List<UserInfo> listUsers() {
        Iterator<UserInfo> daoAll = userDAO.findAll().iterator();
        List<UserInfo> userInfos = new ArrayList<>();
        while (daoAll.hasNext()) {
            UserInfo userInfo = daoAll.next();
            userInfos.add(userInfo);
        }
        return userInfos;
    }
}
