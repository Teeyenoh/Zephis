package uk.co.quarklike.prototype.engine.gui.windows;

import java.util.ArrayList;

import uk.co.quarklike.prototype.engine.RenderEngine;
import uk.co.quarklike.prototype.engine.gui.GUIComponent;

public abstract class GUIWindow {
	protected int x, y, width, height;
	protected ArrayList<GUIComponent> comps = new ArrayList<GUIComponent>();

	public void draw(RenderEngine renderEngine) {
		for (GUIComponent gui : comps) {
			gui.draw(renderEngine);
		}
	}

	protected void addComponent(GUIComponent c) {
		comps.add(c);
	}
}