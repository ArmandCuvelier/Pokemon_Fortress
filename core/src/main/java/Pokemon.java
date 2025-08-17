public class Pokemon {
    private char name;
    private char type1;
    private char type2;
    private int hp;
    private int atq;
    private int def;

    public char getName(){
        return this.name;
    }

    public char[] getType(){
        return new char[] { this.type1, this.type2 };
    }

    public int[] getStats(){
        return new int[] {this.hp,this.atq,this.def};
    }
}
