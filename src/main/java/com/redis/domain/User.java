package com.redis.domain;

import java.io.Serializable;

/**
 * Userʵ�����Ӧ���ݿ��е�tb_user��
 * 
 * @author YaoQi
 * Ҫ��ʹ��redis�����һ��Ҫ��ʵ����ʵ��Serializable�ӿڣ�����ᱨ��
 */

public class User implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = -5244288298702801619L;
    private String id;
    private String name;
    private String password;
    private String username;

   
    public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	@Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", password=" + password + ", username=" + username + "]";
    }
}
