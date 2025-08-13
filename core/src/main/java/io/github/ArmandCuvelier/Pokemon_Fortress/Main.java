package io.github.ArmandCuvelier.Pokemon_Fortress;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class Main extends Game {
    @Override
    public void create() {
        Gdx.graphics.setWindowedMode(1024, 576);
        setScreen(new FirstScreen(this));
    }
}