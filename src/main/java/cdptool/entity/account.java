package cdptool.entity;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Repository;

@Entity
@Table(name = "account", schema = "")
@SuppressWarnings("serial")
public class account {
	/**id*/
	private Integer id;
	/**外键关联cgform_head*/
	private java.lang.String username;
	/**按钮编码*/
	private java.lang.String passwd;
	/**按钮名称*/
	private java.lang.String email;
	/**按钮样式link/button*/
	private java.lang.String telephone;
	@Id  
	@GeneratedValue 
	@Column(name = "id", unique = true, nullable = false)
	 @GenericGenerator(name = "generator", strategy = "increment")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public java.lang.String getEmail() {
		return email;
	}
	public void setEmail(java.lang.String email) {
		this.email = email;
	}
	/**
	 * @return the username
	 */
	public java.lang.String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	@Column(name = "username", length = 45)
	public void setUsername(java.lang.String username) {
		this.username = username;
	}
	/**
	 * @return the passwd
	 */
	public java.lang.String getPasswd() {
		return passwd;
	}
	/**
	 * @param passwd the passwd to set
	 */
	public void setPasswd(java.lang.String passwd) {
		this.passwd = passwd;
	}
	/**
	 * @return the telephone
	 */
	public java.lang.String getTelephone() {
		return telephone;
	}
	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(java.lang.String telephone) {
		this.telephone = telephone;
	}
	
}
