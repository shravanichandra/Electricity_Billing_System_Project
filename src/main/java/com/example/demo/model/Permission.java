package com.example.demo.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "permissions")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "per_id")
    private Long perId;

    @ManyToOne
    @JoinColumn(name = "per_role_id", nullable = false)
    private Role perRole; // Assuming a Permission is associated with a Role

    @Column(name = "per_module", nullable = false)
    private String perModule;

    @Column(name = "per_name", nullable = false)
    private String perName;

    // Default constructor
    public Permission() {
    }

    // Constructor with parameters
    public Permission(Role perRole, String perModule, String perName) {
        this.perRole = perRole;
        this.perModule = perModule;
        this.perName = perName;
    }

    // Getters and Setters
    public Long getPerId() {
        return perId;
    }

    public void setPerId(Long perId) {
        this.perId = perId;
    }

    public Role getPerRole() {
        return perRole;
    }

    public void setPerRole(Role perRole) {
        this.perRole = perRole;
    }

    public String getPerModule() {
        return perModule;
    }

    public void setPerModule(String perModule) {
        this.perModule = perModule;
    }

    public String getPerName() {
        return perName;
    }

    public void setPerName(String perName) {
        this.perName = perName;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "perId=" + perId +
                ", perRole=" + perRole.getRoleName() +
                ", perModule='" + perModule + '\'' +
                ", perName='" + perName + '\'' +
                '}';
    }
}
