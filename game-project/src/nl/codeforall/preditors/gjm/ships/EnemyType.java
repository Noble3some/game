package nl.codeforall.preditors.gjm.ships;



public enum EnemyType {
    ONE,
    TWO,
    THREE;

    //method
    public static EnemyType selectEnemyType() {
        int randomIndex = (int) Math.floor(Math.random() * EnemyType.values().length);
        EnemyType type = EnemyType.values()[randomIndex];
        return type;
    }

}