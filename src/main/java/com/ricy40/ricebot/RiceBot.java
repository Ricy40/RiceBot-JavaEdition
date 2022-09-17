package com.ricy40.ricebot;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

import javax.security.auth.login.LoginException;

public class RiceBot {

    private final Dotenv config;
    private final ShardManager shardManager;

    public RiceBot() throws LoginException {
        config = Dotenv.configure().load();

        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(config.get("TOKEN"));
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.listening("Fortnite Battle Pass x Everything I Wanted"));
        shardManager = builder.build();
    }

    public ShardManager getShardManager() {
        return shardManager;
    }

    public Dotenv getConfig() {
        return config;
    }

    public static void main(String[] args) {
        try {
            RiceBot bot = new RiceBot();
        } catch (LoginException e) {
            System.out.println("Error, provided bot token is invalid!");
        }
    }
}
