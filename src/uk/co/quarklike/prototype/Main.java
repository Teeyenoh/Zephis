package uk.co.quarklike.prototype;

import java.util.Random;

import org.lwjgl.Sys;

import uk.co.quarklike.prototype.engine.*;

public class Main implements Runnable {
	public static final boolean DEBUG = true;//Boolean.valueOf(System.getenv("DEBUG"));
	public static final String TITLE = "Zephis v0.5.0-alpha";

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
		Log.info("Initialising " + TITLE);

		rand = new Random();

		contentHub = new ContentHub();

		m_resource = new ResourceManager();
		m_graphics = new GraphicsManager();
		m_game = new GameManager();

		long time = 0;

		Log.info("Pre-Init...");
		time = Sys.getTime();
		m_resource.preInit(contentHub);
		m_graphics.preInit(contentHub);
		m_game.preInit(contentHub);
		Log.info("Done: " + (Sys.getTime() - time));

		Log.info("Init...");
		time = Sys.getTime();
		m_resource.init();
		m_graphics.init();
		m_game.init();
		Log.info("Done: " + (Sys.getTime() - time));

		Log.info("Post-Init...");
		time = Sys.getTime();
		m_resource.postInit();
		m_graphics.postInit();
		m_game.postInit();
		Log.info("Done: " + (Sys.getTime() - time));
	}

	public void update() {
		currentManager = m_game;
		m_game.update();
		currentManager = m_resource;
		m_resource.update();
		currentManager = m_graphics;
		m_graphics.update();
	}

	public void deinit() {
		m_game.deinit();
		m_graphics.deinit();
		m_resource.deinit();
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
