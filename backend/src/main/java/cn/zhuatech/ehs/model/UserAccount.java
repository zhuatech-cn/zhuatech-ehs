/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.ehs.model;
import jakarta.persistence.*;
@Entity @Table(name="ehs_user")
public class UserAccount extends BaseEntity {
    public enum Role { ADMIN, EHS_MANAGER, SAFETY_OFFICER, QUALITY }
    @Column(nullable=false,unique=true,length=32) private String username; @Column(nullable=false) private String password;
    @Column(nullable=false,length=50) private String fullName; @Enumerated(EnumType.STRING) @Column(nullable=false,length=20) private Role role;
    @Column(name="safety_area_code",length=32) private String safetyAreaCode; @Column(nullable=false) private boolean enabled=true;
    protected UserAccount(){}
    public UserAccount(String username,String password,String fullName,Role role,String safetyAreaCode){this.username=username;this.password=password;this.fullName=fullName;this.role=role;this.safetyAreaCode=safetyAreaCode;}
    public String getUsername(){return username;} public String getPassword(){return password;} public String getFullName(){return fullName;} public Role getRole(){return role;} public String getSafetyAreaCode(){return safetyAreaCode;} public boolean isEnabled(){return enabled;}
}
