//package com.example.polls.model.psgl;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//import javax.persistence.Table;
//import javax.persistence.UniqueConstraint;
//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Size;
//
//import org.hibernate.annotations.NaturalId;
//
//import com.example.polls.model.psgl.RoleUser;
//import com.example.polls.model.audit.DateAudit;
//
//@Entity
//@Table(name = "userspg", uniqueConstraints = {
//        @UniqueConstraint(columnNames = {
//            "username"
//        }),
//        @UniqueConstraint(columnNames = {
//            "email"
//        })
//})
//public class UserPg extends DateAudit {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @NotBlank
//    @Size(max = 40)
//    private String name;
//
//    @NotBlank
//    @Size(max = 15)
//    private String username;
//
//    @NaturalId
//    @NotBlank
//    @Size(max = 40)
//    @Email
//    private String email;
//
//    @NotBlank
//    @Size(max = 100)
//    private String password;
//    public UserPg(@NotBlank @Size(max = 40) String name, @NotBlank @Size(max = 15) String username,
//			@NotBlank @Size(max = 40) @Email String email, @NotBlank @Size(max = 100) String password, Integer age,
//			Boolean locked, Set<RoleUser> roles) {
//		super();
//		this.name = name;
//		this.username = username;
//		this.email = email;
//		this.password = password;
//		this.age = age;
//		this.locked = locked;
//		this.roles = roles;
//	}
//
//	public Integer getAge() {
//		return age;
//	}
//
//	public void setAge(Integer age) {
//		this.age = age;
//	}
//
//	public Boolean getLocked() {
//		return locked;
//	}
//
//	public void setLocked(Boolean locked) {
//		this.locked = locked;
//	}
//
//	@Column(columnDefinition = "integer default 18")
//    private Integer age;
//    
//    @Column(columnDefinition = "boolean default false")
//    private Boolean locked;
//
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "user_roles",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id"))
//    private Set<RoleUser> roles = new HashSet<>();
//
//    public UserPg() {
//
//    }
//
//    public UserPg(String name, String username, String email, String password) {
//        this.name = name;
//        this.username = username;
//        this.email = email;
//        this.password = password;
//    }
//    
//    
//
//    public UserPg(@NotBlank @Size(max = 40) String name, @NotBlank @Size(max = 15) String username,
//			@NotBlank @Size(max = 40) @Email String email, @NotBlank @Size(max = 100) String password, Integer age) {
//		super();
//		this.name = name;
//		this.username = username;
//		this.email = email;
//		this.password = password;
//		this.age = age;
//	}
//
//	public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public Set<RoleUser> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Set<RoleUser> roles) {
//        this.roles = roles;
//    }
//}