package io.github.ArmandCuvelier.Pokemon_Fortress;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class WorldScreen implements Screen {

    private final Game game ;
    private SpriteBatch batch;
    private float[] color;
    private int height = 576;
    private int width = 1024;

    // The level and their way to connect
    private Texture level1,level2,level3,level4,way1,way2,way3;

    // The level and their way to 
    private Rectangle r1, r2, r3, r4;

    // The x and y of the level
    private int x_level1;
    private int x_level2;
    private int x_level3;
    private int x_level4;
    private int y_level1;
    private int y_level2;

    // The width and the height of the level
    private int width_level;
    private int height_level;

    public WorldScreen(Game game,float[] color_background) {
        this.game = game;
        this.color = color_background;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();

        // Definition of the texture
        level1 = new Texture("img/level.png");
        level2 = new Texture("img/level.png");
        level3 = new Texture("img/level.png");
        level4 = new Texture("img/level.png");
        way1 = new Texture("img/way_line.png");
        way2 = new Texture("img/way_diagonal_left.png");
        way3 = new Texture("img/way_diagonal_right.png");

        // Initalisation of the width and height of the level
        width_level = (int) (Gdx.graphics.getWidth()/5.68);
        height_level = (int)(Gdx.graphics.getHeight()/3.2);

        // Initialisation of the x and y of the level
        x_level1 = (int) (Gdx.graphics.getWidth()*0.1);
        x_level2 = (int) (Gdx.graphics.getWidth()*0.3);
        x_level3 = (int) (Gdx.graphics.getWidth()*0.5);
        x_level4 = (int) (Gdx.graphics.getWidth()*0.7);
        y_level1 = (int) (Gdx.graphics.getHeight()*0.45);
        y_level2 = (int) (Gdx.graphics.getHeight()*0.15);

        // Creation of the button with the texture of the level
        r1 = new Rectangle(x_level1, y_level1, width_level, height_level);
        r2 = new Rectangle(x_level2, y_level2, width_level, height_level);
        r3 = new Rectangle(x_level3, y_level1, width_level, height_level);
        r4 = new Rectangle(x_level4, y_level2, width_level, height_level);
    }


    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(color[0], color[1], color[2], color[3]);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(level1, r1.x, r1.y, r1.width, r1.height);
        batch.draw(level2, r2.x, r2.y, r2.width, r2.height);
        batch.draw(level3, r3.x, r3.y, r3.width, r3.height);
        batch.draw(level4, r4.x, r4.y, r4.width, r4.height);
        batch.end();

        // Détection of the clicks
        if(Gdx.input.justTouched()) {
            float mouseX = Gdx.input.getX();
            float mouseY = Gdx.graphics.getHeight() - Gdx.input.getY();
            if(r1.contains(mouseX, mouseY)) onLevel1Clicked();
            if(r2.contains(mouseX, mouseY)) onLevel2Clicked();
            if(r3.contains(mouseX, mouseY)) onLevel3Clicked();
            if(r4.contains(mouseX, mouseY)) onLevel4Clicked();
        }
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

    private void onLevel1Clicked() {

    }

    private void onLevel2Clicked() {

    }

    private void onLevel3Clicked() {

    }

    private void onLevel4Clicked() {

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
    }
}
