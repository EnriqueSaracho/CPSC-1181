
import java.util.ArrayList;

/**
 * A purse holds a collection of coins.CPSC 1181 Lab III from Programming
 * Exercise P7.5 Big Java, 4th Edition, Cay Horstmann
 *
 */
public class Purse {

    private ArrayList<Coin> listOfCoins;

    /**
     * Constructs an empty purse.
     */
    public Purse() {
        listOfCoins = new ArrayList<Coin>();
    }

    /**
     * Adds a coin to the purse regardless of whether the <code>coin</code> was
     * in the purse already or not
     *
     * @param coin the coin to add
     */
    public void addCoin(Coin coin) {
        listOfCoins.add(coin);
    }

    /**
     * Removes a coin from the purse that is the same (denomination) as
     * <code>coin</code> i.e. it removes a coin from the purse that is
     * <code>equal</code> to <code>coin</code>.
     * <p>
     * precondition: <code>equals</code> has been define for <code>coin</code>
     *
     * @param coin a coin that matches the one that should be removed from purse
     * @return true if the matching coin was removed from the purse, false
     * otherwise
     */
    public boolean removeCoin(Coin coin) {
        return listOfCoins.remove(coin);
    }

    /**
     * Gives a text representation of the purse.
     *
     * @return a string in the format "Purse[coin1,coin2,...]"
     */
    public String toString() {
        return "Purse" + listOfCoins.toString();
    }

    /**
     * Counts the number of occurrences of <code>coin</code> in this purse.
     * <p>
     * IMPLEMENTATION detail for the lab: in order for two coins to be
     * considered equal, their value and their name must match but there is a
     * method <code>equals</code> defined inside of the <code>Coin</code> class
     * already
     *
     * @param coin the item to match against
     * @return count the number of times the coin is in purse
     */
    public int occurrences(Coin coin) {
        int count = 0;
        for (Coin c : listOfCoins) {
            if (c.equals(coin)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Determines if a purse has the same coins as the <code>otherPurse</code>,
     * (regardless of order and possible duplicates).
     * <p>
     * IMPLEMENTATION detail for the lab: you must use the method
     * <code>this.occurrences</code> when implementing <code>hasSameCoins</code>
     *
     * @param otherPurse the other purse with coins
     * @return true if this and the otherPurse have the same coins, false
     * otherwise
     */
    public boolean hasSameCoins(Purse otherPurse) {
        if (otherPurse == null) {
            return false;
        }
        if (listOfCoins.size() != otherPurse.listOfCoins.size()) {
            return false;
        }
        for (Coin c : listOfCoins) {
            if (this.occurrences(c) != otherPurse.occurrences(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Gives the highest monetary value of any coin in the purse.
     *
     * @return the highest coin value of any coin in the purse and 0 if the
     * purse is empty.
     */
    public int getHighestCoinValue() {
		if (listOfCoins.size() < 1) {
			return 0;
		}
        int max = listOfCoins.get(0).getValue();
        for (Coin c : listOfCoins) {
            if (c.getValue() > max) {
                max = c.getValue();
            }
        }
        return max;
    }
}
