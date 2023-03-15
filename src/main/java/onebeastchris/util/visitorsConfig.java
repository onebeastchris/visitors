package onebeastchris.util;

import org.spongepowered.configurate.objectmapping.ConfigSerializable;
import org.spongepowered.configurate.objectmapping.meta.Comment;

@ConfigSerializable
@SuppressWarnings("FieldMayBeFinal")
public final class visitorsConfig {
    @Comment("""
            Which Message to send to visitors upon joining the server; part 1 (gets looped).
            """)
    private String visitorWelcomeMessage1 = "Welcome! Please apply in the discord to play.";

    @Comment("""
            Which Message to send to visitors upon joining the server; part 2 (gets looped)
            """)
    private String visitorWelcomeMessage2 = "To get the discord invite link, type /discord.";

    @Comment("""
            Which Message to send to freshly whitelisted players. (only seen once by the player, and only seen when being whitelisted while the player is online)""")
    private String memberWelcomeMessage = "Welcome to the server!";

    @Comment("""
            Whether to enable the /discord command.
            """)
    private boolean discordCommand = true;

    @Comment("""
            Which link to send to players when they use the /discord command.
            """)
    private String discordInviteLink = "https://discord.gg/INVITE_LINK";

    @Comment("""
            Which message to send before the discord invite link when players use the /discord command.
            """)
    private String discordInviteMessage = "Join this discord to apply in order to be able to play here:";

    //@Comment("""
    //        If set to true, players are in a custom adventure mode, where they can't break blocks, place blocks, or use items. If set to false, players are in spectator mode.
    //        """)
    //private boolean useCustomAdventureMode = false;

    public String getWelcomeMemberMessage(){
        return memberWelcomeMessage;
    }

    public String getWelcomeVisitorMessage1(){
        return visitorWelcomeMessage1;
    }

    public String getWelcomeVisitorMessage2(){
        return visitorWelcomeMessage2;
    }

    public boolean getDiscordCommand(){
        return discordCommand;
    }

    public String getInviteLink(){
        return discordInviteLink;
    }

    //public boolean getUseCustomAdventure(){
    //    return useCustomAdventureMode;
    //}

    public String getDiscordInviteMessage() {
        return discordInviteMessage;
    }
}