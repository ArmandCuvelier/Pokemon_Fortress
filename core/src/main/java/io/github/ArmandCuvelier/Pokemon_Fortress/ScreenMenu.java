package io.github.ArmandCuvelier.Pokemon_Fortress;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

public class ScreenMenu implements Screen {
    private final Game game;
    private int height = 576;
    private int width = 1024;

    public ScreenMenu(Game game){
        this.game=game;
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.4196f, 0f, 0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
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
