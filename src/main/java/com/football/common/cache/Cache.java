package com.football.common.cache;

import com.football.common.constant.Constant;
import com.football.common.crypt.RSA;
import com.football.common.model.account.Account;
import com.football.common.model.agent.Agent;
import com.football.common.model.api.Api;
import com.football.common.model.param.Param;
import com.football.common.model.param.ParamKey;
import com.football.common.model.role.Roles;
import com.football.common.response.Response;
import com.football.common.util.ArrayListCommon;
import com.football.common.util.StringCommon;
import org.apache.commons.collections.keyvalue.MultiKey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : TruongNQ
 * @date created : Apr 7, 2018
 * @describe : Expression des is undefined on line 13, column 25 in
 * Templates/Classes/Class.java.
 */

public class Cache {
    public static Map<MultiKey, String> paramMap;
    public static Map<String, Agent> agentMap;
    public static Map<String, Account> accountMap;
    public static List<Api> apiList;
    public static Map<MultiKey, Roles> rolesMap;


    public static Response setParamCache(List<Param> paramList) {
        if (ArrayListCommon.isNullOrEmpty(paramList))
            return Response.BAD_REQUEST;
        Map<MultiKey, String> paramTmp = new HashMap<>();
        for (Param param : paramList) {
            if (param.getStatus() == Constant.STATUS_OBJECT.ACTIVE_INT)
                paramTmp.put(new MultiKey(param.getParamKey().getType(), param.getParamKey().getCode()), param.getValue());
        }
        paramMap = paramTmp;
        return Response.OK;
    }

    public static Response setRolesCache(List<Roles> rolesList) {
        if (ArrayListCommon.isNullOrEmpty(rolesList))
            return Response.BAD_REQUEST;
        Map<MultiKey, Roles> rolesTmp = new HashMap<>();
        for (Roles roles : rolesList) {
            if (roles.getStatus() == Constant.STATUS_OBJECT.ACTIVE_INT)
                rolesTmp.put(new MultiKey(roles.getAgentId(), roles.getApiId()), roles);
        }
        rolesMap = rolesTmp;
        return Response.OK;
    }

    public static Response setAgentCache(List<Agent> agentList) {
        if (ArrayListCommon.isNullOrEmpty(agentList))
            return Response.BAD_REQUEST;
        Map<String, Agent> agentTmp = new HashMap<>();
        for (Agent a : agentList) {
            if (a != null && !StringCommon.isNullOrBlank(a.getCode()) && a.getStatus() == Constant.STATUS_OBJECT.ACTIVE_INT) {
                if (a.getPublicKeyCrypt() == null && !StringCommon.isNullOrBlank(a.getPublicKey()))
                    a.setPublicKeyCrypt(RSA.getPublicKeyFromString(a.getPublicKey()));
                if (a.getPrivateKeyCrypt() == null && !StringCommon.isNullOrBlank(a.getPrivateKey()))
                    a.setPrivateKeyCrypt(RSA.getPrivateKeyFromString(a.getPrivateKey()));
                agentTmp.put(a.getCode(), a);
            }
        }
        agentMap = agentTmp;
        return Response.OK;
    }

    public static Response setAccountCache(List<Account> accountList) {
        if (ArrayListCommon.isNullOrEmpty(accountList))
            return Response.BAD_REQUEST;
        Map<String, Account> accountTmp = new HashMap<>();
        for (Account a : accountList) {
            accountTmp.put(a.getEdong(), a);
        }
        accountMap = accountTmp;
        return Response.OK;
    }

    public static List<Param> getListParamFromCache(String type) {
        List<Param> paramList = new ArrayList<>();
        if (paramMap == null
                || paramMap.isEmpty()
                || StringCommon.isNullOrBlank(type)
                ) {
            return paramList;
        } else {
            type = type.trim().toUpperCase();
            for (MultiKey multiKey : paramMap.keySet()) {
                if (type.equals(multiKey.getKey(0).toString())) {
                    Param p = new Param();
                    p.setParamKey(new ParamKey(type, multiKey.getKey(1).toString()));
                    p.setValue(paramMap.get(multiKey));
                    p.setStatus(Constant.STATUS_OBJECT.ACTIVE_INT);
                    paramList.add(p);
                }
            }
            return paramList;
        }
    }

    public static String getValueParamFromCache(String type, String code) {
        if (paramMap == null
                || paramMap.isEmpty()
                || StringCommon.isNullOrBlank(type)
                || StringCommon.isNullOrBlank(code)
                ) {
            return null;
        } else {
            MultiKey multiKey = new MultiKey(type, code);
            return paramMap.get(multiKey);
        }
    }

    public static int getIntParamFromCache(String type, String code, int defaultValue) {
        if (paramMap == null
                || paramMap.isEmpty()
                || StringCommon.isNullOrBlank(type)
                || StringCommon.isNullOrBlank(code)) {
            return defaultValue;
        } else {
            MultiKey multiKey = new MultiKey(type, code);
            try {
                return Integer.valueOf(paramMap.get(multiKey));
            } catch (Exception e) {
                return defaultValue;
            }
        }
    }

    public static long getLongParamFromCache(String type, String code, long defaultValue) {
        if (paramMap == null
                || paramMap.isEmpty()
                || StringCommon.isNullOrBlank(type)
                || StringCommon.isNullOrBlank(code)) {
            return defaultValue;
        } else {
            MultiKey multiKey = new MultiKey(type, code);
            try {
                return Long.valueOf(paramMap.get(multiKey));
            } catch (Exception e) {
                return defaultValue;
            }
        }
    }

    public static void setApiListCache(List<Api> apiList) {
        Cache.apiList = apiList;
    }
}
