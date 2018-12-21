package com.football.common.feign;

import com.football.common.constant.Constant;
import com.football.common.model.param.Param;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by IntelliJ IDEA.
 * User: Truong Nguyen
 * Date: 28-May-18
 * Time: 2:04 PM
 * To change this template use File | Settings | File Templates.
 */
@FeignClient(Constant.FEIGN_CLIENT.SERVICE_CATEGORY)
public interface CategoryServiceFeignAPI {
    String URL_PATH_PARAM = "/param/";
    String URL_PATH_AGENT = "/agent/";
    String URL_PATH_API = "/api/";
    String URL_PATH_ROLES = "/roles/";
    String URL_PATH_ACCOUNT = "/account/";
    String URL_PATH_CUSTOMER = "/customer/";

    @RequestMapping(path = URL_PATH_PARAM + "status/{status}", method = GET)
    List<Param> findParamByStatus(@RequestHeader(Constant.HEADER.AGENT) String agentCode,
                                  @RequestHeader(Constant.HEADER.PASSWORD) String password,
                                  @RequestParam(value = Constant.KEY.EDONG, required = false) String edong,
                                  @RequestParam(value = Constant.KEY.AUDIT_NUMBER, required = false) long auditNumber,
                                  @PathVariable(Constant.KEY.STATUS) int status);

}
