package com.kalimero2.team.dclink.discord;

import com.kalimero2.team.dclink.DCLink;
import com.kalimero2.team.dclink.DCLinkConfig;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.auth.login.LoginException;
public class DiscordBot {

    private final Logger logger = LoggerFactory.getLogger("dclink-discord");
    private final DCLink dcLink;
    private final JDA jda;
    private final DCLinkConfig.DiscordConfiguration discordConfiguration;

    public DiscordBot(DCLink dcLink) throws LoginException, InterruptedException {
        this.dcLink = dcLink;
        this.discordConfiguration = dcLink.getConfig().getDiscordConfiguration();
        String token = discordConfiguration.getToken();
        if(token.equals("")){
            logger.error("No token found in config");
            throw new LoginException("No token found in config");
        }

        JDABuilder builder = JDABuilder.createDefault(token);
        builder.disableCache(CacheFlag.VOICE_STATE);
        builder.setBulkDeleteSplittingEnabled(false);
        builder.setMemberCachePolicy(MemberCachePolicy.ALL);
        builder.enableCache(CacheFlag.MEMBER_OVERRIDES);
        builder.disableIntents(GatewayIntent.GUILD_PRESENCES, GatewayIntent.GUILD_MESSAGE_TYPING);
        builder.enableIntents(GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_MEMBERS);
        builder.setLargeThreshold(50);

        builder.setActivity(Activity.playing(discordConfiguration.getStatusMessage()));

        jda = builder.build();

        jda.awaitReady();

    }
    public void loadFeatures(){
        new BotCommands(dcLink, jda, discordConfiguration.getGuild());
        new DiscordAccountLinker(dcLink, jda);
    }

    public void shutdown(){
        jda.shutdown();
    }

    public JDA getJda() {
        return jda;
    }

    public Logger getLogger() {
        return logger;
    }
}
