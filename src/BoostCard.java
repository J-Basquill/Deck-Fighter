public class BoostCard extends Card {
    BoostCard(){
        this.setName("Boost");
        this.setMagnitude(4);
        this.setText("I have one shot");
    }

    @Override
    public void playCard(Horde h, Player p) {
        p.setMod(this.magnitude);
        System.out.println(this.getText());
    }
}
