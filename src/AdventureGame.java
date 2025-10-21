import javax.swing.*;
import java.util.Scanner;

class Game{
    private Player player;
    private Location location;

    public void start(){
        System.out.println("Starting game");
    }
    public Player getPlayer(){
        return player;
    }
    public void setPlayer(Player player){
        this.player = player;
    }
}
class Player{
    private Inventory inventory;
    private int damage;
    private int health;
    private int money;
    private String name;

    public Player(String name){
        this.name = name;
        this.damage = 5;
        this.health = 100;
        this.money = 20;
        this.inventory = new Inventory();
    }

    public void selectChar(){
        System.out.println("Select character");
    }
    public String getName(){
        return name;
    }

    public int getHealth() {
        return health;
    }
    public int getDamage() {
        return damage;
    }
    public int getMoney(){
        return  money;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
    public void setMoney(int money) {
        this.money = money;
    }
    public void setHealth(int health) {
        this.health = health;
    }
}

class Inventory{
    private boolean water;
    private boolean food;
    private boolean firewood;
    private String weaponName;
    private String armorName;
    private int weaponDamage;
    private int armorDefence;

    public Inventory(){
        this.water = false;
        this.food = false;
        this.firewood = false;
        this.weaponName = "Fist";
        this.armorName = "None";
        this.weaponDamage = 0;
        this.armorDefence = 0;

    }
    public boolean hasWater(){
        return water;
    }
    public boolean hasFood(){
        return food;
    }
    public boolean hasFireWood(){
        return firewood;
    }
    public String getWeaponName(){
        return weaponName;
    }
    public String getArmorName(){
        return armorName;
    }
    public int getWeaponDamage(){
        return weaponDamage;
    }
    public int getArmorDefence(){
        return armorDefence;
    }
    public void setWater(boolean water){
        this.water = water;
    }
    public void setFood(boolean food){
        this.food = food;
    }
    public void setFirewood(boolean firewood){
        this.firewood = firewood;
    }
    public void setWeaponName(String weaponName){
        this.weaponName = weaponName;
    }
    public void setArmorName(String armorName){
        this.armorName = armorName;
    }
    public void setWeaponDamage(int weaponDamage){
        this.weaponName = weaponName;
    }
    public void setArmorDefence(int armorDefence){
        this.armorDefence = armorDefence;
    }
}
abstract class Location {
    protected Player player;
    protected String name;

    public Location(Player player,String name){
        this.player = player;
        this.name  = name;
    }
    public abstract boolean onLocation();

    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
abstract class NormalLoc extends Location{

    public NormalLoc(Player player,String name){
        super(player,name);
    }
    @Override
    public abstract boolean onLocation();
}
abstract class BattleLoc extends Location{
    protected Obstacle obstacle;

    public BattleLoc(Player player,String name,Obstacle obstacle){
        super(player,name);
        this.obstacle = obstacle;
    }
    @Override
    public abstract boolean onLocation();

    public abstract void combat();
    public Obstacle getObstacle(){
        return obstacle;
    }
    public void setObstacle (Obstacle obstacle){
        this.obstacle = obstacle;
    }
}
class River extends BattleLoc{
    public River(Player player){
        super(player,"River",new Bear());
    }

    @Override
    public boolean onLocation(){
        System.out.println("You are at the river");
        return true;
    }
    @Override
    public void combat() {
        System.out.println("Combat with a Bear");
    }
}
class Cave extends BattleLoc{
    public Cave(Player player){
        super(player,"Cave",new Zombie());
    }

    @Override
    public boolean onLocation(){
        System.out.println("You are at the cave");
        return true;
    }
    @Override
    public void combat() {
        System.out.println("Combat with a Zombie");
    }
}
class Forest extends BattleLoc{
    public Forest(Player player){
        super(player,"Forest",new Vampire());
    }
    @Override
    public boolean onLocation(){
        System.out.println("You are at the forest");
        return false;
    }
    @Override
    public void combat() {
        System.out.println("Combat with a Vampire");
    }
}
class Obstacle{
    private String name;
    private int damage;
    private int health;

    public Obstacle(String name,int damage,int health){
        this.name = name;
        this.damage = damage;
        this.health = health;
    }
    public String getName() {
        return name;
    }
    public int getDamage() {
        return damage;
    }
    public int getHealth() {
        return health;
    }
    public void  setHealth(int health){
        this.health = health;
    }

}
class SafeHouse extends NormalLoc{
public SafeHouse(Player player){
super(player,"SafeHouse");
}
@Override
public boolean onLocation(){
    System.out.println("You are at the safehouse");
    System.out.println("Your health is fully restored!");


    player.setHealth(100);
    return true;
}
}
class Toolstore extends NormalLoc{
    public Toolstore(Player player){
        super(player,"Toolstore");
    }
   @Override
    public boolean onLocation(){
       System.out.println("Welcolme to the Toolstore");
        menu();
       return true;
   }
   public void menu(){
        Scanner input = new Scanner(System.in);
        int select;


       System.out.println("Select an option");
       System.out.println("1-Weapons");
       System.out.println("2-Armors");
       System.out.println("3-Exit");
      select = input.nextInt();

      switch(select){
          case 1:
              showWeapons();
              break;
              case 2:
                  showArmors();
                  break;
                  case 3:
                      System.out.println("Leaving the store...");
                      break;
          default:
              System.out.println("Invalid option");
              break;
      }
   }
   public void showWeapons(){

        System.out.println("Available Weapons:");
       System.out.println("1 - Sword (Damage +3, Price 25)");
       System.out.println("2 - Rifle (Damage +7, Price 45)");
       System.out.println("3 - Shotgun (Damage +10, Price 70)");

   }
   public void showArmors(){
       System.out.println("Available Armors:");
       System.out.println("1 - Light Armor (Defence +2, Price 15)");
       System.out.println("2 - Medium Armor (Defence +5, Price 25)");
       System.out.println("3 - Heavy Armor (Defence +8, Price 40)");

   }
}
class Bear extends Obstacle {
    public Bear() {
        super("Bear", 7, 20);
    }
}

class Vampire extends Obstacle {
    public Vampire() {
        super("Vampire", 4, 14);
    }
}

class Zombie extends Obstacle {
    public Zombie() {
        super("Zombie", 3, 10);
    }
}





public class AdventureGame {
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}
