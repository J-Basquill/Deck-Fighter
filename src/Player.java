import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    protected String name;
    protected int hp;
    protected ArrayList<Card> hand;
    protected ArrayList<Card> discard;
    protected int mod;

    Player(String pName){
        this.setName(pName);
        this.setHp(50);
        this.setHand();
        this.setDiscard();
        this.setMod(1);
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public void setHand() {
        this.hand = new ArrayList<Card>();
        this.hand.add(new AttackCard());
        this.hand.add(new AttackCard());
        this.hand.add(new HealCard());
        this.hand.add(new BoostCard());
    }
    public void setDiscard() {
        this.discard = new ArrayList<Card>();
    }
    public void setMod(int mod) {
        this.mod = mod;
    }

    public String getName() {
        return name;
    }
    public int getHp() {
        return hp;
    }
    public int getMod() {
        return mod;
    }
    public ArrayList<Card> getHand() {
        return hand;
    }
    public ArrayList<Card> getDiscard() {
        return discard;
    }

    public void printStatus(){
        System.out.println(this.getName()+" ["+this.getHp()+"] Mod: "+this.getMod());
    }
    public void printHand(){
        System.out.print("Hand: ");
        for(Card c: getHand()){
            System.out.print(c.getName()+"\t");
        }
        System.out.println("");
    }
    public void printDiscard(){
        System.out.print("Discard: ");
        for(Card c: getDiscard()){
            System.out.print(c.getName()+"\t");
        }
        System.out.println("");
    }

    public boolean isDead(){
        return this.getHp()<=0;
    }
    public boolean handIsEmpty(){
        return this.getHand().size()<=0;
    }

    public void playerTurn(Horde h, Player p){
        p.printStatus();
        h.printHorde();
        p.printOptions();
        p.useCard(new Scanner(System.in).nextInt(), h, p);
        if(this.handIsEmpty())
            this.reshuffle();
    }

    public void printOptions(){
        for(Card c: getHand()){
            System.out.print("Press "+getHand().indexOf(c)+" for "+c.getName()+"\n");
        }
    }
    public void useCard(int index, Horde h, Player p){
        getHand().get(index).playCard(h, p);
        if(this.getHand().get(index) instanceof BoostCard)
            this.getHand().remove(index);
        else
            this.discard(getHand().get(index));
    }
    public void discard(Card c){
        this.discard.add(c);
        this.hand.remove(c);
    }
    public void reshuffle(){
        this.hand.addAll(discard);
        this.discard.clear();
    }
}
