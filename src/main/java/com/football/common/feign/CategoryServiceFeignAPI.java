package com.football.common.feign;

import com.football.common.constant.Constant;
import com.football.common.model.account.Account;
import com.football.common.model.agent.Agent;
import com.football.common.model.api.Api;
import com.football.common.model.customer.CustomerBillFinance;
import com.football.common.model.customer.CustomerFinance;
import com.football.common.model.param.Param;
import com.football.common.model.role.Roles;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by IntelliJ IDEA.
 * User: Truong Nguyen
 * Date: 28-May-18
 * Time: 2:04 PM
 * To change this template use File | Settings | File Templates.
 */
@FeignClient(Constant.FEIGN_CLIENT.SERVICE_CATEGORY)
public interface CategoryServiceFeignAPI {
    String URL_PATH_PARAM = "/api/category/param/";
    String URL_PATH_AGENT = "/api/category/agent/";
    String URL_PATH_API = "/api/category/api/";
    String URL_PATH_ROLES = "/api/category/roles/";
    String URL_PATH_ACCOUNT = "/api/category/account/";
    String URL_PATH_CUSTOMER = "/api/category/customer/";

    @RequestMapping(path = URL_PATH_PARAM + "status/{status}", method = GET)
    List<Param> findParamByStatus(@RequestHeader(Constant.HEADER.AGENT) String agentCode,
                                  @RequestHeader(Constant.HEADER.PASSWORD) String password,
                                  @RequestParam(value = Constant.KEY.EDONG, required = false) String edong,
                                  @RequestParam(value = Constant.KEY.AUDIT_NUMBER, required = false) long auditNumber,
                                  @PathVariable(Constant.KEY.STATUS) int status);

}