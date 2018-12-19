package com.football.common.model.agent;

import com.football.common.constant.Constant;
import com.football.common.crypt.RSA;
import com.football.common.util.StringCommon;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * Created by IntelliJ IDEA.
 * User: Truong Nguyen
 * Date: 14-May-18
 * Time: 11:51 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = Constant.TABLE.AGENT)
@EntityListeners(AuditingEntityListener.class)
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "n_id")
    private Long id;
    @Column(name = "s_code", nullable = false)
    private String code;
    @Column(name = "s_password")
    private String password;
    @Column(name = "s_pubkey")
    private String publicKey;
    @Column(name = "s_prvkey")
    private String privateKey;
    @Column(name = "s_salt")
    private String salt;
    @Column(name = "s_desc")
    private String desc;
    @Column(name = "s_pubkey_own")
    private String publicKeyOwn;
    @Column(name = "n_status", nullable = false)
    private Integer status;
    @Transient
    private PublicKey publicKeyCrypt;
    @Transient
    private PrivateKey privateKeyCrypt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
        if (!StringCommon.isNullOrBlank(publicKey))
            setPublicKeyCrypt(RSA.getPublicKeyFromString(publicKey));
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
        if (!StringCommon.isNullOrBlank(privateKey))
            setPrivateKeyCrypt(RSA.getPrivateKeyFromString(privateKey));
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPublicKeyOwn() {
        return publicKeyOwn;
    }

    public void setPublicKeyOwn(String publicKeyOwn) {
        this.publicKeyOwn = publicKeyOwn;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    @Transient
    public PublicKey getPublicKeyCrypt() {
        return publicKeyCrypt;
    }
    @Transient
    public void setPublicKeyCrypt(PublicKey publicKeyCrypt) {
        this.publicKeyCrypt = publicKeyCrypt;
    }
    @Transient
    public PrivateKey getPrivateKeyCrypt() {
        return privateKeyCrypt;
    }
    @Transient
    public void setPrivateKeyCrypt(PrivateKey privateKeyCrypt) {
        this.privateKeyCrypt = privateKeyCrypt;
    }
}

