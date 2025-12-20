package dev.wand.reportx.api.database;

public record DatabaseConfig(
        String host,
        int port,
        String database,
        String user,
        String password,
        int poolSize
) {}

