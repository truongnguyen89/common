package com.football.common.cache;

import com.football.common.constant.Constant;
import com.football.common.model.auth.Role;
import com.football.common.model.auth.Token;
import com.football.common.model.param.Param;
import com.football.common.model.param.ParamKey;
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
    public static Map<MultiKey, Token> tokenMap;
    public static Map<Long, String> roleMap; //Key = roleId, value = roleCode
    public static Map<String, String> roleUserMap; //Key = userName, value = roleCode


    public static Response setParamCache(List<Param> paramList) {
        if (ArrayListCommon.isNullOrEmpty(paramList))
            return Response.BAD_REQUEST;
        Map<MultiKey, String> paramTmp = new HashMap<>();
        for (Param param : paramList) {
            if (param.getStatus() == Constant.STATUS_OBJECT.ACTIVE)
                paramTmp.put(new MultiKey(param.getParamKey().getType(), param.getParamKey().getCode()), param.getValue());
        }
        paramMap = paramTmp;
        return Response.OK;
    }

    public static Response setTokenCache(List<Token> tokenList) {
        if (ArrayListCommon.isNullOrEmpty(tokenList))
            return Response.BAD_REQUEST;
        Map<MultiKey, Token> tokenTmp = new HashMap<>();
        for (Token token : tokenList) {
            if (token.getStatus() == Constant.STATUS_OBJECT.ACTIVE)
                tokenTmp.put(new MultiKey(token.getUserId(), token.getToken()), token);
        }
        tokenMap = tokenTmp;
        return Response.OK;
    }

    public static Response setRoleCache(List<Role> roleList) {
        if (ArrayListCommon.isNullOrEmpty(roleList))
            return Response.BAD_REQUEST;
        Map<Long, String> roleTmp = new HashMap<>();
        for (Role role : roleList) {
            roleTmp.put(role.getId(), role.getCode());
        }
        roleMap = roleTmp;
        return Response.OK;
    }

    public static Token getTokenFromCache(long userId, String tokenValue) {
        Token token = null;
        if (tokenMap == null || tokenMap.isEmpty() || StringCommon.isNullOrBlank(tokenValue))
            return token;
        else
            return tokenMap.get(new MultiKey(userId, tokenValue));
    }

    public static String getRoleCodeFromCache()

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
                    p.setStatus(Constant.STATUS_OBJECT.ACTIVE);
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

}
