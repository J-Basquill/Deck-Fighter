abstract public class Card {
    protected String name;
    protected int magnitude;
    protected String text;

    public void setName(String name) {
        this.name = name;
    }
    public void setMagnitude(int magnitude) {
        this.magnitude = magnitude;
    }
    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }
    public int getMagnitude() {
        return magnitude;
    }
    public String getText() {
        return text;
    }

    public void playCard(Horde h, Player p){}
    public void playCard(Player p){}
    public boolean isAttack(){
        return false;
    }
}
