public class Enemy {
    protected String name;
    protected int hp;
    protected int power;

    Enemy(){
       setName("Zombie");
       setHp(15);
       setPower(5);
    }
    Enemy(String eName, int eHp, int ePower){
        setName(eName);
        setHp(eHp);
        setPower(ePower);
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public void setPower(int power) {
        this.power = power;
    }

    public String getName() {
        return name;
    }
    public int getHp() {
        return hp;
    }
    public int getPower() {
        return power;
    }

    public boolean isDead(){
        return this.getHp()<=0;

    }

    public void attack(Player p){
        System.out.println(this.getName()+" attacks you for "+this.getPower());
        p.setHp(p.getHp()-this.getPower());
    }
}
