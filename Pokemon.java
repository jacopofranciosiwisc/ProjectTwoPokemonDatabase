// --== CS400 File Header Information ==--
// Name: Vikas Raaja 
// Email: raaja@wisc.edu
// Team: JC Red
// Role: Data Wrangler
// TA: Xinyi Liu
// Lecturer: Gary Dahl
// Notes to Grader: None


/**
 * Class to implement a Pokemon objet 
 * @author vikas
 *
 */
public class Pokemon implements PokemonInterface {
    
    private int ID; // unique for all pokemon 
    private String name;
    // the following 4 variables are a pokemon's stats 
    private int attack;
    private int defense;
    private int hp;
    private int speed;
    private String region;
    private String[] types;

    /**
     * Constructor to initialize a pokemon object 
     * @param i - int ID
     * @param n - String name 
     * @param a - int attack
     * @param d - int defense 
     * @param h - int hp
     * @param s - int speed
     * @param r - String region 
     * @param t - String[] type 
     */
    public Pokemon(int i, String n, int a, int d, int h, String r, int s, String[] t) {
        this.ID = i;
        this.name = n;
        this.attack = a;
        this.defense = d;
        this.hp = h;
        this.speed = s;
        this.region = r;
        this.types = t;
    }

    /**
     * @return String - the name of a pokemon
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * @return String - the region of a pokemon
     */
    @Override
    public String getRegion() {
        return this.region;
    }

    /**
     * @return int - the unique ID of a pokemon
     */
    @Override
    public int getID() {
        return this.ID;
    }

    /**
     * @return int - the attack stat of a pokemon
     */
    @Override
    public int getAttack() {
        return this.attack;
    }

    /**
     * @return int - the defense stat of a pokemon
     */
    @Override
    public int getDefense() {
        return this.defense;
    }

    /**
     * @return int - the hp (hit points) stat of a pokemon 
     */
    @Override
    public int getHP() {
        return this.hp;
    }

    /**
     * @return int - the speed stat of a pokemon 
     */
    @Override
    public int getSpeed() {
        return this.speed;
    }

    /**
     * The stat to represent a pokemon's power. Used as the comparitive value in the RBTree 
     * @return int - the CP of a pokemon which is calculated using the 4 stats 
     */
    @Override
    public int getCP() {
        return (int) (attack*1.5 + defense*0.5 + hp*0.7 + Math.pow(speed, 1.2));
    }

    /**
     * @return String[] - the types of the pokemon (Some have 1, some have 2)
     */
    @Override
    public String[] getTypes() {
        return this.types;
    }
    
    /**
     * Compares 2 pokemon objects by CP
     * @param - PokemonInterface b
     * @return - int (-1, 0, or 1, based on the CP comparison)
     */
    @Override
    public int compareTo(PokemonInterface b) {
    	if (this.getCP() > b.getCP())
    		return 1; // if this is greater than b
    	else if (this.getCP() < b.getCP())
    		return -1; // if this is less than b
    	else 
    		return 0; // if this and b are equal
    }
}
