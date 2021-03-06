package com.weiziplus.springboot.core.pc.system.controller;

import com.weiziplus.springboot.common.interceptor.AdminAuthToken;
import com.weiziplus.springboot.common.interceptor.SysUserLog;
import com.weiziplus.springboot.common.util.PageUtils;
import com.weiziplus.springboot.common.util.ResultUtils;
import com.weiziplus.springboot.core.pc.system.service.SysUserLogService;
import com.weiziplus.springboot.core.pc.system.vo.SysLogVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wanglongwei
 * @date 2019/5/13 15:33
 */
@RestController
@ApiIgnore
@AdminAuthToken
@RequestMapping("/pc/sysUserLog")
public class SysUserLogController {

    @Autowired
    SysUserLogService service;

    @GetMapping("/getPageList")
    @SysUserLog(description = "查看系统用户日志")
    public ResultUtils<PageUtils<SysLogVo>> getPageList(
            HttpServletRequest request,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "roleId", required = false) Long roleId,
            @RequestParam(value = "url", required = false) String url,
            @RequestParam(value = "type", required = false) Integer type,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "ipAddress", required = false) String ipAddress,
            @RequestParam(value = "startTime", required = false) String startTime,
            @RequestParam(value = "endTime", required = false) String endTime) {
        return service.getPageList(request, pageNum, pageSize, username, roleId
                , url, type, description, ipAddress, startTime, endTime);
    }
}
