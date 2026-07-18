package com.schrottii.fisecraft.entity;

import com.schrottii.fisecraft.entity.custom.RootguardianEntity;
import com.schrottii.fisecraft.ModSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.sounds.SoundSource;

public class RootguardianMusic extends AbstractTickableSoundInstance {
    private final RootguardianEntity Bossentity;
    private int ticksExisted = 0;

    public RootguardianMusic(RootguardianEntity bossentity) {
        super(ModSounds.BOSS_MUSIC.get(), SoundSource.RECORDS);
        this.Bossentity = bossentity;
        this.attenuation = SoundInstance.Attenuation.NONE;
        this.looping = true;
        this.delay = 0;
        this.x = this.Bossentity.getX();
        this.y = this.Bossentity.getY();
        this.z = this.Bossentity.getZ();
    }

    public boolean shouldPlaySound() {
        return !this.Bossentity.isSilent();
    }

    public void tick() {
        if(ticksExisted % 100 == 0){
            Minecraft.getInstance().getMusicManager().stopPlaying();

        }
        if (!this.Bossentity.isRemoved() && this.Bossentity.isAlive()) {
            this.volume = 0.5f;
            this.pitch = 1;
            this.x = this.Bossentity.getX();
            this.y = this.Bossentity.getY();
            this.z = this.Bossentity.getZ();
        } else {
            this.stop();

            //Level level = Bossentity.getLevel();
        }
        ticksExisted++;
    }

}