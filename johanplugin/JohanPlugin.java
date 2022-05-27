package net.runelite.client.plugins.johanplugin;

import com.google.inject.Provides;
import javax.inject.Inject;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
        name = "Johan plugin",
        description = "Screenshot after trade",
        tags = {"trade"},
        enabledByDefault = false
)
public class JohanPlugin extends Plugin
{
    @Inject
    private OverlayManager overlayManager;

    @Inject
    private JohanPluginOverlay overlay;

    @Provides
    JohanPluginConfig getConfig(ConfigManager configManager)
    {
        return configManager.getConfig(JohanPluginConfig.class);
    }

    @Override
    protected void startUp() throws Exception
    {
        overlayManager.add(overlay);
    }

    @Override
    protected void shutDown() throws Exception
    {
        overlayManager.remove(overlay);
    }
}
