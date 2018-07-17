import java.util.Scanner;

public class AttackCard extends Card {
    AttackCard(){
        this.setName("Punch");
        this.setMagnitude(10);
        this.setText("POW!!!");
    }

    public boolean isAttack(){
        return true;
    }
    public void playCard(Horde h, Player p) {
        h.chooseTarget();
        Enemy e = h.getEnemies().get(new Scanner(System.in).nextInt());
        System.out.println(this.getText());
        e.setHp(e.getHp()-(this.getMagnitude()*p.getMod()));
        p.setMod(1);
        System.out.println("Enemy HP is now "+e.getHp());
        if(e.isDead())
            h.remove(e);
    }
}
