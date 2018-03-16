package net.paulomart.bungeebugtest;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;

public class BungeeBugTest extends Plugin implements Listener {

	@Override
	public void onEnable() {
		getProxy().getPluginManager().registerCommand(this, new Command("test") {

			@Override
			public void execute(CommandSender arg0, String[] arg1) {
				try {
					Thread.sleep(60000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				arg0.sendMessage("Test...");
			}
		});
		getProxy().getPluginManager().registerListener(this, this);
	}

	@EventHandler
	public void onDisconnect(PlayerDisconnectEvent event) {
		getLogger().info(event.getPlayer() + " disonnected.");
	}
}
