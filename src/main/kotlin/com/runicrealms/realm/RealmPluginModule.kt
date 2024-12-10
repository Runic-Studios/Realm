package com.runicrealms.realm

import com.google.inject.AbstractModule
import org.bukkit.plugin.java.JavaPlugin

class MyPluginModule(private val plugin: JavaPlugin) : AbstractModule() {

    override fun configure() {
        bind(JavaPlugin::class.java).toInstance(plugin)
    }
}
