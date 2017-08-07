package com.pikycz.mobplugin.configsection;

import cn.nukkit.Server;
import cn.nukkit.level.Level;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.ConfigSection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author PikyCZ
 */
public class PluginConfiguration extends PluginBase {

    private ConfigSection entities;

    public final HashMap<Integer, Level> levelsToSpawn = new HashMap<>();
    private List<String> disabledWorlds;
    public static boolean spawnAnimals = true;
    public static boolean spawnMonsters = true;

    public void LoadConfig() {
        this.getLogger().info("Prepare" + this.getDataFolder() + "MobPlugin.yml");
        this.getDataFolder().mkdirs();
        this.loadAll();
    }

    public Config getPluginConfig() {
        return new Config(this.getDataFolder() + "MobPlugin.yml", Config.YAML);
    }

    public void loadAll() {
        this.saveConfig();
        this.loadEntities();
    }

    @SuppressWarnings("serial")
    public void loadEntities() {
        this.entities = new Config(this.getDataFolder() + "MobPlugin.yml", Config.YAML,
                new ConfigSection(new LinkedHashMap<String, Object>() {
                    {
                        put("entities.spawn-animals", true);
                        put("entities.spawn-mobs", true);
                    }
                })).getSections();
    }

    public void saveAll() {
        this.saveEntities();
        this.getConfig().save();
    }

    public void saveEntities(boolean async) {
        Config mobplugin = new Config(this.getDataFolder() + "MobPlugin.yml", Config.YAML);
        mobplugin.setAll(this.entities);
        mobplugin.save(async);
    }

    public void saveEntities() {
        Config mobplugin = new Config(this.getDataFolder() + "MobPlugin.yml", Config.YAML);
        mobplugin.setAll(this.entities);
        mobplugin.save();
    }

    public void disableWorlds() {
        for (Level level : Server.getInstance().getLevels().values()) {
            if (disabledWorlds.contains(level.getFolderName().toLowerCase())) {
                continue;
            }

            levelsToSpawn.put(level.getId(), level);
        }
    }

    public boolean spawnAnimals() {
        /*entitySpawners.add(new BatSpawner(this, this.pluginConfig));
        entitySpawners.add(new ChickenSpawner(this, this.pluginConfig));
        entitySpawners.add(new CowSpawner(this, this.pluginConfig));
        entitySpawners.add(new OcelotSpawner(this, this.pluginConfig));
        entitySpawners.add(new PigSpawner(this, this.pluginConfig));
        Spawner.add(new LlamaSpawner(this, this.pluginCofig));
        entitySpawners.add(new RabbitSpawner(this, this.pluginConfig));
        entitySpawners.add(new SheepSpawner(this, this.pluginConfig));*/
        return false;
    }

    public boolean spawnMonsters() {
        /*entitySpawners.add(new CreeperSpawner(this, this.pluginConfig));
        entitySpawners.add(new EndermanSpawner(this, this.pluginConfig));
        entitySpawners.add(new SkeletonSpawner(this, this.pluginConfig));
        entitySpawners.add(new SpiderSpawner(this, this.pluginConfig));
        entitySpawners.add(new WolfSpawner(this, this.pluginConfig));
        entitySpawners.add(new ZombieSpawner(this, this.pluginConfig));*/
        return false;
    }
}
