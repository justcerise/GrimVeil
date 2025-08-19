package net.grimveil.entity.ai;

import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Box;
import net.grimveil.entity.custom.ShadeEntity;

import java.util.EnumSet;
import java.util.List;
import java.util.Random;

public class RandomAttackGoal extends Goal {
    private final ShadeEntity shade;
    private final double range;
    private final Random random = new Random();
    private PlayerEntity targetPlayer;

    public RandomAttackGoal(ShadeEntity shade, double range){
        this.shade = shade;
        this.range = range;
        this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
    }

    @Override
    public boolean canStart(){
        if (random.nextFloat() > 0.05f) return false;

        List<PlayerEntity> players = shade.getWorld().getEntitiesByClass(
                PlayerEntity.class,
                new Box(
                        shade.getX() - range, shade.getY() - range, shade.getZ() - range,
                        shade.getX() + range, shade.getY() + range, shade.getZ() + range
                ),
                p -> !p.isSpectator() && !p.isCreative()
        );
        if (players.isEmpty()) return false;

        targetPlayer = players.get(random.nextInt(players.size()));
        return true;
    }


    @Override
    public void tick(){
        if (targetPlayer == null || !targetPlayer.isAlive()) return;
        shade.getLookControl().lookAt(targetPlayer, 30f, 30f);

        if (shade.squaredDistanceTo(targetPlayer) > 4){
            shade.getNavigation().startMovingTo(targetPlayer, 1.5);
        } else {
            shade.tryAttack((ServerWorld) shade.getWorld(), targetPlayer);
        }
    }

    @Override
    public boolean shouldContinue(){
        return targetPlayer != null && targetPlayer.isAlive()
                && shade.squaredDistanceTo(targetPlayer) <= range * range;
    }

    @Override
    public void stop(){
        targetPlayer = null;
        shade.getNavigation().stop();
    }
}
