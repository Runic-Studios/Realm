package com.runicrealms.realm

import com.google.inject.Guice
import com.google.inject.Injector
import org.bukkit.plugin.java.JavaPlugin

class RealmPlugin : JavaPlugin() {

    private var injector: Injector? = null

    override fun onEnable() {
        injector = Guice.createInjector(MyPluginModule(this))
        logger.info("Realm Guice injection has finished!")
    }
}
