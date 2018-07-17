import java.util.Scanner;

public class Fight {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter character name...");
        Player p1 = new Player(sc.nextLine());
        System.out.println("\nWelcome to the fight "+p1.getName());
        Horde horde = new Horde();
        generateEncounter(horde, 2);
        horde.printHorde();
        while(!p1.isDead()&&!horde.isEmpty()){
            System.out.println("What do you do");
            p1.playerTurn(horde, p1);
            horde.hordeTurn(p1);

        }
    }

    public static void generateEncounter(Horde h, int num){

        for(int i=0;i<num;i++){
            h.getEnemies().add(new Enemy());
        }
        h.getEnemies().add(new Enemy("Monstrosity", 40, 15));
        System.out.println("Watch out! Some Zombies appeared");
    }
}
