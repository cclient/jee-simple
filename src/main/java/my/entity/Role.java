package my.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Table(name = "Account", schema = "")
@SuppressWarnings("serial")
public class Role {
    /**
     * id
     */
    private Integer id;
    /**
     * 外键关联cgform_head
     */
    private String username;
    /**
     * 按钮编码
     */
    private String passwd;
    /**
     * 按钮名称
     */
    private String email;
    /**
     * 按钮样式link/button
     */
    private String telephone;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    @Column(name = "username", length = 45)
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the passwd
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     * @param passwd the passwd to set
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    /**
     * @return the telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * @param telephone the telephone to set
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

}
