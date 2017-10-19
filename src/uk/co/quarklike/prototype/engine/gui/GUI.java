package uk.co.quarklike.prototype.engine.gui;

import uk.co.quarklike.prototype.engine.RenderEngine;

public abstract class GUI {
	protected int x, y, width, height;

	public GUI(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public abstract void draw(RenderEngine renderEngine);
}
