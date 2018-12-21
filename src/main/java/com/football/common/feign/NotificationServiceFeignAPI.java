package com.football.common.feign;

import com.football.common.constant.Constant;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: truongnq
 * @date: 21-Dec-18 2:42 PM
 * To change this template use File | Settings | File Templates.
 */
@FeignClient(Constant.FEIGN_CLIENT.SERVICE_NOTIFICATION)
public interface NotificationServiceFeignAPI {
    String URL_PATH_PARAM = "/param/";
}
