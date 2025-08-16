package io.github.ArmandCuvelier.Pokemon_Fortress;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ScreenMenu implements Screen {
    /*attribute game */
    private final Game game;

    /* attribute for the width of the screen */
    private int height = 576;
    private int width = 1024;

    /* attribute for the picture of the screen */
    private SpriteBatch background;
    private Texture world1;
    private Texture world2;
    private Texture world3;
    private Texture world4;
    private Texture world5;
    private Texture world6;
    private Texture world7;
    private Texture world8;
    private int height_world1;
    private int height_world2;
    private int width_world1;
    private int width_world2;
    private int width_world3;
    private int width_world4;

    public ScreenMenu(Game game){
        this.game=game;
    }

    @Override
    public void show() {
        // Initialisation of the background and images of the screen
        background = new SpriteBatch();
        world1 = new Texture(Gdx.files.internal("img/World1.png"));
        world2 = new Texture(Gdx.files.internal("img/World2.png"));
        world3 = new Texture(Gdx.files.internal("img/World3.png"));
        world4 = new Texture(Gdx.files.internal("img/World4.png"));
        world5 = new Texture(Gdx.files.internal("img/World5.png"));
        world6 = new Texture(Gdx.files.internal("img/World6.png"));
        world7 = new Texture(Gdx.files.internal("img/World7.png"));
        world8 = new Texture(Gdx.files.internal("img/World8.png"));


        // Initialisation of the width and height of the 8 world
        height_world1 = (int) (Gdx.graphics.getHeight()/2 - (Gdx.graphics.getHeight()/2*0.01));
        height_world2 = (int) (Gdx.graphics.getHeight()/2*0.2);
        width_world1 = (int) ((Gdx.graphics.getWidth()) - (Gdx.graphics.getWidth()*0.9));
        width_world2 = (int) ((Gdx.graphics.getWidth()) - (Gdx.graphics.getWidth()*0.7));
        width_world3 = (int) ((Gdx.graphics.getWidth()) - (Gdx.graphics.getWidth()*0.5));
        width_world4 = (int) ((Gdx.graphics.getWidth()) - (Gdx.graphics.getWidth()*0.3));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.4196f, 0f, 0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        background.begin();
        background.draw(world1, width_world1, height_world1, 200, 200);
        background.draw(world2, width_world2, height_world1, 200, 200);
        background.draw(world3, width_world3, height_world1, 200, 200);
        background.draw(world4, width_world4, height_world1, 200, 200);
        background.draw(world5, width_world1, height_world2, 200, 200);
        background.draw(world6, width_world2, height_world2, 200, 200);
        background.draw(world7, width_world3, height_world2, 200, 200);
        background.draw(world8, width_world4, height_world2, 200, 200);
        background.end();
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
    }
}
