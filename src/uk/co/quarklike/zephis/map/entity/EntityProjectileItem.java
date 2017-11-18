package uk.co.quarklike.zephis.map.entity;

import uk.co.quarklike.zephis.engine.Physics;
import uk.co.quarklike.zephis.map.item.Item;
import uk.co.quarklike.zephis.map.item.ItemStack;

public class EntityProjectileItem extends EntityProjectile {
	private int itemID;

	public EntityProjectileItem(byte direction, int itemID) {
		super(Item.getItem(itemID).getName(), Item.getItem(itemID).getTexture(), direction, Physics.maxRange(15, 1f, 1.5f));
		this.itemID = itemID;
		this.inventory.addItem(itemID, (byte) 1);
	}

	@Override
	public void finish() {
		this.dropItem(new ItemStack(this.itemID, (byte) 1));
		super.finish();
	}

	@Override
	public short getTextureSlot() {
		return Item.getItem(itemID).getTextureSlot();
	}
}