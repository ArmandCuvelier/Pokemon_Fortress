package io.github.ArmandCuvelier.Pokemon_Fortress;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/** First screen of the application. Displayed after the application is created. */
public class FirstScreen implements Screen {
    private final Game game;
    private Texture img;
    private SpriteBatch batch;
    private int height = 576;
    private int width = 1024;
    
    // Initialise the game
    public FirstScreen(Game game) {
        this.game = game;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        img = new Texture(Gdx.files.internal("img/First_screen.png")); 
        resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    @Override
    public void render(float delta) {
        batch.begin();
        batch.draw(img, 0, 0, this.width, this.height);
        batch.end();
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
        img.dispose();
    }
}