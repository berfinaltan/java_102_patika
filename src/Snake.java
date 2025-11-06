class Snake extends Obstacle{
    public Snake(){
        super("Snake",getRandomDamage(),12);
    }
    private static int getRandomDamage(){
        return(int)(Math.random() * 4) + 3;
    }
}