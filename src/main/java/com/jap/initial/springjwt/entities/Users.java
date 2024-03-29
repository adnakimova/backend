package com.jap.initial.springjwt.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name = Users.TABLE)

public class Users implements UserDetails {
    static final String TABLE = "users";
    private static final String _ID = "id";
    private static final String _FULL_NAME = "full_name";
    private static final String _EMAIL = "email";
    private static final String _PHONE = "phone";
    private static final String _PASSWORD = "password";
    private static final String _CREATE_AT = "create_at";
    private static final String _UPDATE_AT = "update_at";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = _ID)
    @JsonProperty
    private Long id;
    
    
    @NotBlank
    @Size(max = 20)
    @Column(name = _FULL_NAME)
    @JsonProperty(_FULL_NAME)
    @ApiModelProperty(required = true, notes = "not blank, max 20")
    private String fullName;
    
    
    @Email
    @NotBlank
    @Size(min = 6, max = 100)
    @Column(name = _EMAIL, unique = true)
    @JsonProperty
    @ApiModelProperty(required = true, notes = "not blank, max 100, email, unique")
    private String email;
    
    
    @NotBlank
    @Size(max = 20)
    @Column(name = _PHONE, unique = true)
    @JsonProperty
    @ApiModelProperty(required = true, notes = "not blank, max 20, unique")
    private String phone;
    
    
    @Column(name = _PASSWORD)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    
    
    @Column(name = _CREATE_AT)
    @JsonProperty
    private Timestamp createAt;
    
    
    
    @Column(name = _UPDATE_AT)
    @JsonProperty
    private Timestamp updateAt;
    
    
    
    @ManyToMany 
    @JoinTable( 
        name = "users_roles", 
        joinColumns = @JoinColumn(
          name = "user_id", referencedColumnName = "id"), 
        inverseJoinColumns = @JoinColumn(
          name = "role_id", referencedColumnName = "id")) 
    private Collection<Roles> roles;
    

    public Collection<Roles> getRoles() {
		return roles;
	}


	public void setRoles(Collection<Roles> roles) {
		this.roles = roles;
	}

	public void addRole(Roles role) {
		this.roles.add(role);
	}




	public Users() {
    }
    
    public Long getId() {
        return id;
    }
    public String getFullName() {
        return fullName;
    }
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }
    public String getPassword() {
        return password;
    }
    public Timestamp getCreateAt() {
        return createAt;
    }
    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }
    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }

    @PrePersist
    protected void onCreate() { this.createAt = new Timestamp(System.currentTimeMillis()); }
    @PreUpdate
    protected void onUpdate() { this.updateAt = new Timestamp(System.currentTimeMillis()); }

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
    
    @Override
    @JsonIgnore
    public String getUsername() {
        return this.getEmail();
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }
}
