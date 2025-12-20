package dev.wand.reportx.database;

public record DatabaseConfig(
        String host,
        int port,
        String database,
        String user,
        String password,
        int poolSize
) {}

