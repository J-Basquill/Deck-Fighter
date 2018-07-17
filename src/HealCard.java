public class HealCard extends Card {
    HealCard(){
        this.setName("Heal");
        this.setMagnitude(15);
        this.setText("Nothing like some good old fashioned milk");
    }

    public void playCard(Horde h, Player p) {
        System.out.println(this.getText());
        p.setHp(p.getHp()+(this.getMagnitude()*p.getMod()));
        p.setMod(1);
        System.out.println("Your HP is "+p.getHp());
    }
}
