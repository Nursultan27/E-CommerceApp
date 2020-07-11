package ru.javamentor.ecommerce.security;

public enum ApplicationUserPermission {
//    USER_READ("user:read"),
    ADMIN_READ("admin:read"),
    ADMIN_WRITE("admin:write");

    private final String permission;

    public String getPermission() {
        return permission;
    }

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }
}
