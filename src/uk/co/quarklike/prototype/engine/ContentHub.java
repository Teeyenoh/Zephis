package uk.co.quarklike.prototype.engine;

import java.util.ArrayList;

import uk.co.quarklike.prototype.engine.gamestate.GameState;
import uk.co.quarklike.prototype.engine.gui.windows.GUIWindow;
import uk.co.quarklike.prototype.map.Map;
import uk.co.quarklike.prototype.map.entity.Entity;

public class ContentHub {
	private ResourceManager resources;

	private int windowWidth, windowHeight;

	private Map mapToDraw;
	private Entity camera;
	private boolean drawMap;
	
	private GameState newState;

	private ArrayList<GUIWindow> gui = new ArrayList<GUIWindow>();

	// Temp
	public int slot;
	public int texture;

	public ResourceManager getResources() {
		return resources;
	}

	public Map getMapToDraw() {
		return mapToDraw;
	}

	public Entity getCamera() {
		return camera;
	}

	public int getWindowWidth() {
		return windowWidth;
	}

	public int getWindowHeight() {
		return windowHeight;
	}

	public boolean drawMap() {
		return this.drawMap;
	}

	public void setResources(ResourceManager m_resource) {
		this.resources = m_resource;
	}

	public void setMapToDraw(Map map) {
		this.mapToDraw = map;
	}

	public void setDrawMap(boolean draw) {
		this.drawMap = draw;
	}

	public void setCamera(Entity camera) {
		this.camera = camera;
	}

	public void setWindowWidth(int width) {
		this.windowWidth = width;
	}

	public void setWindowHeight(int height) {
		this.windowHeight = height;
	}

	public ArrayList<GUIWindow> getGUI() {
		return gui;
	}

	public void addGUI(GUIWindow gui) {
		this.gui.add(gui);
	}

	public GameState getNewState() {
		return newState;
	}

	public void setNewState(GameState newState) {
		this.newState = newState;
	}
}
