package uk.co.quarklike.prototype;

import java.util.Random;

import uk.co.quarklike.prototype.engine.*;

public class Main implements Runnable {
	public static final boolean DEBUG = Boolean.valueOf(System.getenv("DEBUG"));
	public static final String TITLE = "Zephis v0.5.1-alpha";

	public static Main instance;

	private Thread thread;
	private boolean running;

	private Random rand;
	private ContentHub contentHub;
	private GraphicsManager m_graphics;
	private ResourceManager m_resource;
	private GameManager m_game;

	private Manager currentManager;

	@Override
	public void run() {
		init();

		while (running) {
			update();
		}

		deinit();
	}

	public void init() {
		Log.initLog();
		Log.info("Initialising " + TITLE);

		rand = new Random();

		contentHub = new ContentHub();

		currentManager = m_resource;
		m_resource = new ResourceManager();
		currentManager = m_graphics;
		m_graphics = new GraphicsManager();
		currentManager = m_game;
		m_game = new GameManager();
		currentManager = null;

		currentManager = m_resource;
		m_resource.preInit(contentHub);
		currentManager = m_graphics;
		m_graphics.preInit(contentHub);
		currentManager = m_game;
		m_game.preInit(contentHub);
		currentManager = null;

		currentManager = m_resource;
		m_resource.init();
		currentManager = m_graphics;
		m_graphics.init();
		currentManager = m_game;
		m_game.init();
		currentManager = null;

		currentManager = m_resource;
		m_resource.postInit();
		currentManager = m_graphics;
		m_graphics.postInit();
		currentManager = m_game;
		m_game.postInit();
		currentManager = null;
	}

	public void update() {
		currentManager = m_game;
		m_game.update();
		currentManager = m_resource;
		m_resource.update();
		currentManager = m_graphics;
		m_graphics.update();
		currentManager = null;
	}

	public void deinit() {
		currentManager = m_game;
		m_game.deinit();
		currentManager = m_graphics;
		m_graphics.deinit();
		currentManager = m_resource;
		m_resource.deinit();
		currentManager = null;
		Log.deinitLog();
	}

	public Random getRand() {
		return rand;
	}

	public Manager getCurrentManager() {
		return currentManager;
	}

	public void start() {
		if (running)
			return;
		running = true;
		thread = new Thread(this, TITLE);
		thread.start();
	}

	public void stop() {
		if (!running)
			return;
		running = false;
		thread.interrupt();
	}

	public static final void main(String[] args) {
		instance = new Main();
		instance.start();
	}
}
