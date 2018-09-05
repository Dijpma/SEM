package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.PacMan;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = PacMan.WIDTH;
		config.height = PacMan.HEIGHT;
		config.title = "PokéMan";
		new LwjglApplication(new PacMan(), config);
	}
}
