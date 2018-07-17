import java.util.ArrayList;

public class Horde {
    protected ArrayList<Enemy> enemies;
    protected int wins;

    Horde(){
        setEnemies();
    }

    public void setEnemies() {
        this.enemies = new ArrayList<Enemy>();
    }
    public void setWins(int wins) {
        this.wins = 0;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }
    public int getWins() {
        return wins;
    }

    public int size(){
        return this.getEnemies().size();
    }
    public void printHorde(){
        for(Enemy e: this.getEnemies()){
            System.out.print(e.getName()+" ["+e.getHp()+"]\t");
        }System.out.println();
    }
    public boolean isEmpty(){
        if(this.size()<=0)
            return true;
        else
            return false;
    }
    public void remove(Enemy e){
        this.getEnemies().remove(e);
        if(this.isEmpty()){
            System.out.println("You win the day");
        }

    }


    public void chooseTarget(){
        for(Enemy e: this.getEnemies()){
            System.out.println("Press "+ getEnemies().indexOf(e)+" for "+e.getName()+" ["+e.getHp()+"]");
        }
    }
    public void hordeTurn(Player p){
        for(Enemy e: this.getEnemies()){
            e.attack(p);
        }
        if(p.isDead()){
            System.out.println("You have failed. Humanity is doomed.");
        }
    }
}
