package com.asaru.tutorialmod.entity.custom;

import com.asaru.tutorialmod.TutorialMod;
import com.google.common.hash.Hashing;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.texture.DownloadingTexture;
import net.minecraft.client.renderer.texture.Texture;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.item.ArmorStandEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.HandSide;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.entity.PartEntity;
import net.minecraftforge.fml.loading.FMLPaths;


import javax.annotation.Nullable;
import java.io.File;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AndroidEntity extends MonsterEntity {
    public AndroidEntity(EntityType<? extends MonsterEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAtributes() {
        return MobEntity.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 20)
                .add(Attributes.MOVEMENT_SPEED, 0.2D)
                .add(Attributes.FOLLOW_RANGE, 20);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(5, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(6, new LookRandomlyGoal(this));

    }

    private static File getSkinCacheFolder() {
        Path configPath = FMLPaths.GAMEDIR.get();
        Path jsonPath = Paths.get(configPath.toAbsolutePath().toString(), "android/cache");
        return jsonPath.toFile();
    }

    public static File getSkinFolder() {
        Path configPath = FMLPaths.GAMEDIR.get();
        Path jsonPath = Paths.get(configPath.toAbsolutePath().toString(), "android/skins");
        if (!Files.exists(jsonPath)) {
            try {
                Files.createDirectory(jsonPath);
            }catch (Exception e){
                return null;
            }
        }
        return jsonPath.toFile();
    }

    public ResourceLocation getResourceLocation() {
        return loadSkin("https://www.minecraftskins.com/uploads/skins/2020/12/18/salted-craftedmovie-16090169.png", false);
    }

    private static ResourceLocation loadSkin(String urlStr, boolean thinArms) {
        String s = Hashing.sha1().hashUnencodedChars(urlStr).toString();
        getSkinFolder();

        ResourceLocation resourcelocation = new ResourceLocation("android:skin/" + s + ".png");
        Texture texture = Minecraft.getInstance().textureManager.getTexture(resourcelocation);
        if (texture == null) {
            File file1 = new File(getSkinCacheFolder(), s.length() > 2 ? s.substring(0, 2) : "xx");
            File file2 = new File(file1, s);
            URL url = null;
            try {
                url = new URL(urlStr);
                URLConnection urlConn = url.openConnection();
                urlConn.addRequestProperty("User-Agent", "Mozilla/4.76");
                urlStr = urlConn.getURL().toString();
            } catch (Exception e) {

            }
            DownloadingTexture downloadingtexture = new DownloadingTexture(file2, urlStr, DefaultPlayerSkin.getDefaultSkin(), !thinArms, () -> {
            });
            Minecraft.getInstance().textureManager.register(resourcelocation, downloadingtexture);
        }

        return resourcelocation;
    }
}
