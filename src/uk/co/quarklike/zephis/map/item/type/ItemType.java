package uk.co.quarklike.zephis.map.item.type;

import uk.co.quarklike.zephis.map.Map;
import uk.co.quarklike.zephis.map.entity.EntityLiving;

public class ItemType {
	protected String useText;
	protected boolean useable;
	protected boolean isUsed;

	public ItemType() {
		this.useText = "GUI_WINDOW_INVENTORY_COMMAND_USE";
		this.useable = false;
	}
	
	public void use(Map map, EntityLiving user) {
		
	}

	public String getUseText() {
		return useText;
	}

	public boolean isUseable() {
		return useable;
	}
	
	public boolean isUsed() {
		return isUsed;
	}
}