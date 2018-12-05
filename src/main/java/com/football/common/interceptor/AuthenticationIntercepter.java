package com.football.common.interceptor;

import com.football.common.cache.Cache;
import com.football.common.constant.Constant;
import com.football.common.constant.TextConstant;
import com.football.common.crypt.Base64;
import com.football.common.crypt.MD5;
import com.football.common.crypt.RSA;
import com.football.common.message.MessageCommon;
import com.football.common.model.agent.Agent;
import com.football.common.model.api.Api;
import com.football.common.model.role.Roles;
import com.football.common.util.ArrayListCommon;
import com.football.common.util.StringCommon;
import org.apache.commons.collections.keyvalue.MultiKey;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by IntelliJ IDEA.
 * User: Truong Nguyen
 * Date: 01-Jun-18
 * Time: 2:35 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class AuthenticationIntercepter implements HandlerInterceptor {

    private static final Logger LOGGER = LogManager.getLogger(Constant.LOG_APPENDER.AUTHENTICATION);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
//        if (request.getRequestURI().toLowerCase().contains("swagger") || request.getRequestURI().toLowerCase().contains("error"))
//            return true;
//        //validate agent
//        String agentCode = request.getHeader(Constant.HEADER.AGENT);
//        if (StringCommon.isNullOrBlank(agentCode)) {
//            LOGGER.error("[ERROR] Agent is null");
//            response.setStatus(HttpStatus.BAD_REQUEST.value());
//            response.getWriter().write(MessageCommon.getMessage(TextConstant.MESSAGE.IS_NULL, Constant.TABLE.AGENT));
//            return false;
//        } else if (agentCode.equals(Constant.AGENT.ADMIN)
//                || request.getRequestURI().toLowerCase().contains("swagger")
//                || request.getRequestURI().toLowerCase().contains("error")
//                )//Neu la request tu swagger thi bo qua
//            return true;
//        Agent agent = Cache.agentMap.get(agentCode);
//        if (agent == null) {
//            LOGGER.error("[ERROR] Agent not found with agentCode = " + agentCode);
//            response.setStatus(HttpStatus.BAD_REQUEST.value());
//            response.getWriter().write(MessageCommon.getMessage(TextConstant.MESSAGE.NOT_FOUND, Constant.TABLE.AGENT));
//            return false;
//        } else if (agent.getStatus() != Constant.STATUS_OBJECT.ACTIVE_INT) {
//            LOGGER.error("[ERROR] Agent inactive with agentCode = " + agentCode);
//            response.setStatus(HttpStatus.BAD_REQUEST.value());
//            response.getWriter().write(MessageCommon.getMessage(TextConstant.MESSAGE.INACTIVE, Constant.TABLE.AGENT));
//            return false;
//        }
//        //validate password
//        String password = request.getHeader(Constant.HEADER.PASSWORD);
//        if (StringCommon.isNullOrBlank(password)) {
//            LOGGER.error("[ERROR] password is null");
//            response.setStatus(HttpStatus.BAD_REQUEST.value());
//            response.getWriter().write(MessageCommon.getMessage(TextConstant.MESSAGE.IS_NULL, Constant.OBJECT.PASSWORD));
//            return false;
//        } else {
//            String passwordDecrypt = "";
//            try {
//                passwordDecrypt = new String(RSA.decrypt(Base64.toByteArrayBase64(password), agent.getPrivateKeyCrypt()));
//                if (!MD5.matched(passwordDecrypt + agent.getSalt(), agent.getPassword())) {
//                    response.setStatus(HttpStatus.BAD_REQUEST.value());
//                    response.getWriter().write("password invalid");
//                    LOGGER.error("[ERROR] password invalid");
//                    return false;
//                }
//            } catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException | IOException e) {
//                LOGGER.info("Password[Server] = " + agent.getPassword());
//                LOGGER.info("Password[Client] = " + password);
//                LOGGER.error("Exception when validate password ", e);
//                //public-key khong hop le
//                response.setStatus(HttpStatus.BAD_REQUEST.value());
//                response.getWriter().write("Exception when validate password " + e.toString());
//                return false;
//            }
//        }
//        //Validate permission uri
//        boolean validateUri = false;
//        if (ArrayListCommon.isNullOrEmpty(Cache.apiList)) {
//            LOGGER.error("[ERROR] Cache.apiList is null");
//            response.setStatus(HttpStatus.BAD_REQUEST.value());
//            response.getWriter().write("API config is null");
//            return false;
//        } else {
//            String uri = request.getRequestURI();
//            String method = request.getMethod();
//            for (Api api : Cache.apiList) {
//                try {
//                    validateUri = (api.getStatus() == Constant.STATUS_OBJECT.ACTIVE_INT) && uri.contains(api.getUrl()) && (method.equals(api.getMethod()));
//                    //Neu tim thay uri thi check tiep quyen cua agent co duoc phep truy cap ?
//                    if (validateUri) {
//                        Roles roles = Cache.rolesMap.get(new MultiKey(agent.getId(), api.getId()));
//                        if (roles == null) {
//                            LOGGER.error("[ERROR] Agent " + agent.getCode() + " not permission method " + api.getMethod() + " uri " + api.getUrl());
//                            response.setStatus(HttpStatus.UNAUTHORIZED.value());
//                            response.getWriter().write("Agent " + agent.getCode() + " not permission method " + api.getMethod() + " uri " + api.getUrl());
//                            return false;
//                        } else if (roles.getStatus() != Constant.STATUS_OBJECT.ACTIVE_INT) {
//                            LOGGER.error("[ERROR] Roles Agent " + agent.getCode() + " call method " + api.getMethod() + " uri " + api.getUrl() + " inactive");
//                            response.setStatus(HttpStatus.UNAUTHORIZED.value());
//                            response.getWriter().write("Agent " + agent.getCode() + " not permission method " + api.getMethod() + " uri " + api.getUrl());
//                            return false;
//                        }
//                        break;
//                    }
//                } catch (Exception e) {
//                    LOGGER.error("[Exception] when validate uri and roles", e);
//                    response.getWriter().write("Exception when validate uri and roles " + e.toString());
//                    validateUri = false;
//                    continue;
//                }
//            }
//        }
//        if (!validateUri) {
//            LOGGER.error("[ERROR] uri not found config");
//            response.setStatus(HttpStatus.UNAUTHORIZED.value());
//            return validateUri;
//        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, //
                           Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, //
                                Object handler, Exception ex) throws Exception {
    }
}
