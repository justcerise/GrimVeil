package net.grimveil.entity.custom;

import net.minecraft.entity.AnimationState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;
import net.grimveil.entity.ai.RandomAttackGoal;
import net.grimveil.sound.ModSounds;
import org.jetbrains.annotations.Nullable;

public class ShadeEntity extends HostileEntity {
    private static final TrackedData<Boolean> ATTACKING =
            DataTracker.registerData(ShadeEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    public final AnimationState attackAnimationState = new AnimationState();
    private int attackAnimationTimeout = 0;

    private RandomAttackGoal attackGoal;
    private boolean hostile = false;
    private int hostilityTimer = 0;
    private Entity attackTarget;

    private static final TrackedData<Integer> DATA_ID_TYPE_VARIANT =
            DataTracker.registerData(ShadeEntity.class, TrackedDataHandlerRegistry.INTEGER);

    public ShadeEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new WanderAroundFarGoal(this, 1.2));
        this.goalSelector.add(2, new LookAtEntityGoal(this, PlayerEntity.class, 12f));
        this.goalSelector.add(3, new LookAroundGoal(this));
    }

    public static DefaultAttributeContainer.Builder createAttributes(){
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.MAX_HEALTH, 25)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.2)
                .add(EntityAttributes.FOLLOW_RANGE, 16)
                .add(EntityAttributes.ATTACK_DAMAGE, 4);
    }

    private void setupAnimationStates(){
        if (isAttacking() && attackTarget != null && attackTarget.isAlive() &&
                this.squaredDistanceTo(attackTarget) <= 4*4) {
            idleAnimationState.stop();
            if (!attackAnimationState.isRunning()){
                attackAnimationState.start(this.age);
            }
            attackAnimationTimeout--;
            if (attackAnimationTimeout <= 0){
                this.dataTracker.set(ATTACKING, false);
                attackTarget = null;
            }
        } else{
            attackAnimationState.stop();
            this.dataTracker.set(ATTACKING, false);
            attackTarget = null;

            if (!idleAnimationState.isRunning()){
                idleAnimationState.start(this.age);
            }
        }
    }

    @Override
    public void tick(){
        super.tick();
        if (this.getWorld().isClient()){
            this.setupAnimationStates();
        }

        if (!hostile){
            if (this.getWorld().getClosestPlayer(this, 6) != null && this.random.nextInt(200) == 0){
                becomeHostile();
                //screamAnimationState.startIfNotRunning(this.age);
            }
        } else {
            hostilityTimer ++;
            if (hostilityTimer > 200){
                calmDown();
                this.dataTracker.set(ATTACKING, false);
            }
        }
    }

    private void becomeHostile(){
        this.hostile = true;
        this.hostilityTimer = 0;
        this.playSound(ModSounds.ENTITY_SHADE_SCREAM, 1f, 1f);
        attackGoal = new RandomAttackGoal(this,16);
        this.goalSelector.add(0, attackGoal);
    }
    private void calmDown(){
        this.hostile = false;
        if (attackGoal != null) this.goalSelector.remove(attackGoal);
    }

    @Override
    public boolean tryAttack(ServerWorld world, Entity target){
        boolean success = super.tryAttack(world, target);
        if (success){
            this.dataTracker.set(ATTACKING, true);
            attackAnimationTimeout = 20;
            attackTarget = target;

        }
        return success;
    }
    //Will come back to the 'attack' animations at a later date
    //Don't forget them future jc

    public void setAttacking(boolean attacking){
        this.dataTracker.set(ATTACKING, attacking);
    }

    @Override
    public boolean isAttacking() {
        return this.dataTracker.get(ATTACKING);
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder){
        super.initDataTracker(builder);
        builder.add(DATA_ID_TYPE_VARIANT, 0);
        builder.add(ATTACKING, false);
    }

    public ShadeVariant getVariant(){
        return ShadeVariant.byId(this.getTypeVariant() & 255);
    }
    private int getTypeVariant() {
        return this.dataTracker.get(DATA_ID_TYPE_VARIANT);
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.ENTITY_SHADE_AMBIENT;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.ENTITY_SHADE_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.ENTITY_SHADE_HURT;
    }
}