package io.github.ArmandCuvelier.Pokemon_Fortress;

public class Pokemon {
    private String name;
    private String type1;
    private String type2;
    private int hp;
    private int atq;
    private int def;

    public Pokemon(String name, String type1, String type2, int hp, int atq, int def) {
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.hp = hp;
        this.atq = atq;
        this.def = def;
    }

    public String getName(){
        return this.name;
    }

    public String[] getType(){
        return new String[] { this.type1, this.type2 };
    }

    public int[] getStats(){
        return new int[] {this.hp,this.atq,this.def};
    }
}
