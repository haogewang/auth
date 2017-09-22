/**  
 * All rights Reserved, Designed By http://www.easted.com.cn    
 * @author: 易迅通股份     
 * @date:   2017年3月2日 下午5:08:09   
 * @version V1.0 
 * @Copyright: 2017 http://www.easted.com.cn Inc. All rights reserved.
 */
package cn.easted.edm.core.security;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @author: lei
 * @Date: 2017年3月2日 下午5:08:09
 */
public class UserToken extends UsernamePasswordToken {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;

	private String username;

	private char[] password;

	private String key;

	private String signature;

	private String domain;

	private boolean rememberMe = false;

	private String host;

	public UserToken() {
	}

	public UserToken(final String username, final String password, final String key, final String signature,
			final String domain) {
		this(username, password != null ? password.toCharArray() : null, key, signature, domain, true);
	}

	public UserToken(final String username, final String password, final boolean rememberMe) {
		this(username, password != null ? password.toCharArray() : null, null, null, null, rememberMe);
	}

	public UserToken(final String username, final char[] password, final String key, final String signature,
			final String domain, Boolean rememberMe) {
		this.username = username;
		this.password = password;

		this.key = key;
		this.signature = signature;
		this.domain = domain;
		this.rememberMe = rememberMe;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.shiro.authc.AuthenticationToken#getPrincipal()
	 */
	@Override
	public Object getPrincipal() {
		return getUsername();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.shiro.authc.AuthenticationToken#getCredentials()
	 */
	@Override
	public Object getCredentials() {
		return getPassword();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.shiro.authc.RememberMeAuthenticationToken#isRememberMe()
	 */
	@Override
	public boolean isRememberMe() {
		return rememberMe;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.shiro.authc.HostAuthenticationToken#getHost()
	 */
	@Override
	public String getHost() {
		return host;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @param rememberMe
	 *            the rememberMe to set
	 */
	public void setRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
	}

	/**
	 * @param host
	 *            the host to set
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * @return the password
	 */
	public char[] getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(char[] password) {
		this.password = password;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the domain
	 */
	public String getDomain() {
		return domain;
	}

	/**
	 * @param domain
	 *            the domain to set
	 */
	public void setDomain(String domain) {
		this.domain = domain;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the signature
	 */
	public String getSignature() {
		return signature;
	}

	/**
	 * @param signature
	 *            the signature to set
	 */
	public void setSignature(String signature) {
		this.signature = signature;
	}

}
