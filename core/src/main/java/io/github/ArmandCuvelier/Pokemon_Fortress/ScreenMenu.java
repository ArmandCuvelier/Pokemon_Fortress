package io.github.ArmandCuvelier.Pokemon_Fortress;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class ScreenMenu implements Screen {

    private final Game game;
    private SpriteBatch batch;
    private int height = 576;
    private int width = 1024;

    // The world
    private Texture world1, world2, world3, world4, world5, world6, world7, world8;

    // The button
    private Rectangle r1, r2, r3, r4, r5, r6, r7, r8;

    // The x and y of the 8 world
    private int y_world1, y_world2;
    private int x_world1, x_world2, x_world3, x_world4;

    // The width and height of the 8 world
    private int width_world;
    private int height_world;

    public ScreenMenu(Game game) {
        this.game = game;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();

        // Definition of the texture
        world1 = new Texture("img/World1.png");
        world2 = new Texture("img/World2.png");
        world3 = new Texture("img/World3.png");
        world4 = new Texture("img/World4.png");
        world5 = new Texture("img/World5.png");
        world6 = new Texture("img/World6.png");
        world7 = new Texture("img/World7.png");
        world8 = new Texture("img/World8.png");

        // Initialisation of the x and y of the world
        y_world1 = (int) (Gdx.graphics.getHeight()/2 - (Gdx.graphics.getHeight()/2*0.01));
        y_world2 = (int) (Gdx.graphics.getHeight()/2*0.2);
        x_world1 = (int) ((Gdx.graphics.getWidth()) - (Gdx.graphics.getWidth()*0.9));
        x_world2 = (int) ((Gdx.graphics.getWidth()) - (Gdx.graphics.getWidth()*0.7));
        x_world3 = (int) ((Gdx.graphics.getWidth()) - (Gdx.graphics.getWidth()*0.5));
        x_world4 = (int) ((Gdx.graphics.getWidth()) - (Gdx.graphics.getWidth()*0.3));

        // Initialisation of the width and height of the world
        width_world = (int)(Gdx.graphics.getWidth()/5);
        height_world = (int)(Gdx.graphics.getHeight()*0.35);

        // Creation of the button with the texture of the world
        r1 = new Rectangle(x_world1, y_world1, width_world, height_world);
        r2 = new Rectangle(x_world2, y_world1, width_world, height_world);
        r3 = new Rectangle(x_world3, y_world1, width_world, height_world);
        r4 = new Rectangle(x_world4, y_world1, width_world, height_world);
        r5 = new Rectangle(x_world1, y_world2, width_world, height_world);
        r6 = new Rectangle(x_world2, y_world2, width_world, height_world);
        r7 = new Rectangle(x_world3, y_world2, width_world, height_world);
        r8 = new Rectangle(x_world4, y_world2, width_world, height_world);
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0.4196f, 0f, 0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(world1, r1.x, r1.y, r1.width, r1.height);
        batch.draw(world2, r2.x, r2.y, r2.width, r2.height);
        batch.draw(world3, r3.x, r3.y, r3.width, r3.height);
        batch.draw(world4, r4.x, r4.y, r4.width, r4.height);
        batch.draw(world5, r5.x, r5.y, r5.width, r5.height);
        batch.draw(world6, r6.x, r6.y, r6.width, r6.height);
        batch.draw(world7, r7.x, r7.y, r7.width, r7.height);
        batch.draw(world8, r8.x, r8.y, r8.width, r8.height);
        batch.end();

        // Détection of the clicks
        if(Gdx.input.justTouched()) {
            float mouseX = Gdx.input.getX();
            float mouseY = Gdx.graphics.getHeight() - Gdx.input.getY();
            if(r1.contains(mouseX, mouseY)) onWorld1Clicked();
            if(r2.contains(mouseX, mouseY)) onWorld2Clicked();
            if(r3.contains(mouseX, mouseY)) onWorld3Clicked();
            if(r4.contains(mouseX, mouseY)) onWorld4Clicked();
            if(r5.contains(mouseX, mouseY)) onWorld5Clicked();
            if(r6.contains(mouseX, mouseY)) onWorld6Clicked();
            if(r7.contains(mouseX, mouseY)) onWorld7Clicked();
            if(r8.contains(mouseX, mouseY)) onWorld8Clicked();
        }
    }

    private void onWorld1Clicked() {
        game.setScreen(new WorldScreen(game, new float[] {0.3f, 0.3f, 0.25f, 1f}));
    }

    private void onWorld2Clicked() {

    }

    private void onWorld3Clicked() {

    }

    private void onWorld4Clicked() {

    }

    private void onWorld5Clicked() {

    }

    private void onWorld6Clicked() {

    }

    private void onWorld7Clicked() {

    }

    private void onWorld8Clicked() {

    }

    @Override
    public void resize(int width, int height) {
        if(width <= 0 || height <= 0) return;
        
        float targetRatio = 1024f/576f;
        float currentRatio = width/(float)height;
        if(currentRatio > targetRatio) {
            this.width = (int)(height * targetRatio);
            this.height = height;
        } else {
            this.width = width;
            this.height = (int)(width / targetRatio);
        }
        Gdx.gl.glViewport(
            (width - this.width)/2,
            (height - this.height)/2,
            this.width,
            this.height
        );
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
        world1.dispose();
        world2.dispose();
        world3.dispose();
        world4.dispose();
        world5.dispose();
        world6.dispose();
        world7.dispose();
        world8.dispose();
    }
}
