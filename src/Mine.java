class Mine extends BattleLoc {
    private int snakeCount;

    public Mine(Player player) {
        super(player, "Mine", new Snake());
        this.snakeCount = (int)(Math.random() * 5) + 1; // 1–5 arası yılan sayısı
    }

    @Override
    public boolean onLocation() {
        System.out.println("You entered the Mine. There are " + snakeCount + " snakes!");

        for (int i = snakeCount; i > 0; i--) {
            System.out.println("Snake " + i + " appeared!");
            combat();
            System.out.println("Snake defeated!");
            randomLoot();
        }

        System.out.println("You cleared the Mine!");
        return true;
    }

    @Override
    public void combat() {
        System.out.println("️ Fighting a Snake!");

    }


    private void randomLoot() {
        double chance = Math.random() * 100;

        if (chance < 15) { // %15 silah
            System.out.println("You found a weapon!");
            weaponLoot();
        } else if (chance < 30) { // %15 zırh
            System.out.println("You found armor!");
            armorLoot();
        } else if (chance < 55) { // %25 para
            System.out.println("You found some money!");
            moneyLoot();
        } else {
            System.out.println("You found nothing...");
        }
    }


    private void weaponLoot() {
        double chance = Math.random() * 100;

        if (chance < 20) {
            System.out.println("You found a Rifle! (Damage +7)");
            player.getInventory().setWeaponName("Rifle");
            player.setDamage(player.getDamage() + 7);
        } else if (chance < 50) {
            System.out.println("You found a Sword! (Damage +3)");
            player.getInventory().setWeaponName("Sword");
            player.setDamage(player.getDamage() + 3);
        } else {
            System.out.println("You found a Pistol! (Damage +2)");
            player.getInventory().setWeaponName("Pistol");
            player.setDamage(player.getDamage() + 2);
        }
    }


    private void armorLoot() {
        double chance = Math.random() * 100;

        if (chance < 20) {
            System.out.println("You found Heavy Armor! (Defense +8)");
            player.getInventory().setArmorName("Heavy Armor");
            player.getInventory().setArmorDefence(8);
        } else if (chance < 50) {
            System.out.println("You found Medium Armor! (Defense +5)");
            player.getInventory().setArmorName("Medium Armor");
            player.getInventory().setArmorDefence(5);
        }
        else{
            System.out.println("You found Light Armor! (Defense + 2)");
            player.getInventory().setArmorName("Light Armor");
            player.getInventory().setArmorDefence(2);

                 }
        }

        private void moneyLoot(){
        double chance =Math.random() * 100;
            if (chance < 20) {
                System.out.println("You found 10 coins!");
                player.setMoney(player.getMoney() + 10);
            } else if (chance < 50) {
                System.out.println("You found 5 coins!");
                player.setMoney(player.getMoney() + 5);
            } else {
                System.out.println("You found 1 coin!");
                player.setMoney(player.getMoney() + 1);
            }
            System.out.println("Total money: " + player.getMoney());



        }
    }
