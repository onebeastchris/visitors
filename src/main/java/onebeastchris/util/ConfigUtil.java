package onebeastchris.util;

import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.configurate.CommentedConfigurationNode;
import org.spongepowered.configurate.ConfigurateException;
import org.spongepowered.configurate.hocon.HoconConfigurationLoader;


public class ConfigUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger("visitors");

    private boolean discordCommand;
    private String inviteLink;
    //private boolean useCustomAdventure;
    private String welcomeVisitorMessage1;
    private String welcomeVisitorMessage2;

    private String welcomeMemberMessage;

    private String discordInviteMessage;

    private boolean useAdventureMode;

    public static visitorsConfig config;

    public ConfigUtil() {
        final HoconConfigurationLoader loader = HoconConfigurationLoader.builder()
                .path(FabricLoader.getInstance().getConfigDir().resolve("visitors.conf"))
                .defaultOptions(opts -> opts.header("visitors config"))
                .prettyPrinting(true)
                .build();

        try {
            final CommentedConfigurationNode node = loader.load();
            config = node.get(visitorsConfig.class);
            loader.save(node);
        } catch (ConfigurateException e) {
            LOGGER.warn("Could not load config!");
            e.printStackTrace();
            return;
        }

        this.discordCommand = config.getDiscordCommand();
        this.inviteLink = config.getInviteLink();
        //this.useCustomAdventure = config.getUseCustomAdventure();
        this.welcomeVisitorMessage1 = config.getWelcomeVisitorMessage1();
        this.welcomeVisitorMessage2 = config.getWelcomeVisitorMessage2();
        this.welcomeMemberMessage = config.getWelcomeMemberMessage();
        this.discordInviteMessage = config.getDiscordInviteMessage();
        this.useAdventureMode = config.getUseAdventureMode();
    }

    public boolean getDiscordCommand(){
        return discordCommand;
    }

    public String getInviteLink(){
        return inviteLink;
    }

    public boolean getUseAdventure(){
        return useAdventureMode;
    }

    public String getWelcomeVisitorMessage1(){
        return welcomeVisitorMessage1;
    }

    public String getWelcomeVisitorMessage2(){
        return welcomeVisitorMessage2;
    }

    public String getWelcomeMemberMessage(){
        return welcomeMemberMessage;
    }

    public String getDiscordInviteMessage(){
        return discordInviteMessage;
    }
}