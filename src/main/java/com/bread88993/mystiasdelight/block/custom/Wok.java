package com.bread88993.mystiasdelight.block.custom;

import com.bread88993.mystiasdelight.block.entity.ModBlockEntities;
import com.bread88993.mystiasdelight.block.entity.custom.SteamerBlockEntity;
import com.bread88993.mystiasdelight.block.entity.custom.WokBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.registry.ModParticleTypes;
import vectorwing.farmersdelight.common.registry.ModSounds;

import java.util.Random;

public class Wok extends BaseEntityBlock {
    public static final DirectionProperty FACINGC = BlockStateProperties.HORIZONTAL_FACING;

    //public Barbecuenet(Properties properties){
    //    super(properties);
    //}


    private static final VoxelShape TOPX =  Block.box(2, 0, 2, 14, 0.6, 14);
    private static final VoxelShape TOPZ =  Block.box(2, 0, 2, 14, 0.6, 14);
    private static final VoxelShape BIAN1X =  Block.box(2, 0, 2, 2.6, 5, 14);
    private static final VoxelShape BIAN1Z =  Block.box(2, 0, 2, 14, 5, 2.6);
    private static final VoxelShape BIAN2X =  Block.box(13.4, 0, 2, 14, 5, 14);
    private static final VoxelShape BIAN2Z =  Block.box(2, 0, 13.4, 14, 5, 14);
    private static final VoxelShape BIAN3X =  Block.box(2, 0, 2, 14, 5, 2.6);
    private static final VoxelShape BIAN3Z =  Block.box(2, 0, 2, 2.6, 5, 14);
    private static final VoxelShape BIAN4X =  Block.box(2, 0, 13.4, 14, 5, 14);
    private static final VoxelShape BIAN4Z =  Block.box(13.4, 0, 2, 14, 5, 14);

    private static final VoxelShape X_AXIS_AABBCC = Shapes.or(TOPX,BIAN1X,BIAN2X,BIAN3X,BIAN4X);
    private static final VoxelShape Z_AXIS_AABBCC = Shapes.or(TOPZ,BIAN1Z,BIAN2Z,BIAN3Z,BIAN4Z);

    //@Override
    // public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
    //     return SHAPE;
    //}

    public Wok(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACINGC, Direction.NORTH));
    }



    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACINGC, pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACINGC, pRotation.rotate(pState.getValue(FACINGC)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACINGC);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        Direction direction = pState.getValue(FACINGC);
        return direction.getAxis() == Direction.Axis.Z ? X_AXIS_AABBCC : Z_AXIS_AABBCC;
    }


    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        if (pState.getBlock() != pNewState.getBlock()) {
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if (blockEntity instanceof WokBlockEntity) {
                ((WokBlockEntity) blockEntity).drops();
            }
        }
        super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos,
                                 Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (!pLevel.isClientSide()) {
            BlockEntity entity = pLevel.getBlockEntity(pPos);
            if(entity instanceof WokBlockEntity) {
                NetworkHooks.openScreen(((ServerPlayer)pPlayer), (WokBlockEntity)entity, pPos);
            } else {
                throw new IllegalStateException("Our Container provider is missing!");
            }
        }

        return InteractionResult.sidedSuccess(pLevel.isClientSide());
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new WokBlockEntity(pPos, pState);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntity) {
        if (level.isClientSide) {
            return createTickerHelper(blockEntity, ModBlockEntities.WOK_BLOCK_ENTITY.get(), WokBlockEntity::animateTick);
        }
        return createTickerHelper(blockEntity, ModBlockEntities.WOK_BLOCK_ENTITY.get(), WokBlockEntity::cookingTick);
    }
}
