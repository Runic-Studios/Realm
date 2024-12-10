package com.runicrealms.realm

import com.google.inject.Guice
import com.google.inject.Injector
import org.bukkit.plugin.java.JavaPlugin

class RealmPlugin : JavaPlugin() {

    private var injector: Injector? = null

    override fun onEnable() {
        // Create the Guice Injector with the plugin module
        injector = Guice.createInjector(MyPluginModule(this))

        logger.info("MyPlugin has been enabled!")
    }
}
