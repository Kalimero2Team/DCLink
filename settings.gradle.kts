dependencyResolutionManagement{
    versionCatalogs{
        create("libs"){
            // Core
            plugin("shadow","com.github.johnrengelman.shadow").version("8.1.1")

            version("jda", "5.0.0-beta.13")
            version("configurate-hocon", "4.1.2")
            version("sqlite","3.42.0.1")
            version("adventure","4.14.0")
            version("floodgate-api","2.0-SNAPSHOT")
            version("cloud", "1.8.3")
            version("runtask", "2.1.0")

            library("jda","net.dv8tion","JDA").versionRef("jda")
            library("configurate-hocon","org.spongepowered","configurate-hocon").versionRef("configurate-hocon")
            library("sqlite","org.xerial","sqlite-jdbc").versionRef("sqlite")
            library("adventure-api","net.kyori","adventure-api").versionRef("adventure")
            library("adventure-minimessage","net.kyori","adventure-text-minimessage").versionRef("adventure")
            library("floodgate-api","org.geysermc.floodgate","api").versionRef("floodgate-api")
            library("cloud-core","cloud.commandframework","cloud-core").versionRef("cloud")
            library("cloud-brigadier","cloud.commandframework","cloud-brigadier").versionRef("cloud")

            // Paper
            plugin("paper-run","xyz.jpenilla.run-paper").versionRef("runtask")
            plugin("plugin-yml","net.minecrell.plugin-yml.bukkit").version("0.6.0")

            version("paper-api","1.20.1-R0.1-SNAPSHOT")

            library("paper-api","io.papermc.paper","paper-api").versionRef("paper-api")
            library("cloud-paper","cloud.commandframework","cloud-paper").versionRef("cloud")


            // Velocity
            plugin("velocity-run","xyz.jpenilla.run-velocity").versionRef("runtask")

            version("velocity-api","3.2.0-SNAPSHOT")

            library("velocity-api","com.velocitypowered","velocity-api").versionRef("velocity-api")
            library("cloud-velocity","cloud.commandframework","cloud-velocity").versionRef("cloud")


            // Fabric
            plugin("fabric-loom","fabric-loom").version("1.3.9")

            version("minecraft","1.20.1")
            version("fabric-loader","0.14.22")
            version("fabric-api","0.86.1+1.20.1")
            version("adventure-platform-fabric","5.9.0")

            library("fabric-loader","net.fabricmc","fabric-loader").versionRef("fabric-loader")
            library("fabric-api","net.fabricmc.fabric-api","fabric-api").versionRef("fabric-api")
            library("fabric-api-deprecated","net.fabricmc.fabric-api","fabric-api-deprecated").versionRef("fabric-api")
            library("adventure-fabric","net.kyori","adventure-platform-fabric").versionRef("adventure-platform-fabric")
            library("cloud-fabric","cloud.commandframework","cloud-fabric").versionRef("cloud")
        }
    }
}

pluginManagement {
    repositories {
        maven("https://maven.fabricmc.net/")
        gradlePluginPortal()
    }
}

rootProject.name = "dclink"

include("dclink-api")
include("dclink-core")
include("dclink-paper")
include("dclink-velocity")
include("dclink-fabric")
