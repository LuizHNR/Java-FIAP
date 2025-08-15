package br.fiap.api_security.entity;

public enum UserRole {
    ADMIN("admin"),
    USER("user");

    private String role;

    UserRole (String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

}
